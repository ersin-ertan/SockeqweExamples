package com.nullcognition.adapterdelegates;// Created by ersin on 01/08/15

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nullcognition.adapterdelegates.model.Type01;
import com.nullcognition.adapterdelegates.model.Viewable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FragmentGenericListRecycler extends Fragment{

	public static final String NAME = FragmentGenericListRecycler.class.getSimpleName();

	@Nullable
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);

		RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

		AdapterGenericListRecycler adapter = new AdapterGenericListRecycler(getActivity(), getList());
		recyclerView.setAdapter(adapter);

		return rootView;
	}

	private List<Viewable> getList(){

		List<Viewable> list = new ArrayList<>();

		Viewable[] viewables = { // only a sub set of the types
				new Type01("t00a", "secondArg0"),
				new Type01("t00b", "secondArg1"),
				new Type01("t00e", "secondArg2"),
				new Type01("t00d", "secondArg3"),
				new Type01("t00a", "secondArg0"),
				new Type01("t00b", "secondArg1"),
				new Type01("t00e", "secondArg2"),
				new Type01("t00d", "secondArg3"),
				new Type01("t00a", "secondArg0"),
				new Type01("t00b", "secondArg1"),
				new Type01("t00e", "secondArg2"),
				new Type01("t00d", "secondArg3")
		};

		list.addAll(Arrays.asList(viewables));
		Collections.shuffle(list);

		return list;
	}
}


