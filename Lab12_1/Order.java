package Lab12_1;

import java.sql.Date;
import java.util.List;

public class Order {
	private String id;
	private String customer;
	private String employee;
	private Date date;
	List<OrderItem> items;
	public Date getDate() {
		return date;
	}
	public Order(String id, String customer, String employee, Date date, List<OrderItem> items) {
		this.id = id;
		this.customer = customer;
		this.employee = employee;
		this.date = date;
		this.items = items;
	}
	public int getTotalCost() {
		return this.items.stream().mapToInt(OrderItem::getTotalPrice).sum();
	}
	

}
