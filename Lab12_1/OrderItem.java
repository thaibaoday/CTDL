package Lab12_1;

public class OrderItem {
	Product item;
	 int amount;

	public OrderItem(Product item, int amount) {
		this.item = item;
		this.amount = amount;
	}

	public int getTotalPrice() {
		return this.item.price * this.amount;
	}

}
