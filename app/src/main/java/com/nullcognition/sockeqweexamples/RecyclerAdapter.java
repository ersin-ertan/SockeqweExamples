package com.nullcognition.sockeqweexamples;// Created by ersin on 17/07/15

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hannesdorfmann.annotatedadapter.annotation.Field;
import com.hannesdorfmann.annotatedadapter.annotation.ViewField;
import com.hannesdorfmann.annotatedadapter.annotation.ViewType;
import com.hannesdorfmann.annotatedadapter.support.recyclerview.SupportAnnotatedAdapter;

import java.util.List;

public class RecyclerAdapter extends SupportAnnotatedAdapter
		implements RecyclerAdapterBinder{

	static class MyClickListener implements View.OnClickListener{

		public String dataItem;

		public void onClick(View v){
			v.setVisibility(v.getVisibility() == View.INVISIBLE ? View.VISIBLE : View.INVISIBLE);
		}
	}

	@ViewType(
			layout = R.layout.row_txt,
			views = {
					@ViewField(id = R.id.text, name = "text", type = TextView.class)
			}
	)
	public final int rowTxt = 0;

	@ViewType(
			layout = R.layout.row_txt_img,
			views = {
					@ViewField(id = R.id.text, name = "text", type = TextView.class),
					@ViewField(id = R.id.image, name = "image", type = ImageView.class)
			},
			fields = {
					@Field(type = MyClickListener.class, name = "clickListener")
			}
	)
	public final int rowTxtImg = 1;


	List<String> items;
	public RecyclerAdapter(final Context context, List<String> items){
		super(context);
		this.items = items;
	}

	@Override
	public int getItemViewType(int position){
		if(position % 2 == 0){ return rowTxt; }
		else{ return rowTxtImg; }
	}


	@Override
	public int getItemCount(){ return items != null ? items.size() : 0;}


	@Override
	public void bindViewHolder(final RecyclerAdapterHolders.RowTxtViewHolder vh, final int position){
		String str = items.get(position);
		vh.text.setText(str);
	}


	@Override
	public void bindViewHolder(final RecyclerAdapterHolders.RowTxtImgViewHolder vh, final int position){
		String str = items.get(position);
		vh.text.setText(str);
		vh.image.setImageResource(android.R.drawable.star_big_off);
		vh.clickListener = new MyClickListener();
	}
}
