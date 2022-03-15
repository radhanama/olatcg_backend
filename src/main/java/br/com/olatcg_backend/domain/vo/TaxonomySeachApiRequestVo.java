package br.com.olatcg_backend.domain.vo;

import br.com.olatcg_backend.enumerator.SupportedApiDatabasesEnum;

import java.util.List;

public class TaxonomySeachApiRequestVo {
    private List<String> sequences;
    private String database;

    public TaxonomySeachApiRequestVo(List<String> sequences, SupportedApiDatabasesEnum database) {
        this.sequences = sequences;
        this.database = database.name();
    }

    public List<String> getSequences() {
        return sequences;
    }

    public void setSequences(List<String> sequences) {
        this.sequences = sequences;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
