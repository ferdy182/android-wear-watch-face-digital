package com.fernandofgallego.wearfacetest;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity
{
	TextView mTimeView;
	TextView mDateView;
	
	BroadcastReceiver mActionTimeTickBroadcastReceiver;
	private final SimpleDateFormat mTimeFormat = new SimpleDateFormat("HH:mm");
	private final SimpleDateFormat mDateFormat = new SimpleDateFormat("c dd MMM");

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTimeView = (TextView)findViewById(R.id.time);
		mDateView = (TextView)findViewById(R.id.date);
		mTimeView.setText(mTimeFormat.format(new Date()));
		mDateView.setText(mDateFormat.format(new Date()));
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		mActionTimeTickBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context ctx, Intent intent)
            {
                if (intent.getAction().compareTo(Intent.ACTION_TIME_TICK) == 0) {
                	mTimeView.setText(mTimeFormat.format(new Date()));
					mDateView.setText(mDateFormat.format(new Date()));
            }
        }
    };

    registerReceiver(mActionTimeTickBroadcastReceiver, new IntentFilter(Intent.ACTION_TIME_TICK));
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		if (mActionTimeTickBroadcastReceiver != null)
			unregisterReceiver(mActionTimeTickBroadcastReceiver);
	}

}
