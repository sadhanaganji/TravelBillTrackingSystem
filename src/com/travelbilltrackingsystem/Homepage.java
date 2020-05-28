package com.travelbilltrackingsystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Homepage extends Activity {
	Button reg,log;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_homepage);
		reg=(Button)findViewById(R.id.button1);
		reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a1=new Intent(Homepage.this,EmpReg.class);
				startActivity(a1);
			}
		});
		log=(Button)findViewById(R.id.button2);
		log.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a2=new Intent(Homepage.this,EmpLogin.class);
				startActivity(a2);
			}
		});
		
		
		
		
	}


}
