package br.com.olatcg_backend.vision.dto;

public class TaxonomyNameResponseDTO {
    private String name;

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
