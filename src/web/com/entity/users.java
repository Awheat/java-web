package web.com.entity;

public class users {
	private int id;
	private String name;
	private int gender;
	private int age;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public users() {
		super();
	}

	public users(int id, String name, int gender, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}

	public users(String name, int gender, int age, String address) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}

}
