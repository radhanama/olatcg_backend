package br.com.olatcg_backend.data;

import br.com.olatcg_backend.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserData extends CrudRepository<User, Integer> {
    User findByName(String name);
}
