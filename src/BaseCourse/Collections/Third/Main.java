package BaseCourse.Collections.Third;

import java.util.Map;

public class Main {
    /**
     * Simulating shop
     * Creating separate classes for Items(StockItem), for our catalog(StockList) and for user basket(Basket)
     * In StockItem we implement Comparable, hashcode(), equals() to be able to work with Sorted Collection like:
     * TreeSet, TreeMap
     * Also overriding method toString, mainly to test the results easily
     * Used Collections.unmodifiableMap(list) to return final map, instead of returning a copy that can be modified
     * But still we will be able to modify objects that map contains if they are not immutable
     * Previously was it like List<Integer> copy = new ArrayList<>(list);
     *
     * Challenge is to add reserve functionality for the Basket, instead of selling item straightforward
     * For that we modify StockItem class(adding reserve count)
     * And created two additional methods in the Main class (reserveItem and proceedPayment)
     * And one method in StockList (reserveStock) and checkout() in the Basket class to clear the basket
     */
    private static StockList list = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread", 12.34, 5);
        list.addStock(temp);
        temp = new StockItem("Bread", 12.34, 5);
        list.addStock(temp);
        temp = new StockItem("Meat", 122.34, 11);
        list.addStock(temp);
        temp = new StockItem("Soup", 27.52, 20);
        list.addStock(temp);
        temp = new StockItem("Phone", 5500.99, 134);
        list.addStock(temp);
        //overrides previous "Phone", but increases previous quantity
        temp = new StockItem("Phone", 5300.99, 1343);
        list.addStock(temp);

        System.out.println(list);

        Basket basket = new Basket("Nick");
        reserveItem(basket,"Phone", 654);
        reserveItem(basket, "Phone", -8835);//test
        reserveItem(basket, "Soup", 3);
        reserveItem(basket, "Meat", 11);
        System.out.println(basket);
        proceedPayment(basket);
        System.out.println(list);
        System.out.println(basket);
    }

    public static int reserveItem(Basket basket, String name, int quantity) {
        StockItem item = list.get(name);
        int temp = -1;
        //Checking if we can reserve this amount, because Basket doesn't have access to StockList directly
        if (item != null && list.reserveStock(name, quantity) != -1) {
            //System.out.println(item.getReserved());
            temp = basket.addToBasket(item, item.getReserved());
        }
        return temp;
    }
    public static boolean proceedPayment(Basket basket) {
        if(basket != null) {
            for (Map.Entry<StockItem, Integer> entry : basket.Items().entrySet()) {
                list.sellStock(entry.getKey().getName(), entry.getValue());
            }
            basket.checkOut();
            return true;
        }
        return false;
    }
}
