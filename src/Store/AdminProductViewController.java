package Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminProductViewController implements Initializable 
{

    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TableColumn<Product, String> categoryColumn;

    @FXML
    private TableColumn<Product, Double> priceColumn;

    @FXML
    private TableColumn<Product, Integer> quantityColumn;

    @FXML
    private TableColumn<Product, Boolean> saleColumn;

    @FXML
    private TableColumn<Product, Integer> salePercentColumn;
    
    @FXML
    private TableColumn<Product, Integer> idColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        saleColumn.setCellValueFactory(new PropertyValueFactory<>("onSale"));
        salePercentColumn.setCellValueFactory(new PropertyValueFactory<>("salePercentage"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        productTable.setItems(ProductData.getProducts());
    }
    
    @FXML
    private void backToAdminDashBoard(ActionEvent event) throws Exception 
    {
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/StoreView/AdminDashBoard.fxml")));
        stage.setScene(scene);
    }
}
