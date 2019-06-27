package com.example.lenovo.day1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.lenovo.day1.Activitys.HomeActivity;
import com.example.lenovo.day1.Adapters.Wpageradapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int currentItem;
    private ViewPager mVpg1;
    ArrayList<ImageView> imageIDList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化引导数据
        initGuideData();

        initView();


    }

    private void initGuideData() {
        LayoutInflater from = LayoutInflater.from(this);


        imageIDList = new ArrayList();
        imageIDList.add((ImageView) from.inflate(R.layout.imageview1,null));
        imageIDList.add((ImageView) from.inflate(R.layout.imageview1,null));
        imageIDList.add((ImageView) from.inflate(R.layout.imageview1,null));
    }


    @SuppressLint("ClickableViewAccessibility")
    private void initView() {
        mVpg1 = (ViewPager) findViewById(R.id.vpg1);
        Wpageradapter wpageradapter = new Wpageradapter(imageIDList);
        mVpg1.setAdapter(wpageradapter);

        mVpg1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentItem = i;
                Log.i("Guide","监听改变"+i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mVpg1.setOnTouchListener(new View.OnTouchListener() {
            float startX;
            float startY;
            float endX;
            float endY;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        startX=event.getX();
                        startY=event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        endX=event.getX();
                        endY=event.getY();
                        WindowManager windowManager= (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
                        //获取屏幕的宽度
                        Point size = new Point();
                        windowManager.getDefaultDisplay().getSize(size);
                        int width=size.x;
                        //首先要确定的是，是否到了最后一页，然后判断是否向左滑动，并且滑动距离是否符合，我这里的判断距离是屏幕宽度的4分之一（这里可以适当控制）
                        if(currentItem==(imageIDList.size()-1)&&startX-endX>0&&startX-endX>=(width/4)){

                            goToMainActivity();

                        }
                        break;
                }
                return false;
            }
        });
    }

    private void goToMainActivity() {
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
        finish();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,2,3,"瀑布流");
        menu.add(1,2,4,"网格");
        menu.add(1,2,5,"列表");

        return true;
    }
}
