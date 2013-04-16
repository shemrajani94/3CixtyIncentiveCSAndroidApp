package com.comp1008.serveranalytics.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
		loadPrefs();
	}
	
	private void loadPrefs(){
	    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this); 
	    boolean radio0 = sp.getBoolean("2MINS", false); //gets the value of the boolean from the saved prefs, the 'false' is the default value
	    boolean radio1 = sp.getBoolean("5MINS", false);
	    /*boolean radio2 = sp.getBoolean("1HOUR", false);
	    boolean radio3 = sp.getBoolean("5HOURS", false);
	    boolean radio4 = sp.getBoolean("10HOURS", false);*/
	    if(freqSelection.getCheckedRadioButtonId() == -1){ 
		test.setText("None Selected");// if no radio button display show this
	    } else if(radio0){ // if radio0 was set true in savePrefs, check the radiobutton this time
		freqSelection.check(R.id.radio0); // this is what actually 'checks' the radiobutton (by check i mean select)
		test.setText("2 mins selected"); // testing purposes
	    } else if(radio1){
		freqSelection.check(R.id.radio1);
		test.setText("5 mins selected");
	    } /*else if(radio2){
		freqSelection.check(R.id.radio2);
		test.setText("1 hour selected");
	    } else if(radio3){
		freqSelection.check(R.id.radio3);
		test.setText("5 hours selected");
	    } else if(radio4){
		freqSelection.check(R.id.radio4);
		test.setText("10 hours selected");
	    }*/
	}
	
	private void savePrefs(String key, boolean value){
	    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this); //Setup SharedPreferences
	    Editor edit = sp.edit(); // Allow 'edit' mode
	    edit.putBoolean(key, value); //puts the value of a radio button to true (is checked)
	    edit.commit(); //commits changes
	    // loadPrefs(); ***ignore, used for testing only
	}

	//Switch statement that adjusts textView according to radiobutton settings
	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		switch(arg1){
		case R.id.radio0:
			//setData = "Option 1 chosen (every 2 mins)"; ***ignore, used for testing only
			savePrefs("2MINS", true); //
			break;
		case R.id.radio1:
			//setData = "Option 2 chosen (every 5 mins)"; ***ignore, used for testing only
			savePrefs("5MINS", true);
			break;
			
		/*case R.id.radio2:
			//setData = "Option 3 chosen (every hour)"; ***ignore, used for testing only
			savePrefs("1HOUR", true);
			break;
			
		case R.id.radio3:
			//setData = "Option 4 chosen (every 5 hours)"; ***ignore, used for testing only
			savePrefs("5HOURS", true);
			break;	
		
		case R.id.radio4:
			//setData = "Option 5 chosen (every 10 hours)"; ***ignore, used for testing only
			savePrefs("10HOURS", true);
			break;*/
		}
		//test.setText(setData);
	}
}

