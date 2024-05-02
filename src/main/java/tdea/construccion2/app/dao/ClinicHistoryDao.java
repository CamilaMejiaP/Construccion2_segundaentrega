package tdea.construccion2.app.dao;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dto.ClinicHistoryDto;

@Service
public class ClinicHistoryDao implements IClinicHistory{

	@Override
	public void CreateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception {
	}

	@Override
	public void UpdateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception {
	
	}

	@Override
	public String getHistoryClinicDetails(int id) throws Exception {
		return "";
	}

	@Override
	public boolean existClinicHistory(int id) throws Exception {
		
		return true;
	}
 
	
}
