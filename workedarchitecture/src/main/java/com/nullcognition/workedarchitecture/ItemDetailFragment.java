package com.nullcognition.workedarchitecture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.fragmentargs.annotation.FragmentArgsInherited;
import com.nullcognition.workedarchitecture.dummy.DummyContent;

import butterknife.Bind;
import butterknife.ButterKnife;

@FragmentArgsInherited
public class ItemDetailFragment extends FragmentArgable{

	@Bind(R.id.item_detail)
	TextView textView;

	private DummyContent.DummyItem mItem;
	public ItemDetailFragment(){}

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		if(id != null){ mItem = DummyContent.ITEM_MAP.get(id);}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);
		ButterKnife.bind(this, rootView);

		if(mItem != null){textView.setText(mItem.content);}
		return rootView;
	}

	public static void addNewItemDetailFragment(FragmentManager fm, boolean isTablet, @Nullable String id){
		ItemDetailFragment fragment = new ItemDetailFragmentBuilder(isTablet).id(id).build();
		fm.beginTransaction()
		  .replace(R.id.item_detail_container, fragment)
		  .commit();
	}
}
