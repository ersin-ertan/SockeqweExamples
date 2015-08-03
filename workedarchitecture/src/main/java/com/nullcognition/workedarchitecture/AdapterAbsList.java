package com.nullcognition.workedarchitecture;// Created by ersin on 30/07/15

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.hannesdorfmann.annotatedadapter.AbsListViewAnnotatedAdapter;
import com.hannesdorfmann.annotatedadapter.annotation.ViewField;
import com.hannesdorfmann.annotatedadapter.annotation.ViewType;
import com.nullcognition.workedarchitecture.dummy.DummyContent;

import java.util.List;

public class AdapterAbsList extends AbsListViewAnnotatedAdapter implements AdapterAbsListBinder{

	@ViewType(
			layout = android.R.layout.simple_list_item_activated_1,

			views = {
					@ViewField(id = android.R.id.text1, name = "text", type = TextView.class)
			}
	)
	public final int txt = 0; // annotated view type constant

	List<DummyContent.DummyItem> items;

	protected AdapterAbsList(final Context context, List<DummyContent.DummyItem> listofItems){
		super(context);
		items = listofItems;
	}

	@Override
	public int getCount(){ return items != null ? items.size() : 0;}

	@Override
	public Object getItem(final int position){return items.get(position);}

	@Override
	public long getItemId(final int position){ // don't know what this is for
		return 0;
	}

	@Override
	public void bindViewHolder(final AdapterAbsListHolders.TxtViewHolder vh, final int position){
		String text = items.get(position).toString();
		vh.text.setText(text);
	}
}
