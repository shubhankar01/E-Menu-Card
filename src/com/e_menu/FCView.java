package com.e_menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class FCView extends Activity
{
	TabHost th;
	ListView veglist, nonlist, chineselist;
	MyCursorAdapter vegAdap, nonAdap, chiAdap;
	Data database;
	MyListHandler handler = new MyListHandler(FCView.this);
	Cursor cVeg, cNon, cChinese;
	boolean flag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_fc);
		th = (TabHost) findViewById(R.id.tabhost);
		th.setup();
		TabSpec tb1 = th.newTabSpec("tag1");
		tb1.setContent(R.id.tab1);
		tb1.setIndicator("Veg");
		th.addTab(tb1);
		TabSpec tb2 = th.newTabSpec("tag2");
		tb2.setContent(R.id.tab2);
		tb2.setIndicator("NonVeg");
		th.addTab(tb2);
		TabSpec tb3 = th.newTabSpec("tag3");
		tb3.setContent(R.id.tab3);
		tb3.setIndicator("Chinese");
		th.addTab(tb3);

		// Setting up of list
		database = new Data(FCView.this);
		database.open();

		cVeg = database.getdata(Data.DATABASE_VEG, Data.KEY_FC);
		cVeg.moveToFirst();
		cNon = database.getdata(Data.DATABASE_NONVEG, Data.KEY_FC);
		cNon.moveToFirst();
		cChinese = database.getdata(Data.DATABASE_CHINESE, Data.KEY_FC);
		cChinese.moveToFirst();

		veglist = (ListView) findViewById(R.id.list1);
		nonlist = (ListView) findViewById(R.id.list2);
		chineselist = (ListView) findViewById(R.id.list3);

		vegAdap = new MyCursorAdapter(FCView.this, cVeg);
		nonAdap = new MyCursorAdapter(FCView.this, cNon);
		chiAdap = new MyCursorAdapter(FCView.this, cChinese);

		veglist.setAdapter(vegAdap);
		nonlist.setAdapter(nonAdap);
		chineselist.setAdapter(chiAdap);

		veglist.setOnItemClickListener(handler);
		nonlist.setOnItemClickListener(handler);
		chineselist.setOnItemClickListener(handler);

		database.close();
	}

	@Override
	public void onBackPressed()
	{
		String message;
		if (flag == false)
		{
			message = "You Have not ordered yet. Are you sure u want to go back ?";
		} else
		{
			message = "Is this your final order";
		}
		AlertDialog.Builder dialog = new AlertDialog.Builder(FCView.this);

		dialog.setTitle(message);
		dialog.setPositiveButton("Ya, I am Done",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-g enerated method stub

						Intent i = null;

						try
						{
							i = new Intent(FCView.this, Class
									.forName("com.e_menu.OrderActivity"));
						} catch (ClassNotFoundException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();

						}
						i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(i);

					}
				});
		dialog.setNegativeButton("No, I want to Order",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub

					}
				});
		dialog.show();

	}

}