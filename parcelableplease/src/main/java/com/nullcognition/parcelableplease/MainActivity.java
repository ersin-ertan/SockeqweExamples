package com.nullcognition.parcelableplease;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

	private MyReceiver myReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myReceiver = new MyReceiver();

		new Handler().postDelayed(new Runnable(){
			@Override
			public void run(){
				MyIntentService.startServiceActionFoo(getApplicationContext(), "assignedInMain");
			}
		}, 1000);
	}

	@Override
	protected void onStart(){
		super.onStart();

		LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver, new IntentFilter(MyReceiver.ACTION));

//		Intent intent = new MyReceiverIntentBuilder(8).build(this).setAction(MyReceiver.ACTION);
//      does not work with dynamic broadcast receivers, but works with static declared in Manifest.xml
	}

	@Override
	protected void onPause(){
		LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver);
		super.onPause();
	}
}
