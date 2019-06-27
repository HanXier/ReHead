package com.example.lenovo.day1;


import com.example.lenovo.day1.Been.InforBeen;
import com.example.lenovo.day1.Been.ShowBeen;
import com.example.lenovo.day1.Been.TooBeen;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author: 汐er
 * @QQ: 2044273990
 * @date: 2019/6/26
 * @Week: 星期三
 * @GitHub: https://github.com/HanXier
 */
public interface MyService {
    String MOVIE="http://api.shujuzhihui.cn/api/movie/";
    @GET("list")
    Observable<ShowBeen> getmovie(@QueryMap Map<String,String> map);

    String url ="http://api.tianapi.com/wxnew/";
    @POST("?")
    Observable<InforBeen> getData(@Query("key") String Key, @Query("page") String page);



    String download_url = "http://yun918.cn/study/public/";
    //下载
    @GET("res/UnknowApp-1.0.apk")
    Call<ResponseBody> downloadFile();
    //上传
    @Multipart
    @POST("file_upload.php")
    Observable<TooBeen> uploadFile(@Part("key") RequestBody requestBody, @Part MultipartBody.Part multiPart);


}
