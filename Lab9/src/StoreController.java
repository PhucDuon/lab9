
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.beans.binding.Bindings;
public class StoreController {
    private Store store = new Store();
    public final Store getStore() {
        return store;
    }
    @FXML private Button sellBtn;
    @FXML private Text stockTxt;
    @FXML private Text priceTxt;
    @FXML private TextField amountTf;
    @FXML private Text cashTxt;
    
    private void setAmount(int amount) {
        amountTf.setText(""+ amount);
    }
    private int getAmount() {
        return Integer.parseInt(amountTf.getText());
    }
    public void handleSell(ActionEvent event) {
        if(store.getProduct().has(getAmount())) {
        store.getProduct().sell(getAmount());
        setAmount(0);
        }
    }
    @FXML
    private void initialize() {
        //nameTxt.textProperty().bind(store.getProduct().nameProperty());
        stockTxt.textProperty().bind(Bindings.format("%d items", store.getProduct().getLeft()));
        priceTxt.textProperty().bind(Bindings.format("$%.2f", store.getProduct().getPrice()));
        cashTxt.textProperty().bind(Bindings.format("$%.2f", store.getCash().cashProperty()));

    }
}