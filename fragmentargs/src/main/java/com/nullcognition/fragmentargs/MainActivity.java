package com.nullcognition.fragmentargs;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity{

	private boolean tablet;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final boolean isTablet = isTablet();

		Frag00 frag00 = new Frag00Builder(isTablet, "required00").build(); // remember it goes in alpha order

		// use the supportFragmentManager to use extended fragments instead type Fragment
		getSupportFragmentManager().beginTransaction()
		                           .add(R.id.layout_lin, frag00, Frag00.TAG)
		                           .commit();

		new Handler().postDelayed(new Runnable(){
			@Override
			public void run(){

				// cannot offer a null value for a not required primitive param, as is type specific
				Frag01 frag01 = new Frag01Builder(isTablet, "required01").notRequired(2).build();
				getSupportFragmentManager().beginTransaction()
				                           .add(R.id.layout_lin, frag01, Frag01.TAG)
				                           .commit();
			}
		}, 2000);
	}

	public boolean isTablet(){

		// based on which layout is inflated at runtime, pass isTablet boolean to the fragments
		// allowing it own logic to inflate the appropriate layout based on the @Arg value, in onCreateView

		View v = findViewById(R.id.someIdOnlyInTheTabletLayout);
		return v != null ? true : false;
	}
}
