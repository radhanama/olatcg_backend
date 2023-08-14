package br.com.olatcg_backend.service;

import br.com.olatcg_backend.domain.factory.PairwiseAlignmentFactory;
import br.com.olatcg_backend.domain.pairwise.alignment.PairwiseAlignment;
import br.com.olatcg_backend.entity.Analysis;
import br.com.olatcg_backend.mapper.AnalysisMapper;
import br.com.olatcg_backend.repository.AnalysisRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AlignmentAnalysisPersistenceServiceTest {

    @Mock
    private AnalysisRepository analysisRepository;

    @Mock
    private AnalysisMapper analysisMapper;

    @Test
    void save() {
       /*PairwiseAlignment pairwiseAlignment = PairwiseAlignmentFactory.build(getPairwiseAlnReqDTO());
        Analysis analysis = getAnalysis();
        when(analysisMapper.pairAlnToAln(pairwiseAlignment)).thenReturn(analysis);
        service.save(pairwiseAlignment);
        verify(analysisMapper).pairAlnToAln(eq(pairwiseAlignment));
        verify(analysisRepository).save(analysis);*/
    }
}