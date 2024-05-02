package tdea.construccion2.app.service;

import tdea.construccion2.app.dto.ClinicHistoryDto;

public interface IClinicHistoryService {
	public void CreateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception;
	public void UpdateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception;
	public String getHistoryClinicDetails(int id) throws Exception; 
}
