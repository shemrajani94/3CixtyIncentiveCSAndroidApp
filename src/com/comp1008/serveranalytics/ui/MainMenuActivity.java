package com.comp1008.serveranalytics.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.comp1008.serveranalytics.R;

/* MainMenuActivity will show the user an option to choose multiple tasks..
 * These include choosing to view Lab rooms, printers or the settings
 *  */
// Testing Push
public class MainMenuActivity extends Activity {
    
    Button labsButton, printersButton, settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	
	// Declares our buttons 
	labsButton = (Button) findViewById(R.id.labsButton);
	printersButton = (Button) findViewById(R.id.printersButton);
	settingsButton = (Button) findViewById(R.id.settingsButton);
	
	//Do stuff when lab button is pushed
	labsButton.setOnClickListener(new OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
		Intent intent = new Intent(MainMenuActivity.this, LabListActivity.class);
		MainMenuActivity.this.startActivity(intent);
	    }
	});
	
	// Opens the PrinterListActivity when pressed
	printersButton.setOnClickListener(new OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
		Intent intent = new Intent(MainMenuActivity.this, PrinterListActivity.class);
		MainMenuActivity.this.startActivity(intent);
	    }
	});

	// Opens the SettingsActivity when pressed
	settingsButton.setOnClickListener(new OnClickListener() {
    
	    @Override
	    public void onClick(View v) {
		Intent intent = new Intent(MainMenuActivity.this, SettingsActivity.class);
		MainMenuActivity.this.startActivity(intent);
	    }
	});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
    }

}
