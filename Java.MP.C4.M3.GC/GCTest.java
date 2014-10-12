
public class GCTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime(); 
		System.out.println("Total memory: " + runtime.totalMemory());
		System.out.println("Free memory: " + runtime.freeMemory());
		
		
		for (int i = 0; i < 10000; i++)
		{
			String s = "string11111111111111111111111111" + i;
			if (i%500 == 0)
			{
				System.out.println(runtime.freeMemory());
				
			}
		}
	}

	
}
