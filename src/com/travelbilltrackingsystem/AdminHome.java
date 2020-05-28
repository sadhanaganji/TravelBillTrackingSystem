package com.travelbilltrackingsystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdminHome extends Activity {
	Button bi,sa,ei,lo;
	TextView uid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_home);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		uid=(TextView)findViewById(R.id.textView3);
		uid.setText(globalvariabel.GetUsername().toString());
		bi=(Button)findViewById(R.id.button1);
		bi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a1=new Intent(AdminHome.this,BillInfo.class);
				startActivity(a1);
			}
		});
		sa=(Button)findViewById(R.id.button2);
		sa.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a2=new Intent(AdminHome.this,StatusOfApp.class);
				startActivity(a2);
			}
		});
		ei=(Button)findViewById(R.id.button3);
		ei.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a3=new Intent(AdminHome.this,EmpInfo.class);
				startActivity(a3);
			}
		});
		lo=(Button)findViewById(R.id.button4);
		lo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a4=new Intent(AdminHome.this,EmpLogin.class);
				startActivity(a4);
			}
		});
	}
	public void onBackPressed() {
		// TODO Auto-generated method stub
	Toast.makeText(AdminHome.this, "Press logout Button", Toast.LENGTH_SHORT).show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin_home, menu);
		return true;
	}

	
	
	
}
