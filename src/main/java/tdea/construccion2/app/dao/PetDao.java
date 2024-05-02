package tdea.construccion2.app.dao;



import org.springframework.stereotype.Service;
import tdea.construccion2.app.dto.PetDto;

@Service
public class PetDao implements IPetDao{

	@Override
	public void createPet(PetDto petDto) throws Exception {

		
	}

	@Override
	public PetDto findPetById(PetDto petDto) throws Exception {
		return petDto;
		
	}

	@Override
	public boolean findPetIfExist(PetDto petDto) throws Exception {
		return false;
		
	}

	@Override
	public PetDto findPetByName(PetDto petDto) throws Exception {
		return petDto;
		
	}

}
