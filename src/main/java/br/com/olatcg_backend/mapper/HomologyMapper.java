package br.com.olatcg_backend.mapper;

import br.com.olatcg_backend.domain.enumerator.AnalysisStatusEnum;
import br.com.olatcg_backend.domain.homology.search.BlastnHomology;
import br.com.olatcg_backend.domain.homology.search.Homology;
import br.com.olatcg_backend.domain.homology.search.OlatcgHomology;
import br.com.olatcg_backend.domain.homology.search.SequenceIdPair;
import br.com.olatcg_backend.entity.Analysis;
import br.com.olatcg_backend.entity.Taxonomy;
import io.tej.SwaggerCodgen.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring", uses = AlignmentMapper.class)
public abstract class HomologyMapper {

    @Autowired
    private SequenceIdPairMapper sequenceIdPairMapper;

    public Homology dtoToDomain(HomologySearchReqDTO homologySearchReqDTO, SearchToolEnumDTO type) {
        List<SequenceIdPair> sequenceIdPairList = sequenceIdPairMapper.dtoListToDomainList(homologySearchReqDTO.getSequences());

        if(type.equals(SearchToolEnumDTO.OLATCG)){
            return new OlatcgHomology(sequenceIdPairList,
                    homologySearchReqDTO.getOpenPenalty(),
                    homologySearchReqDTO.getExtensionPenalty());
        }

        return new BlastnHomology(sequenceIdPairList,
                homologySearchReqDTO.getOpenPenalty(),
                homologySearchReqDTO.getExtensionPenalty());
    }

    public HomologySearchRespDTO analysisToHomologySearchDto(Analysis taxAnalysis) {
        HomologySearchRespDTO homologySearchRespDTO = new HomologySearchRespDTO();
        HomologyAnalysisDTO homologyAnalysisDTO = new HomologyAnalysisDTO();
        List<HomologyDTO> homologyDTOList = taxonomyListToDtoList(taxAnalysis.getTaxonomies());
        homologyAnalysisDTO.setId(Math.toIntExact(taxAnalysis.getId()));
        homologyAnalysisDTO.setNewick(taxAnalysis.getNewick());
        homologyAnalysisDTO.setCoefficientOfVariation(taxAnalysis.getCoefficienteOfVariation());
        homologyAnalysisDTO.setTaxonomies(homologyDTOList);
        homologyAnalysisDTO.setStatus(getStatus(taxAnalysis.getStatus()));
        homologySearchRespDTO.setData(homologyAnalysisDTO);
        return homologySearchRespDTO;
    }

    private StatusDTO getStatus(AnalysisStatusEnum status) {
        if(status.equals(AnalysisStatusEnum.STARTED)) {
            return new StatusDTO()
                    .title("Operation running in background")
                    .description("The operation has been started and is in progress, " +
                            "you can follow it through its status");
        }

        if(status.equals(AnalysisStatusEnum.FAILED)) {
            return new StatusDTO()
                    .title("The operation failed")
                    .description("Something went wrong when performing the operation. " +
                            "Please try again. If the error persists, contact your system " +
                            "administrator.");
        }

        return new StatusDTO()
                .title("Success")
                .description("The operation was executed successfully");

    }

    protected abstract List<HomologyDTO> taxonomyListToDtoList(List<Taxonomy> homologyFromTaxonomyAnalysis);

    @Mapping(source = "alignment.queryId", target = "queryId")
    @Mapping(source = "alignment.targetId", target = "targetId")
    public abstract HomologyDTO taxonomyToDto(Taxonomy taxonomy);

}
