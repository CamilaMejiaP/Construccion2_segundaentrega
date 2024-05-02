package tdea.construccion2.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdea.construccion2.app.models.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person,Long> {
	 public Person findByUsername(String username);
}
