package tdea.construccion2.app.dto;
import tdea.construccion2.app.models.Pet;

public class PetDto {
	
	private int id;
	private String name;
	private int age;
	private String species;
	private String breed;
	private String characteristics;
	private double weight;
	private long ownerId;
	

	public PetDto(String name, int age, String species, String breed, String characteristics, double weight,
			long ownerId) {
		super();
		this.name = name;
		this.age = age;
		this.species = species;
		this.breed = breed;
		this.characteristics = characteristics;
		this.weight = weight;
		this.ownerId = ownerId;
	}

	public PetDto(Pet pet) {
		this.name = pet.getName();
		this.age = pet.getAge();
		this.ownerId = pet.getOwnerId();
		this.species = pet.getSpecies();
		this.breed = pet.getBreed();
		this.characteristics = pet.getCharacteristics();
		this.weight = pet.getWeight();
	}	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}

	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
