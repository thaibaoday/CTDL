package Lab4;

import Lab3.orderItem;

public class Task1_4 {
	    orderItem[] items;

	    Task1_4(orderItem[] items) {
	        this.items = items;
	    }

	    void sortByProductId() {
	        for (int i = 1; i < this.items.length; ++i) {
	            orderItem key = this.items[i];
	            int j = i - 1;

	            while (j >= 0 && this.items[j].product.id < key.product.id) {
	                this.items[j + 1] = this.items[j];
	                j = j - 1;
	            }
	            this.items[j + 1] = key;
	        }
	    }


}
