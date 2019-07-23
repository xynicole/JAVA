package assignment01;

public class University {
	private String name;
	private String city;

	public University(String uName, String uct) {
		name = uName;
		city = uct;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUniversity() {
		return name;
	}

	public String getCity() {
		return city;
	}

}