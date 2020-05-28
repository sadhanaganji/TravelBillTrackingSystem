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
import android.widget.TextView;
import android.widget.Toast;

public class BillForm extends Activity {
	Button su;
	EditText pot,date,amount,from,to;
	SQLiteDatabase db;
	TextView uid;
	TextView ran;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_bill_form);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		uid=(TextView)findViewById(R.id.textView3);
		uid.setText(globalvariabel.GetUsername().toString());
		ran=(TextView)findViewById(R.id.textView5);
		ran.setText(generatePIN());
		su=(Button)findViewById(R.id.button1);
		pot=(EditText)findViewById(R.id.editText4);
		date=(EditText)findViewById(R.id.editText3);
		amount=(EditText)findViewById(R.id.editText5);
		from=(EditText)findViewById(R.id.editText1);
		to=(EditText)findViewById(R.id.editText2);
		
		
		
		db=openOrCreateDatabase("dereg", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists billf(eid varchar, tid integer, pr varchar, dt integer, at integer, fr varchar, two varchar,sta varchar)");
		//db.execSQL("create table if not exists travel(t integer)");
		su.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(pot.getText().toString().trim().length()==0||date.getText().toString().trim().length()==0||amount.getText().toString().trim().length()==0||from.getText().toString().trim().length()==0||to.getText().toString().trim().length()==0)
				{
					Toast.makeText(BillForm.this,"please enter all the details",Toast.LENGTH_SHORT).show();
					return;
				}

				String sta="Waiting For reply";
				db.execSQL("insert into billf values('"+uid.getText()+"','"+ran.getText()+"','"+pot.getText()+"','"+date.getText()+"','"+amount.getText()+"','"+from.getText()+"','"+to.getText()+"','"+sta+"')");
				
				Toast.makeText(BillForm.this, "successfully filled billform",Toast.LENGTH_SHORT).show();
				clr();
				
				Intent a1=new Intent(BillForm.this,EmpHome.class);
				startActivity(a1);
			}
		});
	}

	public String generatePIN(){
		
			int randomPIN=(int)(Math.random()*90000000)+10000000;
			final String rpin=String.valueOf(randomPIN);
			return rpin;	
		
	}

	public void clr()
	{
		pot.setText("");
		date.setText("");
		amount.setText("");
		from.setText("");
		to.setText("");
		
	}
	
	
}
