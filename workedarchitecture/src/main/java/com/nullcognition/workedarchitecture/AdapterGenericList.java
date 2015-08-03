package com.nullcognition.workedarchitecture;

import android.app.Activity;

import com.hannesdorfmann.adapterdelegates.ListDelegationAdapter;
import com.nullcognition.workedarchitecture.dummy.DummyContent;

import java.util.List;

public class AdapterGenericList extends ListDelegationAdapter<List<DummyContent.DummyItem>>{

	public AdapterGenericList(Activity activity, List<DummyContent.DummyItem> items){
		this.delegatesManager.addDelegate(new Type00AdapterDelegate(activity, 0));

//		this.delegatesManager.addDelegate(new Type01AdapterDelegate(activity, 1));
//		this.delegatesManager.addDelegate(new Type02AdapterDelegate(activity, 2));

		setItems(items);
	}
}
