package br.com.olatcg_backend.domain.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HitVo {
    private int num;
    private List<DescriptionVo> description;
    private int len;
    private List<HspVo> hsps;
}
