package com.e_menu;

import java.util.HashMap;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyCursorAdapter extends CursorAdapter
{

	public Data database;
	Context mycontext;
	public static HashMap<String, Integer> hashpmappicture;

	public MyCursorAdapter(Context context, Cursor c)
	{
		super(context, c);
		mycontext = context;
		database = new Data(mycontext);
		hashpmappicture = new HashMap<String, Integer>();
		putData();
	}

	private void putData()
	{

		hashpmappicture.put("Paneer Manchurian", R.drawable.paneermanchurian);
		hashpmappicture.put("American Chopsey", R.drawable.americanchopsey);
		hashpmappicture.put("Veg Noodles", R.drawable.vegnoodles);
		hashpmappicture.put("Chilly Chicken", R.drawable.chillychicken);
		hashpmappicture.put("Dragon Chicken", R.drawable.dragonchicken);
		hashpmappicture.put("Garlic Chicken", R.drawable.garlicchicken);
		hashpmappicture.put("Butter Chicken", R.drawable.butterchicken);
		hashpmappicture.put("Hyderabadi Chicken", R.drawable.hyderabadichicken);
		hashpmappicture.put("Chicken 65", R.drawable.chicken65);
		hashpmappicture.put("Chicken Drumstick", R.drawable.chickendrumstick);
		hashpmappicture.put("Chicken Tikka", R.drawable.chickentikka);
		hashpmappicture.put("Prawn 65", R.drawable.prawn65);
		hashpmappicture.put("Chicken Fried Rice", R.drawable.chickenfriedrice);
		hashpmappicture
				.put("Schezwan Fried Rice", R.drawable.schezwanfriedrice);
		hashpmappicture.put("Egg Fried Rice", R.drawable.eggfriedrice);
		hashpmappicture.put("Mushroom Chat Pot Masala",
				R.drawable.mushroomchatpotmasala);
		hashpmappicture.put("Mutter Paneer", R.drawable.mutterpaneer);
		hashpmappicture.put("Palak Paneer", R.drawable.palakpaneer);
		hashpmappicture.put("Paneer Bhurji", R.drawable.paneerbhurji);
		hashpmappicture.put("Paneer Pasanda", R.drawable.paneerpasanda);
		hashpmappicture.put("Garlic Roti", R.drawable.garlicroti);
		hashpmappicture.put("Plain Roti", R.drawable.plainroti);
		hashpmappicture.put("Butter Roti", R.drawable.butterroti);
		hashpmappicture.put("Stuffed Roti", R.drawable.stuffedroti);
		hashpmappicture.put("Paneer 65", R.drawable.paneer65);
		hashpmappicture.put("Gobi 65", R.drawable.gobi65);
		hashpmappicture.put("Mushroom 65", R.drawable.mushroom65);

		hashpmappicture.put("Chilly Noodles", R.drawable.chillinoodles);
		hashpmappicture.put("Kung Pao Chicken", R.drawable.kungpaochicken);
		hashpmappicture.put("Hakka Noodles", R.drawable.hakkanoodles);
		hashpmappicture.put("Singapore Noodles", R.drawable.singaporenoodles);
		hashpmappicture.put("Shezwan Noodles", R.drawable.shezwan);
		hashpmappicture.put("Honkong Noodles", R.drawable.hongkongnoodles);
		hashpmappicture.put("Chinese Chopsey", R.drawable.chinesechopsuey);
		hashpmappicture.put("Fried Momos", R.drawable.friedmomos);
	}

	@Override
	public void bindView(View row, Context ctxt, Cursor c)
	{
		ListHolder holder = (ListHolder) row.getTag();
		database.open();
		holder.populateFrom(c, database.getHelper());
		database.close();
	}

	@Override
	public View newView(Context ctxt, Cursor c, ViewGroup parent)
	{
		LayoutInflater inflater = (LayoutInflater) mycontext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.row, parent, false);
		ListHolder holder = new ListHolder(row);

		row.setTag(holder);

		return (row);
	}

	public static int getIdByName(String d)
	{
		if (hashpmappicture.get(d) != null)
		{
			return hashpmappicture.get(d);
		} else
		{
			return R.drawable.chickendrumstick;
		}
	}

}

class ListHolder
{
	private TextView name = null;
	private TextView address = null;
	private TextView price = null;
	private ImageView icon = null;

	ListHolder(View row)
	{
		name = (TextView) row.findViewById(R.id.title);
		address = (TextView) row.findViewById(R.id.ingre);
		icon = (ImageView) row.findViewById(R.id.icon);
		price = (TextView) row.findViewById(R.id.price);
	}

	void populateFrom(Cursor c, SQLiteOpenHelper helper)
	{

		name.setText(c.getString(1));
		address.setText(c.getString(3));
		price.setText("Rs." + c.getString(2));
		price.setTextColor(Color.GRAY);
		icon.setImageResource(MyCursorAdapter.getIdByName(c.getString(1)));

	}

}
