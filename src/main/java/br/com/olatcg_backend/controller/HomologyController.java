package br.com.olatcg_backend.controller;

import br.com.olatcg_backend.mapper.HomologyMapper;
import br.com.olatcg_backend.repository.AnalysisRepository;
import br.com.olatcg_backend.service.HomologySearchService;
import io.tej.SwaggerCodgen.api.HomologyApi;
import io.tej.SwaggerCodgen.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/api")
public class HomologyController implements HomologyApi {

    @Autowired
    private HomologyMapper homologyMapper;

    @Autowired
    private HomologySearchService homologySearchService;

    @Autowired
    private AnalysisRepository analysisRepository;

    @Override
    public ResponseEntity<HomologySearchRespDTO> search(SearchToolEnumDTO type, HomologySearchReqDTO homologySearchReqDTO) {
        var homology = homologyMapper.dtoToDomain(homologySearchReqDTO, type);
        var taxAnalysis = homologySearchService.execute(homology);
        var homologySearchRespDTO = homologyMapper.analysisToHomologySearchDto(taxAnalysis);
        return new ResponseEntity<>(homologySearchRespDTO, HttpStatus.CREATED);
    }
}
