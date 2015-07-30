package com.nullcognition.fragmentargs;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.fragmentargs.FragmentArgs;
import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.hannesdorfmann.fragmentargs.bundler.CastedArrayListArgsBundler;

import java.util.List;

public class Frag00 extends Fragment{

	// Fields MUST have at least package (default) visibility.
	// That means no private, protected or static fields can be annotated with @Arg
	@Arg
	String required;

	@Arg(required = false)
	int notRequired = 1; // if un init, would be 0

	@Arg
	boolean isTablet;

	public static final String TAG = Frag00.class.getSimpleName();

	public Frag00(){ }

	@Override
	public void onCreate(final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		FragmentArgs.inject(this); // inheritable, no need to call Frag01 as specific builder name
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		//		Frag01Builder.injectArguments(this); // used for library, instead use generic FragmentArgs.inject in onCreate

		// isTablet will inflate the appropriate layout
		View rootView;
		if(isTablet){rootView = inflater.inflate(R.layout.fragment_tablet_main, container, false);}
		else{rootView = inflater.inflate(R.layout.fragment_main, container, false);}

		((TextView) rootView.findViewById(R.id.txt_fragment)).setText("Frag00 required: " + required
				+ ", notRequired:" + String.valueOf(notRequired));
		// unlike intent builder, the notRequired's class assignment value is persisted if no builder
		// parameter is provided

		return rootView;
	}

}
