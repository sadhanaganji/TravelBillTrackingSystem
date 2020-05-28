package com.travelbilltrackingsystem;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmpLogin extends Activity {
	EditText eid,epass;
	Button log;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emp_login);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		log=(Button)findViewById(R.id.button1);
		eid=(EditText)findViewById(R.id.editText1);
		epass=(EditText)findViewById(R.id.editText2);
		
		db=openOrCreateDatabase("dereg", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists ereg(id varchar,pass varchar,em varchar,mo varchar)");
		log.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(eid.getText().toString().trim().length()==0||epass.getText().toString().trim().length()==0)
				{
					Toast.makeText(EmpLogin.this,"enter all the fields",Toast.LENGTH_SHORT).show();
					return;
				}
				if(eid.getText().toString().equals("admin")&&epass.getText().toString().equals("admin"))
				{
					globalvariabel.Setusername(eid.getText().toString());
					Toast.makeText(EmpLogin.this,"welcome to admin Home",Toast.LENGTH_SHORT).show();
					Intent a1=new Intent(EmpLogin.this,AdminHome.class);
					startActivity(a1);
					return;
				}
				
				
				Cursor cc=db.rawQuery("select * from ereg where id='"+eid.getText()+"' and pass='"+epass.getText()+"'",null);
				if(cc.moveToFirst())
				{
					globalvariabel.Setusername(eid.getText().toString());
					Toast.makeText(EmpLogin.this,"welcome to emp Home",Toast.LENGTH_SHORT).show();
					Intent a1=new Intent(EmpLogin.this,EmpHome.class);
					startActivity(a1);
					clr();
				}
				
			}
		});
	}
		
		public void clr()
		{
			eid.setText("");
			epass.setText("");
			
		}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.emp_login, menu);
		return true;
	}

}
