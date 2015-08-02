package com.nullcognition.workedarchitecture;// Created by ersin on 02/08/15

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.fragmentargs.FragmentArgs;
import com.hannesdorfmann.fragmentargs.annotation.Arg;

import butterknife.ButterKnife;

public class FragmentArgable extends Fragment{

	@Arg
	boolean isTablet;

	@Arg(required = false)
	String id;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		FragmentArgs.inject(this); // read @Arg fields
	}
}
