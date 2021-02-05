package OnlineShop;

import sun.nio.cs.ext.SJIS;

import java.util.Scanner;

public class Store {
    private Warehouse warehouse;
    private Scanner scanner;
    private boolean b = true;

    public Store(Warehouse warehouse, Scanner scanner){
        this.warehouse = warehouse;
        this.scanner = scanner;
    }

    public void shop(String customer){
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Welcome to the store " + customer);
        System.out.println("our selection:");
        for (String product : this.warehouse.products()){
            System.out.println(product);
        }

        while (b){

            System.out.print("What to put in the cart (press enter to go to the register): ");
            String product = scanner.nextLine();
            if (product.isEmpty()){
                break;
            }
            else if (product.equalsIgnoreCase("done")){
                b = false;
            } else {
                if (warehouse.products().contains(product)) {
                    cart.add(product, warehouse.price(product));
                    warehouse.take(product);
                }
            }
        }
        System.out.println("your shoppingcart contents:");
        cart.print();
        System.out.println("total: " + cart.price());
    }



}
