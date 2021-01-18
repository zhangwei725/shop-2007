package com.pingxixi.utils;

public enum ResponseCode {
    USER_LOGIN_ERROR(40001, "密码错误");
    private int status;
    private String msg;

    ResponseCode(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
