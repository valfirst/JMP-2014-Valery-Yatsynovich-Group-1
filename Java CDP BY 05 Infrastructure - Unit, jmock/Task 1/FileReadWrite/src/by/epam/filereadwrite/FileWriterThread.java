package by.epam.filereadwrite;

import java.io.IOException;
import java.util.Random;

public class FileWriterThread implements Runnable
{
	Random random = new Random();

	@Override
	public void run()
	{
		
		for (int i = 0; i < 10; i++)
		{
			String str = String.valueOf(Character.toChars(65 + random.nextInt(25)));
				try {
					ReadWriter.writeToFile(str);
					Thread.sleep(10 * random.nextInt(100));
				} catch (IOException | InterruptedException  e)
				{
					e.printStackTrace();
				}

		}
	}

	
}
