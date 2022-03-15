package br.com.olatcg_backend.service;

import br.com.olatcg_backend.data.IPhylogenySearchData;
import br.com.olatcg_backend.data.ITaxonomyData;
import br.com.olatcg_backend.domain.Analysis;
import br.com.olatcg_backend.domain.Taxonomy;
import br.com.olatcg_backend.domain.vo.PhylogenyApiRequestVo;
import br.com.olatcg_backend.enumerator.ErrorEnum;
import br.com.olatcg_backend.util.CustomException;
import br.com.olatcg_backend.util.FileUtils;
import br.com.olatcg_backend.vision.dto.PhylogenyResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhylogenyService {
    @Autowired
    private ITaxonomyData taxonomyRepository;
    @Autowired
    private FileUtils fileUtils;
    @Autowired
    private IPhylogenySearchData phylogenySearchRepository;

    public PhylogenyResponseDTO getNewickFormatFromTaxonomy(Long idAnalysis) {
        try{
            List<Taxonomy> taxonomies = taxonomyRepository.findByAnalysis(new Analysis(idAnalysis));
            return new PhylogenyResponseDTO(phylogenySearchRepository.obtainNewickFormatFrom(
                    new PhylogenyApiRequestVo(fileUtils.generateEncodedFastaFileFrom(taxonomies))));
        }catch (CustomException e){
            return new PhylogenyResponseDTO(e.getErrorEnum());
        }catch (Exception e) {
            return new PhylogenyResponseDTO(ErrorEnum.GENERAL_ERROR);
        }
    }
}
