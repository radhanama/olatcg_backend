package br.com.olatcg_backend.entity;

import br.com.olatcg_backend.domain.enumerator.AnalysisStatusEnum;
import br.com.olatcg_backend.domain.enumerator.AnalysisTypeEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Analysis")
public class Analysis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private AnalysisStatusEnum status;

    @Column(name = "ANALYSIS_TYPE")
    @Enumerated(EnumType.STRING)
    private AnalysisTypeEnum type;

    // TODO: isolate these two properties in a homology relationship
    @Column(name = "NEWICK")
    private String newick;
    @Column(name = "COEFFICIENT_OF_VARIATION")
    private Double coefficienteOfVariation;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ANALYSIS", referencedColumnName = "ID")
    private List<Alignment> alignments;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ANALYSIS", referencedColumnName = "ID")
    private List<Taxonomy> taxonomies;

    @Embedded
    protected GeneralEntityData generalEntityData;

    public Analysis(Long id) {
        this.id = id;
    }

    public Analysis(AnalysisTypeEnum type) {
        this.status = AnalysisStatusEnum.STARTED;
        this.type = type;
        this.generalEntityData = new GeneralEntityData();
    }

    public Alignment getAlignmentFromAlnAnalysis() {
        if(!AnalysisTypeEnum.ALIGNMENT.equals(type)) {
            throw new RuntimeException("Error when trying to get alignment from alignment analysis: analysis is not of type alignment");
        }

        return alignments.get(0);
    }

    public List<Taxonomy> getHomologyFromTaxonomyAnalysis() {
        if(!AnalysisTypeEnum.HOMOLOGY.equals(type)) {
            throw new RuntimeException("Error when trying to get homology from homology analysis: analysis is not of type homology");
        }

        return taxonomies;
    }
}
