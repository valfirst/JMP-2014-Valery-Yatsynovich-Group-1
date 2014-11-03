package by.epam.filereadwrite;

import java.io.IOException;
import java.util.Random;

public class FileReaderThread implements Runnable
{
	Random random = new Random();

	@Override
	public void run()
	{
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			for (int i = 0; i < 10; i++)
			{
				ReadWriter.readFromFile();
				Thread.sleep(10 * random.nextInt(100));
			}
		} catch (IOException | InterruptedException  e)
		{
			e.printStackTrace();
		}

	}

	

}
