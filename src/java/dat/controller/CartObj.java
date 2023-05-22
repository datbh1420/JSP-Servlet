package dat.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CartObj implements Serializable {

    private String customerID;
    private Map<String, Integer> items;
    
    public String getCustomerID() {
        return customerID;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void addItemToCart(String title) {
        if (items == null) {
            items = new HashMap<String, Integer>();
        }
        int quantity = 1;
        if (items.containsKey(title)) {
            quantity = items.get(title) + 1;

        }
        items.put(title, quantity);
    }

    public void removeFromCart(String title) {
        if (items == null) {
            return;
        }
        if(items.containsKey(title)){
            this.items.remove(title);
        } 
    }
}
