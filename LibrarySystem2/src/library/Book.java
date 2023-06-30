package library;

public class Book {

	private String book_id;
	private String book_name;
	private String book_genre;
	private double book_cost;
	private int copies;

	Book(String book_name, String genre, double cost, int copies) {

		this.book_name = book_name;
		this.book_genre = genre;
		this.book_cost = cost;
		this.copies = copies;
	}

	@Override
	public String toString() {
		return "book_name=" + book_name + "";
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_genre() {
		return book_genre;
	}

	public void setBook_genre(String book_genre) {
		this.book_genre = book_genre;
	}

	public double getBook_cost() {
		return book_cost;
	}

	public void setBook_cost(double book_cost) {
		this.book_cost = book_cost;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public void decreasecopies() {
		copies--;
	}

	public void increasecopies() {
		copies++;
	}

}
