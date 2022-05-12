package br.com.olatcg_backend.domain.service;

import br.com.olatcg_backend.data.IAnalysisData;
import br.com.olatcg_backend.domain.Analysis;
import br.com.olatcg_backend.enumerator.AnalysisStatusEnum;
import br.com.olatcg_backend.enumerator.AnalysisTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AnalysisSd {

    @Autowired
    private IAnalysisData analysisRepository;

    @Transactional
    public Analysis createWithStartedStatusAndTaxonomyType(){
        Analysis newAnalysis = new Analysis(
                AnalysisStatusEnum.STARTED,
                AnalysisTypeEnum.TAXONOMY
        );
        return analysisRepository.save(newAnalysis);
    }
}
