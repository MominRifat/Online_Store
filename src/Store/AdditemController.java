package Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;
public class AdditemController 
{
    @FXML
    private ChoiceBox<String> categoryBox;

    @FXML
    public void initialize() {
        categoryBox.getItems().addAll("Clothing", "Food");
    }

    @FXML
    private void Next(ActionEvent event) 
    {
        String category = categoryBox.getValue();
        if(category == null || category.isEmpty()) 
        {
            System.out.println("Please select a category.");
            return;
        }

        try 
        {
            FXMLLoader loader = new FXMLLoader();
            if(category.equals("Clothing")) 
            {
                loader.setLocation(getClass().getResource("/StoreView/cloth.fxml"));
            } 
            else if (category.equals("Food")) 
            {
                loader.setLocation(getClass().getResource("/StoreView/Food.fxml"));
            }
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } 
        catch(IOException e) 
        {
            e.printStackTrace();
        }
    }
    @FXML
    private void backToAdminDashBoard(ActionEvent event) throws Exception 
    {
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/StoreView/AdminDashBoard.fxml")));
        stage.setScene(scene);
    }
}
