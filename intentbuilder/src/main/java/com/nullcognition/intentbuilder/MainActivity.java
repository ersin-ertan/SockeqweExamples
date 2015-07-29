package com.nullcognition.intentbuilder;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import se.emilsjolander.intentbuilder.IntentBuilder;

public class MainActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Handler handler = new Handler();
		handler.postDelayed(new Runnable(){
			@Override
			public void run(){
				startActivity(new Main2ActivityIntentBuilder("required")
						.notRequiredButMustBeNullableThusTheWrapper(new Boolean(true)).build(getApplicationContext()));
				// context should be this if not in anon inner class like runnable
			}
		}, 1000);
	}
}
