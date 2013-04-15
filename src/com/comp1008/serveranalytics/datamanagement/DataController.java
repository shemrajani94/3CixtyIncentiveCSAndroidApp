package com.comp1008.serveranalytics.datamanagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import android.content.Context;
import android.widget.Toast;

/*
 * Contains methods for accessing data from ui activities
 */
public class DataController {
	private ArrayList<Computer> listOfComputers = new ArrayList<Computer>();
	private ArrayList<Printer> listOfPrinters = new ArrayList<Printer>();
	private Context context;
	private LocalServerDataReader localDataReader;
	
	public DataController(Context context)
	{
		this.context = context;
		getPrinterList();
		getComputerList();
		try
		{
			this.localDataReader = new LocalServerDataReader(context);
		}
		catch (IOException e)
		{
			CharSequence text = "Couldn't open data file";
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		}
		
		if (localDataReader!=null)
		{
			listOfComputers = localDataReader.loadComputerList();
			listOfPrinters = localDataReader.loadPrinterList();
		}
	}
	
	//initializes the printer list, when the DataController object is created
	private void getPrinterList()
	{
		//get printers from file and populate list
	}
	
	//initializes the machine list, when the DataController object is created
	private void getComputerList()
	{
		//get machines from file and populate list
	}
	
	/*get an Iterator over the machines list to access the list of current machines from
	anywhere in the app */
	public Iterator<Computer> getComputerIterator()
	{
		return listOfComputers.iterator();
	}
	
	/*get an Iterator over the printers list to access the list of current machines from
	anywhere in the app */
	public Iterator<Printer> getPrinterIterator()
	{
		return listOfPrinters.iterator();
	}
	
	public void addComputer(Computer m)
	{
		listOfComputers.add(m);
	}
	
	public void addPrinter(Printer p)
	{
		listOfPrinters.add(p);
	}
	
	public Computer getComputerByName(String name)
	{
		for (Computer c : listOfComputers)
		{
			if (c.getName().equals(name))
			{
				return c;
			}
		}
		return null;
	}
}
