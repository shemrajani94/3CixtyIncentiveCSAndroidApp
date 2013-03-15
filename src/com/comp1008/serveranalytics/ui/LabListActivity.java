package com.comp1008.serveranalytics.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.comp1008.serveranalytics.R;

/* This class should show a list of labs, which are clickable and on click
 * will load the respective lab. getLabs() function should be added. */

public class LabListActivity extends Activity implements AdapterView.OnItemClickListener {
    
    private String labs[] = { "Room 4.06", "Room 1.05", "Room 1.21" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_lab_list);
	// Creates an ArrayAdapter for the String array Labs.
	ArrayAdapter<String> adapter = new ArrayAdapter<String>(LabListActivity.this, android.R.layout.simple_list_item_1, labs);
	// This ListView is in the XML activity_lab_list 
	ListView listOfLabs = (ListView) findViewById(R.id.listOfLabs);
	listOfLabs.setAdapter(adapter);
    }
    
    @Override
    public void onItemClick(AdapterView parent, View v, int position, long id) {
	/* This Method should get list of computers in lab on button click, 
	 * way in which LabMapActivity is called needs to be decided. */
	String labName = labs[position];
	Intent intent = new Intent(LabListActivity.this, LabMapActivity.class);
	Bundle lab = new Bundle();
	lab.putString("lab", labName);
	intent.putExtras(lab);
	startActivity(intent);

    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.lab_list, menu);
	return true;
    }
}
