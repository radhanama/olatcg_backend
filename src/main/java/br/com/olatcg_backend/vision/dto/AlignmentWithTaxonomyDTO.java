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
    private String taxonomyDescription;
    private Double similarity;
    private Double score;

    public AlignmentWithTaxonomyDTO(Taxonomy taxonomy){
        BiologicalSequence inputSeq = taxonomy.getAlignment().getInputBiologicalSequence();
        BiologicalSequence matchSeq = taxonomy.getAlignment().getMatchBiologicalSequence();

        if(inputSeq != null){
            this.inputSequenceId = inputSeq.getId();
            this.inputSequence = inputSeq.getBases();
        }else{
            this.inputSequenceId = null;
            this.inputSequence = null;
        }

        if(matchSeq != null){
            this.matchSequence = new MatchSequenceDTO(
                    matchSeq.getExternalDatabaseId(),
                    matchSeq.getCountryOrigin(),
                    matchSeq.getBases()
            );
        }else{
            this.matchSequence = null;
        }

        this.inputAlignment = taxonomy.getAlignment().getInputAlignment();
        this.matchAlignment = taxonomy.getAlignment().getMatchAlignment();
        this.taxonomy = taxonomy.getName();
        this.taxonomyDescription = taxonomy.getDescription();
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

    public String getTaxonomyDescription() {
        return taxonomyDescription;
    }

    public void setTaxonomyDescription(String taxonomyDescription) {
        this.taxonomyDescription = taxonomyDescription;
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
