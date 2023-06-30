package library;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Main {
	static boolean valid1;
	static String customerId;
	static String customerName = null;
	static int numberOfBorrowedbooks = 0;
	static String bookId;
	static String bookName = null;
	static String bookGenre = null;
	static double bookCost = 0;
	static int copies = 0;
	static boolean valid;

	static HashMap<String, Book> map = new HashMap<>();
	static HashMap<String, Customer> map1 = new HashMap<>();
	static Scanner scan = new Scanner(System.in);

	public static void display() {
		System.out.println("\nCUI menu\n" + "\n1.add a book.\n" + "2.add a customer\n" + "3.View all books\n"
				+ "4.View all customers\n" + "5.issue the book\n" + "6.return a book\n" + "7. exit");
	}

	public static void addBook() {
		switch1: {
			do {
				System.out.println("Enter Book id:");
				bookId = scan.next();

				valid = bookId.matches("[0-9]+");
				if (!valid) {
					System.out.println("invalid id");
				}
				for (Map.Entry<String, Book> b : map.entrySet()) {
					if (b.getKey().equalsIgnoreCase(bookId)) {
						System.out.println("Book ID already exists.");
						break switch1;
					}
				}

			} while (!valid);

			do {
				System.out.println("Enter Book name:");
				bookName = scan.next();

				valid = bookName.matches("[A-Za-z]*");
				if (!valid) {
					System.out.println("Input invalid type.");
				}
			} while (!valid);
			do {
				System.out.println("Enter Book genre:");
				bookGenre = scan.next();

				valid = bookGenre.matches("[A-Za-z]*");
				if (!valid) {
					System.out.println("Input invalid type.");
				}
			} while (!valid);

			do {
				System.out.println("Enter Price of Book:");
				if (scan.hasNextDouble()) {
					bookCost = scan.nextDouble();
					valid = true;
				} else {
					System.out.println("Enter valid price");
					valid = false;
					scan.next();
				}
			} while (!valid);

			do {
				System.out.println("Enter copies:");
				if (scan.hasNextInt()) {
					copies = scan.nextInt();
					valid = true;
				} else {
					System.out.println("Enter valid copies");
					valid = false;
					scan.next();
				}
			} while (!valid);
			Book book = new Book(bookName, bookGenre, bookCost, copies);
			map.put(bookId, book);
			System.out.println("Book Inserted  ");

		}
	}

	public static void showBook() {
		System.out.printf("%5s %15s %15s %15s %15s", "ID", "BookName", "Genre", "Cost", "copies");
		System.out.println();
		for (Map.Entry<String, Book> m : map.entrySet()) {
			String key = m.getKey();
			Book b = m.getValue();
			System.out.printf("%5s %15s %15s %15s %15s", key, b.getBook_name(), b.getBook_genre(), b.getBook_cost(),
					b.getCopies());
			System.out.println();
		}
	}

	public static void addCustomer() {
		switch1: {
			do {
				System.out.println("Enter Customer id:");
				customerId = scan.next();
				valid1 = customerId.matches("[0-9]+");
				if (!valid1) {
					System.out.println("invalid id");
				}
				for (Map.Entry<String, Customer> b : map1.entrySet()) {
					if (b.getKey().equalsIgnoreCase(customerId)) {
						System.out.println("Customer ID already exists.");
						break switch1;
					}
				}
			} while (!valid1);

			do {
				System.out.println("Enter customer name:");
				customerName = scan.next();

				valid1 = customerName.matches("[A-Za-z]*");
				if (!valid1) {
					System.out.println("Input invalid type.");
				}
			} while (!valid1);
			Customer cust = new Customer(customerName, numberOfBorrowedbooks);
			map1.put(customerId, cust);
			System.out.println("Customer Inserted ");
		}
	}

	public static void showCustomer() {
		System.out.printf("%5s %15s %15s %15s", "ID", "CustomerName", "NumberOfBorrowedBooks", "Books Borrowed");
		System.out.println();
		for (Map.Entry<String, Customer> m : map1.entrySet()) {
			String key = m.getKey();
			Customer c = m.getValue();
			System.out.printf("%5s %15s %15s %15s", key, c.getCustomer_name(), c.getNumberOfBorrowedbooks(),
					c.getborrowedBook());
			System.out.println();
		}
	}

	public static void BorrowBook() {
		switch1: {
			do {
				System.out.println("Enter Customer id:");
				customerId = scan.next();
				valid1 = customerId.matches("[0-9]+");
				if (!valid1) {
					System.out.println("invalid id");
				}
			} while (!valid1);

			Entry<String, Customer> customer1 = null;
			for (Map.Entry<String, Customer> cc : map1.entrySet()) {
				if (cc.getKey().equalsIgnoreCase(customerId)) {
					customer1 = cc;
					break;
				}
			}

			if (customer1 == null) {
				System.out.println("Customer ID not exists.");
				break switch1;
			}

			do {
				System.out.println("Enter Book id:");
				bookId = scan.next();

				valid = bookId.matches("[0-9]+");
				if (!valid) {
					System.out.println("invalid id");
				}

			} while (!valid);

			Entry<String, Book> bookToBorrow = null;
			for (Map.Entry<String, Book> bb : map.entrySet()) {
				if (bb.getKey().equalsIgnoreCase(bookId)) {
					bookToBorrow = bb;
					break;
				}
			}

			if (bookToBorrow == null) {
				System.out.println("Book not found.");
				break switch1;
			}

			// Borrow the book

			if (bookToBorrow.getValue().getCopies() != 0) {
				customer1.getValue().borrowbook(bookToBorrow.getValue());

			} else {
				System.out.println("copies not availble");
			}
		}
	}

	public static void returnBook() {
		switch1: {
			do {
				System.out.println("Enter Customer id:");
				customerId = scan.next();
				valid1 = customerId.matches("[0-9]+");
				if (!valid1) {
					System.out.println("invalid id");
				}
			} while (!valid1);

			Entry<String, Customer> customer2 = null;
			for (Map.Entry<String, Customer> cc : map1.entrySet()) {
				if (cc.getKey().equalsIgnoreCase(customerId)) {
					customer2 = cc;
					break;
				}
			}

			if (customer2 == null) {
				System.out.println("Customer ID not exists.");
				break switch1;
			}

			do {
				System.out.println("Enter Book id:");
				bookId = scan.next();

				valid = bookId.matches("[0-9]+");
				if (!valid) {
					System.out.println("invalid id");
				}
			} while (!valid);

			Entry<String, Book> bookToreturn = null;
			for (Map.Entry<String, Book> bb : map.entrySet()) {
				if (bb.getKey().equalsIgnoreCase(bookId)) {
					bookToreturn = bb;
					break;
				}
			}

			if (bookToreturn == null) {
				System.out.println("Book not found.");
				break switch1;
			}
			// return the book

			customer2.getValue().returnbook(bookToreturn.getValue());

		}
	}

	public static void main(String args[]) {
		do {
			display();
			System.out.println("\nSelect a option from 1 to 7:");
			String input = scan.next();

			switch (input) {
			case "1":
				addBook();
				break;
			case "2":
				addCustomer();
				break;
			case "3":
				showBook();
				break;
			case "4":
				showCustomer();
				break;
			case "5":
				BorrowBook();
				break;
			case "6":
				returnBook();
				break;
			case "7":
				System.out.println("Thank you");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input :-Enter number 1 to 7 ");
			}
		} while (true);
	}

}
