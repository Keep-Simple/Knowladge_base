package basics.BaseCourse.Collections.Third;

import java.util.Objects;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private int quantity = 0;
    private double price;
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public StockItem(String name, double price, int quantity) {
        this(name, price);
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getReserved() {
        return reserved;
    }

    public int adjustReservation(int count) {
        if (this.reserved + count >= 0 && this.reserved + count <= this.quantity) {
            this.reserved += count;
            return this.reserved;
        } else
            return -1;
    }

    public void adjustQuantity(int quantity) {
        if (this.quantity + quantity >= 0)
            this.quantity += quantity;
    }

    public void setPrice(double price) {
        if (price > 0.0)
            this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        StockItem stockItem = (StockItem) o;
        return getName().equals(stockItem.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getQuantity(), getPrice());
    }

    @Override
    public int compareTo(StockItem stockItem) {
        if (this == stockItem)
            return 0;
        if (stockItem != null)
            return this.getName().compareTo(stockItem.getName());
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.getName() + " : with price " + String.format("%.2f", this.getPrice()) + " and quantity: " + this.getQuantity() + "\n";
    }
}
