package com.nullcognition.intentbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import se.emilsjolander.intentbuilder.Extra;
import se.emilsjolander.intentbuilder.IntentBuilder;

@IntentBuilder
public class Main2Activity extends AppCompatActivity{

	@Extra
	String required;

	@Extra
	@Nullable
	Boolean notRequiredButMustBeNullableThusTheWrapper;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		if(intent != null){
			Main2ActivityIntentBuilder.inject(getIntent(), this);
		}

		setContentView(R.layout.activity_main2);

		if(notRequiredButMustBeNullableThusTheWrapper == null){
			notRequiredButMustBeNullableThusTheWrapper = true;
		}

		Toast.makeText(
				Main2Activity.this,
				"required:" + required + ", notRequired:" + notRequiredButMustBeNullableThusTheWrapper.toString(),
				Toast.LENGTH_SHORT)
		     .show();

		Handler handler = new Handler();
		handler.postDelayed(new Runnable(){
			@Override
			public void run(){
				// general purpose
				startService(new MyIntentServiceIntentBuilder(MyIntentService.ACTION_FOO).build(getApplicationContext()));

				//MyIntentService.startServiceActionFoo(getApplicationContext(), null); // for specific implementations
			}
		}, 1000);
	}

}
