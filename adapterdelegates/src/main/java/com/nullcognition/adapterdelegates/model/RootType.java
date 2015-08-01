package com.nullcognition.adapterdelegates.model;// Created by ersin on 01/08/15

import android.view.View;

public class RootType implements Viewable{

	private String name;
	public String getName(){return name;}

	public RootType(String name){this.name = name;}
}
