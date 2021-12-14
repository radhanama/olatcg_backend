package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.domain.vo.TaxonomySearchApiResponseVo;
import br.com.olatcg_backend.enumerator.ErrorEnum;

import java.util.List;
import java.util.stream.Collectors;

public class TaxonomySearchResponseDTO {
    private Integer errorCode;
    private String errorDescription;
    private List<AlignmentWithTaxonomyDTO> alignments;

    public TaxonomySearchResponseDTO(ErrorEnum erro) {
        this.errorCode = erro.getErrorCode();
        this.errorDescription = erro.name();
    }

    public TaxonomySearchResponseDTO(TaxonomySearchApiResponseVo vo) {
        this.alignments = vo.getAlignments().stream()
                .map(p -> new AlignmentWithTaxonomyDTO(p))
                .collect(Collectors.toList());
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public List<AlignmentWithTaxonomyDTO> getAlignments() {
        return alignments;
    }

    public void setAlignments(List<AlignmentWithTaxonomyDTO> alignments) {
        this.alignments = alignments;
    }
}
