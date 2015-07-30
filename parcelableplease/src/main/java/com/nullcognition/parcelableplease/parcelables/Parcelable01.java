package com.nullcognition.parcelableplease.parcelables;// Created by ersin on 30/07/15

import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;
import com.hannesdorfmann.parcelableplease.annotation.ParcelableThisPlease;

@ParcelablePlease(allFields = false)
public class Parcelable01 implements Parcelable{

	@ParcelableThisPlease
	String str = "s";
	int i = 2; // will not get parceled


	@Override
	public int describeContents(){ return 0; }

	@Override
	public void writeToParcel(Parcel dest, int flags){Parcelable01ParcelablePlease.writeToParcel(this, dest, flags);}

	public static final Creator<Parcelable01> CREATOR = new Creator<Parcelable01>(){
		public Parcelable01 createFromParcel(Parcel source){
			Parcelable01 target = new Parcelable01();
			Parcelable01ParcelablePlease.readFromParcel(target, source);
			return target;
		}
		public Parcelable01[] newArray(int size){return new Parcelable01[size];}
	};
}
