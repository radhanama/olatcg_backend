package br.com.olatcg_backend.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlignmentWithTaxonomyVo {
    @JsonProperty("input_sequence")
    private String inputSequence;
    @JsonProperty("match_sequence")
    private String matchSequence;
    @JsonProperty("input_alignment")
    private String inputAlignment;
    @JsonProperty("match_alignment")
    private String matchAlignment;
    private String taxonomy;
    private Double score;
    private Double similarity;
    @JsonProperty("external_database_id")
    private String externalDatabaseId;
    @JsonProperty("country_origin")
    private String countryOrigin;

    public AlignmentWithTaxonomyVo() {
    }

    public String getInputSequence() {
        return inputSequence;
    }

    public void setInputSequence(String inputSequence) {
        this.inputSequence = inputSequence;
    }

    public String getMatchSequence() {
        return matchSequence;
    }

    public void setMatchSequence(String matchSequence) {
        this.matchSequence = matchSequence;
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

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public Double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Double similarity) {
        this.similarity = similarity;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
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
}
