package com.e_menu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Usermenu extends Activity implements OnClickListener
{
	Button Fc, Fp, SJT, Darlres, lg;
	public static Boolean check = true;
	public static String message;
	public static double price;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Fc = (Button) findViewById(R.id.sjt);
		SJT = (Button) findViewById(R.id.foodcourt);
		Fp = (Button) findViewById(R.id.foodpark);
		Darlres = (Button) findViewById(R.id.darlingres);
		Fc.setOnClickListener(this);
		SJT.setOnClickListener(this);
		Fp.setOnClickListener(this);
		Darlres.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		Intent ourintent;
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		case R.id.sjt:
			message = "";
			price = 0;
			ourintent = new Intent(Usermenu.this, SJTView.class);
			startActivity(ourintent);

			// setContentView(R.layout.fcview);
			break;
		case R.id.foodcourt:
			message = "";
			price = 0;
			ourintent = new Intent(Usermenu.this, FCView.class);
			startActivity(ourintent);

			break;
		case R.id.foodpark:
			message = "";
			price = 0;
			ourintent = new Intent(Usermenu.this, FPView.class);
			startActivity(ourintent);

			break;
		case R.id.darlingres:
			message = "";
			price = 0;
			ourintent = new Intent(Usermenu.this, Darlresdense.class);
			startActivity(ourintent);

			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu)
	{
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowup = getMenuInflater();
		blowup.inflate(R.menu.loginmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		switch (item.getItemId())
		{

		case R.id.login:
			if (check == true)
			{
				Intent p = new Intent(Usermenu.this, Login.class);
				startActivity(p);
			} else
			{
				Dialog d = new Dialog(this);
				d.setTitle("Message!!!");
				TextView tv = new TextView(this);
				tv.setText("Login Problem!!");
				d.setContentView(tv);
				d.show();
			}
			break;

		}
		return false;
	}

}
