package com.nullcognition.adapterdelegates.adapterdelegates;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates.AbsAdapterDelegate;
import com.nullcognition.adapterdelegates.R;
import com.nullcognition.adapterdelegates.model.Type00;
import com.nullcognition.adapterdelegates.model.Viewable;

import java.util.List;

public class Type00AdapterDelegate extends AbsAdapterDelegate<List<Viewable>>{

	private LayoutInflater inflater;

	public Type00AdapterDelegate(Activity activity, int viewType){
		super(viewType);
		inflater = activity.getLayoutInflater();
	}

	@Override
	public boolean isForViewType(@NonNull List<Viewable> items, int position){
		return items.get(position) instanceof Type00;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent){
		return new Type00ViewHolder(inflater.inflate(R.layout.type_00, parent, false));
	}

	@Override
	public void onBindViewHolder(@NonNull List<Viewable> items, int position, @NonNull RecyclerView.ViewHolder holder){

		Type00ViewHolder vh = (Type00ViewHolder) holder;
		Type00 type00 = (Type00) items.get(position);

		vh.name.setText(type00.getName());
	}


	static class Type00ViewHolder extends RecyclerView.ViewHolder{

		public TextView name;


		public Type00ViewHolder(View itemView){
			super(itemView);
			name = (TextView) itemView.findViewById(R.id.name);
		}
	}
}
