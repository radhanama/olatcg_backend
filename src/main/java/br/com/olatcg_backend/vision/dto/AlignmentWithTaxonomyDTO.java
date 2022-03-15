package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.domain.Taxonomy;
import br.com.olatcg_backend.domain.vo.AlignmentWithTaxonomyVo;

public class AlignmentWithTaxonomyDTO {
    private String inputSequence;
    private String matchSequence;
    private String inputAlignment;
    private String matchAlignment;
    private String taxonomy;
    private Double score;

    public AlignmentWithTaxonomyDTO(AlignmentWithTaxonomyVo vo) {
        this.inputSequence = vo.getInputSequence();
        this.matchSequence = vo.getMatchSequence();
        this.inputAlignment = vo.getInputAlignment();
        this.matchAlignment = vo.getMatchAlignment();
        this.taxonomy = vo.getTaxonomy();
        this.score = vo.getScore();
    }

    public AlignmentWithTaxonomyDTO(Taxonomy taxonomy){
        this.inputSequence = taxonomy.getAlignment().getSequenceA().getBases();
        this.matchSequence = taxonomy.getAlignment().getSequenceB().getBases();
        this.inputAlignment = taxonomy.getAlignment().getAlignmentA();
        this.matchAlignment = taxonomy.getAlignment().getAlignmentB();
        this.taxonomy = taxonomy.getName();
        this.score = taxonomy.getAlignment().getScore();
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
