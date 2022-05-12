package br.com.olatcg_backend.vision.dto;

public class RequestTimeoutResponseDTO {
    private Long idAnalysis;
    private String description;

    public RequestTimeoutResponseDTO(Long idAnalysis) {
        this.idAnalysis = idAnalysis;
        this.description = "Sua análise está em andamento e isso pode demorar um pouco " +
                            "aguarde o carregamento do resultado na fila de processamento!";
    }

    public Long getIdAnalysis() {
        return idAnalysis;
    }

    public void setIdAnalysis(Long idAnalysis) {
        this.idAnalysis = idAnalysis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
