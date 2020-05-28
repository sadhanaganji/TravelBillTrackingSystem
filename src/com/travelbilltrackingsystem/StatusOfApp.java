package com.travelbilltrackingsystem;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class StatusOfApp extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_status_of_app);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.status_of_app, menu);
		return true;
	}

}
