package com.nullcognition.sockeqweexamples;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.widget.Toast;

import se.emilsjolander.intentbuilder.Extra;
import se.emilsjolander.intentbuilder.IntentBuilder;

@IntentBuilder
public class MyReceiver extends BroadcastReceiver{

	@Extra
	Model3 parcelable;

	public MyReceiver(){
	}


	public static void sendParcelable(Context context, Parcelable parcelable){
		// cannot use generic parcelable, must be type specific argument^
// unless you specifically cast, thus instead of statically creating the Broadcast receiver
		// in the manifest.xml, dynamically create it with type parameters, to use as the @Extra
		// an for the sendParcelable type so the intent builder receives the correct type


		context.sendBroadcast(new MyReceiverIntentBuilder((Model3)parcelable).build(context));
	}

	@Override
	public void onReceive(Context context, Intent intent){
		MyReceiverIntentBuilder.inject(intent, this);
		Toast.makeText(context, "Got intent:" + intent.getAction() + "\nthe parc was: "
						+ parcelable.aPackageVisibleInt + " and the bagged field's value:"
						+ parcelable.UnSupportedParcelableFieldButBagged.i,
				Toast.LENGTH_SHORT).show();
	}
}
