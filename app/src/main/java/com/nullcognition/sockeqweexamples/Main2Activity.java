package com.nullcognition.sockeqweexamples;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import se.emilsjolander.intentbuilder.Extra;
import se.emilsjolander.intentbuilder.IntentBuilder;

@IntentBuilder
public class Main2Activity extends AppCompatActivity{

//	@Extra
//	boolean isTablet = false;
	// cannot have non null able primitives annotationed

	@Extra
	Boolean aBoolean; // thus use the wrapped classes

	@Extra
	@Nullable
	String str;

	public static void startMain2Activity(Context context, Boolean aBoolean, @Nullable String str){
		context.startActivity(
				new Main2ActivityIntentBuilder(aBoolean)
						//.str(null) // auto set to null, no need to call. str(null)
						.build(context));
	}


	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Main2ActivityIntentBuilder.inject(getIntent(), this);
		setContentView(R.layout.activity_main2);
	}

}
