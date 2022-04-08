package br.com.olatcg_backend.data;

import br.com.olatcg_backend.domain.BiologicalSequence;
import org.springframework.data.repository.CrudRepository;

public interface IBiologicalSequenceData extends CrudRepository<BiologicalSequence, Integer> {
}
