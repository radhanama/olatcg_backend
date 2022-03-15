package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.enumerator.ErrorEnum;

public class PhylogenyResponseDTO extends ErrorDefaultResponseDTO{
    private String nwkFormat;

    public PhylogenyResponseDTO(String nwkFormat) {
        this.nwkFormat = nwkFormat;
    }

    public PhylogenyResponseDTO(ErrorEnum errorEnum) {
        super(errorEnum);
    }

    public String getNwkFormat() {
        return nwkFormat;
    }

    public void setNwkFormat(String nwkFormat) {
        this.nwkFormat = nwkFormat;
    }
}
