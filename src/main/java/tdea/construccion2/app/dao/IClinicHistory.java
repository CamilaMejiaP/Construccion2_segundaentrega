package tdea.construccion2.app.dao;

import tdea.construccion2.app.dto.ClinicHistoryDto;

public interface IClinicHistory {
	public void CreateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception;
	public void UpdateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception;
	public String getHistoryClinicDetails(int id) throws Exception;
	public boolean existClinicHistory(int id) throws Exception;
}
