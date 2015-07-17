package com.nullcognition.sockeqweexamples;// Created by ersin on 17/07/15

import android.os.Bundle;
import android.widget.Toast;

import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.hannesdorfmann.fragmentargs.annotation.FragmentArgsInherited;

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
		Toast.makeText(getActivity(), title + id + id2 , Toast.LENGTH_SHORT).show();
	}
}
