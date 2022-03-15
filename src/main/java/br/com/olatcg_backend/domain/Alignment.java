package br.com.olatcg_backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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

    @Column(name = "ALIGNMENT_A", length = 3000)
    private String alignmentA;

    @Column(name = "ALIGNMENT_B", length = 3000)
    private String alignmentB;

    @ManyToOne
    @JoinColumn(name = "SEQUENCE_A", referencedColumnName = "ID_SEQUENCE")
    private BiologicalSequence biologicalSequenceA;

    @ManyToOne
    @JoinColumn(name = "SEQUENCE_B", referencedColumnName = "ID_SEQUENCE")
    private BiologicalSequence biologicalSequenceB;

    public Alignment() {
    }

    public Alignment(Double similarity, String type, String model, String alignmentA, String alignmentB, BiologicalSequence biologicalSequenceA, BiologicalSequence biologicalSequenceB, Double score) {
        this.similarity = similarity;
        this.type = type;
        this.model = model;
        this.alignmentA = alignmentA;
        this.alignmentB = alignmentB;
        this.biologicalSequenceA = biologicalSequenceA;
        this.biologicalSequenceB = biologicalSequenceB;
        this.score = score;
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

    public String getAlignmentA() {
        return alignmentA;
    }

    public void setAlignmentA(String alignmentA) {
        this.alignmentA = alignmentA;
    }

    public String getAlignmentB() {
        return alignmentB;
    }

    public void setAlignmentB(String alignmentB) {
        this.alignmentB = alignmentB;
    }

    public BiologicalSequence getSequenceA() {
        return biologicalSequenceA;
    }

    public void setSequenceA(BiologicalSequence biologicalSequenceA) {
        this.biologicalSequenceA = biologicalSequenceA;
    }

    public BiologicalSequence getSequenceB() {
        return biologicalSequenceB;
    }

    public void setSequenceB(BiologicalSequence biologicalSequenceB) {
        this.biologicalSequenceB = biologicalSequenceB;
    }
}
