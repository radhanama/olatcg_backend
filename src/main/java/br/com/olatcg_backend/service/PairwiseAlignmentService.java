package br.com.olatcg_backend.service;

import br.com.olatcg_backend.domain.pairwise.alignment.PairwiseAlignment;
import br.com.olatcg_backend.entity.Alignment;
import br.com.olatcg_backend.entity.Analysis;
import br.com.olatcg_backend.mapper.AlignmentMapper;
import br.com.olatcg_backend.mapper.AnalysisMapper;
import br.com.olatcg_backend.repository.AnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PairwiseAlignmentService {

    @Autowired
    private AnalysisMapper analysisMapper;
    @Autowired
    private AnalysisRepository analysisRepository;

    public Analysis align(PairwiseAlignment pairwiseAlignment) {
        pairwiseAlignment.align();
        Analysis alnAnalysis = analysisMapper.pairwiseAlnToAlnAnalysis(pairwiseAlignment);
        return analysisRepository.save(alnAnalysis);
    }
}
