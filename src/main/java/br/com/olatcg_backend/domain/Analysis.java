package br.com.olatcg_backend.domain;

import br.com.olatcg_backend.enumerator.AnalysisStatusEnum;
import br.com.olatcg_backend.enumerator.AnalysisTypeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Analysis")
public class Analysis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ANALYSIS")
    private Long id;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private AnalysisStatusEnum status;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private AnalysisTypeEnum type;

    @OneToMany(mappedBy = "analysis")
    private List<Taxonomy> taxonomies;

    @OneToMany(mappedBy = "analysis")
    private List<Alignment> alignments;

    public Analysis() {
    }

    public Analysis(Long id) {
        this.id = id;
    }

    public Analysis(AnalysisStatusEnum status, AnalysisTypeEnum type) {
        this.status = status;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnalysisStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AnalysisStatusEnum status) {
        this.status = status;
    }

    public AnalysisTypeEnum getType() {
        return type;
    }

    public void setType(AnalysisTypeEnum type) {
        this.type = type;
    }

    public List<Taxonomy> getTaxonomies() {
        return taxonomies;
    }

    public void setTaxonomies(List<Taxonomy> taxonomies) {
        this.taxonomies = taxonomies;
    }

    public List<Alignment> getAlignments() {
        return alignments;
    }

    public void setAlignments(List<Alignment> alignments) {
        this.alignments = alignments;
    }
}
