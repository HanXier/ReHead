package com.example.lenovo.day1.Util;


import com.example.lenovo.day1.Been.BeenDao;
import com.example.lenovo.day1.dao.BeenDaoDao;
import com.example.lenovo.day1.dao.DaoMaster;
import com.example.lenovo.day1.dao.DaoSession;

import java.util.List;

/**
 * 创建者：  汐Y
 * 创建日期：2019/3/25
 * 创建时间：20:50
 * QQ：     2044273990
 * 跟随你心,无问西东。一生所爱,余生所忠~
 */
public class MyDBHelper {



        private static MyDBHelper myDBHelper;
        private final BeenDaoDao dBbeanDao;

        private MyDBHelper(){
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyAPP.getMyApp(),
                    "infph.db");

            DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());

            DaoSession daoSession = daoMaster.newSession();

            dBbeanDao = daoSession.getBeenDaoDao();
        }

        public static MyDBHelper getMyDBHelper() {
            if (myDBHelper == null){
                synchronized (MyDBHelper.class){
                    if (myDBHelper == null){
                        myDBHelper = new MyDBHelper();
                    }
                }
            }
            return myDBHelper;
        }

        public void insert(BeenDao dBbean){
            if (has(dBbean)){
                return;
            }
            dBbeanDao.insert(dBbean);
        }

        public void delete(BeenDao dBbean){
            if (has(dBbean)){
                dBbeanDao.delete(dBbean);
            }
        }

        public List<BeenDao> query(){
            return  dBbeanDao.queryBuilder().list();
        }

        public boolean has(BeenDao dBbean){
            List<BeenDao> list = dBbeanDao.queryBuilder().where(BeenDaoDao.Properties.Title.eq(dBbean
                            .getTitle()),
                    BeenDaoDao.Properties.NewsImg.eq(dBbean.getNewsImg())).list();

            if (list!=null&&list.size()>0){
                return  true;
            }

            return false;
        }


}
