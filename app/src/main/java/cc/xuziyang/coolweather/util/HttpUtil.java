package cc.xuziyang.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

//使用OkHttp创建一个访问服务区数据的工具类
public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
