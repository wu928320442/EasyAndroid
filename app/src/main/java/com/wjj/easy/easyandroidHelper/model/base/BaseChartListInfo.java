package com.wjj.easy.easyandroidHelper.model.base;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by zhaotun on 2016/12/26.
 */

public class BaseChartListInfo<T extends Parcelable> implements Parcelable {

    public static final String PARCELABLE_ARRAY_LIST_DATA_KEY = "parcelable_array_list_data_key";

    private boolean success;
    private int totalCount;
    private int recordsTotal;
    private int recordsFiltered;
    private ArrayList<T> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseChartInfo{" +
                "success=" + success +
                ", totalCount=" + totalCount +
                ", recordsTotal=" + recordsTotal +
                ", recordsFiltered=" + recordsFiltered +
                ", data=" + data +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.success ? (byte) 1 : (byte) 0);
        dest.writeInt(this.totalCount);
        dest.writeInt(this.recordsTotal);
        dest.writeInt(this.recordsFiltered);

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(PARCELABLE_ARRAY_LIST_DATA_KEY, data);
        dest.writeBundle(bundle);
    }

    public BaseChartListInfo() {
    }

    protected BaseChartListInfo(Parcel in) {
        this.success = in.readByte() != 0;
        this.totalCount = in.readInt();
        this.recordsTotal = in.readInt();
        this.recordsFiltered = in.readInt();

        try {
            this.data = in.readBundle().getParcelableArrayList(PARCELABLE_ARRAY_LIST_DATA_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final Creator<BaseChartListInfo> CREATOR = new Creator<BaseChartListInfo>() {
        @Override
        public BaseChartListInfo createFromParcel(Parcel source) {
            return new BaseChartListInfo(source);
        }

        @Override
        public BaseChartListInfo[] newArray(int size) {
            return new BaseChartListInfo[size];
        }
    };

}
