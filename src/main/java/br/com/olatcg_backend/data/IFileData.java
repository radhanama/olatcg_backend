package br.com.olatcg_backend.data;

import br.com.olatcg_backend.domain.File;
import org.springframework.data.repository.CrudRepository;

public interface IFileData extends CrudRepository<File, Integer> {
}
