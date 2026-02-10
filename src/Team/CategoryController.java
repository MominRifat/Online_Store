package Team;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
public class CategoryController 
{
    @FXML
    private Button foodButton;

    @FXML
    private Button clothButton;

    @FXML
    private Button backButton;


    @FXML
    private void handleFood(ActionEvent event) throws Exception
    {
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Team/FoodCategory.fxml")));
        stage.setScene(scene);
    }

    @FXML
    private void handleCloth(ActionEvent event) throws Exception
    {
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Team/ClothCategory.fxml")));
        stage.setScene(scene);
    }

    @FXML
    private void handleBack(ActionEvent event) throws Exception 
    {
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/StoreView/CustomerDashBoard.fxml")));
        stage.setScene(scene);
    }

}
