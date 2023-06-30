package library;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String customerId;
	private String customerName;
	private int numberOfBorrowedbooks;
	private List<Book> borrowedBook;

	public Customer(String customer_name, int numberOfBorrowedbooks) {
		super();
		this.customerName = customer_name;
		this.numberOfBorrowedbooks = numberOfBorrowedbooks;
		this.borrowedBook = new ArrayList<>();
	}

	public int getNumberOfBorrowedbooks() {
		return numberOfBorrowedbooks;
	}

	public void setNumberOfBorrowedbooks(int numberOfBorrowedbooks) {
		this.numberOfBorrowedbooks = numberOfBorrowedbooks;
	}


	@Override
	public String toString() {
		return "Customer [customer_id=" + customerId + ", customer_name=" + customerName + "]";
	}


	public String getCustomer_id() {
		return customerId;
	}

	public void setCustomer_id(String customer_id) {
		this.customerId = customer_id;
	}

	public void setBorrowedBook(List<Book> borrowedBook) {
		this.borrowedBook = borrowedBook;
	}

	public String getCustomer_name() {
		return customerName;
	}

	public void setCustomer_name(String customer_name) {
		this.customerName = customer_name;
	}

	public List<Book> getborrowedBook() {
		return borrowedBook;
	}
	
	public void returnbook(Book book) {
		if (numberOfBorrowedbooks != 0) {
			book.increasecopies();
			numberOfBorrowedbooks--;
			getborrowedBook().remove(book);
			System.out.println("Book has been returned successfully");
		} else {
			System.out.println("you dont have any borrowed book");
		}
	}
	
	public void borrowbook(Book book) {
		if (borrowedBook.contains(book)) {
			System.out.println("you already have this book");
			return;
		}
		if (numberOfBorrowedbooks <= 2) {
			book.decreasecopies();
			borrowedBook.add(book);
			numberOfBorrowedbooks++;

			System.out.println("Book borrowed successfully ");
		} else {
			System.out.println("U have more than 3 books");
		}

	}
	
}
