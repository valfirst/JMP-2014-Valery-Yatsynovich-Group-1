package by.epam.filereadwrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriter
{

	private static File file; 

	private static File getFile() throws IOException
	{
		if (file == null)
		{
			file = new File("abc.txt");
			file.createNewFile();
			file.deleteOnExit();
		}
		return file;
	}

	public static synchronized void writeToFile(String str) throws IOException, InterruptedException
	{
		
		FileWriter writer = new FileWriter(getFile(), true);
		writer.write(str);
		System.out.println("Write: " + str);
		writer.close();
	}
	
	public static synchronized String readFromFile() throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(getFile()));
		String str = reader.readLine();
		System.out.println("Read: " + str);
		reader.close();
		
		return str;
	}
}
