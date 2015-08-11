package com.aliao.newfeatures.adapter.SimpleRecycler;

import android.content.Context;
import android.content.Entity;

import com.aliao.newfeatures.R;

import java.util.List;

/**
 * Created by 丽双 on 2015/8/11.
 */
public class DemoRecyclerAdapter extends BaseRecyclerAdapter {

    public DemoRecyclerAdapter(List<?> list, Context context) {
        super(list, context);
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.text_row_item;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Entity item = (Entity) list.get(position);
//        holder.getTextView(R.id.item_textview).setText(item.get);
//        holder.setTextView();
    }
}
