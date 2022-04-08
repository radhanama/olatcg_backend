package br.com.olatcg_backend.vision.geral;

import br.com.olatcg_backend.service.SequenceAlignmentService;
import br.com.olatcg_backend.util.CustomException;
import br.com.olatcg_backend.util.Routes;
import br.com.olatcg_backend.vision.dto.SequenceAlignmentAnalysesResponseDTO;
import br.com.olatcg_backend.vision.dto.SequenceAlignmentRequestDTO;
import br.com.olatcg_backend.vision.dto.SequenceAlignmentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SequenceAlignmentController {
    @Autowired
    private SequenceAlignmentService sequenceAlignmentService;

    @GetMapping(Routes.SEQUENCE_ALIGNMENT_API + "/search")
    public SequenceAlignmentAnalysesResponseDTO search(){
        return sequenceAlignmentService.search();
    }

    @PostMapping(Routes.SEQUENCE_ALIGNMENT_API + "/align")
    public SequenceAlignmentResponseDTO align(@RequestBody SequenceAlignmentRequestDTO dto) throws CustomException {
        return sequenceAlignmentService.align(dto);
    }
}
