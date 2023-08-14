package br.com.olatcg_backend.domain.pairwise.alignment;

import br.com.olatcg_backend.domain.enumerator.AlignmentTypeEnum;
import org.biojava.nbio.alignment.Alignments;
import org.biojava.nbio.alignment.SimpleGapPenalty;
import org.biojava.nbio.core.alignment.template.SequencePair;
import org.biojava.nbio.core.alignment.template.SubstitutionMatrix;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.compound.NucleotideCompound;

public class GlobalPairwiseAlignment extends PairwiseAlignment {

    public GlobalPairwiseAlignment() {
        type = AlignmentTypeEnum.GLOBAL;
    }

    @Override
    protected SequencePair<DNASequence, NucleotideCompound> performAlign(DNASequence sequenceA, DNASequence sequenceB, SimpleGapPenalty gapPenalty, SubstitutionMatrix<NucleotideCompound> matrix) {
        return Alignments.getPairwiseAlignment(sequenceA, sequenceB, Alignments.PairwiseSequenceAlignerType.GLOBAL, gapPenalty, matrix);
    }

}
