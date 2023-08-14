package br.com.olatcg_backend.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class GeneralEntityData {

    public GeneralEntityData() {
        this.inclusionDate = LocalDateTime.now();
    }

    @Column(name = "INCLUSION_DT")
    private LocalDateTime inclusionDate;

    @Column(name = "LAST_UPDATE_DT")
    private LocalDateTime lastUpdateDate;

}
