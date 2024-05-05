package tdea.construccion2.app.dao;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dto.ClinicHistoryDto;
import tdea.construccion2.app.models.ClinicHistory;
import tdea.construccion2.app.repository.IClinicHistoryRepository;

@Service
public class ClinicHistoryDao implements IClinicHistory{
	
	@Autowired
	private IClinicHistoryRepository clinicHistoryRepository;

	@Override
	public ClinicHistoryDto CreateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception {
		ClinicHistory clinicHistory =  new ClinicHistory();
		clinicHistory.setDiagnostic(clinichistorydto.getDiagnostic());
		clinicHistory.setDetails(clinichistorydto.getDetails());
		clinicHistory.setDosis(clinichistorydto.getDosis());
		clinicHistory.setMedicines(clinichistorydto.getMedicines());
		clinicHistory.setProcedure(clinichistorydto.getProcedure());
		clinicHistory.setReason(clinichistorydto.getReason());
		clinicHistory.setSymptoms(clinichistorydto.getSymptoms());
		clinicHistory.setVaccionationHistory(clinichistorydto.getVaccionationHistory());
		clinicHistory.setAnulation(clinichistorydto.getAnulation());
		int orderIdValue = Objects.equals(clinichistorydto.getOrderId(), null) ? 0 : clinichistorydto.getOrderId();        
        clinicHistory.setOrderId(orderIdValue);
		clinicHistory.setVeterinarianId(clinichistorydto.getVeterinarianId());
		clinicHistory.setRegisterDate(clinichistorydto.getRegisterDate());
		clinicHistoryRepository.save(clinicHistory);
		return new ClinicHistoryDto(clinicHistory);
	}

	@Override
	public ClinicHistoryDto UpdateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception {
		ClinicHistory clinicHistory =  new ClinicHistory();
		clinicHistory.setDiagnostic(clinichistorydto.getDiagnostic());
        clinicHistory.setDetails(clinichistorydto.getDetails());
        clinicHistory.setDosis(clinichistorydto.getDosis());
        clinicHistory.setMedicines(clinichistorydto.getMedicines());
        clinicHistory.setProcedure(clinichistorydto.getProcedure());
        clinicHistory.setReason(clinichistorydto.getReason());
        clinicHistory.setSymptoms(clinichistorydto.getSymptoms());
        clinicHistory.setVaccionationHistory(clinichistorydto.getVaccionationHistory());
        clinicHistory.setAnulation(clinichistorydto.getAnulation());
        int orderIdValue = Objects.equals(clinichistorydto.getOrderId(), null) ? 0 : clinichistorydto.getOrderId();        
        clinicHistory.setOrderId(orderIdValue);
        clinicHistory.setOrderId(clinichistorydto.getOrderId());
        clinicHistory.setVeterinarianId(clinichistorydto.getVeterinarianId());
        clinicHistory.setRegisterDate(clinichistorydto.getRegisterDate());
        clinicHistory = clinicHistoryRepository.save(clinicHistory);
        return new ClinicHistoryDto(clinicHistory);
	}

	@Override
	public boolean existClinicHistory(int id) throws Exception {
		return clinicHistoryRepository.existsById(id);
	}

	@Override
	public ClinicHistoryDto findClinicHistoryById(int id) throws Exception {
		ClinicHistory clinicHistory = clinicHistoryRepository.findById(id);
	    if (clinicHistory == null) {
	       return null;
	    } 
	    return new ClinicHistoryDto(clinicHistory);
	}

	
 
	
}
