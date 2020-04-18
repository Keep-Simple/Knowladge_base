package BaseCourse.Collections.Third;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if (item != null && quantity > 0) {
            list.put(item, quantity);
            return quantity;
        }
        return -1;
    }

    public void checkOut() {
        list.clear();
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping Basket " + name + " contains " + list.size() + " " + ((list.size() == 1) ? "item" : " items") + "\n";
        double totalCost = 0;
        for (Map.Entry<StockItem, Integer> entry : list.entrySet()) {
            s += entry.getKey().getName() + " with price " + entry.getKey().getPrice() + " : " + entry.getValue() + " added\n";
            totalCost += entry.getKey().getPrice() * entry.getValue();
        }
        return s + "\nTotal cost is:\n" + String.format("%.2f", totalCost);
    }
}
