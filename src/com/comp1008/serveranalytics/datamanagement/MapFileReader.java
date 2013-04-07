package com.comp1008.serveranalytics.datamanagement;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.comp1008.serveranalytics.map.MapComputer;
import com.comp1008.serveranalytics.map.MapDoor;

import android.content.Context;

public class MapFileReader {
	private FileReader file;
	private ArrayList<MapDoor> doors = new ArrayList<MapDoor>();
	private ArrayList<MapComputer> computers = new ArrayList<MapComputer>();
	private Scanner in;
	
	public MapFileReader(String roomName, Context context)
	{
		file = new FileReader(roomName, context);
		InputStream input = file.getInputStream();
		in = new Scanner(input); 
		loadComputers();
	}
	
	public ArrayList<MapComputer> getComputers()
	{
		return computers;
	}
	
	private void loadComputers()
	{
		while (in.hasNext())
		{
			String line = in.nextLine();
			if (line.equals("COMPUTERS"))
			{
				while (in.hasNext())
				{
					line = in.nextLine();
					if(!line.equals("DOORS"))
					{
						parseComputer(line);
					}
					else
					{
						break;
					}
				}
			}
			break;
		}		
	}
	
	private void parseComputer(String line)
	{
		String name = "";
		String x = "";
		String y = "";
		int charCount = 0;
		
		for (charCount = 0; charCount < line.length(); charCount++){
		    char c = line.charAt(charCount);        
		    if (c == ',')
		    {
		    	break;
		    }
		    else
		    {
		    	name = name+Character.toString(c);
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
		    	x = x+Character.toString(c);
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
		    	y = y+Character.toString(c);
		    }
		}
		
		float xF = Float.parseFloat(x);
		float yF = Float.parseFloat(y);
		computers.add(new MapComputer(xF,yF));
		
	}
	
	

}
