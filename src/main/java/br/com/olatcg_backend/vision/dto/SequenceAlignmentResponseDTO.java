package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.domain.Alignment;

public class SequenceAlignmentResponseDTO {
    private Long idAnalysis;
    private String inputAlignment;
    private String matchAlignment;

    public SequenceAlignmentResponseDTO(Alignment alignment) {
        this.idAnalysis = alignment.getAnalysis().getId();
        this.inputAlignment = alignment.getInputAlignment();
        this.matchAlignment = alignment.getMatchAlignment();
    }

    public Long getIdAnalysis() {
        return idAnalysis;
    }

    public void setIdAnalysis(Long idAnalysis) {
        this.idAnalysis = idAnalysis;
    }

    public String getInputAlignment() {
        return inputAlignment;
    }

    public void setInputAlignment(String inputAlignment) {
        this.inputAlignment = inputAlignment;
    }

    public String getMatchAlignment() {
        return matchAlignment;
    }

    public void setMatchAlignment(String matchAlignment) {
        this.matchAlignment = matchAlignment;
    }
}
