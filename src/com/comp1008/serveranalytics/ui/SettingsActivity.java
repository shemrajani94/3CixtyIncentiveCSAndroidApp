package com.comp1008.serveranalytics.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.comp1008.serveranalytics.R;

/* SettingsActivity will load a settings page that allows the user to chose
 * at what frequency they would like to poll the server for information about printers and computers */


public class SettingsActivity extends Activity implements OnCheckedChangeListener{

	TextView settingsTitle, pollingTitle, test;
	RadioGroup freqSelection;
	String setData;
	
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		initialize();
		//Loads view and initializes buttons and radioGroup
	}

	private void initialize() {
		settingsTitle = (TextView) findViewById(R.id.settingsTitle);
		pollingTitle = (TextView) findViewById(R.id.pollingTitle);
		freqSelection = (RadioGroup) findViewById(R.id.rgSettings);
		freqSelection.setOnCheckedChangeListener(this);
		//Creates on click and on checkedChangeListeners for the button and radiogroup
		
		test = (TextView) findViewById(R.id.radiotester);
		//Textview used as test to see if radiobuttons are working
	}

	//Switch statement that adjusts textView according to radiobutton settings
	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		switch(arg1){
		case R.id.radio0:
			setData = "Option 1 chosen (every 2 mins)";
			break;
		case R.id.radio1:
			setData = "Option 2 chosen (every 5 mins)";
			break;
			
		case R.id.radio2:
			setData = "Option 3 chosen (every hour)";
			break;
			
		case R.id.radio3:
			setData = "Option 4 chosen (every 5 hours)";
			break;	
		
		case R.id.radio4:
			setData = "Option 5 chosen (every 10 hours)";
			break;	
			
		}
		test.setText(setData);
		
	}

	
}

