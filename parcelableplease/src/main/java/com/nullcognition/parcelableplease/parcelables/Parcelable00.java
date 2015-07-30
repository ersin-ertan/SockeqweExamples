package com.nullcognition.parcelableplease.parcelables;// Created by ersin on 30/07/15

import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;


@ParcelablePlease
public class Parcelable00 implements Parcelable{


	String str = "s";
	int i = 2;
	// then right click and generate... ParcelablePlease

	@Override
	public int describeContents(){ return 0; }

	@Override
	public void writeToParcel(Parcel dest, int flags){Parcelable00ParcelablePlease.writeToParcel(this, dest, flags);}

	public static final Creator<Parcelable00> CREATOR = new Creator<Parcelable00>(){
		public Parcelable00 createFromParcel(Parcel source){
			Parcelable00 target = new Parcelable00();
			Parcelable00ParcelablePlease.readFromParcel(target, source);
			return target;
		}
		public Parcelable00[] newArray(int size){return new Parcelable00[size];}
	};
}

// Fields must have at least default (package) visibility. That means private fields are not supported.
// Private classes are not supported because of visibility issues

/*
* Supported types
*
Primitives
byte, boolean, double, float, int, long, String,

Primitive wrappers
Byte, Boolean, Double, Float, Int, Long


Android specific
Parcelable (anything that implements Parcelable), Bundle, SparseBooleanArray, Arrays

int[], long[], double[], String[], float[], char[], boolean[], byte[], Parcelable[]
- array of anything that implements Parcelable


Other
Serializable, java.util.Date (by simpling passing time as millis)

Collections
List<? extends Parcelalble>, ArrayList<? extends Parcelable>, LinkedList<? extends Parcelable>
CopyOnWriteArrayList<? extends Parcelable>

 */
