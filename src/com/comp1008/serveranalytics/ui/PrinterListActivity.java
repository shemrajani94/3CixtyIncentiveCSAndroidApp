package com.comp1008.serveranalytics.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.comp1008.serveranalytics.R;

public class PrinterListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_printer_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.printer_list, menu);
	return true;
    }

}
