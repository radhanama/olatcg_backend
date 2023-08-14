package br.com.olatcg_backend.service;

import io.tej.SwaggerCodgen.model.AlignmentTypeEnumDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.olatcg_backend.PairwiseAlignmentDataToTest.getPairwiseAln;
import static br.com.olatcg_backend.PairwiseAlignmentDataToTest.getPairwiseAlnReqDTO;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PairwiseAlignmentServiceTest {

    @InjectMocks
    private PairwiseAlignmentService service;

    @Test
    void align() {
        /*service.align(AlignmentTypeEnumDTO.GLOBAL, getPairwiseAlnReqDTO());
        verify(alignmentAnalysisPersistenceService).save(eq(getPairwiseAln()));*/
    }
}