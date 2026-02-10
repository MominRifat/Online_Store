package Store;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
public class Store implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private String name;
    private ArrayList<Product> items;

    public Store(String name) 
    {
        this.setName(name);
        this.items = new ArrayList<>();
    }

    public int findProduct(String id) 
    {
        for(int i = 0; i < items.size(); i++) 
        {
            if(String.valueOf(items.get(i).getId()).equals(id)) 
            {
                return i;
            }
        }
        return -1;
    }

    public int findProductByName(String name) 
    {
        for(int i = 0; i < items.size(); i++) 
        {
            if(items.get(i).getName().equalsIgnoreCase(name)) 
            {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Product> getProducts(String category) 
    {
        ArrayList<Product> result = new ArrayList<>();
        for(Product p : items) 
        {
            if(p.getCategory().equalsIgnoreCase(category)) 
            {
                result.add(p);
            }
        }
        return result;
    }

    public void putOnSaleFood(String name, int percentage) 
    {
        for(Product p : items) 
        {
            if(p instanceof FoodItem && p.getName().equalsIgnoreCase(name)) 
            {
                p.putOnSale(name, percentage);
            }
        }
    }

    public void putOnSaleCloth(String id, int percentage) 
    {
        for(Product p : items) 
        {
            if(p instanceof Clothing && String.valueOf(p.getId()).equals(id)) 
            {
                p.putOnSale(id, percentage);
            }
        }
    }

    public void putOnSaleCloth(String brand, String subCategory, int percentage) 
    {
        for(Product p : items) 
        {
            if(p instanceof Clothing) 
            {
                ((Clothing) p).putOnSale(brand, subCategory, percentage);
            }
        }
    }

    public String addProduct(String name, String id, int quantity, String brand, String subCategory, String size, double price) 
    {
        int index = findProduct(id);
        if(index != -1) 
        {
            items.get(index).increaseQuantity(quantity);
            return id;
        } 
        else 
        {
            Clothing c = new Clothing(name, "Clothing", price, quantity, false, 0, brand, size, subCategory);
            items.add(c);
            return String.valueOf(c.getId());
        }
    }

    public String addProduct(String name, String id, int quantity, LocalDate mfg, LocalDate exp, double price) 
    {
        int index = findProduct(id);
        if(index != -1) 
        {
            items.get(index).increaseQuantity(quantity);
            return id;
        } 
        else 
        {
            FoodItem f = new FoodItem(name, "Food", price, quantity, false, 0, mfg, exp);
            items.add(f);
            return String.valueOf(f.getId());
        }
    }

    public void buyProduct(String id, int qnt) throws OutOfStockException 
    {
        int index = findProduct(id);
        if(index != -1) 
        {
            Product p = items.get(index);
            if(p.getQuantity() >= qnt) 
            {
                p.decreaseQuantity(qnt);
            } 
            else 
            {
                throw new OutOfStockException("Not enough stock for product ID: ");
            }
        }
    }
    
    public void buyProductWithName(String name, int qnt) throws OutOfStockException 
    {
        int index = findProduct(name);
        if(index != -1) 
        {
            Product p = items.get(index);
            if(p.getQuantity() >= qnt) 
            {
                p.decreaseQuantity(qnt);
            } 
            else 
            {
                throw new OutOfStockException("Not enough stock for product ID: ");
            }
        }
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
 

