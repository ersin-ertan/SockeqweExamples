package com.nullcognition.annotatedadapter;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		inflateFragment();

	}
	private void inflateFragment(){
		getSupportFragmentManager().beginTransaction()
		                           .add(R.id.frameLayout, new FragmentAbsList(), FragmentAbsList.NAME)
		                           .commit();

	}

	boolean b = true;

	@Override
	public void onBackPressed(){
//		super.onBackPressed();
		FragmentManager fragmentManager = getSupportFragmentManager();
		if(b){ // tried to search by fragmenttag, but the fragmentRecyclerList was persisted on fragment replace
			b = false;
			fragmentManager.beginTransaction()
			               .replace(R.id.frameLayout, new FragmentRecyclerList(), FragmentRecyclerList.NAME)
			               .commit();
		}
		else{
			b = true;
			fragmentManager.beginTransaction()
			               .replace(R.id.frameLayout, new FragmentAbsList(), FragmentAbsList.NAME)
			               .commit();
		}
		// change mainactivity fragment to have a parmeterized onViewCreated to inflate recycler view vs absList
	}
}
