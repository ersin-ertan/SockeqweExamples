package com.nullcognition.adapterdelegates.adapterdelegates;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates.AbsAdapterDelegate;
import com.nullcognition.adapterdelegates.R;
import com.nullcognition.adapterdelegates.model.Ad;
import com.nullcognition.adapterdelegates.model.Viewable;

import java.util.List;

public class AdAdapterDelegate extends AbsAdapterDelegate<List<Viewable>>{

	LayoutInflater inflater;

	public AdAdapterDelegate(Activity activity, int viewType){
		super(viewType);
		inflater = activity.getLayoutInflater();
	}

	@Override
	public boolean isForViewType(@NonNull List<Viewable> items, int position){
		return items.get(position) instanceof Ad;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent){
		return new AdViewHolder(inflater.inflate(R.layout.type_ad, parent, false));
	}

	@Override
	public void onBindViewHolder(@NonNull List<Viewable> items, int position, @NonNull RecyclerView.ViewHolder holder){}

	static class AdViewHolder extends RecyclerView.ViewHolder{
		public AdViewHolder(View itemView){super(itemView);}
	}
}
