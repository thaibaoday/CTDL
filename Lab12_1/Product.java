package Lab12_1;

import java.sql.Date;

public class Product {
	private String name;
	 String type;
	int price;
	private Date expireDate;

	public Product(String name, String type, int price, Date expireDate) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.expireDate = expireDate;
	}

}
