package br.com.olatcg_backend.vision.dto;

public class PhylogenyResponseDTO {
    private String nwkFormat;

    public PhylogenyResponseDTO(String nwkFormat) {
        this.nwkFormat = nwkFormat;
    }

    public String getNwkFormat() {
        return nwkFormat;
    }

    public void setNwkFormat(String nwkFormat) {
        this.nwkFormat = nwkFormat;
    }
}
