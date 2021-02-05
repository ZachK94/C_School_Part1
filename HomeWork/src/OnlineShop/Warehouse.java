package OnlineShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {

    private Map<String, Integer> productPrice;
    private Map<String, Integer> stockProducts;

    public Warehouse(){
        productPrice = new HashMap<>();
        stockProducts = new HashMap<>();
    }



    public void addProduct(String product, int price, int stock){
        productPrice.put(product, price);
        stockProducts.put(product, stock);
    }

    public int price(String product){
        if (productPrice.containsKey(product)){
        return productPrice.get(product);
        }
        else {
            return -99;
        }
    }

    public int stock(String product){
        if (stockProducts.containsKey(product)){
            return stockProducts.get(product);
        }
        else {
            return 0;
        }
    }

    public boolean take(String product){
        if (stockProducts.containsKey(product)) {
            stockProducts.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public Set<String> products(){
        return productPrice.keySet();
    }




}
