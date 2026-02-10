package Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class loginControlar
{
    @FXML
    private TextField adminIdField;

    @FXML
    private TextField customerIdField;

    @FXML
    private Button adminLoginButton;

    @FXML
    private Button customerLoginButton;

    @FXML
    private void adminLogin(javafx.event.ActionEvent event) 
    {
        try 
        {
            Parent adminRoot = FXMLLoader.load(getClass().getResource("/StoreView/AdminDashboard.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(adminRoot));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void customerLogin(javafx.event.ActionEvent event) 
    {
        try 
        {
            Parent customerRoot = FXMLLoader.load(getClass().getResource("/StoreView/CustomerDashBoard.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(customerRoot));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
