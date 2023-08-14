package br.com.olatcg_backend.service;

import br.com.olatcg_backend.domain.enumerator.AnalysisTypeEnum;
import br.com.olatcg_backend.entity.Analysis;
import br.com.olatcg_backend.repository.AnalysisRepository;
import io.tej.SwaggerCodgen.model.AnalysisTypeEnumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.olatcg_backend.mapper.PageRequestMapper.getPageRequest;

@Service
public class AnalysisFinderService {

    @Autowired
    private AnalysisRepository analysisRepository;

    public Page<Analysis> findAll(Integer pageNumber, Integer pageSize, String sort) {
        PageRequest pageRequest = getPageRequest(pageNumber, pageSize, sort);
        return analysisRepository.findAll(pageRequest);
    }

    public Optional<Analysis> findById(Integer id) {
        return analysisRepository.findById(Long.valueOf(id));

    }

    public Page<Analysis> findByType(AnalysisTypeEnumDTO type, Integer pageNumber, Integer pageSize, String sort) {
        PageRequest pageRequest = getPageRequest(pageNumber, pageSize, sort);
        return analysisRepository.findByType(AnalysisTypeEnum.valueOf(type.name()), pageRequest);
    }

}
