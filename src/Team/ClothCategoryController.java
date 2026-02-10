package Team;
import Store.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
public class ClothCategoryController 
{
    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, String> nameCol;

    @FXML
    private TableColumn<Product, String> idCol;

    @FXML
    private TableColumn<Product, String> categoryCol;

    @FXML
    private TableColumn<Product, Double> priceCol;

    @FXML
    private TableColumn<Product, Integer> quantityCol;

    @FXML
    private TableColumn<Product, Boolean> saleCol;
    
    @FXML
    private TableColumn<Product, Boolean> salePercentCol;
    
    public void initialize(URL location, ResourceBundle resources) 
    {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        saleCol.setCellValueFactory(new PropertyValueFactory<>("onSale"));
        salePercentCol.setCellValueFactory(new PropertyValueFactory<>("salePercentage"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productTable.setItems(ProductData.getProducts());
    }
    @FXML
    private void back(ActionEvent event) throws Exception 
    {
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Team/ByCategory.fxml")));
        stage.setScene(scene);
    }
    @FXML
    private void buybutton(ActionEvent event) throws Exception 
    {
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Team/buy.fxml")));
        stage.setScene(scene);
    }
}
