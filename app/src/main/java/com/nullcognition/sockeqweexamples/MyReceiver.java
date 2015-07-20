package com.nullcognition.sockeqweexamples;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import se.emilsjolander.intentbuilder.Extra;
import se.emilsjolander.intentbuilder.IntentBuilder;

@IntentBuilder
public class MyReceiver extends BroadcastReceiver{

	@Extra
	String str;

	public MyReceiver(){
	}


	public static void sendParcelable(Context context, final String string){
		context.sendBroadcast(new MyReceiverIntentBuilder(string).build(context));
	}

	@Override
	public void onReceive(Context context, Intent intent){
		MyReceiverIntentBuilder.inject(intent, this);
		Toast.makeText(context, "Got intent:" + intent.getAction() + "\nthe string was: " + str,
				Toast.LENGTH_SHORT).show();
	}
}
