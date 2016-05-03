package com.example.chenzhe.eyerhyme.util;

import com.example.chenzhe.eyerhyme.customInterface.viewController;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;

import okhttp3.Call;
import okhttp3.MediaType;

/**
 * Created by chenzhe on 2016/4/24.
 */
public class PostUtil {
    private Gson gson;
    private static String url = "http://222.200.180.59:8080/boot-1.0.0";
    private static PostUtil util = new PostUtil();
    private PostUtil() {
        gson = new Gson();
    }
    public static PostUtil newInstance() {
        return util;
    }

    public void sendPost(final viewController controller, final String path, HashMap<String, Object> map) {
        String temp = url+path;
        OkHttpUtils.postString().url(temp).mediaType(MediaType.parse("application/json"))
                .content(gson.toJson(map))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        controller.updateView(path, null);
                        return;
                    }

                    @Override
                    public void onResponse(String response) {
                        controller.updateView(path, response);
                    }
                });
    }
}
