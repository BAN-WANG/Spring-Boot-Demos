package com.ss.quickStart.core;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: wsy
 * \* Date: 2017/9/26
 * \* Time: 9:55
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Result {
    private int code;
    private String messaage;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessaage() {
        return messaage;
    }

    public void setMessaage(String messaage) {
        this.messaage = messaage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}