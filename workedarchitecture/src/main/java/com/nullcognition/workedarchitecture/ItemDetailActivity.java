package com.nullcognition.workedarchitecture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import se.emilsjolander.intentbuilder.Extra;
import se.emilsjolander.intentbuilder.IntentBuilder;

@IntentBuilder
public class ItemDetailActivity extends AppCompatActivity{

	@Extra
	String id;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_item_detail);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		initFragment(savedInstanceState);
	}

	private void initFragment(final Bundle savedInstanceState){

		Intent intent = getIntent();
		if(intent != null){ ItemDetailActivityIntentBuilder.inject(intent, this); }

		if(savedInstanceState == null){
			ItemDetailFragment.addNewItemDetailFragment(getSupportFragmentManager(), false, id);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		int id = item.getItemId();
		if(id == android.R.id.home){
			NavUtils.navigateUpTo(this, new Intent(this, ItemListActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
