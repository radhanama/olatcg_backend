package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.domain.Analysis;

public class PreProcessingSearchTaxonomyFromSequenceDTO {
    private String sequence;
    private Analysis analysis;

    public PreProcessingSearchTaxonomyFromSequenceDTO(String sequence, Analysis analysis) {
        this.sequence = sequence;
        this.analysis = analysis;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }
}
