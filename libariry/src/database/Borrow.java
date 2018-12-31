package database;

public class Borrow {
	String id;
	int borrowUp;
	int borrowAlready;
	float ticket;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBorrowUp() {
		return borrowUp;
	}
	public void setBorrowUp(int borrowUp) {
		this.borrowUp = borrowUp;
	}
	public int getBorrowAlready() {
		return borrowAlready;
	}
	public void setBorrowAlready(int borrowAlready) {
		this.borrowAlready = borrowAlready;
	}
	public float getTicket() {
		return ticket;
	}
	public void setTicket(float ticket) {
		this.ticket = ticket;
	}

	

}
