package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.domain.Analysis;

import java.util.List;
import java.util.stream.Collectors;

public class SequenceAlignmentAnalysesResponseDTO {
    private List<SequenceAlignmentAnalysisDTO> sequenceAlignmentAnalyses;

    public SequenceAlignmentAnalysesResponseDTO(List<SequenceAlignmentAnalysisDTO> sequenceAlignmentAnalyses) {
        this.sequenceAlignmentAnalyses = sequenceAlignmentAnalyses;
    }

    public SequenceAlignmentAnalysesResponseDTO(Analysis analysis) {
        this.sequenceAlignmentAnalyses = analysis.getAlignments()
                .stream().map(SequenceAlignmentAnalysisDTO::new)
                .collect(Collectors.toList());
    }

    public List<SequenceAlignmentAnalysisDTO> getSequenceAlignmentAnalyses() {
        return sequenceAlignmentAnalyses;
    }

    public void setSequenceAlignmentAnalyses(List<SequenceAlignmentAnalysisDTO> sequenceAlignmentAnalyses) {
        this.sequenceAlignmentAnalyses = sequenceAlignmentAnalyses;
    }
}
