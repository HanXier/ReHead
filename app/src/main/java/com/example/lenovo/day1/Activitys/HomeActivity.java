package com.example.lenovo.day1.Activitys;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.example.lenovo.day1.Adapters.FragmentAdapter;
import com.example.lenovo.day1.Fragments.ForFragment;
import com.example.lenovo.day1.Fragments.OneFragment;
import com.example.lenovo.day1.Fragments.ThreeFragment;
import com.example.lenovo.day1.Fragments.TwoFragment;
import com.example.lenovo.day1.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private LinearLayout mLlMain;
    private NavigationView mNv;
    private DrawerLayout mDl;
    private TabLayout mTab;
    private ViewPager mVpg;
    private List<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mLlMain = (LinearLayout) findViewById(R.id.ll_main);
        mNv = (NavigationView) findViewById(R.id.nv);
        mDl = (DrawerLayout) findViewById(R.id.dl);


        //设置ToolBar信息
        mToolBar.setTitle(R.string.about);
        setSupportActionBar(mToolBar);

        //侧滑设置图片显示
        mNv.setItemIconTintList(null);

        //设置侧滑开关控制器
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDl, mToolBar, R.string.about, R.string.about);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        mDl.addDrawerListener(toggle);
        toggle.syncState();
        mTab = (TabLayout) findViewById(R.id.tab);
        mVpg = (ViewPager) findViewById(R.id.vpg);



        String[] s = {"壹", "貳","叁","肆"};
        list = new ArrayList<>();
        list.add(new OneFragment());
        list.add(new TwoFragment());
        list.add(new ThreeFragment());
        list.add(new ForFragment());


        FragmentAdapter adapters = new FragmentAdapter(getSupportFragmentManager(), list, s);
        mVpg.setAdapter(adapters);
        mTab.setupWithViewPager(mVpg);

    }
}
