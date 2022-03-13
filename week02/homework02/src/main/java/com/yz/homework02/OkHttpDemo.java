package com.yz.homework02;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * ClassName:OkHttpUtils
 * Package:com.yz.homework02
 * Description:此处编写类的描述内容
 *
 * @Date:2022-03-13 18:40
 * @Author:jiayz,JYZ
 */
public class OkHttpDemo {

    // 缓存客户端实例
    public static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws Exception {

        //String url = "https://square.github.io/okhttp/";
        String url = "http://localhost:8801";
        String text = OkHttpDemo.getAsString(url);
        System.out.println("url: " + url + " ; response: \n" + text);

        // 清理资源
        OkHttpDemo.client = null;
    }


    // GET 调用
    public static String getAsString(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}
