package com.wjj.easy.easyandroidHelper.model.base;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhaotun .
 */

public class BaseResponseInfo<T extends Parcelable> extends BaseStatus {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return super.toString() + " BaseResponseInfo{" +
                "data=" + data +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(this.data.getClass().getName());
        dest.writeParcelable(this.data, flags);
    }

    public BaseResponseInfo() {
    }

    protected BaseResponseInfo(Parcel in) {
        super(in);

        try {
            String className = in.readString();
            this.data = in.readParcelable(Class.forName(className).getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final Parcelable.Creator<BaseResponseInfo> CREATOR = new Parcelable.Creator<BaseResponseInfo>() {
        @Override
        public BaseResponseInfo createFromParcel(Parcel source) {
            return new BaseResponseInfo(source);
        }

        @Override
        public BaseResponseInfo[] newArray(int size) {
            return new BaseResponseInfo[size];
        }
    };
}
