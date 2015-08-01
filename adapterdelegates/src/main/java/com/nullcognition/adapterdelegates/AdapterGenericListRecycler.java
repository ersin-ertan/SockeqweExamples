package com.nullcognition.adapterdelegates;

import android.app.Activity;

import com.hannesdorfmann.adapterdelegates.ListDelegationAdapter;
import com.nullcognition.adapterdelegates.adapterdelegates.Type01AdapterDelegate;
import com.nullcognition.adapterdelegates.model.Viewable;

import java.util.List;

public class AdapterGenericListRecycler extends ListDelegationAdapter<List<Viewable>>{

	public AdapterGenericListRecycler(Activity activity, List<Viewable> items){
		// Delegates only the subset
		this.delegatesManager.addDelegate(new Type01AdapterDelegate(activity, 0));

		setItems(items);
		// but no need to do the rest of the initialization, due to the extension
	}
}
