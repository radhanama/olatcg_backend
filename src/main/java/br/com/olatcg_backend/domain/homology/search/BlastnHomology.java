package br.com.olatcg_backend.domain.homology.search;

import java.util.List;

public class BlastnHomology extends Homology {

    public BlastnHomology(List<SequenceIdPair> sequenceIdPairList, Integer openPenalty, Integer extensionPenalty) {
        super(sequenceIdPairList, openPenalty, extensionPenalty);
    }

    @Override
    public void search() {
        // TODO: implement homology search via blast CLI
    }

    /*public List<br.com.olatcg_backend.domain.Homology> execute(List<SequenceIdPairDTO> sequenceIdPairListDTO) {

        File querySeqsFasta = createFastaFileFromList(sequenceIdPairListDTO);

        String blastCliOutputJson = runBlastSearch(querySeqsFasta);

        return homologyMapper.JSONStringToVo(blastCliOutputJson);
    }

    public List<br.com.olatcg_backend.domain.Homology> JSONStringToVo(String blastCliOutputJson) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            BlastOutputVo blastOutputVo = objectMapper.readValue(blastCliOutputJson, BlastOutputVo.class);
            return reportVoListToDomainList(blastOutputVo.getBlastOutputs());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting blast CLI output JSON to domain object");
        }
        return null;
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
    protected abstract Homology hitVoToDomain(HitVo hitVo);

    private File createFastaFileFromList(List<SequenceIdPairDTO> sequenceIdPairListDTO) {
        try {
            File tempFastaFile = File.createTempFile("sequences", ".fasta");
            tempFastaFile.deleteOnExit();

            LinkedHashMap<String, DNASequence> dnaSequences = new LinkedHashMap<>();

            for (SequenceIdPairDTO sequenceIdPairDTO : sequenceIdPairListDTO) {
                DNASequence dnaSequence = new DNASequence(sequenceIdPairDTO.getSequence());
                dnaSequence.setAccession(new AccessionID(Long.toString(sequenceIdPairDTO.getId())));
                dnaSequences.put(Long.toString(sequenceIdPairDTO.getId()), dnaSequence);
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
    }*/
}
