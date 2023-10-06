package Lab3;

public class orderItem {
	    Product product;
	    int quantity;
	    double price;

	    orderItem(Product product, int quantity, double price) {
	        this.product = product;
	        this.quantity = quantity;
	        this.price = price;
	    }

	    double getCost() {
	        return this.quantity * this.price;
	    }
	

}
