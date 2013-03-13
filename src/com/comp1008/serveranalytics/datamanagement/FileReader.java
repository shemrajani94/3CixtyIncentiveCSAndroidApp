package com.comp1008.serveranalytics.datamanagement;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;

public class FileReader {
	
	private InputStream fileStream;
	
	public FileReader(String fileName, Context context) throws IOException
	{
		AssetManager assetManager = context.getAssets();
		try
		{	
			this.fileStream = assetManager.open(fileName);
		}
		catch (Exception IOException)
		{
			//handle exception somehow
		}
	}
	
	public InputStream getInputStream()
	{
		return fileStream;
	}

}
