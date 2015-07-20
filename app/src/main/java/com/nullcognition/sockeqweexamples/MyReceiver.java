package com.nullcognition.sockeqweexamples;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import se.emilsjolander.intentbuilder.Extra;
import se.emilsjolander.intentbuilder.IntentBuilder;

@IntentBuilder
public class MyReceiver extends BroadcastReceiver{

	@Extra
	TestParcelable parcelable;

	public MyReceiver(){
	}


	public static void sendParcelable(Context context, TestParcelable parcelable){

		context.sendBroadcast(new MyReceiverIntentBuilder(parcelable).build(context));
	}

	@Override
	public void onReceive(Context context, Intent intent){
		MyReceiverIntentBuilder.inject(intent, this);
		Toast.makeText(context, "Got intent:" + intent.getAction() + "\nthe parc was: " + parcelable.i ,
				Toast.LENGTH_SHORT).show();
	}
}
