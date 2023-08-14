package br.com.olatcg_backend.mapper;

import br.com.olatcg_backend.domain.enumerator.AnalysisStatusEnum;
import br.com.olatcg_backend.domain.enumerator.AnalysisTypeEnum;
import br.com.olatcg_backend.domain.pairwise.alignment.PairwiseAlignment;
import br.com.olatcg_backend.entity.Alignment;
import io.tej.SwaggerCodgen.model.PairwiseAlnDTO;
import io.tej.SwaggerCodgen.model.PairwiseAlnRespDTO;
import io.tej.SwaggerCodgen.model.PairwiseAlnWithSequencesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring",
        uses = TaxonomyMapper.class,
        imports = {AnalysisTypeEnum.class, AnalysisStatusEnum.class, LocalDate.class})
public interface AlignmentMapper {

    @Mapping(source = "alignmentA", target = "inputAlignment")
    @Mapping(source = "alignmentB", target = "matchAlignment")
    @Mapping(source = "identityPercentage", target = "identityPercentage")
    @Mapping(source = "sequenceA", target = "inputBiologicalSequence.bases")
    @Mapping(source = "sequenceB", target = "matchBiologicalSequence.bases")
    @Mapping(source = "type", target = "alignmentType")
    @Mapping(constant = "DNA", target = "inputBiologicalSequence.type")
    @Mapping(constant = "DNA", target = "matchBiologicalSequence.type")
    Alignment pairwiseAlnToAlignment(PairwiseAlignment pairwiseAln);

    @Mapping(source = "inputAlignment", target = "alignmentA")
    @Mapping(source = "matchAlignment", target = "alignmentB")
    PairwiseAlnDTO alnToPairAlnDTO(Alignment alignment);

    @Mapping(source = "inputBiologicalSequence.bases", target = "sequenceA")
    @Mapping(source = "matchBiologicalSequence.bases", target = "sequenceB")
    @Mapping(source = "inputAlignment", target = "alignmentA")
    @Mapping(source = "matchAlignment", target = "alignmentB")
    PairwiseAlnWithSequencesDTO alnToPairAlnWithSeqDTO(Alignment alignment);

    @Mapping(source = "analysisId", target = "data.id")
    @Mapping(source = "alignment.inputAlignment", target = "data.alignment.alignmentA")
    @Mapping(source = "alignment.matchAlignment", target = "data.alignment.alignmentB")
    @Mapping(source = "alignment.identityPercentage", target = "data.alignment.identityPercentage")
    PairwiseAlnRespDTO analysisIdAndAlignmentToPairAlnRespDTO(Long analysisId, Alignment alignment);
}
