package br.com.olatcg_backend.mapper;

import br.com.olatcg_backend.domain.enumerator.AnalysisStatusEnum;
import br.com.olatcg_backend.domain.enumerator.AnalysisTypeEnum;
import br.com.olatcg_backend.domain.homology.search.Homology;
import br.com.olatcg_backend.domain.homology.search.HomologyHit;
import br.com.olatcg_backend.domain.pairwise.alignment.PairwiseAlignment;
import br.com.olatcg_backend.entity.Alignment;
import br.com.olatcg_backend.entity.Analysis;
import br.com.olatcg_backend.entity.Taxonomy;
import io.tej.SwaggerCodgen.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.com.olatcg_backend.domain.enumerator.AnalysisStatusEnum.FINISHED;
import static br.com.olatcg_backend.domain.enumerator.AnalysisTypeEnum.ALIGNMENT;
import static br.com.olatcg_backend.domain.enumerator.AnalysisTypeEnum.HOMOLOGY;

@Mapper(componentModel = "spring",
        uses = AlignmentMapper.class,
        imports = {AnalysisStatusEnum.class, AnalysisTypeEnum.class, List.class,
                AnalysisStatusEnumDTO.class, AnalysisTypeEnumDTO.class, LocalDateTime.class})
public abstract class AnalysisMapper {

    @Autowired
    protected AlignmentMapper alignmentMapper;

    public abstract List<AnalysisDTO> analysisListToAnalysisDTOList(List<Analysis> analysisList);

    public abstract AnalysisDTO analysisToAnalysisDTO(Analysis analysis);

    @Mapping(expression = "java(getPaginationAndSortDTO(totalPages, pageNumber, pageSize, sort))", target = "paginationAndSort")
    @Mapping(expression = "java(analysisListToAnalysisDTOList(analysisList))", target = "data")
    public abstract AnalysesRespDTO analysisRespListToAnalysisDTOList(List<Analysis> analysisList, Integer totalPages, Integer pageNumber, Integer pageSize, String sort);

    protected PaginationAndSortDTO getPaginationAndSortDTO(Integer totalPages, Integer pageNumber, Integer pageSize, String sort) {
        return new PaginationAndSortDTO()
                .totalPages(totalPages)
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .sort(SortEnumDTO.fromValue(sort));
    }

    @Mapping(expression = "java(LocalDateTime.now())", target = "generalEntityData.inclusionDate")
    @Mapping(expression = "java(LocalDateTime.now())", target = "generalEntityData.lastUpdateDate")
    protected abstract Analysis getAnalysisByTypeAndStatus(AnalysisTypeEnum type, AnalysisStatusEnum status);

    public Analysis pairwiseAlnToAlnAnalysis(PairwiseAlignment pairwiseAlignment) {
        Analysis analysis = getAnalysisByTypeAndStatus(ALIGNMENT, FINISHED);

        Alignment alignment = alignmentMapper.pairwiseAlnToAlignment(pairwiseAlignment);
        analysis.setAlignments(List.of(alignment));

        return analysis;
    }

    public Analysis homologyToAnalysis(Homology homology) {
        Analysis analysis = getAnalysisByTypeAndStatus(HOMOLOGY, FINISHED);

        analysis.setId(homology.getAnalysisId());
        analysis.setNewick(homology.getNewick());
        analysis.setCoefficienteOfVariation(homology.getCoefficientOfVariation());

        List<Alignment> alignmentList = new ArrayList<>();
        List<Taxonomy> taxonomyList = new ArrayList<>();

        for(HomologyHit hit: homology.getHomologyHitList()) {
            Alignment alignment = alignmentMapper.pairwiseAlnToAlignment(hit.getPairwiseAlignment());
            Taxonomy taxonomy = new Taxonomy(hit.getTaxonomy(), HomologyHit.DEFAULT_DESCRIPTION, alignment);

            alignmentList.add(alignment);
            taxonomyList.add(taxonomy);
        }

        analysis.setAlignments(alignmentList);
        analysis.setTaxonomies(taxonomyList);

        return analysis;
    }

    @Mapping(source = "analysis", target = "data")
    public abstract AnalysisByIdRespDTO analysisToAnalysisByIdRespDTO(Analysis analysis);
}
