package com.nullcognition.workedarchitecture;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class ItemListActivity extends AppCompatActivity
		implements ItemListFragment.Callbacks,
		           NavigationDrawerFragment.NavigationDrawerCallbacks{

	private boolean                  isTablet;
	private NavigationDrawerFragment navigationDrawerFragment;
	private CharSequence             title;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nav_drawer);

		initTwoPane();
		initNavDrawer();

	}
	private void initNavDrawer(){
		navigationDrawerFragment = (NavigationDrawerFragment)
				getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
		title = getTitle();

		navigationDrawerFragment.setUp(R.id.navigation_drawer, (R.id.drawer_layout));
	}
	private void initTwoPane(){
		if(findViewById(R.id.item_detail_container) != null){
			isTablet = true;
			((ItemListFragment) getSupportFragmentManager()
					.findFragmentById(R.id.item_list))
					.setActivateOnItemClick(true);
		}

	}

	@Override
	public void onItemSelected(String id){
		if(isTablet){
			ItemDetailFragment.addNewItemDetailFragment(getSupportFragmentManager(), isTablet, id);
		}
		else{ startActivity(new ItemDetailActivityIntentBuilder(id).build(this));}
	}

	// NavigationDrawer
	@Override
	public void onNavigationDrawerItemSelected(int position){ // want to get the standard layout to work first without replacing fragments
//		FragmentManager fragmentManager = getSupportFragmentManager();
//		fragmentManager.beginTransaction()
//		               .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
//		               .commit();
	}

	public void onSectionAttached(int number){
		switch(number){
			case 1:
				title = getString(R.string.title_section1);
				break;
			case 2:
				title = getString(R.string.title_section2);
				break;
			case 3:
				title = getString(R.string.title_section3);
				break;
		}
	}

	public void restoreActionBar(){
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(title);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		if(!navigationDrawerFragment.isDrawerOpen()){
			getMenuInflater().inflate(R.menu.nav_drawer, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		int id = item.getItemId();

		if(id == R.id.action_settings){
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public static class PlaceholderFragment extends Fragment{

		private static final String ARG_SECTION_NUMBER = "section_number";

		public static PlaceholderFragment newInstance(int sectionNumber){
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle              args     = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment(){}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
		                         Bundle savedInstanceState){
			View rootView = inflater.inflate(R.layout.fragment_nav_drawer, container, false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity){
			super.onAttach(activity);
			((ItemListActivity) activity).onSectionAttached(
					getArguments().getInt(ARG_SECTION_NUMBER));
		}
	}
}
