public class SecondTask {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{

		int[] a = new int[1];
		
		passByReference(a);
		printA(a);
		a[0] = returnScalar();
		printA(a);
		a = returnObject();
		printA(a);
	}

	    private static void passByReference(int[] a)
	    {
	    	a[0] = 1;
	    }

	    private static int returnScalar()
	    {
	    	return 2;
	    }
	    
	    private static int[] returnObject()
	    {
	    	return new int[]{3};
	    }
	    
	    private static void printA(int[] a)
	    {
	    	System.out.println(a[0]);
	    }

}