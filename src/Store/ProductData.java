package Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class ProductData 
{
    private static final ObservableList<Product> productList = FXCollections.observableArrayList();
    public static ObservableList<Product> getProducts() 
    {
        return productList;
    }
    public static void addProduct(Product product) 
    {
        productList.add(product);
    }
    public static void clearProducts() 
    {
        productList.clear();
    }
    public static void updateSalePercentage(int productId, int percentage) 
    {
        for (Product p : productList) 
        {
            if (p.getId() == productId) 
            {
                p.setOnSale(true);
                p.setSalePercentage(percentage);
                break;
            }
        }
    }
    public static void updateSalePercentage(String name, int percentage) 
    {
        for (Product p : productList) 
        {
            if (p.getName().equalsIgnoreCase(name)) 
            {
                p.setOnSale(true);
                p.setSalePercentage(percentage);
                break;
            }
        }
    }
    public static void updateProduct(String id, int qnt) 
    {
        for (Product p : productList) 
        {
            if (String.valueOf(p.getId()).equals(id)) 
            {
            	if (p.getQuantity() >= qnt) 
            	{
                    p.decreaseQuantity(qnt);
                    System.out.println("Buing Complete");
                } 
            	else 
            	{
                    System.out.println("No id found");
                }
                break;
            }
                
        }
    }
}