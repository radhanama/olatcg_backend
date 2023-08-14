package br.com.olatcg_backend.service;

import br.com.olatcg_backend.domain.homology.search.Homology;
import br.com.olatcg_backend.entity.Analysis;
import br.com.olatcg_backend.mapper.AnalysisMapper;
import br.com.olatcg_backend.repository.AnalysisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class AsyncHomologySearchService {

    @Autowired
    private AnalysisMapper analysisMapper;
    @Autowired
    private AnalysisRepository analysisRepository;

    @Async
    public Future<Analysis> execute(Homology homology) {
        try {
            homology.search();
            Analysis taxAnalysis = analysisMapper.homologyToAnalysis(homology);
            return new AsyncResult<>(analysisRepository.save(taxAnalysis));
        } catch (Exception e) {
            log.info("Error while excuting homology search: " + e);
            throw e;
        }
    }
}

