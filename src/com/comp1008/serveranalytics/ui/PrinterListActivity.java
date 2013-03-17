package com.comp1008.serveranalytics.ui;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.comp1008.serveranalytics.R;

public class PrinterListActivity extends Activity implements AdapterView.OnItemClickListener{

	private String printers[] = {"Printer1", "Printer2", "Printer3"};
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_printer_list);
	ArrayAdapter<String> adapter = new ArrayAdapter<String>(PrinterListActivity.this, R.layout.lab_list_custom, printers);
	ListView listOfPrinters = (ListView) findViewById(R.id.PrintersList);
	listOfPrinters.setAdapter(adapter);
    }
    
    public void onItemClick(AdapterView adapter, View v, int position, long id){
    	String PrinterName = printers[position];
    	Log.v("labClick", "Clicked lab " + PrinterName);
    	Intent intent = new Intent(PrinterListActivity.this, SettingsActivity.class);
    	Bundle printer = new Bundle();
    	printer.putString("printer", PrinterName);
    	intent.putExtras(printer);
    	startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.printer_list, menu);
	return true;
    }

}
