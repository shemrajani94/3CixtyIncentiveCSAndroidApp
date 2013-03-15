package com.comp1008.serveranalytics.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.comp1008.serveranalytics.R;

public class LabMapActivity extends Activity {
	
	private String labName;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	Bundle labNameGiven = getIntent().getExtras();
    	if (labName!=null)
    	{
    		labName = labNameGiven.getString("lab");
    	}
    	
    	
    	
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_map);
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_lab_map, menu);
        return true;
    }
    
}
