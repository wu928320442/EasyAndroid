package com.wjj.easy.easyandroidHelper.model.base;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhaotun on 2016/12/26.
 */

public class BaseChartInfo<T extends Parcelable> implements Parcelable {

    private boolean success;
    private int totalCount;
    private int recordsTotal;
    private int recordsFiltered;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
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

        dest.writeString(this.data.getClass().getName());
        dest.writeParcelable(this.data, flags);
    }

    public BaseChartInfo() {
    }

    protected BaseChartInfo(Parcel in) {
        this.success = in.readByte() != 0;
        this.totalCount = in.readInt();
        this.recordsTotal = in.readInt();
        this.recordsFiltered = in.readInt();

        try {
            String className = in.readString();
            this.data = in.readParcelable(Class.forName(className).getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final Creator<BaseChartInfo> CREATOR = new Creator<BaseChartInfo>() {
        @Override
        public BaseChartInfo createFromParcel(Parcel source) {
            return new BaseChartInfo(source);
        }

        @Override
        public BaseChartInfo[] newArray(int size) {
            return new BaseChartInfo[size];
        }
    };

}
