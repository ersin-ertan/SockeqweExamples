package com.nullcognition.parcelableplease;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

public class MyIntentService extends IntentService{

	private static final String ACTION_FOO = "com.nullcognition.parcelableplease.action.FOO";

	public MyIntentService(){super("MyIntentService");}

	@Override
	protected void onHandleIntent(Intent intent){
		if(intent != null){
			final String action = intent.getAction();
			if(ACTION_FOO.equals(action)){
				handleActionFoo();
			}
		}
	}

	private void handleActionFoo(){

	}

	public static void startActionFoo(Context context){
		Intent intent = new Intent(context, MyIntentService.class);
		intent.setAction(ACTION_FOO);
		context.startService(intent);
	}

}
