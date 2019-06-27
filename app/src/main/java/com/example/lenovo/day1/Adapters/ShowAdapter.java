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
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.day1.Been.InforBeen;
import com.example.lenovo.day1.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 汐er
 * @QQ: 2044273990
 * @date: 2019/6/26
 * @Week: 星期三
 * @GitHub: https://github.com/HanXier
 */
public class ShowAdapter extends RecyclerView.Adapter{

    private static int VIEW_TYPE_BANNER = 0;
    private static int VIEW_TYPE_NEWS = 1;


    private Context mContext;
    private ArrayList<InforBeen.NewslistBean> mNewsList;
    private ArrayList<InforBeen.NewslistBean> mBannerList;
    private OnItemClickListener mListener;

    public ShowAdapter(Context context,
                               ArrayList<InforBeen.NewslistBean> newsList,
                               ArrayList<InforBeen.NewslistBean> bannerList) {
        mContext = context;
        mNewsList = newsList;
        mBannerList = bannerList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_BANNER) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_banner, null);
            return new BannerViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_news, null);
            return new NewsViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == VIEW_TYPE_BANNER) {
            BannerViewHolder holder1 = (BannerViewHolder) holder;
            holder1.mBanner.setImages(mBannerList)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            InforBeen.NewslistBean bean = (InforBeen.NewslistBean) path;

                            RequestOptions options = new RequestOptions().placeholder(R.drawable.ic_launcher_background);
                            Glide.with(context).load(bean.getPicUrl()).apply(options).into(imageView);
                        }
                    })
                    .start();
        }else{
            int newPosition = position;
            if (mBannerList.size()>0){
                newPosition-=1;
            }
            NewsViewHolder holder1 = (NewsViewHolder) holder;
            InforBeen.NewslistBean storiesBean = mNewsList.get(newPosition);
            holder1.mTvTitle.setText(storiesBean.getTitle());

            RequestOptions options = new RequestOptions().placeholder(R.mipmap.ic_launcher);
            Glide.with(mContext).load(storiesBean.getPicUrl()).apply(options).into(holder1.mIv);


            final int finalNewPosition = newPosition;
            holder1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        mListener.onItemClick(finalNewPosition, mNewsList.get(finalNewPosition));



                    }
                }
            });
        }
    }

    /**
     * 多布局必须复写这个方法
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (mBannerList.size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_BANNER;
            }  else {
                return VIEW_TYPE_NEWS;
            }
        }

        return position;
    }

    @Override
    public int getItemCount() {
        if (mBannerList.size() > 0) {
            return mNewsList.size() + 1;
        } else {
            return mNewsList.size();
        }
    }

    public void setData(InforBeen bean) {

        List<InforBeen.NewslistBean> top_stories = bean.getNewslist();
        mBannerList.clear();
        mBannerList.addAll(top_stories);

        List<InforBeen.NewslistBean> stories = bean.getNewslist();
        mNewsList.clear();
        mNewsList.addAll(stories);

        notifyDataSetChanged();
    }

    class BannerViewHolder extends RecyclerView.ViewHolder{

        Banner mBanner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            mBanner=  itemView.findViewById(R.id.banner);
        }
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView mTvTitle;

        ImageView mIv;

        public NewsViewHolder(View itemView) {
            super(itemView);
            mTvTitle= itemView.findViewById(R.id.tv_title);
            mIv= itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int positon,InforBeen.NewslistBean listBean);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }
}
