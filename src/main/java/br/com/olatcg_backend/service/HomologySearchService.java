package br.com.olatcg_backend.service;

import br.com.olatcg_backend.domain.enumerator.AnalysisStatusEnum;
import br.com.olatcg_backend.domain.enumerator.AnalysisTypeEnum;
import br.com.olatcg_backend.domain.homology.search.Homology;
import br.com.olatcg_backend.entity.Analysis;
import br.com.olatcg_backend.mapper.AnalysisMapper;
import br.com.olatcg_backend.repository.AnalysisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
@Slf4j
public class HomologySearchService {

    @Autowired
    private AnalysisRepository analysisRepository;
    @Autowired
    private AsyncHomologySearchService asyncHomologySearchService;

    public Analysis execute(Homology homology) {
        var taxAnalysis = analysisRepository.save(new Analysis(AnalysisTypeEnum.HOMOLOGY));
        try {
            homology.setAnalysisId(taxAnalysis.getId());
            Future<Analysis> futureTaxAnalysis = asyncHomologySearchService.execute(homology);
            return futureTaxAnalysis.get(10, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            log.info(e.toString());
            return taxAnalysis;
        } catch (ExecutionException | InterruptedException e) {
            taxAnalysis.setStatus(AnalysisStatusEnum.FAILED);
            analysisRepository.save(taxAnalysis);
            throw new RuntimeException(e);
        }
    }
}
