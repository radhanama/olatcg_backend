package br.com.olatcg_backend.service;

import br.com.olatcg_backend.data.IAnalysisData;
import br.com.olatcg_backend.data.IFileData;
import br.com.olatcg_backend.data.ITaxonomyData;
import br.com.olatcg_backend.data.ITaxonomySearchData;
import br.com.olatcg_backend.data.IUserData;
import br.com.olatcg_backend.domain.Analysis;
import br.com.olatcg_backend.domain.File;
import br.com.olatcg_backend.domain.Taxonomy;
import br.com.olatcg_backend.domain.service.AnalysisSd;
import br.com.olatcg_backend.domain.vo.TaxonomySeachApiRequestVo;
import br.com.olatcg_backend.domain.vo.TaxonomySearchApiResponseVo;
import br.com.olatcg_backend.enumerator.AnalysisStatusEnum;
import br.com.olatcg_backend.enumerator.ErrorEnum;
import br.com.olatcg_backend.enumerator.SupportedApiDatabasesEnum;
import br.com.olatcg_backend.enumerator.SupportedFileTypeEnum;
import br.com.olatcg_backend.util.CustomException;
import br.com.olatcg_backend.util.FileUtils;
import br.com.olatcg_backend.util.converters.TaxonomyConverter;
import br.com.olatcg_backend.domain.vo.DecodedFileVo;
import br.com.olatcg_backend.vision.dto.PreProcessingSearchTaxonomyFromSequenceFileDTO;
import br.com.olatcg_backend.vision.dto.SequenceFileDTO;
import br.com.olatcg_backend.vision.dto.TaxonomyNameResponseDTO;
import br.com.olatcg_backend.vision.dto.TaxonomySearchAnalysesResponseDTO;
import br.com.olatcg_backend.vision.dto.TaxonomySearchResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class TaxonomySearchService {
    @Autowired
    private ITaxonomySearchData taxonomySearchRepository;
    @Autowired
    private ITaxonomyData taxonomyRepository;
    @Autowired
    private IUserData userRepository;
    @Autowired
    private TaxonomyConverter taxonomyConverter;
    @Autowired
    private IAnalysisData analysisRepository;
    @Autowired
    private IFileData fileRepository;
    @Autowired
    private AnalysisSd analysisSd;

    public PreProcessingSearchTaxonomyFromSequenceFileDTO preProcessingSearchTaxonomyFrom(SequenceFileDTO dto) throws CustomException {
        try {
            DecodedFileVo decodedFileVo = FileUtils.decodeFile(dto.getEncodedFile());
            this.validateTypeAndSequence(decodedFileVo.getFileType(), decodedFileVo.getDescodedContent());
            List<String> sequences = Arrays.asList(decodedFileVo.getDescodedContent().split("\n"));
            return new PreProcessingSearchTaxonomyFromSequenceFileDTO(
                    sequences,
                    dto.getName(),
                    dto.getDescription(),
                    decodedFileVo.getFileType(),
                    analysisSd.createWithStartedStatusAndTaxonomyType()
            );
        } catch (Exception e) {
            throw new CustomException(ErrorEnum.PRE_PROCESSING_TAXONOMY_SEARCH_FROM_SEQUENCE_FILE);
        }
    }

    @Async
    public TaxonomySearchResponseDTO searchTaxonomyFrom(PreProcessingSearchTaxonomyFromSequenceFileDTO preProcessingReturn) throws CustomException {
        Analysis processingAnalysis = preProcessingReturn.getProcessingAnalysis();
        try {
            TaxonomySearchApiResponseVo response = taxonomySearchRepository.obtainTaxonomyFrom(
                    new TaxonomySeachApiRequestVo(
                            preProcessingReturn.getSequences(),
                            SupportedApiDatabasesEnum.OLATCGDB
                    )
            );
            List<Taxonomy> taxonomies = ConvertResponseToTaxonomyAndSave(
                    preProcessingReturn.getFileName(),
                    preProcessingReturn.getFileDescription(),
                    preProcessingReturn.getFileType().getCode(),
                    processingAnalysis,
                    response
            );
            return new TaxonomySearchResponseDTO(taxonomies);
        //}catch (ApiCustomException e){
            /// TODO: 10/05/2022 ADICIONAR ATIVIDADE AO BANCO EM MODO "CARREGANDO" - FAZER ALTERAÇÕES NECESSÁRIAS NO BANCO
        }catch (CustomException e){
            processingAnalysis.setStatus(AnalysisStatusEnum.FAILED);
            analysisRepository.save(processingAnalysis);
            throw new CustomException(e.getErrorEnum());
        }catch (Exception e){
            processingAnalysis.setStatus(AnalysisStatusEnum.FAILED);
            analysisRepository.save(processingAnalysis);
            throw new CustomException(ErrorEnum.GENERAL_ERROR);
        }
    }

    public TaxonomySearchAnalysesResponseDTO search() {
        return new TaxonomySearchAnalysesResponseDTO(analysisRepository.findAllTaxonomyAnalyzes());
    }

    public TaxonomyNameResponseDTO findNameFrom(Long bioSeqId){
        return new TaxonomyNameResponseDTO(taxonomyRepository.findByBiologicalSequenceId(bioSeqId).getName());
    }

    @Transactional
    private List<Taxonomy> ConvertResponseToTaxonomyAndSave(String name, String description, String type, Analysis analysis, TaxonomySearchApiResponseVo response) throws CustomException {
        try {
            File file = fileRepository.save(new File(name, description, type, userRepository.findByName("admin")));
            return taxonomyConverter.from(response, file, analysis);
        }catch (Exception e){
            throw new CustomException(ErrorEnum.PERSISTENCE_DATABASE_ERROR);
        }
    }

    private void validateTypeAndSequence(SupportedFileTypeEnum type, String content) throws CustomException {
        if(!type.equals(SupportedFileTypeEnum.TEXT_PLAIN)){
            throw new CustomException(ErrorEnum.INVALID_FILE_TYPE);
        }else if(content.matches("[^atcgATCG]")){
            throw new CustomException(ErrorEnum.INVALID_CHARACTERS_IN_SEQUENCE_FILE_ERROR);
        }
    }
}
