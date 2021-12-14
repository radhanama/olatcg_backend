package br.com.olatcg_backend.service;

import br.com.olatcg_backend.data.ITaxonomySearchData;
import br.com.olatcg_backend.domain.vo.TaxonomySeachApiRequestVo;
import br.com.olatcg_backend.enumerator.ErrorEnum;
import br.com.olatcg_backend.enumerator.SupportedApiDatabases;
import br.com.olatcg_backend.enumerator.SupportedFileType;
import br.com.olatcg_backend.util.CustomException;
import br.com.olatcg_backend.vision.dto.SequenceFileDTO;
import br.com.olatcg_backend.vision.dto.TaxonomySearchResponseDTO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TaxonomySearchService {
    @Autowired
    private ITaxonomySearchData taxonomySearchRepository;

    public TaxonomySearchResponseDTO searchTaxonomyFrom(SequenceFileDTO dto){
        try{
            byte[] decoded = Base64.decodeBase64(dto.getContent());
            String decodedString = new String(decoded, "UTF-8");
            this.validateSequenceFile(decodedString, dto.getType());
            List<String> sequences = Arrays.asList(decodedString.split("\n"));
            return new TaxonomySearchResponseDTO(taxonomySearchRepository
                    .obtainTaxonomyFrom(new TaxonomySeachApiRequestVo(
                            sequences, SupportedApiDatabases.OLATCGDB)));
        }catch (CustomException e){
            return new TaxonomySearchResponseDTO(e.getErrorEnum());
        }catch (Exception e){
            return new TaxonomySearchResponseDTO(ErrorEnum.GENERAL_ERROR);
        }
    }

    private void validateSequenceFile(String decodedString, SupportedFileType type) throws CustomException {
        if(decodedString.matches("[^atcgATCG]")){
            throw new CustomException(ErrorEnum.INVALID_CHARACTERS_IN_SEQUENCE_FILE);
        }else if(type != SupportedFileType.TEXT){
            throw new CustomException(ErrorEnum.INVALID_SEQUENCE_FILE_TYPE);
        }
    }
}
