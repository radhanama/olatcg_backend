package br.com.olatcg_backend.domain.service;

import br.com.olatcg_backend.data.IAnalysisData;
import br.com.olatcg_backend.domain.Analysis;
import br.com.olatcg_backend.domain.Taxonomy;
import br.com.olatcg_backend.enumerator.AnalysisStatusEnum;
import br.com.olatcg_backend.enumerator.AnalysisTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public Analysis createWithStartedStatusAndTaxonomyBlastType() {
        Analysis newAnalysis = new Analysis(
                AnalysisStatusEnum.STARTED,
                AnalysisTypeEnum.TAXONOMY_BLAST
        );
        return analysisRepository.save(newAnalysis);
    }

    @Transactional
    public void updateStatus(Long idAnalysis, AnalysisStatusEnum statusEnum){
        Analysis analysis = analysisRepository.findById(idAnalysis).get();
        analysis.setStatus(statusEnum);
        analysisRepository.save(analysis);
    }

    @Transactional
    public void saveTaxonomyAnalysisAndFinishAnalysis(Long analysisId, List<Taxonomy> taxonomies) {
        Analysis analysis = analysisRepository.findById(analysisId).get();
        analysis.addTaxonomies(taxonomies);
        analysis.setStatus(AnalysisStatusEnum.FINISHED);
        analysisRepository.saveAndFlush(analysis);
    }

    @Transactional
    public Analysis saveTaxonomyAnalysisAndFinishAnalysis(Analysis analysis, List<Taxonomy> taxonomies) {
        analysis.addTaxonomies(taxonomies);
        analysis.setStatus(AnalysisStatusEnum.FINISHED);
        return analysisRepository.saveAndFlush(analysis);
    }
}
