package com.wjj.easy.easyandroidHelper.model.base;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by zhaotun .
 */

public class BaseResponseListInfo<T extends Parcelable> extends BaseStatus {

    public static final String PARCELABLE_ARRAY_LIST_DATA_KEY = "parcelable_array_list_data_key";

    private ArrayList<T> data;

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return super.toString() + " BaseResponseListInfo{" +
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

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(PARCELABLE_ARRAY_LIST_DATA_KEY, data);
        dest.writeBundle(bundle);
    }

    public BaseResponseListInfo() {
    }

    protected BaseResponseListInfo(Parcel in) {
        super(in);

        try {
            this.data = in.readBundle().getParcelableArrayList(PARCELABLE_ARRAY_LIST_DATA_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final Creator<BaseResponseListInfo> CREATOR = new Creator<BaseResponseListInfo>() {
        @Override
        public BaseResponseListInfo createFromParcel(Parcel source) {
            return new BaseResponseListInfo(source);
        }

        @Override
        public BaseResponseListInfo[] newArray(int size) {
            return new BaseResponseListInfo[size];
        }
    };
}
