package com.nullcognition.parcelableplease;// Created by ersin on 30/07/15

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nullcognition.parcelableplease.parcelables.Parcelable03;

import se.emilsjolander.intentbuilder.Extra;
import se.emilsjolander.intentbuilder.IntentBuilder;


// dynamic registration does not work with the intentbuilder, but static does
// static system wide tested, but not with LocalBroadcastmanager
public class MyReceiver extends BroadcastReceiver{

	public static final String ACTION = "action";
	public MyReceiver(){ }

	@Override
	public void onReceive(Context context, Intent intent){

		Parcelable03 p3 = intent.getParcelableExtra(Parcelable03.NAME);
		Toast.makeText(context, "got:" + p3.nonParcelableType.getI(), Toast.LENGTH_SHORT).show();

	}
}
