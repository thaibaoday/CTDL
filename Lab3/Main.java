package Lab3;

public class Main {
	public static void main(String[] args) {
		Product p1 = new Product(1, "Product 1", "Type A");
		Product p2 = new Product(2, "Product 2", "Type B");
		Product p3 = new Product(3, "Product 3", "Type A");

		orderItem[] items = { new orderItem(p3, 2, 20.0), new orderItem(p1, 1, 15.0), new orderItem(p2, 3, 10.0) };

		Order order = new Order(items);
		order.sortItemsById();

		System.out.println("Total cost: " + order.cost());
		System.out.println("Contains product 2: " + order.contains(2));

		System.out.println("Items of Type A:");
		for (orderItem item : order.filter("Type A")) {
			System.out.println("Product ID: " + item.product.id);
		}
	}
}
