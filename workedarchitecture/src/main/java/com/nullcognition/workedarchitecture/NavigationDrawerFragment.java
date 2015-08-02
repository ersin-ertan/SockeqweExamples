package com.nullcognition.workedarchitecture;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class NavigationDrawerFragment extends FragmentArgable{

	private static final String STATE_SELECTED_POSITION  = "selected_navigation_drawer_position";
	private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

	private NavigationDrawerCallbacks callbacks;
	private ActionBarDrawerToggle     drawerToggle;
	private DrawerLayout              drawerLayout;
	private View                      fragmentContainerView;

	private int currentSelectedPosition = 0;
	private boolean fromSavedInstanceState;
	private boolean userLearnedDrawer;

	public NavigationDrawerFragment(){
	}

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
		userLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

		if(savedInstanceState != null){
			currentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
			fromSavedInstanceState = true;
		}

		selectItem(currentSelectedPosition);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Bind(R.id.navigation_drawer_listView)
	ListView mDrawerListView;

	@OnItemClick(R.id.navigation_drawer_listView)
	public void onItemClick(AdapterView<?> parent, View view, long id, int position){
		// left other parmeters visible if needed
		selectItem(position);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		mDrawerListView = (ListView) inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
		ButterKnife.bind(this, mDrawerListView);

		mDrawerListView.setAdapter(new ArrayAdapter<String>(
				getActionBar().getThemedContext(),
				android.R.layout.simple_list_item_activated_1,
				android.R.id.text1,
				new String[]{
						getString(R.string.title_section1),
						getString(R.string.title_section2),
						getString(R.string.title_section3),
				}));
		mDrawerListView.setItemChecked(currentSelectedPosition, true);
		return mDrawerListView;
	}

	public boolean isDrawerOpen(){
		return drawerLayout != null && drawerLayout.isDrawerOpen(fragmentContainerView);
	}

	public void setUp(int fragmentId, int drawerLayoutId){
		final FragmentActivity fragmentActivity = getActivity();
		drawerLayout = (DrawerLayout) fragmentActivity.findViewById(drawerLayoutId);
		fragmentContainerView = fragmentActivity.findViewById(fragmentId);

		drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);

		drawerToggle = new ActionBarDrawerToggle(
				fragmentActivity,                    /* host Activity */
				drawerLayout,                    /* DrawerLayout object */
				R.drawable.ic_drawer,             /* nav drawer image to replace 'Up' caret */
				R.string.navigation_drawer_open,  /* "open drawer" description for accessibility */
				R.string.navigation_drawer_close  /* "close drawer" description for accessibility */
		){
			@Override
			public void onDrawerClosed(View drawerView){
				super.onDrawerClosed(drawerView);
				if(!isAdded()){
					return;
				}

				fragmentActivity.supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
			}

			@Override
			public void onDrawerOpened(View drawerView){
				super.onDrawerOpened(drawerView);
				if(!isAdded()){
					return;
				}

				if(!userLearnedDrawer){
					userLearnedDrawer = true;
					SharedPreferences sp = PreferenceManager
							.getDefaultSharedPreferences(fragmentActivity);
					sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).apply();
				}

				fragmentActivity.supportInvalidateOptionsMenu();
			}
		};

		if(!userLearnedDrawer && !fromSavedInstanceState){
			drawerLayout.openDrawer(fragmentContainerView);
		}

		drawerLayout.post(new Runnable(){
			@Override
			public void run(){
				drawerToggle.syncState();
			}
		});

		drawerLayout.setDrawerListener(drawerToggle);
	}

	private void selectItem(int position){
		currentSelectedPosition = position;
		if(mDrawerListView != null){
			mDrawerListView.setItemChecked(position, true);
		}
		if(drawerLayout != null){
			drawerLayout.closeDrawer(fragmentContainerView);
		}
		if(callbacks != null){
			callbacks.onNavigationDrawerItemSelected(position);
		}
	}

	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try{
			callbacks = (NavigationDrawerCallbacks) activity;
		}
		catch(ClassCastException e){
			throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
		}
	}

	@Override
	public void onDetach(){
		super.onDetach();
		callbacks = null;
	}

	@Override
	public void onDestroyView(){
		super.onDestroyView();
		ButterKnife.unbind(this);
	}

	@Override
	public void onSaveInstanceState(Bundle outState){
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_SELECTED_POSITION, currentSelectedPosition);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig){
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
		if(drawerLayout != null && isDrawerOpen()){
			inflater.inflate(R.menu.global, menu);
			showGlobalContextActionBar();
		}
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		if(drawerToggle.onOptionsItemSelected(item)){
			return true;
		}

		if(item.getItemId() == R.id.action_example){
			Toast.makeText(getActivity(), "Example action.", Toast.LENGTH_SHORT).show();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private void showGlobalContextActionBar(){
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setTitle(R.string.app_name);
	}

	private ActionBar getActionBar(){
		return ((AppCompatActivity) getActivity()).getSupportActionBar();
	}

	public static interface NavigationDrawerCallbacks{
		void onNavigationDrawerItemSelected(int position);
	}
}
