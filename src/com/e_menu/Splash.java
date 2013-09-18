package com.e_menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

	// MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle TravisLoveBacon) {
		// TODO Auto-generated method stub
		super.onCreate(TravisLoveBacon);
		setContentView(R.layout.splash);
		// ourSong = MediaPlayer.create(Splash.this, R.raw.song);

		// SharedPreferences getPrefs = PreferenceManager
		// .getDefaultSharedPreferences(getBaseContext());
		// boolean music = getPrefs.getBoolean("checkbox", true);
		// if (music == true)
		// ourSong.start();

		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openStartingPoint = new Intent(Splash.this,Usermenu.class);
					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// ourSong.release();
		finish();
	}
}
