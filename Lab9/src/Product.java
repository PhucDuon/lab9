import java.text.DecimalFormat;
import java.util.LinkedList;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;


public class Product {
    private LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();
    private String name;
    private int stock;
    private double price;
    private IntegerProperty sold = new SimpleIntegerProperty();
    private IntegerProperty left = new SimpleIntegerProperty();
    private DoubleProperty income = new SimpleDoubleProperty();

    public Product(String name, int stock, double price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        // income.bind(sold.multiply(price));
        // left.bind(Bindings.subtract(stock, sold));
        // sold.set(0);
    }
    public final String getName() { return name; }
    public final int getStock() { return stock; }
    public final double getPrice() { return price; }

    public final ReadOnlyIntegerProperty soldProperty() { return sold; }
    public final int getSold() { return sold.get(); }
    public final ReadOnlyIntegerProperty leftProperty() { return left; }
    public final int getLeft() { return left.get(); }
    public final ReadOnlyDoubleProperty incomeProperty() { return income; }
    public final double getIncome() { return income.get(); }
   
    public void sell(int n) {
        sold.set(sold.get() + n);
        stock = stock - n;
        double money = n * price;
        for (ProductObserver observer : observers)
            observer.handleSale(money);
    }

    public void restock(int n) {
        stock = stock + n;
    }

    public boolean has(int n) {
        return stock >= n;
    }

    public void addProductObserver(ProductObserver observer) {
        observers.add(observer);
    }

    @Override
    public String toString() {
        return stock + " " + name + " at $" + formatted(price);
    }
    private String formatted(double value) {
          return new DecimalFormat("###,##0.00").format(value);
    }
}