package OnlineShop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Item> map;
    private Item item;

    public ShoppingCart(){
        map = new HashMap<>();
    }

    public void add(String product, int price){
        if (map.containsKey(product)) {

            map.get(product).increaseQuantity();
        } else {
            map.put(product, new Item(product, 1, price));
        }
    }

    public int price(){
        int sum = 0;
        for (Item item : map.values()){
            sum += item.price();
        }
        return sum;
    }

    public void print(){
        for (Item item : map.values()){
            System.out.println(item.getProduct() +": "+  item.getQty());
        }
    }


}
