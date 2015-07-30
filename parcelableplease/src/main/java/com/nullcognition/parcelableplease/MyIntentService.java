package com.nullcognition.parcelableplease;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

import com.nullcognition.parcelableplease.parcelables.NonParcelableType;
import com.nullcognition.parcelableplease.parcelables.Parcelable03;

import se.emilsjolander.intentbuilder.Extra;
import se.emilsjolander.intentbuilder.IntentBuilder;

@IntentBuilder
public class MyIntentService extends IntentService{

	@Extra
	String action;

	@Extra
	@Nullable
	String param;

	public static final String ACTION_FOO = "com.nullcognition.intentbuilder.action.FOO";

	public MyIntentService(){
		super("MyIntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent){
		MyIntentServiceIntentBuilder.inject(intent, this);
		if(intent != null){
			if(ACTION_FOO.equals(action)){
				handleActionFoo(param);
			}
		}
	}

	private void handleActionFoo(String param){

		if(param == null){ param = "assignedInIntentService";}

		Parcelable03 p3 = Parcelable03.newParcelable03(new NonParcelableType(32));
		LocalBroadcastManager.getInstance(this).sendBroadcast(
				new Intent(MyReceiver.ACTION).putExtra(Parcelable03.NAME, p3));

		// sendBroadcast(new Intent(MyReceiver.ACTION), MyReceiver.PERMISSION);
		// do not use system wide if not sending through system
	}

	public static void startServiceActionFoo(Context context, @Nullable String param){

		context.startService(
				new MyIntentServiceIntentBuilder(ACTION_FOO).param(param).build(context));
	}
}
