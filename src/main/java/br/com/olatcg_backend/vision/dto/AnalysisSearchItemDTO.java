package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.domain.Analysis;
import br.com.olatcg_backend.enumerator.AnalysisStatusEnum;

public class AnalysisSearchItemDTO {
    private Long id;
    private AnalysisStatusEnum status;

    public AnalysisSearchItemDTO(Analysis analysis) {
        this.id = analysis.getId();
        this.status = analysis.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnalysisStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AnalysisStatusEnum status) {
        this.status = status;
    }
}
