package by.epam.filereadwrite;

import org.junit.Test;

import junit.framework.TestCase;

public class FileWriterTest extends TestCase
{

	@Test
	public void testReadSuccessfull() throws Exception
	{
		String file = "test7.txt";
		String str = "some text";
		
		ReadWriter rw = new ReadWriter(file);
		FileWriterThread fileWriter = new FileWriterThread(rw);
		fileWriter.setWriteToFileString(str);

		fileWriter.run();
		
		String readString = rw.readFromFile();
		
		assertTrue(str.equals(readString));
	}

	@Test
	public void testWriteToFileString() throws Exception
	{
		String file = "test8.txt";
		String str = "some text";
		
		ReadWriter rw = new ReadWriter(file);
		FileWriterThread fileWriter = new FileWriterThread(rw);
		
		fileWriter.setWriteToFileString(str);

		assertEquals(str, fileWriter.getWriteToFileString());
	}
	
	@Test
	public void testWriteEmptyString() throws Exception
	{
		String file = "test9.txt";

		ReadWriter rw = new ReadWriter(file);
		FileWriterThread fileWriter = new FileWriterThread(rw);
		
		fileWriter.run();
		
		String readString = rw.readFromFile();

		assertNull(readString);
	}
}
