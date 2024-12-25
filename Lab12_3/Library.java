package Lab12_3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Library {
	private String name;
	private List<Book> books;

	public Library(String name, List<Book> books) {
		this.name = name;
		this.books = books;
	}

	public Book getOldestBook() {
		Comparator<Book> comparator = Comparator.comparing(Book::getYear).thenComparing(Book::getTitle);
		return this.books.stream().max(comparator).get();
	}

	public Map<Integer, List<Book>> getBooksByYears() {
		return this.books.stream().collect(Collectors.groupingBy(Book::getYear));
	}

	public Set<Book> findBooks(String author, int year) {
		Comparator<Book> comparator = Comparator.comparing(Book::getTitle);
		return this.books.stream().filter(x -> x.hasAuthor_Year(author, year))
				.collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
	}

}
