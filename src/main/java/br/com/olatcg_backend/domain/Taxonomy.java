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
@Table(name = "TAXONOMY")
public class Taxonomy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TAXONOMY")
    private Long id;

    @Column(name = "NM_TAXONOMY")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ALIGNMENT")
    private Alignment alignment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FILE")
    private File file;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ANALYSIS")
    private Analysis analysis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER", referencedColumnName = "ID_USER")
    private User owner;

    public Taxonomy() {
    }

    public Taxonomy(String name, Alignment alignment, Analysis analysis, File file, User owner) {
        this.name = name;
        this.alignment = alignment;
        this.analysis = analysis;
        this.file = file;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
