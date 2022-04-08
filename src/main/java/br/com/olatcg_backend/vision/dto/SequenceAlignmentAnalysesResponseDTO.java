package br.com.olatcg_backend.vision.dto;

import java.util.List;

public class SequenceAlignmentAnalysesResponseDTO {
    private List<SequenceAlignmentAnalysisDTO> sequenceAlignmentAnalyses;

    public SequenceAlignmentAnalysesResponseDTO(List<SequenceAlignmentAnalysisDTO> sequenceAlignmentAnalyses) {
        this.sequenceAlignmentAnalyses = sequenceAlignmentAnalyses;
    }

    public List<SequenceAlignmentAnalysisDTO> getSequenceAlignmentAnalyses() {
        return sequenceAlignmentAnalyses;
    }

    public void setSequenceAlignmentAnalyses(List<SequenceAlignmentAnalysisDTO> sequenceAlignmentAnalyses) {
        this.sequenceAlignmentAnalyses = sequenceAlignmentAnalyses;
    }
}
