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

public class FPView extends Activity
{
	TabHost th;
	ListView veglist, nonlist, chineselist;
	MyCursorAdapter vegAdap, nonAdap, chiAdap;
	Data database;
	MyListHandler handler = new MyListHandler(FPView.this);
	Cursor cVeg, cNon, cChinese;
	boolean flag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_fp);
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
		database = new Data(FPView.this);
		database.open();

		cVeg = database.getdata(Data.DATABASE_VEG, Data.KEY_FP);
		cVeg.moveToFirst();
		cNon = database.getdata(Data.DATABASE_NONVEG, Data.KEY_FP);
		cNon.moveToFirst();
		cChinese = database.getdata(Data.DATABASE_CHINESE, Data.KEY_FP);
		cChinese.moveToFirst();

		veglist = (ListView) findViewById(R.id.list1);
		nonlist = (ListView) findViewById(R.id.list2);
		chineselist = (ListView) findViewById(R.id.list3);

		vegAdap = new MyCursorAdapter(FPView.this, cVeg);
		nonAdap = new MyCursorAdapter(FPView.this, cNon);
		chiAdap = new MyCursorAdapter(FPView.this, cChinese);

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
		AlertDialog.Builder dialog = new AlertDialog.Builder(FPView.this);

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
							i = new Intent(FPView.this, Class
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