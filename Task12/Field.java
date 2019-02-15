package core;

public class Field {
	int id;
	String value;
	
	public Field(int id, String value) {
		this.id = id;
		this.value = value;
		
	}

	@Override
	public String toString() {
		return "Field [id=" + id + ", value=" + value + "]";
	}

}
