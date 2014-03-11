package com.example.splashscreen;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AFirstActivity extends Activity {
	private Timer timer;
	private TextView current_time;
	public Intent intent;
	private Calendar calendar;
	public int FirstRun = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_first_splash);
		current_time = (TextView) findViewById(R.id.current_time);
		intent = new Intent(this, ASecondActivity.class);
	}

	protected void onStart() {

		super.onStart();

		timer = new Timer("DigitalClock");
		calendar = Calendar.getInstance();

		final Runnable updateTask = new Runnable() {
			public void run() {
				current_time.setText(getCurrentTime());
				if (FirstRun == 2)
					startActivity(intent);
			}
		};

		int msec = 999 - calendar.get(Calendar.MILLISECOND);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(updateTask);
			}
		}, msec, 1000);
	}

	private String getCurrentTime() {
		calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		FirstRun++;
		return "Splash screen \n"+String.format("%02d:%02d:%02d", hour, minute, second);
	}
}
