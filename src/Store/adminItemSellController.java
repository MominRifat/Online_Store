package Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class adminItemSellController 
{

    @FXML
    private Button clothNextButton;

    @FXML
    private Button foodNextButton;

    @FXML
    private Button backButton;

    @FXML
    private void initialize() 
    {
    }

    @FXML
    private void handleClothNext(ActionEvent event) 
    {
        try 
        {
            Stage stage = (Stage) clothNextButton.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/StoreView/ClothSellItem.fxml")));
            stage.setScene(scene);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleFoodNext(ActionEvent event) {
        try 
        {
            Stage stage = (Stage) foodNextButton.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/StoreView/FoodSellItem.fxml")));
            stage.setScene(scene);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBack(ActionEvent event) throws Exception
    {
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/StoreView/AdminDashBoard.fxml")));
        stage.setScene(scene);
    }
}
