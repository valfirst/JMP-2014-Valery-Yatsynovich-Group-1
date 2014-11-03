package by.epam.filereadwrite;

import org.junit.Test;

import junit.framework.TestCase;

public class ReadWriteTests extends TestCase
{

	@Test
	public void testReadWriteSuccessfull() throws Exception
	{
		String str = "123";
		
		ReadWriter.writeToFile(str);
		String readString = ReadWriter.readFromFile();
		
		assertTrue(str.equals(readString));
	}
}
