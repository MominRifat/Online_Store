package Team;
import Store.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class buyController 
{
    @FXML
    private TextField id;

    @FXML
    private TextField quantity;

    @FXML
    private Button buy;

    @FXML
    private Button back;

    @FXML
    private void initialize() {
    }
    @FXML
    private void handleBuy() 
    {
        String idx = id.getText().trim();
        String quantityText = quantity.getText().trim();

        if (idx.isEmpty() || quantityText.isEmpty()) {
            System.out.print("Please enter both ID and quantity");
            return;
        }

        int quantity;
        quantity = Integer.parseInt(quantityText);
        ProductData.updateProduct(idx, quantity);
    }

    @FXML
    private void backToView(ActionEvent event) throws Exception 
    {
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Team/ViewAllProduct.fxml")));
        stage.setScene(scene);
    }

}
