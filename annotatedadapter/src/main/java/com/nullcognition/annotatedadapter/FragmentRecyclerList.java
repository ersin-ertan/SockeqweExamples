package com.nullcognition.annotatedadapter;// Created by ersin on 31/07/15

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentRecyclerList extends Fragment{

	public static final String NAME = FragmentAbsList.class.getSimpleName();
	public FragmentRecyclerList(){}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

		View rootView = inflater.inflate(R.layout.fragment_recyclerlist, container, false);

		populateFragmentRecyclerList(rootView);

		return rootView;
	}

	public void populateFragmentRecyclerList(View rootView){

		List<TextImage> list = new ArrayList<>();
		for(int i = 0; i < 40; i++){
			TextImage ti = new TextImage();
			ti.text = "text" + i;
//			ti.imageResourceId = R.drawable.abc_btn_rating_star_off_mtrl_alpha;
			// populated in the viewholder in RecyclerListAdapter
			list.add(ti);
		}

		RecyclerListAdapter adapter = new RecyclerListAdapter(getActivity(), list);
		RecyclerView recyclerView = ((RecyclerView) rootView.findViewById(R.id.recyclerView));

		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		recyclerView.setAdapter(adapter);

		// additional, not required just for the divider lines
		recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
	}
}
