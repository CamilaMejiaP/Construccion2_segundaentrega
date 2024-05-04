package tdea.construccion2.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdea.construccion2.app.models.ClinicHistory;

@Repository
public interface IClinicHistoryRepository  extends JpaRepository<ClinicHistory,  Integer>{
	 public ClinicHistory findById(int id);
	 public boolean existsById(int id);
}
