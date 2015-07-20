package com.nullcognition.sockeqweexamples;// Created by ersin on 20/07/15

import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;

@ParcelablePlease
public class TestParcelable implements Parcelable{
	int i = 1;

	@Override
	public int describeContents(){ return 0; }
	@Override
	public void writeToParcel(Parcel dest, int flags){
		TestParcelableParcelablePlease.writeToParcel(this, dest, flags);}

	public static final Creator<TestParcelable> CREATOR = new Creator<TestParcelable>(){
		public TestParcelable createFromParcel(Parcel source){
			TestParcelable target = new TestParcelable();
			TestParcelableParcelablePlease.readFromParcel(target, source);
			return target;
		}
		public TestParcelable[] newArray(int size){return new TestParcelable[size];}
	};
}
