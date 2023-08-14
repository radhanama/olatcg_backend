package br.com.olatcg_backend.mapper;

import br.com.olatcg_backend.entity.Taxonomy;
import io.tej.SwaggerCodgen.model.TaxonomyDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaxonomyMapper {
    TaxonomyDTO entityToDto(Taxonomy taxonomy);
}
