package com.travelbilltrackingsystem;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EmpHome extends Activity {
Button tb,bs,pro,lo;
TextView uid;
TextView sid;


SQLiteDatabase db;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emp_home);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		uid=(TextView)findViewById(R.id.textView3);
		uid.setText(globalvariabel.GetUsername().toString());
		tb=(Button)findViewById(R.id.button1);
		
		db=openOrCreateDatabase("dereg", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists ereg(id varchar,pass varchar,em varchar,mo varchar)");
		
		db.execSQL("create table if not exists billf(eid varchar, tid integer, pr varchar, dt integer, at integer, fr varchar, two varchar,sta varchar)");
		
		tb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a1=new Intent(EmpHome.this,BillForm.class);
				startActivity(a1);
			}
		});
		bs=(Button)findViewById(R.id.button2);
		bs.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Cursor c=db.rawQuery("SELECT * FROM billf WHERE eid='"+uid.getText()+"'", null);
				if(c.getCount()==0)
				{
			showMessage("Error","No record found");
				return;
				}
				StringBuffer buffer=new StringBuffer();
				while(c.moveToNext())
				{
					buffer.append("uid:"+c.getString(0)+"\n");
					buffer.append("ran:"+c.getString(1)+"\n");
					buffer.append("pot:"+c.getString(2)+"\n");
					buffer.append("date:"+c.getString(3)+"\n");
					buffer.append("amount:"+c.getString(4)+"\n");
					buffer.append("from:"+c.getString(5)+"\n");
					buffer.append("to:"+c.getString(6)+"\n");
					buffer.append("sta:"+c.getString(7)+"\n");
					
				}
				showMessage("Bill Status",buffer.toString());
			}
			public void showMessage(String title,String message)
			{
			Builder builder=new Builder(EmpHome.this);
			builder.setCancelable(true);
			builder.setTitle(title);
			builder.setMessage(message);
			builder.show();
			}
	
		});
		
	
			
		
		pro=(Button)findViewById(R.id.button3);
		pro.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Cursor cc=db.rawQuery("SELECT * FROM ereg WHERE id='"+uid.getText()+"'", null);
				if(cc.getCount()==0)
				{
			showMessage("Error","No record found");
				return;
				}
				StringBuffer buffer=new StringBuffer();
				while(cc.moveToNext())
				{
					buffer.append("eid:"+cc.getString(0)+"\n");
					buffer.append("epass:"+cc.getString(1)+"\n");
					buffer.append("email:"+cc.getString(2)+"\n");
					buffer.append("emob:"+cc.getString(3)+"\n\n");
					
				}
				showMessage("employee profile details",buffer.toString());
			}
			public void showMessage(String title,String message)
			{
			Builder builder=new Builder(EmpHome.this);
			builder.setCancelable(true);
			builder.setTitle(title);
			builder.setMessage(message);
			builder.show();
			}
	
		});
		
			lo=(Button)findViewById(R.id.button4);
		lo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a4=new Intent(EmpHome.this,Homepage.class);
				startActivity(a4);
			}
		});
		
	}
	

	@Override
		public void onBackPressed() {
			// TODO Auto-generated method stub
		Toast.makeText(EmpHome.this, "Press logout Button", Toast.LENGTH_SHORT).show();
		}

	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin_home, menu);
		return true;
	}
	



}