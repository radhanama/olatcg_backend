package br.com.olatcg_backend.domain.vo;

import br.com.olatcg_backend.enumerator.SupportedApiDatabasesEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TaxonomySeachApiRequestVo {
    @JsonProperty("process_id")
    private Long processId;
    private List<String> sequences;
    private String database;
    @JsonProperty("match_score")
    private int matchScore;
    @JsonProperty("mismatch_score")
    private int mismatchScore;

    public TaxonomySeachApiRequestVo(Long processId, List<String> sequences, SupportedApiDatabasesEnum database) {
        this.processId = processId;
        this.sequences = sequences;
        this.database = database.name();
    }

    public TaxonomySeachApiRequestVo(List<String> sequences, SupportedApiDatabasesEnum database, int matchScore, int mismatchScore) {
        this.sequences = sequences;
        this.database = database.name();
        this.matchScore = matchScore;
        this.mismatchScore = mismatchScore;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
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

    public int getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(int matchScore) {
        this.matchScore = matchScore;
    }

    public int getMismatchScore() {
        return mismatchScore;
    }

    public void setMismatchScore(int mismatchScore) {
        this.mismatchScore = mismatchScore;
    }
}
