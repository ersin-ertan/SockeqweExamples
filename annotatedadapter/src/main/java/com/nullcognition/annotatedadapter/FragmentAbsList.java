package com.nullcognition.annotatedadapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FragmentAbsList extends Fragment{

	public static final String NAME = FragmentAbsList.class.getSimpleName();
	public FragmentAbsList(){}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

		View rootView = inflater.inflate(R.layout.fragment_abslist, container, false);

		populateFragmentAbsList(rootView);

		return rootView;
	}

	public void populateFragmentAbsList(View rootView){

		List<TextImage> list = new ArrayList<>();
		for(int i = 0; i < 40; i++){
			TextImage ti = new TextImage();
			ti.text = "text" + i;
			ti.imageResourceId = R.drawable.abc_btn_rating_star_off_mtrl_alpha;
			list.add(ti);
		}

		final AbsListAdapter adapter = new AbsListAdapter(getActivity(), list);
		ListView listView = ((ListView) rootView.findViewById(R.id.listView));
		listView.setAdapter(adapter);

		listView.setFastScrollEnabled(true); // can set views to appear beside the scroll
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id){
				TextImage ti = (TextImage) adapter.getItem(position);
				Toast.makeText(getActivity(), "ti:" + ti.text + ", id:" + id, Toast.LENGTH_SHORT).show();
			}
		});
	}
}
