package Store;
public class Clothing extends Product
{
	private static final long serialVersionUID = 1L;
	private String brand;
    private String size;
    private String subCategory;
    
    public Clothing(String name, String category, double price, int quantity, boolean onSale, int salePercentage, String brand, String size, String subCategory) 
    {
    	super(name, category, price, quantity, onSale, salePercentage);
    	this.brand = brand;
    	this.size = size;
    	this.subCategory = subCategory;
    }
    
    public void putOnSale(String id, int percentage) 
    {
        if(String.valueOf(getId()).equals(id)) 
        {
            setOnSale(true);
            setSalePercentage(percentage);
        }
    }
    
    public String getBrand() 
    { 
    	return brand; 
    }
    public String getSize() 
	{ 
    	return size; 
    }
    public String getSubCategory() 
	{ 
    	return subCategory; 
    }

    public void setBrand(String brand) 
	{ 
		this.brand = brand; 
	}
    public void setSize(String size) 
	{ 
		this.size = size; 
	}
    public void setSubCategory(String subCategory) 
	{ 
		this.subCategory = subCategory; 
	}
    
    public String toString(boolean details) 
    {
        if(details == false) 
        {
            return super.toString();
        } 
        else 
        {
            return super.toString(true) + String.format(", Brand: %s, Size: %s, SubCategory: %s", brand, size, subCategory);
        }
    }
    
    public void putOnSale(String brand, String subCategory, int percentage) 
    {
        if(this.brand.equalsIgnoreCase(brand) && this.subCategory.equalsIgnoreCase(subCategory)) 
        {
            setOnSale(true);
            setSalePercentage(percentage);
        }
    }
    
    
}
