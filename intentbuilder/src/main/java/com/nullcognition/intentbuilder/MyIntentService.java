package com.nullcognition.intentbuilder;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import se.emilsjolander.intentbuilder.Extra;
import se.emilsjolander.intentbuilder.IntentBuilder;

@IntentBuilder
public class MyIntentService extends IntentService{

	@Extra
	String action;

	@Extra
	@Nullable
	String param;// class assigned values are overwritten, = "classAssigned"; does nothing

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

		// setting the optional to null, or excluding it from the builder will provide a null param
		// thus assigning the default is done prior to use, not in the class field assignment
		if(param == null){ param = "sensibleDefault";}

		// do something with the param
	}

	// if starting a specific type of service that is repeatedly used, or needs additional
	// processing that should be encapsulated in this class rather than polluting the callers'
	public static void startServiceActionFoo(Context context, @Nullable String param){

		context.startService(
				new MyIntentServiceIntentBuilder(ACTION_FOO).param(param).build(context));
	}
}
