package br.com.olatcg_backend.data;

import br.com.olatcg_backend.domain.Alignment;
import org.springframework.data.repository.CrudRepository;

public interface IAlignmentData extends CrudRepository<Alignment, Integer> {
}
