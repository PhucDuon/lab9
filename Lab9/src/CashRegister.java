import java.text.DecimalFormat;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class CashRegister implements ProductObserver {
    private DoubleProperty cash = new SimpleDoubleProperty(); 

    private static final DecimalFormat format = new DecimalFormat("###,##0.00");
       
    public final DoubleProperty cashProperty() {
        return cash;
    }
    public final double getCash() {
        return cash.get();
    }
    public CashRegister() {
        cash.set(0.0);
    }

    public void add(double money) {
        String formattedmoney = format.format(money);
        double income = Double.parseDouble(formattedmoney);
        cash.set(cash.get() + income);
    }

    @Override
    public void handleSale(double amount) {
        add(amount);
    }

}