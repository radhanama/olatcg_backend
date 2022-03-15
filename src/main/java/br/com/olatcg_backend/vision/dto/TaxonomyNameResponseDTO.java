package br.com.olatcg_backend.vision.dto;

public class TaxonomyNameResponseDTO extends ErrorDefaultResponseDTO {
    private String name;

    public TaxonomyNameResponseDTO() {
    }

    public TaxonomyNameResponseDTO(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
