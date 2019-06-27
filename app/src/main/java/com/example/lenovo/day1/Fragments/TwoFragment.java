package com.example.lenovo.day1.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.day1.Adapters.ThreeAdapter;
import com.example.lenovo.day1.Been.BeenDao;
import com.example.lenovo.day1.R;
import com.example.lenovo.day1.Util.MyDBHelper;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class TwoFragment extends Fragment {

    private ArrayList<BeenDao> list = new ArrayList<>();
    private View view;
    private RecyclerView mRv;
    private SmartRefreshLayout mRefreshLayout;
    private ThreeAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_two, container, false);

        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv2);
        mRefreshLayout = (SmartRefreshLayout) inflate.findViewById(R.id.refreshLayout2);

        adapter = new ThreeAdapter(list, getActivity());
        mRv.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRv.setLayoutManager(layoutManager);

        adapter.setOnItemLongClick(new ThreeAdapter.OnItemLongClick() {
            @Override
            public void onItemClick(int positon, BeenDao listBean) {
                MyDBHelper.getMyDBHelper().delete(listBean);
                list.remove(positon);
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser){
            initData();
        }else {

            list.clear();
        }
    }

    private void initData() {

        List<BeenDao> query = MyDBHelper.getMyDBHelper().query();
        list.addAll(query);
        adapter.notifyDataSetChanged();
    }
}
