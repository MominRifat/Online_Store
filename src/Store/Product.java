package Store;
import java.io.Serializable;
import java.util.Random;
public abstract class Product implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String name;
    private int id;
    private String category;
    private double price;
    private int quantity;
    private boolean onSale;
    private int salePercentage;
    
    public Product(String name, String category, double price, int quantity, boolean onSale, int salePercentage) 
    {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.onSale = onSale;
        this.salePercentage = salePercentage;
        this.id = new Random().nextInt(9000) + 1000;
    }
    
    public String getName() 
    { 
    	return name; 
    }
    public int getId() 
	{ 
    	return id; 
	}
    public String getCategory() 
	{ 
    	return category; 
	}
    public double getPrice() 
	{ 
    	return price; 
	}
    public int getQuantity() 
	{ 
    	return quantity; 
	}
    public boolean isOnSale() 
	{ 
    	return onSale; 
	}
    public int getSalePercentage() 
	{ 
    	return salePercentage; 
	}
    
    public void setName(String name) 
	{ 	
		this.name = name; 
	}
    public void setCategory(String category) 
	{ 	
		this.category = category; 
	}
    public void setPrice(double price) 
	{ 	
		this.price = price; 
	}
    public void setQuantity(int quantity) 
	{ 	
		this.quantity = quantity; 
	}
    public void setOnSale(boolean onSale) 
	{ 	
		this.onSale = onSale; 
	}
    public void setSalePercentage(int salePercentage) 
	{ 	
		this.salePercentage = salePercentage; 
	}
    
    public void increaseQuantity(int quantity) 
    {
        this.quantity += quantity;
    }

    public void decreaseQuantity(int quantity) 
    {
        this.quantity -= quantity;
    }

    public double totalPrice(int quantity) 
    {
        return price * quantity;
    }
    
    public double salePrice(int quantity) 
    {
        if(onSale == true) 
        {
            double discount = price * salePercentage / 100.0;
            return (price - discount) * quantity;
        }
        return price * quantity;
    }
    
    public abstract void putOnSale(String criterion, int percentage);
    
    public String toString() 
    {
    	String result = String.format("Name: %s, ID: %04d, Price: %.2f", name, id, price);
        if(onSale == true) 
        {
            double discounted = price - (price * salePercentage / 100.0);
            result += ", Sale Price: " + discounted;
        }
        return result;
    }

    public String toString(boolean details) 
    {
        if(details == true) 
        {
            return "Name: " + name + ", ID: " + id + ", Category: " + category + ", Price: " + price + ", Quantity: " + quantity + ", On Sale: " + onSale + ", Sale Percentage: " + salePercentage;
        } 
        else 
        {
            return toString();
        }
    }
}
