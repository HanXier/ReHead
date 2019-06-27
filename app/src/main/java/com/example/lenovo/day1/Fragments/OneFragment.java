package com.example.lenovo.day1.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.day1.Adapters.ShowAdapter;
import com.example.lenovo.day1.Been.BeenDao;
import com.example.lenovo.day1.Been.InforBeen;
import com.example.lenovo.day1.Been.ShowBeen;
import com.example.lenovo.day1.MyService;
import com.example.lenovo.day1.R;
import com.example.lenovo.day1.Util.MyDBHelper;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {

    private ArrayList<InforBeen.NewslistBean> newsList;
    private ArrayList<InforBeen.NewslistBean> bannerList;

    private View view;
    private RecyclerView mRv;
    private SmartRefreshLayout mRefreshLayout;
    private ShowAdapter showAdapter;
    private Banner bs;
    private List list1;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_one, container, false);

        initView(inflate);
        initretrofit();
        return inflate;
    }

    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);
        mRefreshLayout = (SmartRefreshLayout) inflate.findViewById(R.id.refreshLayout);


        newsList = new ArrayList<>();
        bannerList = new ArrayList<>();
        showAdapter = new ShowAdapter(getActivity(),newsList,bannerList);
        mRv.setAdapter(showAdapter);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRefreshLayout.setEnableRefresh(true);//启用刷新
        mRefreshLayout.setEnableLoadmore(true);//启用加载
                 //刷新
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
                     @Override
                     public void onRefresh(RefreshLayout refreshlayout) {

                         showAdapter.notifyDataSetChanged();
                         refreshlayout.finishRefresh();
                     }
                 });
                 //加载更多
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                     @Override
                     public void onLoadmore(RefreshLayout refreshlayout) {

                         showAdapter.notifyDataSetChanged();
                         refreshlayout.finishLoadmore();
                     }
                 });

        showAdapter.setOnItemClickListener(new ShowAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int positon, InforBeen.NewslistBean listBean) {
                BeenDao dBbean = new BeenDao();
                dBbean.setId(null);
                dBbean.setNewsImg(listBean.getPicUrl());
                dBbean.setSource(listBean.getDescription());
                dBbean.setTitle(listBean.getTitle());
                MyDBHelper.getMyDBHelper().insert(dBbean);
            }
        });


    }

    private void initretrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MyService myService = retrofit.create(MyService.class);
        // Map<String,Object> map=new HashMap<>();
        // map.put("appKey","72ed8f3327d246da8d85fc07ef423fe1");
        Observable<InforBeen> data = myService.getData("52b7ec3471ac3bec6846577e79f20e4c", "11");

        data.subscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InforBeen>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InforBeen tab) {
                       showAdapter.setData(tab);
                        mRefreshLayout.finishRefresh();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }



}
