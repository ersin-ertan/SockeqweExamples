package com.nullcognition.sockeqweexamples;// Created by ersin on 18/07/15

import android.content.Context;
import android.widget.TextView;

import com.hannesdorfmann.annotatedadapter.AbsListViewAnnotatedAdapter;
import com.hannesdorfmann.annotatedadapter.annotation.ViewField;
import com.hannesdorfmann.annotatedadapter.annotation.ViewType;

import java.util.List;

public class ListAdapter extends AbsListViewAnnotatedAdapter
		implements ListAdapterBinder{

	@ViewType(
			layout = R.layout.row_txt,
			views = {  // ids can be the same, but be carefull with the use and find of both
					@ViewField(id = R.id.row_txt, name = "text", type = TextView.class)
			}
	)
	public final int rowTxt = 0;

	List<String> items;

	public ListAdapter(final Context context, List<String> items){
		super(context);
		this.items = items;
	}

	@Override
	public int getCount(){
		return items != null ? items.size() : 0;
	}

	@Override
	public Object getItem(final int position){
		return items.get(position);
	}

	@Override
	public long getItemId(final int position){
		return rowTxt; //
	}

	@Override
	public void bindViewHolder(final ListAdapterHolders.RowTxtViewHolder vh, final int position){
		vh.text.setText(items.get(position));
	}


}
