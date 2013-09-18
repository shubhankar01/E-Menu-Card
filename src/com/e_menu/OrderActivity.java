package com.e_menu;

import java.util.StringTokenizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class OrderActivity extends Activity
{

	TextView name, singlePrice, quantity, netPrice, total;
	Button payOrder;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order);
		payOrder = (Button) findViewById(R.id.payBill);
		name = (TextView) findViewById(R.id.tvName);
		singlePrice = (TextView) findViewById(R.id.tvSingle);
		quantity = (TextView) findViewById(R.id.tvQty);
		netPrice = (TextView) findViewById(R.id.tvPrice);
		total = (TextView) findViewById(R.id.tvTotal);
		makeTokan(Usermenu.message);
		total.setText("Rs " + String.valueOf(Usermenu.price));
		payOrder.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v)
			{
				Class myclass;
				try
				{
					myclass = Class.forName("com.e_menu.WebActivity");
					Intent myintent = new Intent(OrderActivity.this, myclass);
					startActivity(myintent);
				} catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}

			}
		});

	}

	@Override
	public void onBackPressed()
	{
		// TODO Auto-generated method stub
		Intent i = null;

		try
		{
			i = new Intent(OrderActivity.this,
					Class.forName("com.e_menu.Usermenu"));
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);

	}

	public void makeTokan(String message)
	{
		StringTokenizer st = new StringTokenizer(message, "\n");
		String nm = "", s = "", q = "", net = "";

		while (st.hasMoreTokens())
		{
			StringTokenizer inner = new StringTokenizer(st.nextToken(), "-");
			nm += inner.nextToken() + "\n\n";
			s += inner.nextToken() + "\n\n";
			q += inner.nextToken() + "\n\n";
			net += inner.nextToken() + "\n\n";

		}
		name.setText(nm);
		singlePrice.setText(s);
		quantity.setText(q);
		netPrice.setText(net);

	}

}
