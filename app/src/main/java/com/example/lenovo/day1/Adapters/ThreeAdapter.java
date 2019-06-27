package com.example.lenovo.day1.Adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.day1.Been.BeenDao;
import com.example.lenovo.day1.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class ThreeAdapter extends XRecyclerView.Adapter{

    List<BeenDao> list;
    Context context;

    public ThreeAdapter(List <BeenDao> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(List <BeenDao> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_news, viewGroup, false);


        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;

        viewHolder1.mTvTitle.setText(list.get(i).getTitle());

        Glide.with(context).load(list.get(i).getNewsImg()).into(viewHolder1.mIv);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemLongClick!=null){
                    onItemLongClick.onItemClick(i,list.get(i));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTvTitle;

        ImageView mIv;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvTitle= itemView.findViewById(R.id.tv_title);
            mIv= itemView.findViewById(R.id.iv);
        }
    }

    private OnItemLongClick onItemLongClick;

    public void setOnItemLongClick(OnItemLongClick onItemLongClick) {
        this.onItemLongClick = onItemLongClick;
    }

    public interface OnItemLongClick{
        void onItemClick(int positon, BeenDao listBean);
    }
}
