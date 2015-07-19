package com.nullcognition.sockeqweexamples;// Created by ersin on 17/07/15

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hannesdorfmann.annotatedadapter.annotation.Field;
import com.hannesdorfmann.annotatedadapter.annotation.ViewField;
import com.hannesdorfmann.annotatedadapter.annotation.ViewType;
import com.hannesdorfmann.annotatedadapter.support.recyclerview.SupportAnnotatedAdapter;

import java.util.List;

public class RecyclerAdapter extends SupportAnnotatedAdapter
		implements RecyclerAdapterBinder{

	static class MyClickListener implements View.OnClickListener{

		public int position; // this isn't working

		public void onClick(View v){
			v.setVisibility(v.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
			Toast.makeText(v.getContext(), "" + position, Toast.LENGTH_SHORT).show();
		}
	}

	@ViewType(
			layout = R.layout.row_txt,
			views = {  // ids can be the same, but be carefull with the use and find of both
					@ViewField(id = R.id.row_txt, name = "text", type = TextView.class)
			}
	)
	public final int rowTxt = 0;

	@ViewType(
			layout = R.layout.row_txt_img,
			views = {
					@ViewField(id = R.id.row_txt, name = "text", type = TextView.class),
					@ViewField(id = R.id.row_image, name = "image", type = ImageView.class)
			},
			fields = {
					@Field(type = MyClickListener.class, name = "clickListener")
			}
	)
	public final int rowTxtImg = 1;


	List<String> items;
	Context context;


	public RecyclerAdapter(final Context context, List<String> items){
		super(context);
		this.items = items;
		// option to store context or not since super does not
		this.context = context;
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
		vh.image.setImageResource(R.drawable.abc_btn_rating_star_on_mtrl_alpha);
		vh.clickListener = new MyClickListener();
		vh.clickListener.position = position;

	}


	// look into these methods
	{
//	RecyclerView.AdapterDataObserver da;

//		da.onChanged();;
//		da.onItemRangeChanged(0, 3);
//		da.onItemRangeInserted(0, 6);
//		da.onItemRangeMoved(1,1);
//		da.onItemRangeRemoved(1,1);
	}

	@Override
	public void unregisterAdapterDataObserver(final RecyclerView.AdapterDataObserver observer){
		super.unregisterAdapterDataObserver(observer);
	}
	@Override
	public void registerAdapterDataObserver(final RecyclerView.AdapterDataObserver observer){
		super.registerAdapterDataObserver(observer);
	}
}
