package by.epam.filereadwrite;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException
	{
		Thread writer = new Thread(new FileWriterThread());
		Thread reader = new Thread(new FileReaderThread());
		writer.start();
		reader.start();
	}

}
