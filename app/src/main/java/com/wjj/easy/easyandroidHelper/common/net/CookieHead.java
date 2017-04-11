package com.wjj.easy.easyandroidHelper.common.net;

/**
 * Created by wujiajun on 17/4/11.
 */

public enum CookieHead {

    CLIENT_TYPE("client_type", "android"),
    USER_NAME("user_name", "");


    private String head;
    private String value;

    CookieHead(String head, String value) {
        this.head = head;
        this.value = value;
    }

    public String getHead() {
        return head;
    }

    public String getValue() {
        return value;
    }
}
