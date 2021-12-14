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

    @Column(name = "TYPE")
    private String type;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "ALIGNMENT_A")
    private String alignmentA;

    @Column(name = "ALIGNMENT_B")
    private String alignmentB;

    @ManyToOne
    @JoinColumn(name = "SEQUENCE_A", referencedColumnName = "ID_SEQUENCE")
    private Sequence sequenceA;

    @ManyToOne
    @JoinColumn(name = "SEQUENCE_B", referencedColumnName = "ID_SEQUENCE")
    private Sequence sequenceB;

    public Alignment() {
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

    public Sequence getSequenceA() {
        return sequenceA;
    }

    public void setSequenceA(Sequence sequenceA) {
        this.sequenceA = sequenceA;
    }

    public Sequence getSequenceB() {
        return sequenceB;
    }

    public void setSequenceB(Sequence sequenceB) {
        this.sequenceB = sequenceB;
    }
}
