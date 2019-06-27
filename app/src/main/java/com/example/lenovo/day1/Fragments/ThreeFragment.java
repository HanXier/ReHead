package com.example.lenovo.day1.Fragments;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.lenovo.day1.Activitys.NotificationService;
import com.example.lenovo.day1.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends Fragment implements View.OnClickListener {


    private View view;
    /**
     * 上传
     */
    private Button mUp;
    /**
     * 下载
     */
    private Button mLoad;
    private SeekBar mBar;
    /**
     * 广播
     */
    private Button mSound;
    private Timer timer;
    private String channelId;
    private NotificationManager notificationManager;
    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_three, container, false);
        initView(inflate);
        //1:获取系统提供的通知管理服务
        notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        //2：如果是8以上的系统，则新建一个消息通道
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setChannerl();
        }
        return inflate;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setChannerl() {

        channelId = "chat";//消息通道的id，以后可以通过该id找到该消息通道
        String channelName = "聊天消息";//消息通道的name
        int importance = NotificationManager.IMPORTANCE_MAX;//通知的优先级
        // .具体的请自行百度。作用就是优先级的不同。可以导致消息出现的形式不一样。
        // MAX是会震动并且出现在屏幕的上方。设置优先级为low或者min时。来通知时都不会震动，
        // 且不会直接出现在屏幕上方
        createNotificationChannel(channelId, channelName, importance);


    }
    private void createNotification(String content) {


        Intent intent = new Intent(getActivity(), NotificationService.class);
        /*
         * 调用PendingIntent的静态放法创建一个 PendingIntent对象用于点击通知之后执行的操作，
         * PendingIntent可以理解为延时的Intent，在这里即为点击通知之后执行的Intent
         * 这里调用getActivity(Context context, int requestCode, Intent intent, int flag)方法
         * 表示这个PendingIntent对象启动的是Activity，类似的还有getService方法、getBroadcast方法
         */
        PendingIntent pi = PendingIntent.getActivity(getActivity(), 0, intent, 0);


        NotificationCompat.Builder builder;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //如果是8以上的系统。需要传一个channelId.
            builder = new NotificationCompat.Builder(getActivity(), "chat");
        } else {
            builder = new NotificationCompat.Builder(getActivity());
        }

        builder.setContentTitle("泰山") // 创建通知的标题
                .setContentText(content) // 创建通知的内容
                .setSmallIcon(R.drawable.ic_launcher_background) // 创建通知的小图标
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)) // 创建通知的大图标
                /*
                 * 首先，无论你是使用自定义视图还是系统提供的视图，上面4的属性一定要设置，不然这个通知显示不出来
                 */.setWhen(System.currentTimeMillis()) // 设定通知显示的时间
                .setContentIntent(pi) // 设定点击通知之后启动的内容，这个内容由方法中的参数：PendingIntent对象决定
                //.setPriority(NotificationCompat.PRIORITY_MAX) // 设置通知的优先级
                .setAutoCancel(true); // 设置点击通知之后通知是否消失
        //.setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg"))) // 设置声音
        /*
         * 设置震动，用一个 long 的数组来表示震动状态，这里表示的是先震动1秒、静止1秒、再震动1秒，这里以毫秒为单位
         * 如果要设置先震动1秒，然后停止0.5秒，再震动2秒则可设置数组为：long[]{1000, 500, 2000}。
         * 别忘了在AndroidManifest配置文件中申请震动的权限
         */
        builder.setVibrate(new long[]{1000, 500, 2000});
        /*
         * 设置手机的LED灯为蓝色并且灯亮2秒，熄灭1秒，达到灯闪烁的效果，不过这些效果在模拟器上是看不到的，
         * 需要将程序安装在真机上才能看到对应效果，如果不想设置这些通知提示效果，
         * 可以直接设置：setDefaults(Notification.DEFAULT_ALL);
         * 意味将通知的提示效果设置为系统的默认提示效果
         */
        //.setLights(Color.BLUE, 2000, 1000)
        Notification notification = builder.build(); // 创建通知（每个通知必须要调用这个方法来创建）
        /*
         * 使用从系统服务获得的通知管理器发送通知，第一个参数是通知的id，不同的通知应该有不同的id，
         * 这样当我们要取消哪条通知的时候我们调用notificationManager（通知管理器）.cancel(int id)
         * 方法并传入发送通知时的对应id就可以了。在这里如果我们要取消这条通知，
         * 我们调用notificationManager.cancel(1);就可以了
         * 第二个参数是要发送的通知对象
         */
        notificationManager.notify(1, notification);


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName, int importance) {
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        notificationManager.createNotificationChannel(channel);

    }

    private void initView(View inflate) {
        mUp = (Button) inflate.findViewById(R.id.up);
        mUp.setOnClickListener(this);
        mLoad = (Button) inflate.findViewById(R.id.load);
        mLoad.setOnClickListener(this);
        mBar = (SeekBar) inflate.findViewById(R.id.bar);
        mSound = (Button) inflate.findViewById(R.id.sound);


        mSound.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.up:
                timer = new Timer();
                timer.schedule(new TimerTask() {
                  @Override
                     public void run() {
                      Toast.makeText(getActivity(),"上传成功",Toast.LENGTH_SHORT).show();
                                        }
                 },3000);//延时3s执行

                break;
            case R.id.load:
                load();

                break;
            case R.id.sound:
                //3:创建通知
                createNotification("起来敲代码了.......");
                break;
        }
    }

    private void load() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(300);
                        mBar.setProgress(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        mBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getContext(), "正在下载", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "开始下载", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "下载完成", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
