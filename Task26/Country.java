package core;

public class Country {
	private int id;
	private String code;
	private String name;
	private String description;

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Country: ID = " + this.id + " Name = " + this.name + " Code = " + this.code + " Description = "
				+ this.description;
	}

}
