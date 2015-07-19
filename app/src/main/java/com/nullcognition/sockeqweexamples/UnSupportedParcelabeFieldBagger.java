package com.nullcognition.sockeqweexamples;// Created by ersin on 18/07/15

import android.os.Parcel;

import com.hannesdorfmann.parcelableplease.ParcelBagger;

public class UnSupportedParcelabeFieldBagger implements ParcelBagger<UnSupportedParcelableField>{
	@Override
	public void write(final UnSupportedParcelableField value, final Parcel out, final int flags){
		if(value == null){ out.writeInt(-1);} // default
		else{ out.writeInt(value.i);}
	}
	@Override
	public UnSupportedParcelableField read(final Parcel in){

		int i = in.readInt();

		if(i == -1){ return null;}

		return new UnSupportedParcelableField(i);
	}
}
