package br.com.olatcg_backend.service;

import br.com.olatcg_backend.data.IAlignmentData;
import br.com.olatcg_backend.data.IAnalysisData;
import br.com.olatcg_backend.data.IBiologicalSequenceData;
import br.com.olatcg_backend.data.ISequenceAlignmentData;
import br.com.olatcg_backend.domain.service.AlignmentSd;
import br.com.olatcg_backend.domain.vo.SequenceAlignmentApiResponseVo;
import br.com.olatcg_backend.domain.Alignment;
import br.com.olatcg_backend.domain.vo.SequenceAlignmentApiRequestVo;
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
    @Autowired
    private AlignmentSd alignmentSd;

    public SequenceAlignmentResponseDTO align(SequenceAlignmentRequestDTO dto) throws CustomException {
        try{
            SequenceAlignmentApiResponseVo apiResponse = sequenceAlignmentRepository.align(new SequenceAlignmentApiRequestVo(dto));
            Alignment newAlignment = alignmentSd.saveAlignmentWithNewAnalysis(
                    dto.getSequenceA(),
                    dto.getSequenceB(),
                    dto.getAlignmentType(),
                    apiResponse.getAlignmentA(),
                    apiResponse.getAlignmentB(),
                    apiResponse.getScore(),
                    apiResponse.getSimilarity()
            );
            return new SequenceAlignmentResponseDTO(newAlignment);
        }catch (Exception e){
            throw new CustomException(ErrorEnum.SEQUENCE_ALIGNMENT_ERROR);
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
