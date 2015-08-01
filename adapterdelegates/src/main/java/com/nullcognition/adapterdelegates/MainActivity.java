package com.nullcognition.adapterdelegates;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportFragmentManager().beginTransaction()
		                           .add(R.id.linearLayout, new FragmentRecycler(), FragmentRecycler.NAME)
		                           .commit();

		int i = 9;
	}

	boolean b = false;

	@Override
	public void onBackPressed(){
		//super.onBackPressed();


		FragmentManager fragmentManager = getSupportFragmentManager();
		if(b)
		{			b = false;
			fragmentManager.beginTransaction()
			               .replace(R.id.linearLayout, new FragmentRecycler(), FragmentRecycler.NAME)
			               .commit();
		}
		else{
			b = true;
			fragmentManager.beginTransaction()
			               .replace(R.id.linearLayout, new FragmentGenericListRecycler(), FragmentGenericListRecycler.NAME)
			               .commit();
		}
	}

}
