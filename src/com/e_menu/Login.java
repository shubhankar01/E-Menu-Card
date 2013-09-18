package com.e_menu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity implements OnClickListener{
    
	EditText user;
	EditText password;
	Button submit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		user=(EditText)findViewById(R.id.etUsername);
		password=(EditText)findViewById(R.id.etPassword);
		submit=(Button)findViewById(R.id.bSubmit);
		submit.setOnClickListener(this);
		
		
	}
	@Override
	public void onClick(View v) {
		Intent ourintent;
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bSubmit:
			if(user.toString()=="anupam" && password.toString()=="asd"){
			
			}
			else
			{
				Dialog d=new Dialog(this);
				d.setTitle("Message!!!");
				TextView tv=new TextView(this);
				tv.setText("Wrong Username & Password!!");
				d.setContentView(tv);
				d.show();
			}
	      break;	
		}
		
	}
	

}
