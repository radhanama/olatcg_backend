package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.enumerator.SupportedApiDatabasesEnum;

public class TaxonomyDTO {
    private SupportedApiDatabasesEnum databaseType;
    private int matchScore;
    private int mismatchScore;
    private SequenceFileDTO sequenceFile;

    public SupportedApiDatabasesEnum getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(SupportedApiDatabasesEnum databaseType) {
        this.databaseType = databaseType;
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

    public SequenceFileDTO getSequenceFile() {
        return sequenceFile;
    }

    public void setSequenceFile(SequenceFileDTO sequenceFile) {
        this.sequenceFile = sequenceFile;
    }
}
