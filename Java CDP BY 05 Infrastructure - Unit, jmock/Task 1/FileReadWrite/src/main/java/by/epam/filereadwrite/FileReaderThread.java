package by.epam.filereadwrite;

import java.io.IOException;
import java.util.Random;

public class FileReaderThread implements Runnable
{
	private Random random = new Random();
	private ReadWriter rw;
	private int readTimes = 1;
	
	public FileReaderThread(ReadWriter rw)
	{
		this.rw = rw;
	}

	@Override
	public void run()
	{
		try {
			for (int i = 0; i < readTimes; i++)
			{
				String str = rw.readFromFile();
				System.out.println("Read: " + str);
				Thread.sleep(10 * random.nextInt(100));
			}
		} catch (IOException | InterruptedException  e)
		{
			e.printStackTrace();
		}

	}

	public ReadWriter getReadWriter()
	{
		return rw;
	}
	
	public void setReadWriter(ReadWriter rw)
	{
		this.rw = rw;
	}

	public void setReadTimes(int readTimes)
	{
		this.readTimes = readTimes;
	}
	
	public int getReadTimes()
	{
		return readTimes;
	}
}
