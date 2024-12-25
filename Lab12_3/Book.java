package Lab12_3;

import java.util.List;

public class Book {
	private String id;
	private String title;
	private int price;
	private String type;
	private int year;
	private List<Author> authors;
	public Book(String id, String title, int price, String type, int year, List<Author> authors) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.type = type;
		this.year = year;
		this.authors = authors;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	 public boolean hasAuthor_Year(String author, int year) {
	        return this.authors.equals(authors) && this.year == year;
	 }

}
