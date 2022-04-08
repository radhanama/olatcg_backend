package br.com.olatcg_backend.vision.dto;

public class MatchSequenceDTO {
    private String externalDatabaseId;
    private String countryOrigin;
    private String bases;

    public MatchSequenceDTO(String externalDatabaseId, String countryOrigin, String bases) {
        this.externalDatabaseId = externalDatabaseId;
        this.countryOrigin = countryOrigin;
        this.bases = bases;
    }

    public String getExternalDatabaseId() {
        return externalDatabaseId;
    }

    public void setExternalDatabaseId(String externalDatabaseId) {
        this.externalDatabaseId = externalDatabaseId;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public String getBases() {
        return bases;
    }

    public void setBases(String bases) {
        this.bases = bases;
    }
}
