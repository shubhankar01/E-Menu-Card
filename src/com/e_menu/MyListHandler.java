package com.e_menu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;

public class MyListHandler implements OnItemClickListener
{

	Context context;

	MyListHandler(Context c)
	{
		context = c;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
	{
		final Cursor c = (Cursor) arg0.getItemAtPosition(arg2);
		final EditText item = new EditText(context);
		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		dialog.setTitle("Order");
		dialog.setView(item);
		dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				int noofitems = 1;
				noofitems = Integer.valueOf(item.getText().toString());
				double pr = noofitems * Double.valueOf(c.getString(2));
				if (noofitems > 0)
				{
					Usermenu.price += pr;
					Usermenu.message += c.getString(1) + "-" + c.getString(2)
							+ "-" + noofitems + "-" + pr + "\n";
				}
			}
		});
		dialog.show();
	}

}
