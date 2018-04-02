package com.example.jgpush.event;

import com.example.jgpush.base.BaseMessage;

import cn.jpush.im.android.api.model.GroupInfo;

/**
 * Created by issuser on 2018/3/26.
 */

public class MyEvent {
    public long userId;
    public int code;
    public boolean refresh;
    public GroupInfo groupInfo;

    public MyEvent(long userId) {
        this.userId = userId;
    }

    public MyEvent(int code) {
        this.code = code;
    }

    public MyEvent(boolean refresh) {
        this.refresh = refresh;
    }

    public MyEvent(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }
}
