package br.com.olatcg_backend.mapper;

import br.com.olatcg_backend.domain.homology.search.SequenceIdPair;
import io.tej.SwaggerCodgen.model.SequenceIdPairDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SequenceIdPairMapper {

    List<SequenceIdPair> dtoListToDomainList(List<SequenceIdPairDTO> sequenceIdPairDTOList);

    @Mapping(source = "queryId", target = "id")
    SequenceIdPair dtoToDomain(SequenceIdPairDTO sequenceIdPairDTO);
}
