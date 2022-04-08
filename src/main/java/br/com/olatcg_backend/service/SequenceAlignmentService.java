package br.com.olatcg_backend.service;

import br.com.olatcg_backend.data.IAlignmentData;
import br.com.olatcg_backend.data.IAnalysisData;
import br.com.olatcg_backend.data.IBiologicalSequenceData;
import br.com.olatcg_backend.data.ISequenceAlignmentData;
import br.com.olatcg_backend.data.service.SequenceAlignmentApiResponseVo;
import br.com.olatcg_backend.domain.Alignment;
import br.com.olatcg_backend.domain.Analysis;
import br.com.olatcg_backend.domain.BiologicalSequence;
import br.com.olatcg_backend.domain.vo.SequenceAlignmentApiRequestVo;
import br.com.olatcg_backend.enumerator.AlignmentTypeEnum;
import br.com.olatcg_backend.enumerator.ErrorEnum;
import br.com.olatcg_backend.util.CustomException;
import br.com.olatcg_backend.vision.dto.SequenceAlignmentAnalysesResponseDTO;
import br.com.olatcg_backend.vision.dto.SequenceAlignmentAnalysisDTO;
import br.com.olatcg_backend.vision.dto.SequenceAlignmentRequestDTO;
import br.com.olatcg_backend.vision.dto.SequenceAlignmentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SequenceAlignmentService {
    @Autowired
    private ISequenceAlignmentData sequenceAlignmentRepository;
    @Autowired
    private IBiologicalSequenceData biologicalSequenceRepository;
    @Autowired
    private IAlignmentData alignmentRepository;
    @Autowired
    private IAnalysisData analysisRepository;

    public SequenceAlignmentResponseDTO align(SequenceAlignmentRequestDTO dto) throws CustomException {
        try{
            SequenceAlignmentApiResponseVo apiResponse = sequenceAlignmentRepository.align(new SequenceAlignmentApiRequestVo(dto));
            Alignment newAlignment = SaveAlignment(dto.getSequenceA(), dto.getSequenceB(), dto.getType(), apiResponse.getAlignmentA(), apiResponse.getAlignmentB(), apiResponse.getScore());
            return new SequenceAlignmentResponseDTO(newAlignment);
        }catch (Exception e){
            throw new CustomException(ErrorEnum.SEQUENCE_ALIGNMENT_ERROR);
        }
    }

    private Alignment SaveAlignment(String sequenceA, String sequenceB, AlignmentTypeEnum type, String alignmentA, String alignmentB, Double score) throws CustomException {
        try {
            Analysis newAnalysis = analysisRepository.save(new Analysis());
            BiologicalSequence bioSeqA = biologicalSequenceRepository.save(new BiologicalSequence(sequenceA, type.name()));
            BiologicalSequence bioSeqB = biologicalSequenceRepository.save(new BiologicalSequence(sequenceB, type.name()));
            return alignmentRepository.save(new Alignment(
                    null,
                    type.name(),
                    null,
                    alignmentA,
                    alignmentB,
                    bioSeqA,
                    bioSeqB,
                    score,
                    newAnalysis));
        }catch (Exception e){
            throw new CustomException(ErrorEnum.PERSISTENCE_DATABASE_ERROR);
        }
    }

    public SequenceAlignmentAnalysesResponseDTO search() {
        List<SequenceAlignmentAnalysisDTO> sequenceAlignmentResponseDTOS = analysisRepository
                .findAllAlignmentAnalyzes().stream().map(alignmentAnalysis ->
                        new SequenceAlignmentAnalysisDTO(alignmentAnalysis.getAlignments().get(0)))
                .collect(Collectors.toList());
        return new SequenceAlignmentAnalysesResponseDTO(sequenceAlignmentResponseDTOS);
    }
}
