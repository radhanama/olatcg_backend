package br.com.olatcg_backend;

import br.com.olatcg_backend.domain.factory.PairwiseAlignmentFactory;
import br.com.olatcg_backend.domain.pairwise.alignment.PairwiseAlignment;
import io.tej.SwaggerCodgen.model.AlignmentTypeEnumDTO;
import io.tej.SwaggerCodgen.model.PairwiseAlnReqDTO;

public class PairwiseAlignmentDataToTest {

    public static PairwiseAlnReqDTO getPairwiseAlnReqDTO() {
        return new PairwiseAlnReqDTO()
                .sequenceA("atcg")
                .sequenceB("atcg")
                .openPenalty(2)
                .extensionPenalty(4);
    }

    public static PairwiseAlignment getPairwiseAln() {
        PairwiseAlignment pairwiseAlignment = PairwiseAlignmentFactory.build(AlignmentTypeEnumDTO.GLOBAL, getPairwiseAlnReqDTO());
        pairwiseAlignment.setAlignmentA("atcg");
        pairwiseAlignment.setAlignmentB("atcg");
        pairwiseAlignment.setIdentityPercentage(1.0);
        return pairwiseAlignment;
    }

}
