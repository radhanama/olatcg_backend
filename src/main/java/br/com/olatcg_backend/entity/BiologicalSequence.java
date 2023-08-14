package br.com.olatcg_backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "BIOLOGICAL_SEQUENCE")
public class BiologicalSequence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BASES", length = 100000)
    private String bases;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "COUNTRY_ORIGIN")
    private String countryOrigin;

    @Column(name = "EXTERNAL_DATABASE_ID")
    private String externalDatabaseId;

    public BiologicalSequence() {
    }

    public BiologicalSequence(String bases, String type) {
        this.bases = bases;
        this.type = type;
    }

    public BiologicalSequence(String bases, String type, String countryOrigin, String externalDatabaseId) {
        this.bases = bases;
        this.type = type;
        this.countryOrigin = countryOrigin;
        this.externalDatabaseId = externalDatabaseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBases() {
        return bases;
    }

    public void setBases(String bases) {
        this.bases = bases;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public String getExternalDatabaseId() {
        return externalDatabaseId;
    }

    public void setExternalDatabaseId(String externalDatabaseId) {
        this.externalDatabaseId = externalDatabaseId;
    }
}
