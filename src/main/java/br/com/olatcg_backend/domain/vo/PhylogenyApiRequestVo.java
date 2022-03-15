package br.com.olatcg_backend.domain.vo;

public class PhylogenyApiRequestVo {
    private String encodedFastaFile;

    public PhylogenyApiRequestVo(String encodedFastaFile) {
        this.encodedFastaFile = encodedFastaFile;
    }

    public String getEncodedFastaFile() {
        return encodedFastaFile;
    }

    public void setEncodedFastaFile(String encodedFastaFile) {
        this.encodedFastaFile = encodedFastaFile;
    }
}
