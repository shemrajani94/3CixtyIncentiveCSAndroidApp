package com.comp1008.serveranalytics.datamanagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import android.content.Context;
/*
 * This class reads data from the local CSV file into the currently active data controller
 */

public class LocalServerDataReader {
	
	private InputStream file;
	private Scanner in;
	
	public LocalServerDataReader(Context context) throws IOException
	{
	
		file = new FileReader("alldata.txt", context).getInputStream();
		
		if (file!=null)
		{
			in = new Scanner(file);
		}

	}
	
	public ArrayList<Computer> loadComputerList()
	{
		ArrayList<Computer> computers = new ArrayList<Computer>();
		while (in.hasNext())
		{
			String line = in.nextLine();
			if (line.equals("COMPUTERS"))
			{
				while (in.hasNext())
				{
					line = in.nextLine();
					if(!line.equals("PRINTERS"))
					{
						computers.add(parseComputer(line));
					}
					else
					{
						break;
					}
				}
			}
			break;
		}
		return computers;
	}
	
	private Computer parseComputer(String line)
	{
		
		int charCount = 0;
		String ip = "";
		String status = "";
		String room = "";
		String user = "";
		String name = "";
		
		for (charCount = 0; charCount < line.length(); charCount++){
		    char c = line.charAt(charCount);        
		    if (c == ',')
		    {
		    	break;
		    }
		    else
		    {
		    	ip = ip+Character.toString(c);
		    }
		}
		for (charCount = charCount+1; charCount < line.length(); charCount++){
		    char c = line.charAt(charCount);        
		    if (c == ',')
		    {
		    	break;
		    }
		    else
		    {
		    	status = status+Character.toString(c);
		    }
		}
		for (charCount = charCount+1; charCount < line.length(); charCount++){
		    char c = line.charAt(charCount);        
		    if (c == ',')
		    {
		    	break;
		    }
		    else
		    {
		    	room = room+Character.toString(c);
		    }
		}
		for (charCount = charCount+1; charCount < line.length(); charCount++){
		    char c = line.charAt(charCount);        
		    if (c == ',')
		    {
		    	break;
		    }
		    else
		    {
		    	user = user+Character.toString(c);
		    }
		}
		for (charCount = charCount+1; charCount < line.length(); charCount++){
		    char c = line.charAt(charCount);        
		    if (c == '\n')
		    {
		    	break;
		    }
		    else
		    {
		    	name = name+Character.toString(c);
		    }
		}
		Computer computer = new Computer(ip, status, room, user, name);
		return computer;
	}
	
	public ArrayList<Printer> loadPrinterList()
	{
		return null;
	}

}