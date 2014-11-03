package by.epam.bankexchange.entity;

public enum Currency
{
	USD(0),
	EUR(1),
	RUR(2);
	
	private final int id;
    
    Currency(int id)
    {
        this.id = id;
    }
    
    public int getId() 
    {
    	return id; 
    }
}
