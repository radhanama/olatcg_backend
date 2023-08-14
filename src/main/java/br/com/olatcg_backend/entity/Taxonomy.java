package br.com.olatcg_backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "HOMOLOGY")
@NoArgsConstructor
public class Taxonomy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NM_TAXONOMY")
    private String name;

    @Column(name = "DESC_TAXONOMY", length = 100000)
    private String description;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ALIGNMENT", referencedColumnName = "ID")
    private Alignment alignment;

    public Taxonomy(String name, String description, Alignment alignment) {
        this.name = name;
        this.description = description;
        this.alignment = alignment;
    }
}
