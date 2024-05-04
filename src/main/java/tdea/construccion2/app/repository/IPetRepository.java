package tdea.construccion2.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdea.construccion2.app.models.Pet;

@Repository
public interface IPetRepository extends JpaRepository<Pet,Integer> {
	public Pet findById(int id);
	public Pet findByName(String name);
}
