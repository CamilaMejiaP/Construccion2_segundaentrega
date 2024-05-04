package tdea.construccion2.app.dao;

import tdea.construccion2.app.dto.ClinicHistoryDto;

public interface IClinicHistory {
	public ClinicHistoryDto CreateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception;
	public ClinicHistoryDto UpdateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception;
	public boolean existClinicHistory(int id) throws Exception;
	public ClinicHistoryDto findClinicHistoryById(int id) throws Exception;
}
