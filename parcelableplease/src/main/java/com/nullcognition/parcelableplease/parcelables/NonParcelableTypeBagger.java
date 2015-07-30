package com.nullcognition.parcelableplease.parcelables;// Created by ersin on 30/07/15

import android.os.Parcel;

import com.hannesdorfmann.parcelableplease.ParcelBagger;

public class NonParcelableTypeBagger implements ParcelBagger<NonParcelableType>{
	@Override
	public void write(final NonParcelableType value, final Parcel out, final int flags){

		if(value == null){ throw new NullPointerException();}  // added
		else{ out.writeInt(value.getI());}
	}

	@Override
	public NonParcelableType read(final Parcel in){

		int i = in.readInt();
		return new NonParcelableType(i);
	}
}
