package com.nullcognition.annotatedadapter;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		inflateFragment();
		initAdapter();

	}
	private void inflateFragment(){
		getSupportFragmentManager().beginTransaction().add(new MainActivityFragment(), MainActivityFragment.NAME).commit();

	}
	private void initAdapter(){

		List<TextImage> list = new ArrayList<>();
		for(int i = 0; i < 40; i++){
			TextImage ti = new TextImage();
			ti.text = "text" + i;
			ti.imageResourceId = R.drawable.abc_btn_rating_star_off_mtrl_alpha;
			list.add(ti);
		}

		final AbsListAdapter adapter = new AbsListAdapter(this, list);
		ListView listView = ((ListView) findViewById(R.id.listView));
		listView.setAdapter(adapter);

		listView.setFastScrollEnabled(true); // can set views to appear
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id){
				TextImage ti = (TextImage) adapter.getItem(position);
				Toast.makeText(MainActivity.this, "ti:" + ti.text + ", id:" + id, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public void onBackPressed(){
//		super.onBackPressed();
		FragmentManager fragmentManager = getSupportFragmentManager();
		if(fragmentManager.findFragmentByTag(MainActivityFragment.NAME) != null)
			fragmentManager.beginTransaction().replace(R.id.relativeLayout, new MainActivityFragment());
		// change mainactivity fragment to have a parmeterized onViewCreated to inflate recycler view vs absList
	}
}
