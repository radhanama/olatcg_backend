package br.com.olatcg_backend.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.mapstruct.factory.Mappers;

class AnalysisMapperTest {

    private AnalysisMapper mapper;

    @BeforeEach
    void init(){
        mapper = Mappers.getMapper(AnalysisMapper.class);
    }

}