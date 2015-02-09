package by.epam.filereadwrite;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException
	{
		ReadWriter rw = new ReadWriter("123.txt");
		String writeString = "ABCDEFG";
		
		FileWriterThread fileWriterThread = new FileWriterThread(rw);
		fileWriterThread.setWriteToFileString(writeString);
		
		FileReaderThread fileReaderThread = new FileReaderThread(rw);
		fileReaderThread.setReadTimes(10);
		
		Thread writer = new Thread(fileWriterThread);
		Thread reader = new Thread(fileReaderThread);
		writer.start();
		reader.start();
	}

}
