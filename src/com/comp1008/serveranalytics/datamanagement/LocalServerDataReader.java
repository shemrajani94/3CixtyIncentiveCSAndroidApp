package com.comp1008.serveranalytics.datamanagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
/*
 * This class reads data from the local CSV file into the currently active data controller
 */

public class LocalServerDataReader {
	
	InputStream file;
	DataController currentDataController;
	
	public LocalServerDataReader(Context context, DataController dc) throws IOException
	{
		this.currentDataController = dc;
	
		file = new FileReader("alldata.txt", context).getInputStream();

	}
	
	//CODE TO SPLIT UP CSV DATA HERE AND READ INTO DATA STRUCTURES

}