package com.nullcognition.parcelableplease.parcelables;// Created by ersin on 30/07/15

import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.Bagger;
import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;

@ParcelablePlease
public class Parcelable03 implements Parcelable{

	public static final String NAME = Parcelable03.class.getSimpleName();

	public Parcelable03(){}

	@Bagger(NonParcelableTypeBagger.class)
	public NonParcelableType nonParcelableType;

	public static Parcelable03 newParcelable03(NonParcelableType nonParcelableType){
		if(nonParcelableType == null){ throw new NullPointerException(); } // added
		Parcelable03 parcelable03 = new Parcelable03();
		parcelable03.nonParcelableType = nonParcelableType;
		return parcelable03;
	}

	@Override
	public int describeContents(){ return 0; }

	@Override
	public void writeToParcel(Parcel dest, int flags){Parcelable03ParcelablePlease.writeToParcel(this, dest, flags);}

	public static final Creator<Parcelable03> CREATOR = new Creator<Parcelable03>(){

		public Parcelable03 createFromParcel(Parcel source){
			Parcelable03 target = new Parcelable03();
			Parcelable03ParcelablePlease.readFromParcel(target, source);
			return target;
		}
		public Parcelable03[] newArray(int size){return new Parcelable03[size];}
	};
}
