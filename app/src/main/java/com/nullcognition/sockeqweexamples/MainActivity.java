package com.nullcognition.sockeqweexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		int id = item.getItemId();

		if(id == R.id.action_recycler){
// did not have the container so was not added to anything(headless fragment)
			getSupportFragmentManager().beginTransaction().add(
					R.id.activity_linLayout, new MyChildBuilder(2, "Recycler View").id(00).build(), "fragmentTag")
			                           .commit();
			// good to pass in if double pane(tablet) vs single pane
			return true;
		}
		else if(id == R.id.action_list){


			getSupportFragmentManager().beginTransaction().add(
					R.id.activity_linLayout, new MyChild2Builder("List View").build(), "fragmentChild2")
			                           .commit();

		}
		else if(id == R.id.action_service){
			MyIntentService.startService(this, "google.com", null); // should say nullable on the third param but doesn't
		}
		else if(id == R.id.action_activity2){
			Main2Activity.startMain2Activity(this, true, "hi");
		}

		return super.onOptionsItemSelected(item);
	}
}

