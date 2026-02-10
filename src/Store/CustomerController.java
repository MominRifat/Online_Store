package Store;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class CustomerController 
{
    @FXML
    private void viewProducts(ActionEvent event) throws Exception 
    {
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Team/ViewAllProduct.fxml")));
        stage.setScene(scene);
    }

    @FXML
    private void viewByCategory(ActionEvent event) throws IOException 
    {
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Team/ByCategory.fxml")));
        stage.setScene(scene);
    }

    @FXML
    private void buyProduct(ActionEvent event) throws Exception 
    {
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Team/buy.fxml")));
        stage.setScene(scene);
    }

    @FXML
    private void backToLogin(ActionEvent event) throws Exception 
    {
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/StoreView/Login.fxml")));
        stage.setScene(scene);
    }
}
