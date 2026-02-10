package Store;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class FoodItem extends Product
{
	private static final long serialVersionUID = 1L;
	private LocalDate manufacturingDate;
    private LocalDate expirationDate;
    
    public FoodItem(String name, String category, double price, int quantity, boolean onSale, int salePercentage, LocalDate manufacturingDate, LocalDate expirationDate) 
    {
    	super(name, category, price, quantity, onSale, salePercentage);
    	this.manufacturingDate = manufacturingDate;
    	this.expirationDate = expirationDate;
    }
    
    public FoodItem(String name, String category, double price, int quantity, boolean onSale, int salePercentage, String manufacturingDate, String expirationDate) 
    {
    	super(name, category, price, quantity, onSale, salePercentage);
    	this.manufacturingDate = LocalDate.parse(manufacturingDate);
    	this.expirationDate = LocalDate.parse(expirationDate);
    }
    
    public void putOnSale(String name, int percentage) 
    {
        if (getName().equalsIgnoreCase(name)) 
        {
            setOnSale(true);
            setSalePercentage(percentage);
        }
    }
    
    public LocalDate getManufacturingDate() 
    { 
    	return manufacturingDate; 
    }
    public LocalDate getExpirationDate() 
    { 
    	return expirationDate; 
    }
    public void setManufacturingDate(LocalDate manufacturingDate) 
    { 
    	this.manufacturingDate = manufacturingDate; 
    }
    public void setExpirationDate(LocalDate expirationDate) 
    { 
    	this.expirationDate = expirationDate; 
    }
    
    public String toString(boolean details) 
    {
        if(details == false) 
        {
            return super.toString();
        } 
        else 
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return super.toString(true) + String.format(", Manufacturing Date: %s, Expiration Date: %s", manufacturingDate.format(formatter), expirationDate.format(formatter));
        }
    }
}
