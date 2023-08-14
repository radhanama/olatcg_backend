package br.com.olatcg_backend.domain.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AlignmentTypeEnum {
    GLOBAL(1, "GLOBAL"),
    LOCAL(2, "LOCAL");

    private final Integer code;
    private final String value;
}
