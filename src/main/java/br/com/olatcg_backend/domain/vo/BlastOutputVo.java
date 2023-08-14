package br.com.olatcg_backend.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BlastOutputVo {
    @JsonProperty("BlastOutput2")
    private List<ReportVo> blastOutputs;

    public List<ReportVo> getBlastOutputs() {
        return blastOutputs;
    }

    public void setBlastOutputs(List<ReportVo> blastOutputs) {
        this.blastOutputs = blastOutputs;
    }
}
