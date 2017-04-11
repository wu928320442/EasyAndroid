package com.wjj.easy.easyandroidHelper.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhaotun on 2016/12/20.
 */

public class LoginInfo implements Parcelable {

    /**
     * mobile : 15670388343
     * sessionId : 8996AD494B77221C98EE7C6D359224A1.o214zsug
     */

    private String mobile;
    private String sessionId;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "mobile='" + mobile + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mobile);
        dest.writeString(this.sessionId);
    }

    protected LoginInfo(Parcel in) {
        this.mobile = in.readString();
        this.sessionId = in.readString();
    }

    public static final Creator<LoginInfo> CREATOR = new Creator<LoginInfo>() {
        @Override
        public LoginInfo createFromParcel(Parcel source) {
            return new LoginInfo(source);
        }

        @Override
        public LoginInfo[] newArray(int size) {
            return new LoginInfo[size];
        }
    };
}
