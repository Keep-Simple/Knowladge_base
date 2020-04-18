package basics.BaseCourse.Collections.Third;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new HashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            //check if already exists in the list
            StockItem stockItem = list.getOrDefault(item.getName(), item);
            //if already there, adjust quantity and replace in the list
            if (item != stockItem)
                item.adjustQuantity(stockItem.getQuantity());
            list.put(item.getName(), item);
            return item.getQuantity();
        }
        return -1;
    }

    public int sellStock(String name, int quantity) {
        if (list.containsKey(name)) {
            list.get(name).adjustQuantity(-quantity);
            return quantity;
        }
        return -1;
    }

    public int reserveStock(String name, int quantity) {
        if (list.containsKey(name)) {
            return list.get(name).adjustReservation(quantity);
        } else
            return -1;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, StockItem> Items() {
        //return Map that is also "final"
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0;
        for (Map.Entry<String, StockItem> entry : list.entrySet()) {
            StockItem item = entry.getValue();
            double itemValue = item.getPrice() * item.getQuantity();
            s += item;
            totalCost += itemValue;
        }
        return s + "\nWith total cost : " + String.format("%.3f", totalCost);
    }
}
