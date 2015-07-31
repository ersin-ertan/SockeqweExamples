package com.nullcognition.annotatedadapter;// Created by ersin on 30/07/15

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.hannesdorfmann.annotatedadapter.AbsListViewAnnotatedAdapter;
import com.hannesdorfmann.annotatedadapter.annotation.ViewField;
import com.hannesdorfmann.annotatedadapter.annotation.ViewType;

import java.util.List;

public class AbsListAdapter extends AbsListViewAnnotatedAdapter implements AbsListAdapterBinder{

	@ViewType(
			layout = R.layout.txt_img,
			views = {
					@ViewField(id = R.id.imageView, name = "image", type = ImageView.class),
					@ViewField(id = R.id.textView, name = "text", type = TextView.class)
			}
	)
	public final int txt_img = 0; // annotated view type constant

	List<TextImage> items;

	protected AbsListAdapter(final Context context, List<TextImage> listofItems){
		super(context);
		items = listofItems;
	}

	@Override
	public int getCount(){ return items != null ? items.size() : 0;}

	@Override
	public Object getItem(final int position){return items.get(position);}

	@Override
	public long getItemId(final int position){ // don't know what this is for
		return txt_img;
	}

	@Override
	public void bindViewHolder(final AbsListAdapterHolders.Txt_imgViewHolder vh, final int position){
		String text = items.get(position).text;
		vh.text.setText(text);
		int imageResourceId = items.get(position).imageResourceId;
		vh.image.setImageResource(imageResourceId);

		// or use glide to set the image to the imageUrl
	}
}
