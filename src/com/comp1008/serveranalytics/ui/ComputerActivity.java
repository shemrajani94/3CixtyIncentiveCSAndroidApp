package com.comp1008.serveranalytics.ui;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

import com.comp1008.serveranalytics.R;

public class ComputerActivity extends Activity {
	
	private String computerName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_computer);
		

    	Bundle computerGiven = getIntent().getExtras();
    	if (computerGiven!=null)
    	{
    		computerName = computerGiven.getString("computer");
    	}
    	
    	TextView compNameView = (TextView)findViewById(R.id.computername_content);
    	compNameView.setText(computerName);
    	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_computer, menu);
		return true;
		
	}

}
