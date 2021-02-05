package OnlineShop;

public class Item {

    private String product;
    private int qty;
    int unitPrice;

    public Item(String product, int qty, int unitPrice){
        this.product = product;
        this.qty = qty;
        this.unitPrice  = unitPrice;
    }

    public int price(){
        return this.unitPrice * this.qty;
    }

    public void increaseQuantity(){
        this.qty++;
    }

    public String toString(){
        return this.product + ": " + this.qty;
    }


    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
