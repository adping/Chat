package com.example.jgpush.base;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.example.jgpush.view.ConversationDetailActivity;

import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.event.NotificationClickEvent;

/**
 * Created by issuser on 2018/3/19.
 */

public class App extends Application {

    public static final String TAG = "TEST_JPUSH";

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);  // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this); //初始化

        JMessageClient.setDebugMode(true);
        JMessageClient.init(this);//初始化SDK
    }
}
