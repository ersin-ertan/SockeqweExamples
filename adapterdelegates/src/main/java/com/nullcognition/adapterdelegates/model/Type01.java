package com.nullcognition.adapterdelegates.model;// Created by ersin on 01/08/15

public class Type01 extends RootType{

	public String additionalArg;
	public String getAdditionalArg(){return additionalArg;}

	public Type01(final String name, String additionalArg){
		super(name);
		this.additionalArg = additionalArg;
	}

}
