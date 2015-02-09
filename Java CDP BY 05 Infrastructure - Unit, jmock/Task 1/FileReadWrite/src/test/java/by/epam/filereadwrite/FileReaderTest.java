package by.epam.filereadwrite;

import static org.mockito.Mockito.*;

import org.junit.Test;

import junit.framework.TestCase;

public class FileReaderTest extends TestCase
{

	@Test
	public void testSetGetReadTimes() throws Exception
	{
		int readTimes = 5;
		
		FileReaderThread fileReaderThread = new FileReaderThread(null);
		fileReaderThread.setReadTimes(readTimes);
		
		assertEquals(readTimes, fileReaderThread.getReadTimes());
	}

	@Test
	public void testReadFromFileCalled() throws Exception
	{
		ReadWriter mockRw = mock(ReadWriter.class);

		FileReaderThread fileReaderThread = new FileReaderThread(mockRw);

		fileReaderThread.run();
		
		verify(mockRw, atLeast(1)).readFromFile();
	}
	
	@Test
	public void testReadTimes() throws Exception
	{
		int readTimes = 5;
		
		ReadWriter mockRw = mock(ReadWriter.class);

		FileReaderThread fileReaderThread = new FileReaderThread(mockRw);
		fileReaderThread.setReadTimes(readTimes);
		
		fileReaderThread.run();
		
		verify(mockRw, times(readTimes)).readFromFile();
	}
}