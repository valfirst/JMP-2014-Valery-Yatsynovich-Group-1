package by.epam.filereadwrite;

import java.io.IOException;
import java.util.Random;

public class FileWriterThread implements Runnable
{
	private Random random = new Random();
	private ReadWriter rw;
	private String writeToFileString;
	
	public FileWriterThread(ReadWriter rw)
	{
		this.rw = rw;
	}
	

	@Override
	public void run()
	{
		if (writeToFileString == null)
		{
			return;
		}
		
		for (int i = 0; i < writeToFileString.length(); i++)
		{
			try {
				String str = Character.toString(writeToFileString.charAt(i));
				System.out.println("Write: " + str);

				rw.writeToFile(str);
				Thread.sleep(10 * random.nextInt(100));
			} catch (IOException | InterruptedException  e)
			{
				e.printStackTrace();
			}

		}
	}
	
	public ReadWriter getReadWriter()
	{
		return rw;
	}
	
	public void setWriteToFileString(String str)
	{
		writeToFileString = str;
	}
	
	public String getWriteToFileString()
	{
		return writeToFileString;
	}
}
