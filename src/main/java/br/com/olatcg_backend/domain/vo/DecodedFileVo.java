package br.com.olatcg_backend.domain.vo;

import br.com.olatcg_backend.enumerator.SupportedFileTypeEnum;

public class DecodedFileVo {
    private SupportedFileTypeEnum fileType;
    private String descodedContent;

    public DecodedFileVo() {
    }

    public SupportedFileTypeEnum getFileType() {
        return fileType;
    }

    public void setFileType(SupportedFileTypeEnum fileType) {
        this.fileType = fileType;
    }

    public String getDescodedContent() {
        return descodedContent;
    }

    public void setDescodedContent(String descodedContent) {
        this.descodedContent = descodedContent;
    }
}
