package tdea.construccion2.app.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dto.PetDto;
import tdea.construccion2.app.models.Pet;
import tdea.construccion2.app.repository.IPetRepository;

@Service
public class PetDao implements IPetDao{
	
	@Autowired
	private  IPetRepository petRepository;

	@Override
	public PetDto createPet(PetDto petDto) throws Exception {
		Pet pet = new Pet();
		pet.setName(petDto.getName());	
		pet.setAge(petDto.getAge());
		pet.setBreed(petDto.getBreed());
		pet.setCharacteristics(petDto.getCharacteristics());
		pet.setSpecies(petDto.getSpecies());
		pet.setWeight(petDto.getWeight());
		pet.setOwnerId(petDto.getOwnerId());
		petRepository.save(pet);
		return new PetDto(pet);
	}

	@Override
	public boolean findPetIfExist(int id) throws Exception {
		return petRepository.existsById(id);
	}

	@Override
	public PetDto findPetById(int id) throws Exception {
		Pet pet = petRepository.findById(id);
		if(pet == null) {
			return null;
		}
		return new PetDto(pet);
	}

	@Override
	public PetDto findPetByName(String name) throws Exception {
		Pet pet = petRepository.findByName(name);
		if(pet == null) {
			return null;
		}
		return new PetDto(pet);
	}

	

}
