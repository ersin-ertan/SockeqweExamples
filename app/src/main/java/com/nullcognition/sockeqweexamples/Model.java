package com.nullcognition.sockeqweexamples;// Created by ersin on 18/07/15

import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;

@ParcelablePlease
public class Model implements Parcelable{

	String s = "s";
	int i = 3;


	@Override
	public int describeContents(){ return 0; }

	@Override
	public void writeToParcel(Parcel dest, int flags){
		ModelParcelablePlease.writeToParcel(this, dest, flags);
	}

	public static final Creator<Model> CREATOR = new Creator<Model>(){

		public Model createFromParcel(Parcel source){

			Model target = new Model();

			ModelParcelablePlease.readFromParcel(target, source);

			return target;
		}

		public Model[] newArray(int size){return new Model[size];}
	};
}

// Fields must have at least default (package) visibility. That means private fields are not supported.
// Private classes are not supported because of visibility issues

/*
* Supported types
Primitives

byte
boolean
double
float
int
long
String
Primitive wrappers

Byte
Boolean
Double
Float
Int
Long
Android specific

Parcelable (anything that implements Parcelable)
Bundle
SparseBooleanArray
Arrays

int[]
long[]
double[]
String[]
float[]
char[]
boolean[]
byte[]
Parcelable[] - array of anything that implements Parcelable
Other

Serializable
java.util.Date (by simpling passing time as millis)
Collections

List<? extends Parcelalble>
ArrayList<? extends Parcelable>
LinkedList<? extends Parcelable>
CopyOnWriteArrayList<? extends Parcelable>
* */
