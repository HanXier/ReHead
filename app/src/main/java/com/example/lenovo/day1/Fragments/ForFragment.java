package com.example.lenovo.day1.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.day1.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForFragment extends Fragment {


    private View view;
    private RecyclerView mRv;
    private SmartRefreshLayout mRefreshLayout;

    public ForFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_for, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRv = (RecyclerView) view.findViewById(R.id.rv);
        mRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);

        mRefreshLayout.setEnableRefresh(true);//启用刷新
        mRefreshLayout.setEnableLoadmore(true);//启用加载
                 //刷新
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
                     @Override
                     public void onRefresh(RefreshLayout refreshlayout) {


                         refreshlayout.finishRefresh();
                     }
                 });
                 //加载更多
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                     @Override
                     public void onLoadmore(RefreshLayout refreshlayout) {

                         refreshlayout.finishLoadmore();
                     }
                 });

    }
}
