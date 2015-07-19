package com.nullcognition.sockeqweexamples;// Created by ersin on 17/07/15

import android.os.Bundle;
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

// example of recycler view in the fragment with the recycler annotated adapter

//@FragmentArgsInherited(false) if false, non of the inherited or optional @Arg members
// can be used
@FragmentArgsInherited
public class MyChild extends MyFragment{

	@Arg
	int id2; // will override id is super if the same variable name, and inher(false)

	// since MyFragment is created first, any changes to the passed in variable will be
	// propagated to MyFragment,


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

		List<String> list = new LinkedList<String>();
		for(int i = 0; i < 100; i++){
			list.add(String.valueOf(i));
		}

		recyclerView.setAdapter(
				new RecyclerAdapter(getActivity(), list));

		return rootView;
	}

	// Don't use
//	public void removeZerothObject(){ // not working unless you can update the whole view container
//		// and even invalidate on the recycler view did not work, my known way is to replace the
//		// adapter with a new one... seems like a waste of an object
//		list.remove(0);
//		RecyclerView rv = (RecyclerView) getView().findViewById(R.id.recyclerView);
//		if(rv != null){
//			Toast.makeText(getActivity(), "rv not null, removing", Toast.LENGTH_SHORT).show();
////			rv.invalidate(); // has repeats of the refreshed number
//		}
//	}

	public void setRecyclerViewLayoutManager(final RecyclerView recyclerView){
		int scrollPosition = 4; // note should be 0, but trying 4
		if(recyclerView.getLayoutManager() != null){
			scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
					.findFirstCompletelyVisibleItemPosition();
		}
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		recyclerView.scrollToPosition(scrollPosition);
	}
}
