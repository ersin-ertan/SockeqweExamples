package com.nullcognition.fragmentargs;// Created by ersin on 29/07/15

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.hannesdorfmann.fragmentargs.annotation.FragmentArgsInherited;
import com.hannesdorfmann.fragmentargs.bundler.CastedArrayListArgsBundler;

import java.util.List;

@FragmentArgsInherited
public class Frag01 extends Frag00{

	public static final String TAG = Frag01.class.getSimpleName();

	// could not get advanced use case to work
//	@Arg ( bundler = CastedArrayListArgsBundler.class )
//	List<Foo> fooList;   // Foo implements Parcelable


	public Frag01(){ }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//		Frag01Builder.injectArguments(this); // library way
//		FragmentArgs.inject(this); // new way, in onCreate but inherited, so no need


		View rootView = inflater.inflate(R.layout.fragment_main, container, false);

		((TextView) rootView.findViewById(R.id.txt_fragment)).setText("Frag01 required: " + required
				+ ", notRequired:" + String.valueOf(notRequired));

		return rootView;
	}
}

