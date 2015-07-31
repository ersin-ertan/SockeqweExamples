package com.nullcognition.annotatedadapter;// Created by ersin on 31/07/15

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hannesdorfmann.annotatedadapter.annotation.Field;
import com.hannesdorfmann.annotatedadapter.annotation.ViewField;
import com.hannesdorfmann.annotatedadapter.annotation.ViewType;
import com.hannesdorfmann.annotatedadapter.support.recyclerview.SupportAnnotatedAdapter;

import java.util.List;

public class RecyclerListAdapter extends SupportAnnotatedAdapter
		implements RecyclerListAdapterBinder{
	@ViewType(
			layout = R.layout.txt,
			views = {
					@ViewField(
							id = R.id.textView,
							name = "text",
							type = TextView.class)
			}
	)
	public final int txt = 0;

	@ViewType(
			layout = R.layout.txt_img,
			views = {
					@ViewField(id = R.id.textView, name = "text", type = TextView.class),
					@ViewField(id = R.id.imageView, name = "image", type = ImageView.class)
			},
			fields = { // other fields (not Views)
					@Field(name = "listener", type = MyClickListener.class)
			}
	)
	public final int txt_img = 1;

	public static class MyClickListener implements View.OnClickListener{
		public String dataItem;
		@Override
		public void onClick(final View v){
			Toast.makeText(v.getContext(), dataItem, Toast.LENGTH_SHORT).show();
		}
	}

	List<TextImage> items;

	public RecyclerListAdapter(Context context, List<TextImage> items){
		super(context);
		this.items = items;
	}

	@Override
	public int getItemCount(){
		return items == null ? 0 : items.size();
	}

	@Override
	public int getItemViewType(int position){
		if(position % 2 == 0){ return txt; }
		else{ return txt_img; }
	}

	@Override
	public void bindViewHolder(RecyclerListAdapterHolders.TxtViewHolder vh, int position){

		String str = items.get(position).text;
		vh.text.setText(str);
	}

	@Override
	public void bindViewHolder(RecyclerListAdapterHolders.Txt_imgViewHolder vh, int position){

		String str = items.get(position).text;
		vh.text.setText(str);
		vh.image.setImageResource(R.drawable.abc_btn_rating_star_on_mtrl_alpha);

		vh.listener = new MyClickListener();
		vh.listener.dataItem = String.valueOf(position);
		vh.itemView.setOnClickListener(vh.listener);
	}

}
