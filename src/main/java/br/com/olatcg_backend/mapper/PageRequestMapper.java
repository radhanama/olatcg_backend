package br.com.olatcg_backend.mapper;

import io.tej.SwaggerCodgen.model.SortEnumDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageRequestMapper {

    public static PageRequest getPageRequest(Integer pageNumber, Integer pageSize, String sort) {
        Sort sortBy = Sort.by("id");

        return PageRequest.of(pageNumber, pageSize,
                sort.equals(SortEnumDTO.ASC.getValue()) ?
                        sortBy.ascending() : sortBy.descending());
    }

}
