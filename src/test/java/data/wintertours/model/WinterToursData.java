package data.wintertours.model;

public class WinterToursData {

	private String name;
	private String email;
	private String phone;
	private String message;

	public WinterToursData(String name, String email, String phone, String message) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.message = message;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getMessage() {
		return message;
	}

}
