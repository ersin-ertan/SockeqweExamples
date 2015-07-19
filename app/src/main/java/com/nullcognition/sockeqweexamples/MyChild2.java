package com.nullcognition.sockeqweexamples;// Created by ersin on 18/07/15

// example of the list view with the list annotated adapter

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hannesdorfmann.fragmentargs.annotation.FragmentArgsInherited;

import java.util.LinkedList;
import java.util.List;

@FragmentArgsInherited
public class MyChild2 extends MyFragment{

	@Nullable
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.fragment_list, container, false);

		ListView lv = (ListView) rootView.findViewById(R.id.listView);

		List<String> list = new LinkedList<>();
		for(int i = 0; i < 100; ++i){
			list.add(String.valueOf(i));
		}

		lv.setAdapter(new ListAdapter(getActivity(), list));
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id){
				Toast.makeText(getActivity(), "clicked:"+position + " "+id, Toast.LENGTH_SHORT).show();
			}
		});

		return rootView;
	}


}
