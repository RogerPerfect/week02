package com.example.java02;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Request;

public class OkHttpUtils {
    // 缓存客户端实例
    public static OkHttpClient client = new OkHttpClient();

    // GET 调用
    public static String getAsString(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


    public static void main(String[] args) throws Exception {

        String url = " http://localhost:8801";
        String text = OkHttpUtils.getAsString(url);
        System.out.println("url: " + url + " ; response: \n" + text);

        // 清理资源
        OkHttpUtils.client = null;
    }
}