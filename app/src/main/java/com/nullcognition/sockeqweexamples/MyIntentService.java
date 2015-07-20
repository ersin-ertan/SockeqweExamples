package com.nullcognition.sockeqweexamples;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import se.emilsjolander.intentbuilder.Extra;
import se.emilsjolander.intentbuilder.IntentBuilder;

@IntentBuilder
public class MyIntentService extends IntentService{

	public static final String ACTION = "com.nullcognition.spotifystreamer2";
	public static final String INTENT = "com.nullcognition.PARCEL_INTENT";

	@Extra
	String action;

	@Extra
	@Nullable
	String secondString;

	public MyIntentService(){super("MyIntentService");}

	// technique to put the calling code in the containing class
	// must initialization will only need one or two parameters to pass in
	// be sure to call context.startservice and not self referencing startService static method
	public static void startService(Context context, String url, @Nullable String secondString){
		context.startService(new MyIntentServiceIntentBuilder(url)
				.secondString(secondString)
				.build(context));
	}

	@Override
	protected void onHandleIntent(Intent intent){
		MyIntentServiceIntentBuilder.inject(intent, this); // remember 'IntentBuilder' is appended, not Builder
		if(intent != null){
			final String action = intent.getAction();

			sendParcelableToCallingActivity();

		}
	}


	private void sendParcelableToCallingActivity(){

		MyReceiver.sendParcelable(this, new TestParcelable());
	}

}

