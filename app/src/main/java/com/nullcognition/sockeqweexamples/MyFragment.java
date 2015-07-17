package com.nullcognition.sockeqweexamples;// Created by ersin on 17/07/15

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hannesdorfmann.fragmentargs.FragmentArgs;
import com.hannesdorfmann.fragmentargs.annotation.Arg;

public class MyFragment extends Fragment{

	@Arg
	String title;

	@Arg(required = false)
	int id;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		FragmentArgs.inject(this); // can put this into a super class and extend, which will have the fragmentArgs.inject
		// called for you, would be good to put whether or not is two pane as a inherited member variable
		Toast.makeText(getActivity(), title + id,				Toast.LENGTH_SHORT).show();
		title = "HELLO";

	}

}

