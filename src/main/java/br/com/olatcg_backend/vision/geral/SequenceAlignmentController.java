package br.com.olatcg_backend.vision.geral;

import br.com.olatcg_backend.data.IAnalysisData;
import br.com.olatcg_backend.domain.Analysis;
import br.com.olatcg_backend.service.SequenceAlignmentService;
import br.com.olatcg_backend.util.CustomException;
import br.com.olatcg_backend.util.Routes;
import br.com.olatcg_backend.vision.dto.SequenceAlignmentAnalysesResponseDTO;
import br.com.olatcg_backend.vision.dto.SequenceAlignmentRequestDTO;
import br.com.olatcg_backend.vision.dto.SequenceAlignmentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SequenceAlignmentController {
    @Autowired
    private SequenceAlignmentService sequenceAlignmentService;
    @Autowired
    private IAnalysisData analysisRepository;

    @GetMapping(Routes.SEQUENCE_ALIGNMENT_API + "/search")
    public SequenceAlignmentAnalysesResponseDTO search(){
        return sequenceAlignmentService.search();
    }

    @PostMapping(Routes.SEQUENCE_ALIGNMENT_API + "/align")
    public SequenceAlignmentResponseDTO align(@RequestBody SequenceAlignmentRequestDTO dto) throws CustomException {
        return sequenceAlignmentService.align(dto);
    }

    @GetMapping(Routes.SEQUENCE_ALIGNMENT_API + "/getAlignmentByIdAnalysis")
    public SequenceAlignmentAnalysesResponseDTO getAlignmentByAnalysisId(@RequestParam Long idAnalysis){
        Analysis analysis = analysisRepository.findAlignmentAnalysisById(idAnalysis);
        return new SequenceAlignmentAnalysesResponseDTO(analysis);
    }
}
