import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class StoreApplication extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("store.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        //stage.setTitle("Store Application");
        //stage.sizeToScene();
        stage.show();
        // Add code here to load the root node from the FXML file
        // and show it
    }
}