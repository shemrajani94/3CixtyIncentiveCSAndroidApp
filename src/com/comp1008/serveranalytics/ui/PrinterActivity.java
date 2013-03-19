package com.comp1008.serveranalytics.ui;

import com.comp1008.serveranalytics.R;
import com.comp1008.serveranalytics.R.layout;
import com.comp1008.serveranalytics.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
/*
 * Activity which shows all information available about a chosen printer
 */
public class PrinterActivity extends Activity {

	private String printerName;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_printer);
		
		//unpack printer name string from bundle given
    	Bundle printerGiven = getIntent().getExtras();
    	if (printerGiven!=null)
    	{
    		printerName = printerGiven.getString("printer");
    	}
    	
    	TextView compNameView = (TextView)findViewById(R.id.printername_content);
    	compNameView.setText(printerName);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_printer, menu);
		return true;
	}

}
