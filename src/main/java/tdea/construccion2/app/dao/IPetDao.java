package tdea.construccion2.app.dao;

import tdea.construccion2.app.dto.PetDto;

public interface IPetDao {
	public PetDto createPet(PetDto petDto) throws Exception;
	public boolean findPetIfExist(int id)throws Exception;
	public PetDto findPetById(int id) throws Exception;
	public PetDto findPetByName(String name) throws Exception;
}
