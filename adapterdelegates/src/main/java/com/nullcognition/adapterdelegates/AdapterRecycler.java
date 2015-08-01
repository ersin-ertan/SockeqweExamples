
package com.nullcognition.adapterdelegates;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates.AdapterDelegatesManager;
import com.nullcognition.adapterdelegates.adapterdelegates.AdAdapterDelegate;
import com.nullcognition.adapterdelegates.adapterdelegates.Type00AdapterDelegate;
import com.nullcognition.adapterdelegates.adapterdelegates.Type01AdapterDelegate;
import com.nullcognition.adapterdelegates.model.Viewable;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter{

	private AdapterDelegatesManager<List<Viewable>> delegatesManager;
	private List<Viewable> items;

	public AdapterRecycler(Activity activity, List<Viewable> items){
		this.items = items;

		// Delegates
		delegatesManager = new AdapterDelegatesManager<>();
		delegatesManager.addDelegate(new AdAdapterDelegate(activity, 0));
		delegatesManager.addDelegate(new Type00AdapterDelegate(activity, 1));
		delegatesManager.addDelegate(new Type01AdapterDelegate(activity, 2));
		delegatesManager.addDelegate(new AdAdapterDelegate(activity, 3));
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
		return delegatesManager.onCreateViewHolder(parent, viewType);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
		delegatesManager.onBindViewHolder(items, position, holder);
	}

	@Override
	public int getItemViewType(int position){
		return delegatesManager.getItemViewType(items, position);
	}

	@Override
	public int getItemCount(){
		return items.size();
	}
}
