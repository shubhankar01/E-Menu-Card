package com.e_menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Data
{
	public static final String DATABASE_VEG = "Veg";
	public static final String DATABASE_NONVEG = "NonVeg";
	public static final String DATABASE_CHINESE = "Chinese";

	private static final String DATABASE_NAME = "DishFactory";
	private static final int DATABASE_VERSION = 1;

	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "name";
	public static final String KEY_PRICE = "price";
	public static final String KEY_INGREDIENTE = "ingrediente";
	public static final String KEY_SJT = "sjt";
	public static final String KEY_FP = "fp";
	public static final String KEY_FC = "fc";
	public static final String KEY_FM = "fm";

	private static SQLiteDatabase mydata;
	private final Context ourContext;
	private DbFactory ourhelper;

	public DbFactory getHelper()
	{
		return ourhelper;
	}

	public Data(Context c)
	{
		ourContext = c;
	}

	public Data open()
	{
		ourhelper = new DbFactory(ourContext);
		mydata = ourhelper.getWritableDatabase();
		return this;
	}

	public void close()
	{
		ourhelper.close();
	}

	public void DeleteEntry(String categ, String item) throws SQLException
	{
		// TODO Auto-generated method stub
		mydata.delete(categ, KEY_NAME + "=?", new String[] { item });

	}

	public Cursor getdata(String categ, String mess)
	{
		// TODO Auto-generated method stub
		String[] columns = new String[] { KEY_ROWID, KEY_NAME, KEY_PRICE,
				KEY_INGREDIENTE, KEY_SJT, KEY_FP, KEY_FC, KEY_FM };
		Cursor c = mydata.query(categ, columns, mess + " = 1", null, null,
				null, null);
		return c;
	}

	private static class DbFactory extends SQLiteOpenHelper
	{

		public DbFactory(Context context)
		{
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db)
		{
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_VEG + " (" + KEY_ROWID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME
					+ " TEXT NOT NULL, " + KEY_PRICE + " TEXT NOT NULL, "
					+ KEY_INGREDIENTE + " TEXT NOT NULL, " + KEY_SJT
					+ " INTEGER, " + KEY_FP + " INTEGER, " + KEY_FC
					+ " INTEGER, " + KEY_FM + " INTEGER" + ");");
			db.execSQL("CREATE TABLE " + DATABASE_NONVEG + " (" + KEY_ROWID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME
					+ " TEXT NOT NULL, " + KEY_PRICE + " TEXT NOT NULL, "
					+ KEY_INGREDIENTE + " TEXT NOT NULL, " + KEY_SJT
					+ " INTEGER, " + KEY_FP + " INTEGER, " + KEY_FC
					+ " INTEGER, " + KEY_FM + " INTEGER" + ");");
			db.execSQL("CREATE TABLE " + DATABASE_CHINESE + " (" + KEY_ROWID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME
					+ " TEXT NOT NULL, " + KEY_PRICE + " TEXT NOT NULL, "
					+ KEY_INGREDIENTE + " TEXT NOT NULL, " + KEY_SJT
					+ " INTEGER, " + KEY_FP + " INTEGER, " + KEY_FC
					+ " INTEGER, " + KEY_FM + " INTEGER" + ");");
			populateVEG(db);
			populateNONVEG(db);
			populateCHINESE(db);
		}

		private void populateVEG(SQLiteDatabase db)
		{
			String[] name = new String[] { "Mushroom Chat Pot Masala",
					"Mutter Paneer", "Palak Paneer", "Paneer Bhurji",
					"Paneer Pasanda", "Garlic Roti", "Plain Roti",
					"Butter Roti", "Stuffed Roti", "Paneer 65", "Gobi 65",
					"Mushroom 65" };
			String[] price = new String[] { "52.00", "45.00", "43.00", "54.00",
					"35.00", "66.00", "44.00", "44.00", "65.00", "30.00",
					"30.00", "30.00" };
			String[] ingredients = new String[] {
					"Fried Mushroom In Rich Spicy Gravy",
					"Delicious North Indian Paneer Gravy",
					"Palak Paneer with Methi", "Spicy Paneer Gravy",
					"Triangulated Paneer with spicy gravy",
					"Indian Bread stuffed with Garlic", "Plain Roti in flour",
					"Roti with Butter", "Indian Bread Stuffed with Vegetables",
					"Marinated Fried Paneer", "Marinated Fried Gobi",
					"Marinated Fried Mushroom" };

			int fp[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			int fc[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			int sjt[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			int fm[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

			for (int i = 0; i < 12; i++)
			{

				ContentValues cv = new ContentValues();
				cv.put(KEY_NAME, name[i]);
				cv.put(KEY_PRICE, price[i]);
				cv.put(KEY_INGREDIENTE, ingredients[i]);
				cv.put(KEY_FC, fc[i]);
				cv.put(KEY_SJT, sjt[i]);
				cv.put(KEY_FP, fp[i]);
				cv.put(KEY_FM, fm[i]);
				db.insert(DATABASE_VEG, null, cv);
			}

		}

		private void populateNONVEG(SQLiteDatabase db)
		{
			String[] name = new String[] { "Chilly Chicken", "Dragon Chicken",
					"Garlic Chicken", "Butter Chicken", "Hyderabadi Chicken",
					"Chicken 65", "Chicken Drumstick", "Chicken Tikka",
					"Prawn 65", "Chicken Fried Rice", "Schezwan Fried Rice",
					"Egg Fried Rice" };
			String[] price = new String[] { "65.00", "60.00", "62.00", "65.00",
					"60.00", "65.00", "75.00", "55.00", "65.00", "55.00",
					"65.00", "55.00" };

			String[] ingredients = new String[] { "Crispy Chicken Dry/Gravy",
					"Chopped chicken with Italian Sauce",
					"Fried chicken In spicy gravy",
					"Chicken Thick Gravy Served with Butter",
					"Spicy chicken dish prepared in Hyderabadi Style",
					"Crispy chicken pieces served with Salad",
					"Crispy chicken pieces served with Salad",
					"Grilled Chicken chunks marinated in special spices",
					"Crispy Prawn pieces served with Salad",
					"Basmati rice with nutty chicken", "Spicy Fried Rice",
					"Fried Rice with Scrambled Egg" };

			int fp[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			int fc[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			int sjt[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			int fm[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

			for (int i = 0; i < 12; i++)
			{

				ContentValues cv = new ContentValues();
				cv.put(KEY_NAME, name[i]);
				cv.put(KEY_PRICE, price[i]);
				cv.put(KEY_INGREDIENTE, ingredients[i]);
				cv.put(KEY_FC, fc[i]);
				cv.put(KEY_SJT, sjt[i]);
				cv.put(KEY_FP, fp[i]);
				cv.put(KEY_FM, fm[i]);
				db.insert(DATABASE_NONVEG, null, cv);
			}

		}

		private void populateCHINESE(SQLiteDatabase db)
		{
			String[] name = new String[] { "Paneer Manchurian", "Veg Noodles",
					"American Chopsey", "Chilly Noodles", "Kung Pao Chicken",
					"Hakka Noodles", "Singapore Noodles", "Shezwan Noodles",
					"Honkong Noodles", "Chinese Chopsey", "Fried Momos" };
			String[] price = new String[] { "75.00", "85.00", "95.00", "70.00",
					"120.00", "70.00", "75.00", "80.00", "70.00", "100.00",
					"65.00" };
			String[] ingredients = new String[] {
					"Paneer with Delicious Manchurian Gravy",
					"Noodles with Fried Vegetable",
					"Crispy Noodles with delightful sause", "Spicy Noodles",
					"Chinese Sichuan dish with Chicken Cubes", "Thai Noodles",
					"Chicken, noodles, mushrooms, and water chestnuts",
					"Spicy Noodles", "Noodles prepared in Hongkong Style ",
					"Plain Choupsey with cheese dip", "Fried steamed Momos" };

			int fp[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			int fc[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			int sjt[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			int fm[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			for (int i = 0; i < 11; i++)
			{

				ContentValues cv = new ContentValues();
				cv.put(KEY_NAME, name[i]);
				cv.put(KEY_PRICE, price[i]);
				cv.put(KEY_INGREDIENTE, ingredients[i]);
				cv.put(KEY_FC, fc[i]);
				cv.put(KEY_SJT, sjt[i]);
				cv.put(KEY_FP, fp[i]);
				cv.put(KEY_FM, fm[i]);

				db.insert(DATABASE_CHINESE, null, cv);
			}

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
		{
			// TODO Auto-generated method stub
			db.execSQL(" DROP TABLE IF EXISTS " + DATABASE_VEG);
			db.execSQL(" DROP TABLE IF EXISTS " + DATABASE_NONVEG);
			db.execSQL(" DROP TABLE IF EXISTS " + DATABASE_CHINESE);

			onCreate(db);
		}

	}

}
