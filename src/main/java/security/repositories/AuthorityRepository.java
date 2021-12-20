package security.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import security.entities.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {
}
