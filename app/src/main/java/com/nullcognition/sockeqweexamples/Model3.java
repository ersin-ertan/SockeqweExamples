package com.nullcognition.sockeqweexamples;// Created by ersin on 18/07/15


import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.Bagger;
import com.hannesdorfmann.parcelableplease.annotation.ParcelableNoThanks;
import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;

@ParcelablePlease( ignorePrivateFields = true)
class Model3 implements Parcelable{

	@ParcelableNoThanks
	String s = "e";

	private int j = 3; // would have been a compile error

	int i = 4; // will get parceled

	@Bagger(UnSupportedParcelabeFieldBagger.class)
	UnSupportedParcelableField u;

	@Override
	public int describeContents(){ return 0; }

	@Override
	public void writeToParcel(Parcel dest, int flags){Model3ParcelablePlease.writeToParcel(this, dest, flags);}

	public static final Creator<Model3> CREATOR = new Creator<Model3>(){

		public Model3 createFromParcel(Parcel source){

				Model3 target = new Model3();

			Model3ParcelablePlease.readFromParcel(target, source);

			return target;
		}

		public Model3[] newArray(int size){return new Model3[size];}
	};
}
