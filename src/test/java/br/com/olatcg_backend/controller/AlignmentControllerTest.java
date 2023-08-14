package br.com.olatcg_backend.controller;

import br.com.olatcg_backend.entity.Alignment;
import br.com.olatcg_backend.entity.Analysis;
import br.com.olatcg_backend.mapper.AnalysisMapper;
import br.com.olatcg_backend.service.PairwiseAlignmentService;
import io.tej.SwaggerCodgen.model.PairwiseAlnReqDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.olatcg_backend.PairwiseAlignmentDataToTest.getPairwiseAlnReqDTO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlignmentControllerTest {

    @Mock
    private PairwiseAlignmentService pairwiseAlignmentService;

    @Mock
    private AnalysisMapper analysisMapper;

    @InjectMocks
    private AlignmentController alignmentController;

    @Test
    void align() {
        /*Analysis analysisReturnedByService = new Alignment();
        when(pairwiseAlignmentService.align(any(PairwiseAlnReqDTO.class))).thenReturn(analysisReturnedByService);
        alignmentController.align(getPairwiseAlnReqDTO());
        verify(pairwiseAlignmentService).align(any(PairwiseAlnReqDTO.class));
        verify(analysisMapper).analysisToPairAlnRespDTO(eq(analysisReturnedByService));*/
    }
}