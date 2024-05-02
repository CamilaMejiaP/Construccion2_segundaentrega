package tdea.construccion2.app.dto;

import tdea.construccion2.app.models.Person;

public class PersonDto {

	private long id;
	private int age;
	private int roleId;
	private String name;
	private String username;
	private String password;

	public PersonDto(long id, int age, int roleId, String name, String username, String password) {
		super();
		this.id = id;
		this.age = age;
		this.roleId = roleId;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public PersonDto(Person person) {
		this.age = person.getAge();
		this.roleId = person.getRoleId();
		this.name = person.getName();
		this.username = person.getUsername();
		this.password = person.getPassword();
	}
	public PersonDto(String userName, String password) {
		this.username = userName;
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getRoleId() {
 		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
