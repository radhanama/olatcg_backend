package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.domain.BiologicalSequence;
import br.com.olatcg_backend.domain.Taxonomy;

public class AlignmentWithTaxonomyDTO {
    private Long inputSequenceId;
    private String inputSequence;
    private MatchSequenceDTO matchSequence;
    private String inputAlignment;
    private String matchAlignment;
    private String taxonomy;
    private Double similarity;
    private Double score;

    public AlignmentWithTaxonomyDTO(Taxonomy taxonomy){
        BiologicalSequence matchBioSeq = taxonomy.getAlignment().getMatchBiologicalSequence();

        this.inputSequenceId = taxonomy.getAlignment().getInputBiologicalSequence().getId();
        this.inputSequence = taxonomy.getAlignment().getInputBiologicalSequence().getBases();
        this.matchSequence = new MatchSequenceDTO(
                matchBioSeq.getExternalDatabaseId(),
                matchBioSeq.getCountryOrigin(),
                matchBioSeq.getBases()
        );
        this.inputAlignment = taxonomy.getAlignment().getInputAlignment();
        this.matchAlignment = taxonomy.getAlignment().getMatchAlignment();
        this.taxonomy = taxonomy.getName();
        this.similarity = taxonomy.getAlignment().getSimilarity();
        this.score = taxonomy.getAlignment().getScore();
    }

    public Long getInputSequenceId() {
        return inputSequenceId;
    }

    public void setInputSequenceId(Long inputSequenceId) {
        this.inputSequenceId = inputSequenceId;
    }

    public String getInputSequence() {
        return inputSequence;
    }

    public void setInputSequence(String inputSequence) {
        this.inputSequence = inputSequence;
    }

    public MatchSequenceDTO getMatchSequence() {
        return matchSequence;
    }

    public void setMatchSequence(MatchSequenceDTO matchSequence) {
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
}
