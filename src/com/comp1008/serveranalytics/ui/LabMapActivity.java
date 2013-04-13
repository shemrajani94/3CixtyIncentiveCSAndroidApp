package com.comp1008.serveranalytics.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.comp1008.serveranalytics.R;
/*
 * Tabbed activity which contains the mapview on one tab and the list of machines in the lab
 * on the other tab.
 */
public class LabMapActivity extends Activity implements AdapterView.OnItemClickListener {
	
	private String labName;
	//in proper implementation this array is populated by data controller
	private String computers[] = { "Computer-1", "Computer-2", "Computer-3", "Computer-4", "Computer-5", "Computer-6"
								 , "Computer-7", "Computer-8", "Computer-9", "Computer-10", "Computer-11", "Computer-12"
								 , "Computer-13", "Computer-14", "Computer-15", "Computer-16", "Computer-17", "Computer-18"
								 , "Computer-19", "Computer-20", "Computer-21", "Computer-22", "Computer-23", "Computer-24"
								 , "Computer-25"};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	Bundle labNameGiven = getIntent().getExtras();
    	labName = labNameGiven.getString("lab");   	
    	
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_map);
     
        //initialise the tabs
        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();
        
        TabSpec tabSpec;
        tabSpec = tabHost.newTabSpec("Lab Map");
        tabSpec.setContent(R.id.mapview);
        tabSpec.setIndicator("Lab Map");
        tabHost.addTab(tabSpec);
        
        tabSpec = tabHost.newTabSpec("List of Computers");
        tabSpec.setContent(R.id.listview);
        tabSpec.setIndicator("List Of Computers");
        tabHost.addTab(tabSpec);
        
        // Creates an ArrayAdapter for the String array computers.
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(LabMapActivity.this, R.layout.lab_list_custom, computers);
    	// This ListView is in the XML activity_lab_map
    	ListView listOfComputers = (ListView) findViewById(R.id.listOfComputers);
    	listOfComputers.setAdapter(adapter);

    	listOfComputers.setOnItemClickListener(this);
        

    }

	public void onItemClick(AdapterView parent, View v, int position, long id) {

		/* This Method should get list of computers in lab on button click, 
		 * Passes string of lab name corresponding to button pressed to labMapActivity  */
		String computerName = computers[position];
		Log.v("labClick", "Clicked computer " + computerName);
		
		Intent intent = new Intent(LabMapActivity.this, ComputerActivity.class);
		Bundle computer = new Bundle();
		computer.putString("computer", computerName);
		intent.putExtras(computer);
		startActivity(intent);
		 
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_lab_map, menu);
        return true;
    }
    
    public String getLabName()
    {
    	return labName;
    }
    
}
