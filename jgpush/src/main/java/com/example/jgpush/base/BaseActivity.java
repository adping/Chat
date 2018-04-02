package com.example.jgpush.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.jgpush.MainActivity;
import com.example.jgpush.R;
import com.example.jgpush.view.ConversationDetailActivity;

import org.greenrobot.eventbus.EventBus;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.event.NotificationClickEvent;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        JMessageClient.registerEventReceiver(BaseActivity.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        JMessageClient.unRegisterEventReceiver(BaseActivity.this);
    }

    public void onEvent(NotificationClickEvent event) {
        Intent notificationIntent = new Intent(this, ConversationDetailActivity.class);
        notificationIntent.putExtra("name", event.getMessage().getFromName());
        Log.e("onEvent","----"+event.getMessage().getFromName());
        this.startActivity(notificationIntent);// 跳转到指定页面
    }
}
