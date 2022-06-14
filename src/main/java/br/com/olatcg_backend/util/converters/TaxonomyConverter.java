package br.com.olatcg_backend.util.converters;

import br.com.olatcg_backend.data.IUserData;
import br.com.olatcg_backend.domain.Alignment;
import br.com.olatcg_backend.domain.BiologicalSequence;
import br.com.olatcg_backend.domain.File;
import br.com.olatcg_backend.domain.Taxonomy;
import br.com.olatcg_backend.domain.vo.TaxonomySearchApiResponseVo;
import br.com.olatcg_backend.domain.vo.TaxonomySearchBlastnApiResponseVo;
import br.com.olatcg_backend.enumerator.AlignmentTypeEnum;
import br.com.olatcg_backend.enumerator.ErrorEnum;
import br.com.olatcg_backend.enumerator.SequenceTypeEnum;
import br.com.olatcg_backend.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaxonomyConverter {

    @Autowired
    private IUserData userRepository;

    public List<Taxonomy> from(TaxonomySearchApiResponseVo response, File file) throws CustomException {
        try{
            return response.getAlignments().stream().map(item -> {
                BiologicalSequence inputBiologicalSequence = new BiologicalSequence(item.getInputSequence(), SequenceTypeEnum.DNA.name(), item.getCountryOrigin(), item.getExternalDatabaseId());
                BiologicalSequence matchBiologicalSequence = new BiologicalSequence(item.getMatchSequence(), SequenceTypeEnum.DNA.name(), item.getCountryOrigin(), item.getExternalDatabaseId());

                Alignment alignment = new Alignment(item.getSimilarity(), AlignmentTypeEnum.GLOBAL.name(), null,
                        item.getInputAlignment(), item.getMatchAlignment(), inputBiologicalSequence, matchBiologicalSequence, item.getScore());

                return new Taxonomy(
                        item.getTaxonomy(),
                        alignment,
                        file,
                        userRepository.findByName("admin")
                );
            }).collect(Collectors.toList());
        } catch (Exception e) {
            throw new CustomException(ErrorEnum.CONVERT_TAXONOMY_SEARCH_API_RESPONSE_TO_TAXONOMY_ERROR);
        }
    }

    public List<Taxonomy> from(TaxonomySearchBlastnApiResponseVo response) throws CustomException {
        try{
            return response.getAlignments().stream().map(item -> {

                Alignment alignment = new Alignment(null, AlignmentTypeEnum.GLOBAL.name(), null,
                        item.getInputAlignment(), item.getMatchAlignment(), null, null, null);

                return new Taxonomy(
                        item.getSequenceDescription(),
                        alignment,
                        userRepository.findByName("admin")
                );
            }).collect(Collectors.toList());
        } catch (Exception e) {
            throw new CustomException(ErrorEnum.CONVERT_TAXONOMY_SEARCH_API_RESPONSE_TO_TAXONOMY_ERROR);
        }
    }
}
