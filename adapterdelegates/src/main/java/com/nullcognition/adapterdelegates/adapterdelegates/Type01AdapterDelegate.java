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
import com.nullcognition.adapterdelegates.model.Type01;
import com.nullcognition.adapterdelegates.model.Viewable;

import java.util.List;

public class Type01AdapterDelegate extends AbsAdapterDelegate<List<Viewable>>{

	private LayoutInflater inflater;

	public Type01AdapterDelegate(Activity activity, int viewType){
		super(viewType);
		inflater = activity.getLayoutInflater();
	}

	@Override
	public boolean isForViewType(@NonNull List<Viewable> items, int position){
		return items.get(position) instanceof Type01;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent){
		return new Type01ViewHolder(inflater.inflate(R.layout.type_01, parent, false));
	}

	@Override
	public void onBindViewHolder(@NonNull List<Viewable> items, int position, @NonNull RecyclerView.ViewHolder holder){

		Type01ViewHolder vh = (Type01ViewHolder) holder;
		Type01 type01 = (Type01) items.get(position);

		vh.name.setText(type01.getName());
		vh.race.setText(type01.getAdditionalArg());
	}

	static class Type01ViewHolder extends RecyclerView.ViewHolder{

		public TextView name;
		public TextView race;

		public Type01ViewHolder(View itemView){
			super(itemView);
			name = (TextView) itemView.findViewById(R.id.name);
			race = (TextView) itemView.findViewById(R.id.additionalArg);
		}
	}
}
