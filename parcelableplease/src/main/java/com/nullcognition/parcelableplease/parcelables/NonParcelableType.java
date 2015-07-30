package com.nullcognition.parcelableplease.parcelables;// Created by ersin on 30/07/15

public class NonParcelableType{

	public NonParcelableType(int ii){i = ii;}
	public NonParcelableType(){}

	private int i = 1; // will default to this value
	// in the bagger writeInt if empty constructor is used
	public int getI(){ return i;}
	public void setI(final int i){ this.i = i;}
}
