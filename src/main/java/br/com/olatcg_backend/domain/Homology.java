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
@Table(name = "HOMOLOGY")
public class Homology {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_HOMOLOGY")
    private Long id;

    @Column(name = "NM_TAXONOMY")
    private String taxonomy;

    @ManyToOne
    @JoinColumn(name = "ID_ALIGNMENT")
    private Alignment alignment;

    @ManyToOne
    @JoinColumn(name = "OWNER", referencedColumnName = "ID_USER")
    private User owner;

    public Homology() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
