package com.aliao.newfeatures.adapter.SimpleRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;

/**
 * Created by ALiao on 2015/8/11.
 */
public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter<RVHolder>{

    public List<?> list;
    private Context context;

    public BaseRecyclerAdapter(List<?> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(onCreateViewLayoutID(viewType), null);
        return new RVHolder(view);
    }
    public abstract int onCreateViewLayoutID(int viewType);

    @Override
    public void onBindViewHolder(final RVHolder holder, int position) {
        onBindViewHolder(holder.getViewHolder(), position);
        if (onItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(null, v, holder.getLayoutPosition(), holder.getItemId());
                }
            });
        }
    }

    public abstract void onBindViewHolder(ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return list.size();
    }

    private AdapterView.OnItemClickListener onItemClickListener;

    public AdapterView.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
