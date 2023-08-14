package br.com.olatcg_backend.entity;

import br.com.olatcg_backend.domain.enumerator.AlignmentTypeEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ALIGNMENT")
public class Alignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "QUERY_ID")
    private String queryId;

    @Column(name = "TARGET_ID")
    private String targetId;

    @Column(name = "SIMILARITY")
    private Double similarity;

    @Column(name = "SCORE")
    private Double score;

    @Column(name = "IDENTITY_PERCENTAGE")
    private Double identityPercentage;

    @Column(name = "ALIGNMENT_TYPE")
    private AlignmentTypeEnum alignmentType;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "INPUT_ALIGNMENT", length = 100000)
    private String inputAlignment;

    @Column(name = "MATCH_ALIGNMENT", length = 100000)
    private String matchAlignment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "INPUT_BIOLOGICAL_SEQUENCE", referencedColumnName = "ID")
    private BiologicalSequence inputBiologicalSequence;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MATCH_BIOLOGICAL_SEQUENCE", referencedColumnName = "ID")
    private BiologicalSequence matchBiologicalSequence;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "alignment")
    private Taxonomy taxonomy;

    public Alignment() {
    }

    public Alignment(Double similarity, AlignmentTypeEnum alignmentTypeEnum, String model, String inputAlignment, String matchAlignment, BiologicalSequence inputBiologicalSequence, BiologicalSequence matchBiologicalSequence, Double score) {
        this.similarity = similarity;
        this.alignmentType = alignmentTypeEnum;
        this.model = model;
        this.inputAlignment = inputAlignment;
        this.matchAlignment = matchAlignment;
        this.inputBiologicalSequence = inputBiologicalSequence;
        this.matchBiologicalSequence = matchBiologicalSequence;
        this.score = score;
    }

}
