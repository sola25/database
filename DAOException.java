package database;

@SuppressWarnings("serial")
public class DAOException extends RuntimeException {
	
	
	public DAOException()
	{
		super();
	}
	
	public DAOException(String messege,Throwable cause)
	{
		super(messege,cause);
	}
	
	public DAOException(String messege)
	{
		super(messege);
	}
	
	public DAOException(Throwable cause)
	{
		super(cause);
	}
	
	

}
