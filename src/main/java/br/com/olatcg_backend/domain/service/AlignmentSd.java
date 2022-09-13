package br.com.olatcg_backend.domain.service;

import br.com.olatcg_backend.data.IAlignmentData;
import br.com.olatcg_backend.data.IAnalysisData;
import br.com.olatcg_backend.data.IBiologicalSequenceData;
import br.com.olatcg_backend.domain.Alignment;
import br.com.olatcg_backend.domain.Analysis;
import br.com.olatcg_backend.domain.BiologicalSequence;
import br.com.olatcg_backend.enumerator.AlignmentTypeEnum;
import br.com.olatcg_backend.enumerator.AnalysisStatusEnum;
import br.com.olatcg_backend.enumerator.AnalysisTypeEnum;
import br.com.olatcg_backend.enumerator.ErrorEnum;
import br.com.olatcg_backend.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AlignmentSd {
    @Autowired
    private IAnalysisData analysisRepository;
    @Autowired
    private IBiologicalSequenceData biologicalSequenceRepository;
    @Autowired
    private IAlignmentData alignmentRepository;

    @Transactional
    public Alignment saveAlignmentWithNewAnalysis(String sequenceA, String sequenceB, AlignmentTypeEnum type, String alignmentA, String alignmentB, Double score, Double similarity) throws CustomException {
        try {
            Analysis newAnalysis = analysisRepository.save(new Analysis(
                    AnalysisStatusEnum.FINISHED,
                    AnalysisTypeEnum.ALIGNMENT
            ));
            BiologicalSequence bioSeqA = biologicalSequenceRepository.save(new BiologicalSequence(sequenceA, type.name()));
            BiologicalSequence bioSeqB = biologicalSequenceRepository.save(new BiologicalSequence(sequenceB, type.name()));
            return alignmentRepository.save(new Alignment(
                    similarity,
                    type.name(),
                    null,
                    alignmentA,
                    alignmentB,
                    bioSeqA,
                    bioSeqB,
                    score,
                    newAnalysis));
        }catch (Exception e){
            throw new CustomException(ErrorEnum.PERSISTENCE_DATABASE_ERROR);
        }
    }
}
