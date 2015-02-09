package by.epam.filereadwrite;

import junit.framework.TestCase;

import org.junit.Test;

public class ReadWriterTest extends TestCase{

	@Test
	public void testReadWriteSuccessfull() throws Exception
	{
		String file = "test1.txt";
		
		ReadWriter rw = new ReadWriter(file);
		
		String str = "some text";
		rw.writeToFile(str);
		String readString = rw.readFromFile();
		
		assertTrue(str.equals(readString));
	}

	@Test
	public void testReadFromEmptyFile() throws Exception
	{
		String file = "empty.txt";
		ReadWriter rw = new ReadWriter(file);
		
		assertNull(rw.readFromFile());
	}
	
	@Test
	public void testWriteTwoTimes() throws Exception
	{
		String file = "test3.txt";
		
		ReadWriter rw = new ReadWriter(file);
		
		String str1 = "aaaa";
		String str2 = "bbbb";
		rw.writeToFile(str1);
		rw.writeToFile(str2);
		String readString = rw.readFromFile();
		
		assertTrue((str1 + str2).equals(readString));
	}
	
	@Test
	public void testFileName() throws Exception
	{
		String file = "test4.txt";
		ReadWriter rw = new ReadWriter(file);
		
		assertEquals(file, rw.getFileName());
	}
}
