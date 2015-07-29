package com.aliao.newfeatures.adapter.douban;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aliao.newfeatures.R;

/**
 * Created by ALiao on 2015/7/29.
 */
public class DoubanRecyclerAdapter extends RecyclerView.Adapter<DoubanRecyclerAdapter.ViewHolder> {

    private String[] mDataSet;

    public DoubanRecyclerAdapter(String[] dataSet) {
        this.mDataSet = dataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_title);
        }

        public TextView getTextView() {
            return mTextView;
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_cardview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextView().setText(mDataSet[position]);

    }


    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
