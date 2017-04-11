package com.wjj.easy.easyandroidHelper.model.base;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhaotun
 */

public class BaseStatus implements Parcelable {

    public static final int RESPONSE_CODE_SUCCESS = 0;

    private int code;// 0成功
    private String message;

    public static final Creator<BaseStatus> CREATOR = new Creator<BaseStatus>() {
        @Override
        public BaseStatus createFromParcel(Parcel in) {
            return new BaseStatus(in);
        }

        @Override
        public BaseStatus[] newArray(int size) {
            return new BaseStatus[size];
        }
    };

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return code == RESPONSE_CODE_SUCCESS;
    }

    @Override
    public String toString() {
        return "BaseStatus{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeString(this.message);
    }

    public BaseStatus() {
    }

    protected BaseStatus(Parcel in) {
        this.code = in.readInt();
        this.message = in.readString();
    }

}
