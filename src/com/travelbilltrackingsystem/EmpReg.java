package com.travelbilltrackingsystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



/* eid=empId,epass=empPassword,email=empMailAddres,emob=empMobileNumber*/
public class EmpReg extends Activity {
	EditText eid,epass,email,emob;
	Button sub;
	SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emp_reg);
		eid=(EditText)findViewById(R.id.editText1);
		epass=(EditText)findViewById(R.id.editText2);
		email=(EditText)findViewById(R.id.editText3);
		emob=(EditText)findViewById(R.id.editText4); 
		sub=(Button)findViewById(R.id.button1);
		db=openOrCreateDatabase("dereg", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists ereg(id varchar,pass varchar,em varchar,mo varchar)");
		sub.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(eid.getText().toString().trim().length()==0||epass.getText().toString().trim().length()==0)
				{
					Toast.makeText(EmpReg.this, "please enter all the details",Toast.LENGTH_SHORT).show();
					return;
				}
				else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
						{
							Toast.makeText(EmpReg.this, "please enter valid email id",Toast.LENGTH_SHORT).show();
							return;
						}
				else if(emob.getText().toString().trim().length()!=10)
				{
					Toast.makeText(EmpReg.this, "please enter 10 digit mobile number",Toast.LENGTH_SHORT).show();
					return;
				}
				db.execSQL("insert into ereg values('"+eid.getText()+"','"+epass.getText()+"','"+email.getText()+"','"+emob.getText()+"')");
				
				Toast.makeText(EmpReg.this, "registration done successfully",Toast.LENGTH_SHORT).show();
				clr();
			
				
			}	
			
		});
	}
		public void clr()
		{
			eid.setText("");
			epass.setText("");
			email.setText("");
			emob.setText("");
			
		}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.emp_reg, menu);
		return true;
	}

}
