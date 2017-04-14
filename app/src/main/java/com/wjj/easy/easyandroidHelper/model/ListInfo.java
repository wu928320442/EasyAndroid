package com.wjj.easy.easyandroidHelper.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljw on 2017/4/13.
 */

public class ListInfo implements Parcelable {

    /**
     * success : true
     * returnCode : 0
     * message : ok
     * data : [{"taskId":2539544,"title":"李茶的姑妈","content":"李茶的姑妈","imageUrl":"https://qn-message.qbcdn.com/5aeceeb6753d48638a596b842ed7c98e","amt":"290","doTime":"2017-04-18","city":"南京","address":"江苏省南京市","payKind":"元","taskTypeName":"宝约优选","onlyVip":0,"hasMemberAmt":0,"memberAmt":"0","isFree":false},{"taskId":2539751,"title":"浪漫白色女神节相约鹦鹉螺市集","content":"浪漫白色女神节相约鹦鹉螺市集","imageUrl":"https://qn-message.qbcdn.com/2c5216f7e2cd49dfb1a92ec7d59da636","amt":"1","doTime":"2017-06-18","city":"上海","address":"上海市上海市","payKind":"元","taskTypeName":"宝约优选","onlyVip":0,"hasMemberAmt":0,"memberAmt":"0","isFree":false},{"taskId":2539926,"title":"走进J Studio艺术沙龙 | 用画笔定格粉红樱花，画出心中最美花海","content":"走进J Studio艺术沙龙 | 用画笔定格粉红樱花，画出心中最美花海","imageUrl":"https://qn-message.qbcdn.com/16930371610448289a859eb802e9837a","amt":"140","doTime":"2017-05-05","city":"上海","address":"上海市上海市","payKind":"元","taskTypeName":"宝约优选","onlyVip":0,"hasMemberAmt":0,"memberAmt":"0","isFree":false},{"taskId":2539933,"title":"花艺课堂 | 摘几束鲜花 搭出别样精彩","content":"花艺课堂 | 摘几束鲜花 搭出别样精彩","imageUrl":"https://qn-message.qbcdn.com/c2354e61e34d415e8b46fa0091eafda6","amt":"188","doTime":"2017-04-28","city":"上海","address":"上海市上海市","payKind":"元","taskTypeName":"宝约优选","onlyVip":0,"hasMemberAmt":0,"memberAmt":"0","isFree":false},{"taskId":2539935,"title":"最会\u201c讲故事的人\u201d英国艺术家瑞安·甘德在华首展","content":"最会\u201c讲故事的人\u201d英国艺术家瑞安·甘德在华首展","imageUrl":"https://qn-message.qbcdn.com/d09c37f19d654cef9c8b82f8cee8e17b","amt":"1","doTime":"2017-05-14","city":"上海","address":"上海市上海市","payKind":"元","taskTypeName":"宝约优选","onlyVip":0,"hasMemberAmt":0,"memberAmt":"0","isFree":false},{"taskId":2539949,"title":"ING手持吸尘器 G3006 | 机身小巧轻盈，手持轻轻松松","content":"ING手持吸尘器 G3006 | 机身小巧轻盈，手持轻轻松松","imageUrl":"https://qn-message.qbcdn.com/e8ab5b49f67c465a98060b68d209a8dd","amt":"1,192","doTime":"2017-04-30","city":"上海","address":"上海市上海市","payKind":"元","taskTypeName":"宝约优选","onlyVip":0,"hasMemberAmt":0,"memberAmt":"0","isFree":false},{"taskId":2539950,"title":"ING手持吸尘器 G3010 | 拒绝束缚·做有态度的吸尘器","content":"ING手持吸尘器 G3010 | 拒绝束缚·做有态度的吸尘器","imageUrl":"https://qn-message.qbcdn.com/9e24b97a47e242169f787979559218d9","amt":"1,639","doTime":"2017-04-30","city":"上海","address":"上海市上海市","payKind":"元","taskTypeName":"宝约优选","onlyVip":0,"hasMemberAmt":0,"memberAmt":"0","isFree":false},{"taskId":2539952,"title":"ING手持吸尘器 G3009 | 单手除尘·更轻便","content":"ING手持吸尘器 G3009 | 单手除尘·更轻便","imageUrl":"https://qn-message.qbcdn.com/416d3fa70ec24f2daac9a2492c1b0307","amt":"3,180","doTime":"2017-04-30","city":"上海","address":"上海市上海市","payKind":"元","taskTypeName":"宝约优选","onlyVip":0,"hasMemberAmt":0,"memberAmt":"0","isFree":false},{"taskId":2539983,"title":"摘草莓亲子活动｜春の果实 新鲜采摘才好吃","content":"摘草莓亲子活动｜春の果实 新鲜采摘才好吃","imageUrl":"https://qn-message.qbcdn.com/747deaa8a96048588bfc640c879e3285","amt":"80","doTime":"2017-04-24","city":"上海","address":"上海市上海市","payKind":"元","taskTypeName":"宝约优选","onlyVip":0,"hasMemberAmt":0,"memberAmt":"0","isFree":false},{"taskId":2540049,"title":"\u201c凝固\u2014基弗在中国\u201d安塞姆·基弗作品展  南京站","content":"\u201c凝固\u2014基弗在中国\u201d安塞姆·基弗作品展  南京站","imageUrl":"https://qn-message.qbcdn.com/3b52d69597114e3b924f21a1cb59a8ef","amt":"62","doTime":"2017-05-04","city":"南京","address":"江苏省南京市","payKind":"元","taskTypeName":"宝约优选","onlyVip":0,"hasMemberAmt":0,"memberAmt":"0","isFree":false}]
     */

