package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.enumerator.SupportedFileType;

public class SequenceFileDTO {
    private String name;
    private SupportedFileType type;
    private String description;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SupportedFileType getType() {
        return type;
    }

    public void setType(SupportedFileType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
