package com.yz.homework02;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * ClassName:HttpClientUtils
 * Package:com.yz.homework02
 * Description:此处编写类的描述内容
 *
 * @Date:2022-03-13 18:34
 * @Author:jiayz,JYZ
 */
public class HttpClientDemo {

    public static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static void main(String[] args) throws Exception {
        //String url = "http://hc.apache.org/httpcomponents-client-4.5.x/quickstart.html";
        String url = "http://localhost:8801";
        String text = HttpClientDemo.getAsString(url);
        System.out.println("url: " + url + " ; response: \n" + text);
    }

    // GET 调用
    public static String getAsString(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            return EntityUtils.toString(entity1, "UTF-8");
        } finally {
            response1.close();
        }
    }
}
