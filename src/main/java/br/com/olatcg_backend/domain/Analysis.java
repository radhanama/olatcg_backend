package br.com.olatcg_backend.domain;

import br.com.olatcg_backend.enumerator.AnalysisStatusEnum;
import br.com.olatcg_backend.enumerator.AnalysisTypeEnum;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Analysis")
public class Analysis implements Serializable {

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

    @OneToMany(mappedBy = "analysis", cascade = CascadeType.ALL)
    private List<Taxonomy> taxonomies = new ArrayList<>();

    @OneToMany(mappedBy = "analysis", cascade = CascadeType.ALL)
    private List<Alignment> alignments = new ArrayList<>();

    public Analysis() {
    }

    public Analysis(Long id, AnalysisStatusEnum status, AnalysisTypeEnum type, List<Taxonomy> taxonomies, List<Alignment> alignments) {
        this.id = id;
        this.status = status;
        this.type = type;
        this.taxonomies = taxonomies;
        this.alignments = alignments;
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

    public void addTaxonomies(List<Taxonomy> taxonomies) {
        this.taxonomies.addAll(taxonomies.stream().map(tax -> {
            tax.setAnalysis(this);
            tax.getAlignment().setAnalysis(this);
            return tax;
        }).collect(Collectors.toList()));
    }

    public List<Alignment> getAlignments() {
        return alignments;
    }

    public void addAlignments(List<Alignment> alignments) {
        this.alignments.addAll(alignments.stream().map(aln -> {
            aln.setAnalysis(this);
            return aln;
        }).collect(Collectors.toList()));
    }
}
