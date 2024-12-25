package Lab12_1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class OrderManger {
	private List<Order> orders;

	public OrderManger(List<Order> orders) {
		this.orders = orders;
	}

	public Product maxProduct() {
		return this.orders.stream().flatMap(x -> x.items.stream()).map(x -> x.item)
				.max(Comparator.comparing(item -> item.price)).orElse(null);
	}

	public Map<Object, Integer> productTypesStatistics() {
        return this.orders.stream().flatMap(x -> x.items.stream()).collect(Collectors.groupingBy(x -> x.item.type, Collectors.summingInt(x -> x.amount)));
	}
	public TreeSet<Order> ordersByCost() {
        TreeSet<Order> sortedOrders = new TreeSet<>(Comparator.comparing(Order::getTotalCost).reversed().thenComparing(Order::getDate));
        sortedOrders.addAll(this.orders);
        return sortedOrders;
    }
}
