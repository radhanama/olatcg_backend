package br.com.olatcg_backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ALIGNMENT")
public class Alignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ALIGNMENT")
    private Long id;

    @Column(name = "SIMILARITY")
    private Double similarity;

    @Column(name = "SCORE")
    private Double score;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "INPUT_ALIGNMENT", length = 100000)
    private String inputAlignment;

    @Column(name = "MATCH_ALIGNMENT", length = 100000)
    private String matchAlignment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INPUT_BIOLOGICAL_SEQUENCE", referencedColumnName = "ID_BIOLOGICAL_SEQUENCE")
    private BiologicalSequence inputBiologicalSequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATCH_BIOLOGICAL_SEQUENCE", referencedColumnName = "ID_BIOLOGICAL_SEQUENCE")
    private BiologicalSequence matchBiologicalSequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ANALYSIS")
    private Analysis analysis;

    public Alignment() {
    }

    public Alignment(Double similarity, String type, String model, String inputAlignment, String matchAlignment, BiologicalSequence inputBiologicalSequence, BiologicalSequence matchBiologicalSequence, Double score) {
        this.similarity = similarity;
        this.type = type;
        this.model = model;
        this.inputAlignment = inputAlignment;
        this.matchAlignment = matchAlignment;
        this.inputBiologicalSequence = inputBiologicalSequence;
        this.matchBiologicalSequence = matchBiologicalSequence;
        this.score = score;
    }

    public Alignment(Double similarity, String type, String model, String inputAlignment, String matchAlignment, BiologicalSequence inputBiologicalSequence, BiologicalSequence matchBiologicalSequence, Double score, Analysis analysis) {
        this.similarity = similarity;
        this.type = type;
        this.model = model;
        this.inputAlignment = inputAlignment;
        this.matchAlignment = matchAlignment;
        this.inputBiologicalSequence = inputBiologicalSequence;
        this.matchBiologicalSequence = matchBiologicalSequence;
        this.score = score;
        this.analysis = analysis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public BiologicalSequence getInputBiologicalSequence() {
        return inputBiologicalSequence;
    }

    public void setInputBiologicalSequence(BiologicalSequence inputBiologicalSequence) {
        this.inputBiologicalSequence = inputBiologicalSequence;
    }

    public BiologicalSequence getMatchBiologicalSequence() {
        return matchBiologicalSequence;
    }

    public void setMatchBiologicalSequence(BiologicalSequence matchBiologicalSequence) {
        this.matchBiologicalSequence = matchBiologicalSequence;
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }
}
