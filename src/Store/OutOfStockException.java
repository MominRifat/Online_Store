package Store;
public class OutOfStockException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public OutOfStockException() 
    {
        super("Item is out of stock");
    }

    public OutOfStockException(String msg) 
    {
        super(msg);
    }
}
