package br.com.olatcg_backend.util.converters;

import br.com.olatcg_backend.data.IAlignmentData;
import br.com.olatcg_backend.data.IBiologicalSequenceData;
import br.com.olatcg_backend.data.ITaxonomyData;
import br.com.olatcg_backend.data.IUserData;
import br.com.olatcg_backend.domain.Alignment;
import br.com.olatcg_backend.domain.Analysis;
import br.com.olatcg_backend.domain.BiologicalSequence;
import br.com.olatcg_backend.domain.File;
import br.com.olatcg_backend.domain.Taxonomy;
import br.com.olatcg_backend.domain.vo.TaxonomySearchApiResponseVo;
import br.com.olatcg_backend.enumerator.AlignmentTypeEnum;
import br.com.olatcg_backend.enumerator.ErrorEnum;
import br.com.olatcg_backend.enumerator.SequenceTypeEnum;
import br.com.olatcg_backend.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaxonomyConverter {

    @Autowired
    private IUserData userRepository;
    @Autowired
    private IBiologicalSequenceData sequenceRepository;
    @Autowired
    private IAlignmentData alignmentRepository;
    @Autowired
    private ITaxonomyData taxonomyRepository;

    @Transactional
    public List<Taxonomy> from(TaxonomySearchApiResponseVo response, Analysis analysis, File file) throws CustomException {
        try{
            List<Taxonomy> taxonomies = response.getAlignments().stream().map(item -> {
                BiologicalSequence inputBiologicalSequence = new BiologicalSequence(item.getInputSequence(), SequenceTypeEnum.DNA.name(), item.getCountryOrigin(), item.getExternalDatabaseId());
                BiologicalSequence matchBiologicalSequence = new BiologicalSequence(item.getMatchSequence(), SequenceTypeEnum.DNA.name(), item.getCountryOrigin(), item.getExternalDatabaseId());
                sequenceRepository.saveAll(Arrays.asList(inputBiologicalSequence, matchBiologicalSequence));
                Alignment alignment = new Alignment(null, AlignmentTypeEnum.GLOBAL.name(), null,
                        item.getInputAlignment(), item.getMatchAlignment(), inputBiologicalSequence, matchBiologicalSequence, item.getScore());
                alignmentRepository.save(alignment);

                return new Taxonomy(
                        item.getTaxonomy(),
                        alignment,
                        analysis,
                        file,
                        userRepository.findByName("admin")
                );
            }).collect(Collectors.toList());
            taxonomyRepository.saveAll(taxonomies);
            return taxonomies;
        } catch (Exception e) {
            throw new CustomException(ErrorEnum.CONVERT_TAXONOMY_SEARCH_API_RESPONSE_TO_TAXONOMY_ERROR);
        }
    }
}
