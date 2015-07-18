package com.nullcognition.sockeqweexamples;// Created by ersin on 17/07/15

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.hannesdorfmann.fragmentargs.annotation.FragmentArgsInherited;

import java.util.LinkedList;
import java.util.List;

//@FragmentArgsInherited(false) if false, non of the inherited or optional @Arg members
// can be used
@FragmentArgsInherited
public class MyChild extends MyFragment{

	@Arg
	int id2; // will override id is super if the same variable name, and inher(false)

	// since MyFragment is created first, any changes to the passed in variable will be
	// propagated to MyFragment,

	public List<String> list;

	@Override
	public void onCreate(final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		// as per oop , MyFragment toast is called first
		Toast.makeText(getActivity(), title + id + id2, Toast.LENGTH_SHORT).show();
	}

	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);

		RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
		setRecyclerViewLayoutManager(recyclerView);

		list = new LinkedList<String>();
		for(int i = 0; i < 50; i++){
			list.add(String.valueOf(i));
		}

		recyclerView.setAdapter(
				new RecyclerAdapter(getActivity(), list));

		return rootView;
	}

	public void removeZerothObject(){
		list.remove(0);
	}

	public void setRecyclerViewLayoutManager(final RecyclerView recyclerView){
		int scrollPosition = 4;
		if(recyclerView.getLayoutManager() != null){
			scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
					.findFirstCompletelyVisibleItemPosition();
		}
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		recyclerView.scrollToPosition(scrollPosition);
	}
}
