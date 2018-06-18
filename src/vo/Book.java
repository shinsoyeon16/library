package vo;

public class Book {
	private String name;
	private String author;
	private String company;
	private String field;
	private String isbn;
	
	public Book() {}
	public Book(String name, String author, String company, String field, String isbn) {
		this.name=name; this.author=author; this.company=company; this.field=field;this.isbn=isbn;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}


}
