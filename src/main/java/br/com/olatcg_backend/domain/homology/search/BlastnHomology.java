package br.com.olatcg_backend.domain.homology.search;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.biojava.nbio.core.search.io.blast.BlastResult;
import org.biojava.nbio.core.sequence.AccessionID;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.io.FastaWriterHelper;
import org.forester.archaeopteryx.tools.Blast;
import org.mapstruct.Mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.olatcg_backend.domain.vo.BlastOutputVo;
import br.com.olatcg_backend.domain.vo.HitVo;
import br.com.olatcg_backend.domain.vo.ReportVo;

public class BlastnHomology extends Homology {

    public BlastnHomology(List<SequenceIdPair> sequenceIdPairList, Integer openPenalty, Integer extensionPenalty) {
        super(sequenceIdPairList, openPenalty, extensionPenalty);
    }

    @Override
    public void search() {
        try {
            this.execute(sequenceIdPairList);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error conducting homology search", e);
        }
    }

    public List<Homology> execute(List<SequenceIdPair> sequenceIdPairListDTO) {

        File querySeqsFasta = createFastaFileFromList(sequenceIdPairListDTO);

        String blastCliOutputJson = runBlastSearch(querySeqsFasta);

        return JSONStringToVo(blastCliOutputJson);
    }

    public List<Homology> JSONStringToVo(String blastCliOutputJson) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            BlastOutputVo blastOutputVo = objectMapper.readValue(blastCliOutputJson, BlastOutputVo.class);
            return reportVoListToDomainList(blastOutputVo.getBlastOutputs());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting blast CLI output JSON to domain object");
        }
    }

    private List<Homology> reportVoListToDomainList(List<ReportVo> reportVoList) {
        return reportVoList.stream()
                .map(reportVo -> reportVo.getResults().getSearch().getHitVos())
                .flatMap(List::stream)
                .map(this::hitVoToDomain)
                .collect(Collectors.toList());
    }

    @Mapping(source = "", target = "taxonomy")
    @Mapping(source = "", target = "alignment")
    protected Homology hitVoToDomain(HitVo hitVo) {
        return new BlastnHomology(sequenceIdPairList, hitVo.getNum(), hitVo.getLen());
    }

    private File createFastaFileFromList(List<SequenceIdPair> sequenceIdPairListDTO) {
        try {
            File tempFastaFile = File.createTempFile("sequences", ".fasta");
            tempFastaFile.deleteOnExit();

            LinkedHashMap<String, DNASequence> dnaSequences = new LinkedHashMap<>();

            for (SequenceIdPair SequenceIdPair : sequenceIdPairListDTO) {
                DNASequence dnaSequence = new DNASequence(SequenceIdPair.getSequence());
                dnaSequence.setAccession(new AccessionID(SequenceIdPair.getId()));
                dnaSequences.put(SequenceIdPair.getId(), dnaSequence);
            }

            FastaWriterHelper.writeNucleotideSequence(tempFastaFile, dnaSequences.values());

            return tempFastaFile;
        } catch (Exception e) {
            throw new RuntimeException("Error creating query FASTA file", e);
        }
    }

    private String runBlastSearch(File inputFile) {
        try {
            File outputFile = File.createTempFile("output_", ".json");
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "blastn", "-query", inputFile.getAbsolutePath(),
                    "-db", "blast/dbs/agromyces_database", "-outfmt", "15", "-out",
                    outputFile.getAbsolutePath());

            Process process = processBuilder.start();
            process.waitFor();

            return convertOutputFileToStr(outputFile);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error running blast search", e);
        }
    }

    private String convertOutputFileToStr(File outputFile) throws IOException {
        byte[] bytes = Files.readAllBytes(outputFile.toPath());
        return new String(bytes);
    }
}
