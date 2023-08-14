package br.com.olatcg_backend.service;

import io.tej.SwaggerCodgen.model.SequenceIdPairDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HomologyServiceTest {

    @InjectMocks
    private HomologySearchService homologySearchService;

    /*@Test
    void performHomologySearchTest() throws Exception {
        List<SequenceIdPairDTO> sequenceIdPairDTOList = List.of(
                new SequenceIdPairDTO()
                        .id(1L)
                        .sequence("atcg"),
                new SequenceIdPairDTO()
                        .id(2L)
                        .sequence("gcta")
        );

        homologySearchService.execute(sequenceIdPairDTOList);
    }*/
}