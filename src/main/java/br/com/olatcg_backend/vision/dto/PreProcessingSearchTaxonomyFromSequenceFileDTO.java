package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.domain.Analysis;
import br.com.olatcg_backend.enumerator.SupportedApiDatabasesEnum;
import br.com.olatcg_backend.enumerator.SupportedFileTypeEnum;

import java.util.List;

public class PreProcessingSearchTaxonomyFromSequenceFileDTO {
    private List<String> sequences;
    private String fileName;
    private String fileDescription;
    private SupportedFileTypeEnum fileType;
    private int matchScore;
    private int mismatchScore;
    private SupportedApiDatabasesEnum databaseType;
    private Analysis processingAnalysis;

    public PreProcessingSearchTaxonomyFromSequenceFileDTO(List<String> sequences, String fileName, String fileDescription, SupportedFileTypeEnum fileType, Analysis processingAnalysis, int matchScore, int mismatchScore, SupportedApiDatabasesEnum databaseType) {
        this.sequences = sequences;
        this.fileName = fileName;
        this.fileDescription = fileDescription;
        this.fileType = fileType;
        this.processingAnalysis = processingAnalysis;
        this.matchScore = matchScore;
        this.mismatchScore = mismatchScore;
        this.databaseType = databaseType;
    }

    public List<String> getSequences() {
        return sequences;
    }

    public void setSequences(List<String> sequences) {
        this.sequences = sequences;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public SupportedFileTypeEnum getFileType() {
        return fileType;
    }

    public void setFileType(SupportedFileTypeEnum fileType) {
        this.fileType = fileType;
    }

    public Analysis getProcessingAnalysis() {
        return processingAnalysis;
    }

    public void setProcessingAnalysis(Analysis processingAnalysis) {
        this.processingAnalysis = processingAnalysis;
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

    public SupportedApiDatabasesEnum getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(SupportedApiDatabasesEnum databaseType) {
        this.databaseType = databaseType;
    }
}
