package Lab3;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	orderItem[] items;

	Order(orderItem[] items) {
		this.items = items;
	}

	void sortItemsById() {
		Arrays.sort(this.items, Comparator.comparingInt(item -> item.product.id));
	}

	public double cost() {
		double totalCost = 0.0;
		for (orderItem item : this.items) {
			totalCost += item.getCost();
		}
		return totalCost;
	}

	public boolean contains(int productId) {
		int low = 0, high = this.items.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (this.items[mid].product.id == productId)
                return true;
            if (this.items[mid].product.id < productId)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
		
	}

	public orderItem[] filter(String type) {
		return Arrays.stream(this.items).filter(item -> item.product.type.equals(type)).toArray(orderItem[]::new);
	}
}
