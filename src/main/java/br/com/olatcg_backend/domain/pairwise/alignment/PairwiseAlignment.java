package br.com.olatcg_backend.domain.pairwise.alignment;

import br.com.olatcg_backend.domain.enumerator.AlignmentTypeEnum;
import br.com.olatcg_backend.exception.DomainException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.biojava.nbio.alignment.SimpleGapPenalty;
import org.biojava.nbio.core.alignment.matrices.SubstitutionMatrixHelper;
import org.biojava.nbio.core.alignment.template.SequencePair;
import org.biojava.nbio.core.alignment.template.SubstitutionMatrix;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.compound.NucleotideCompound;
import org.springframework.util.ObjectUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Getter
@Setter
@EqualsAndHashCode
public abstract class PairwiseAlignment {

    private String queryId;
    private String targetId;

    @NotNull
    @NotEmpty
    private String alignmentA;

    @NotNull
    @NotEmpty
    private String alignmentB;

    @NotNull
    @NotEmpty
    protected String sequenceA;

    @NotNull
    @NotEmpty
    protected String sequenceB;

    @NotNull
    protected Integer openPenalty;

    @NotNull
    protected Integer extensionPenalty;

    @NotNull
    @NotEmpty
    private Double identityPercentage;

    @NotNull
    protected AlignmentTypeEnum type;

    protected abstract SequencePair<DNASequence, NucleotideCompound> performAlign(DNASequence sequenceA, DNASequence sequenceB, SimpleGapPenalty gapPenalty, SubstitutionMatrix<NucleotideCompound> matrix);

    public void align(){
        try {
            if(!ObjectUtils.isEmpty(alignmentA) && !ObjectUtils.isEmpty(alignmentB)){
                throw new DomainException("Tried to perform a pairwise alignment two times with the same sequences");
            }

            DNASequence sequenceA = new DNASequence(this.sequenceA);
            DNASequence sequenceB = new DNASequence(this.sequenceB);

            SimpleGapPenalty gapPenalty = new SimpleGapPenalty();
            gapPenalty.setOpenPenalty(this.openPenalty);
            gapPenalty.setExtensionPenalty(this.extensionPenalty);

            SubstitutionMatrix<NucleotideCompound> matrix = SubstitutionMatrixHelper.getNuc4_2();

            SequencePair<DNASequence, NucleotideCompound> pair = performAlign(
                    sequenceA, sequenceB,
                    gapPenalty, matrix);

            defineAlignmentData(pair);

        } catch (Exception e) {
            throw new DomainException("An error occurred when trying to make pairwise alignment");
        }
    }

    private void defineAlignmentData(SequencePair<DNASequence, NucleotideCompound> pair) {
        alignmentA = pair.getQuery().getSequenceAsString();
        alignmentB = pair.getTarget().getSequenceAsString();
        identityPercentage = pair.getPercentageOfIdentity(true);
    }
}
