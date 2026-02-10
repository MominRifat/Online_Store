package Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class FoodController 
{
    @FXML private TextField nameField;
    @FXML private TextField priceField;
    @FXML private TextField quantityField;
    @FXML private TextField mfgDateField;
    @FXML private TextField expDateField;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private Store store;

    public void setStore(Store store) 
    {
        this.store = store;
    }
    @FXML
    private void handleAdd() 
    {
        try 
        {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());
            LocalDate mfgDate = LocalDate.parse(mfgDateField.getText(), formatter);
            LocalDate expDate = LocalDate.parse(expDateField.getText(), formatter);
            FoodItem item = new FoodItem(name, "Food", price, quantity, false, 0, mfgDate, expDate);
            System.out.println("Added: " + item.toString(true));
            ProductData.addProduct(item);
            int id = item.getId();
            String idx = String.valueOf(id);
            if (store != null) 
            {
                store.addProduct(name, idx, quantity, mfgDate, expDate, price);
                System.out.println("Clothing item added to store.");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void handleBack(ActionEvent event) throws Exception 
    {
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/StoreView/AdminAddItem.fxml")));
        stage.setScene(scene);
    }
}
