package database;

public class Locallist {
	public String first;
	
	public Locallist(String first) {
		super();
		this.first = first;
	}
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}



	@Override
	public String toString() {
		return first;
	}
	

}
