package com.example.lenovo.day1.Util;

import android.app.Application;



    public class MyAPP extends Application {
        private static MyAPP myApp;

        public static MyAPP getMyApp() {
            return myApp;
        }

        @Override
        public void onCreate() {
            super.onCreate();

            myApp = this;
        }
    }