    private boolean success;
    private int returnCode;
    private String message;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

        @Override
        public String toString() {
            return "DataBean{" +
                    "taskId=" + taskId +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", amt='" + amt + '\'' +
                    ", doTime='" + doTime + '\'' +
                    ", city='" + city + '\'' +
                    ", address='" + address + '\'' +
                    ", payKind='" + payKind + '\'' +
                    ", taskTypeName='" + taskTypeName + '\'' +
                    ", onlyVip=" + onlyVip +
                    ", hasMemberAmt=" + hasMemberAmt +
                    ", memberAmt='" + memberAmt + '\'' +
                    ", isFree=" + isFree +
                    '}';
        }

        /**
         * taskId : 2539544
         * title : 李茶的姑妈
         * content : 李茶的姑妈
         * imageUrl : https://qn-message.qbcdn.com/5aeceeb6753d48638a596b842ed7c98e
         * amt : 290
         * doTime : 2017-04-18
         * city : 南京
         * address : 江苏省南京市
         * payKind : 元
         * taskTypeName : 宝约优选
         * onlyVip : 0
         * hasMemberAmt : 0
         * memberAmt : 0
         * isFree : false
         */

        private int taskId;
        private String title;
        private String content;
        private String imageUrl;
        private String amt;
        private String doTime;
        private String city;
        private String address;
        private String payKind;
        private String taskTypeName;
        private int onlyVip;
        private int hasMemberAmt;
        private String memberAmt;
        private boolean isFree;

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getAmt() {
            return amt;
        }

        public void setAmt(String amt) {
            this.amt = amt;
        }

        public String getDoTime() {
            return doTime;
        }

        public void setDoTime(String doTime) {
            this.doTime = doTime;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPayKind() {
            return payKind;
        }

        public void setPayKind(String payKind) {
            this.payKind = payKind;
        }

        public String getTaskTypeName() {
            return taskTypeName;
        }

        public void setTaskTypeName(String taskTypeName) {
            this.taskTypeName = taskTypeName;
        }

        public int getOnlyVip() {
            return onlyVip;
        }

        public void setOnlyVip(int onlyVip) {
            this.onlyVip = onlyVip;
        }

        public int getHasMemberAmt() {
            return hasMemberAmt;
        }

        public void setHasMemberAmt(int hasMemberAmt) {
            this.hasMemberAmt = hasMemberAmt;
        }

        public String getMemberAmt() {
            return memberAmt;
        }

        public void setMemberAmt(String memberAmt) {
            this.memberAmt = memberAmt;
        }

        public boolean isIsFree() {
            return isFree;
        }

        public void setIsFree(boolean isFree) {
            this.isFree = isFree;
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.success ? (byte) 1 : (byte) 0);
        dest.writeInt(this.returnCode);
        dest.writeString(this.message);
        dest.writeList(this.data);
    }

    public ListInfo() {
    }

    protected ListInfo(Parcel in) {
        this.success = in.readByte() != 0;
        this.returnCode = in.readInt();
        this.message = in.readString();
        this.data = new ArrayList<DataBean>();
        in.readList(this.data, DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<ListInfo> CREATOR = new Parcelable.Creator<ListInfo>() {
        @Override
        public ListInfo createFromParcel(Parcel source) {
            return new ListInfo(source);
        }

        @Override
        public ListInfo[] newArray(int size) {
            return new ListInfo[size];
        }
    };

    @Override
    public String toString() {
        return "ListInfo{" +
                "success=" + success +
                ", returnCode=" + returnCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
