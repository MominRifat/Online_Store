package Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class FoodSellController 
{
    @FXML
    private TextField NameField;

    @FXML
    private TextField percentageField;

    @FXML
    private Button idSellButton;

    @FXML
    private Button backButton;

    @FXML
    private void initialize(){}

    @FXML
    private void handlePutOnSaleById() 
    {
        String NameText = NameField.getText().trim();
        String percentageText = percentageField.getText().trim();

        try 
        {
            int percentage = Integer.parseInt(percentageText);
            ProductData.updateSalePercentage(NameText, percentage);
            System.out.println("Updated product with Name " + NameText + " to " + percentage + "% off.");
        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Invalid percentage entered.");
        }
    }

    @FXML
    private void handleBack(ActionEvent event) throws Exception {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/StoreView/adminitemsell.fxml")));
        stage.setScene(scene);
    }
}
