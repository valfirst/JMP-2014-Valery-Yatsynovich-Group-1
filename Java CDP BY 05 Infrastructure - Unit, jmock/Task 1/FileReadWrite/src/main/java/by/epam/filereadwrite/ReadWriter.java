package by.epam.filereadwrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriter
{
	private File file;

	public ReadWriter(String fileName) throws IOException
	{
		file = new File(fileName);
		file.createNewFile();
		file.deleteOnExit();
	}

	public synchronized void writeToFile(String str) 
			throws IOException, InterruptedException
	{
		
		FileWriter writer = new FileWriter(file, true);
		writer.write(str);
		writer.close();
	}
	
	public synchronized String readFromFile() throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str = reader.readLine();
		
		reader.close();
		
		return str;
	}
	
	public String getFileName()
	{
		return file.getName();
	}
}
