package com.comp1008.serveranalytics.datamanagement;

import java.util.ArrayList;
import java.util.Iterator;

import android.content.Context;

/*
 * Contains methods for accessing data from ui activities
 */
public class DataController {
	private ArrayList<Machine> listOfMachines = new ArrayList<Machine>();
	private ArrayList<Printer> listOfPrinters = new ArrayList<Printer>();
	private Context context;
	
	public DataController(Context context)
	{
		this.context = context;
		initializePrinterList();
		initializeMachineList();
	}
	
	//initializes the printer list, when the DataController object is created
	private void initializePrinterList()
	{
		//get printers from file and populate list
	}
	
	//initializes the machine list, when the DataController object is created
	private void initializeMachineList()
	{
		//get machines from file and populate list
	}
	
	/*get an Iterator over the machines list to access the list of current machines from
	anywhere in the app */
	public Iterator<Machine> getMachineIterator()
	{
		Iterator<Machine> machinesIterator = listOfMachines.iterator();
		return machinesIterator;
	}
	
	/*get an Iterator over the printers list to access the list of current machines from
	anywhere in the app */
	public Iterator<Printer> getPrinterIterator()
	{
		Iterator<Printer> printersIterator = listOfPrinters.iterator();
		return printersIterator;
	}
}
