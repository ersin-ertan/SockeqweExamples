package com.nullcognition.sockeqweexamples;// Created by ersin on 18/07/15

import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;
import com.hannesdorfmann.parcelableplease.annotation.ParcelableThisPlease;

@ParcelablePlease(allFields = false)
public class Model2 implements Parcelable{

	@ParcelableThisPlease
	String s = "e";

	int i = 9;// will not get parceled


	@Override
	public int describeContents(){ return 0; }

	@Override
	public void writeToParcel(Parcel dest, int flags){Model2ParcelablePlease.writeToParcel(this, dest, flags);}

	public static final Creator<Model2> CREATOR = new Creator<Model2>(){

		public Model2 createFromParcel(Parcel source){

			Model2 target = new Model2();

			Model2ParcelablePlease.readFromParcel(target, source);

			return target;
		}

		public Model2[] newArray(int size){return new Model2[size];}
	};
}

