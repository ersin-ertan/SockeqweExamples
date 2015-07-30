package com.nullcognition.parcelableplease.parcelables;// Created by ersin on 30/07/15

import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.ParcelableNoThanks;
import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;

@ParcelablePlease(ignorePrivateFields = true)
public class Parcelable02 implements Parcelable{

	int willGetParceled = 3;

	@ParcelableNoThanks
	String str = "s";

	private int i = 2; // would have been a compile error due to private scope, but ignore is true

	@Override
	public int describeContents(){ return 0; }

	@Override
	public void writeToParcel(Parcel dest, int flags){Parcelable02ParcelablePlease.writeToParcel(this, dest, flags);}

	public static final Creator<Parcelable02> CREATOR = new Creator<Parcelable02>(){
		public Parcelable02 createFromParcel(Parcel source){
			Parcelable02 target = new Parcelable02();
			Parcelable02ParcelablePlease.readFromParcel(target, source);
			return target;
		}
		public Parcelable02[] newArray(int size){return new Parcelable02[size];}
	};
}
