package com.tdd.blog.website.modal.Bo;


import org.json.JSONObject;

/**
 * rest返回对象
 *^
 * @param <T>
 */
public class RestResponseBo<T> {

    /**
     * 服务器响应数据
     */
    private T payload;

    /**
     * 请求是否成功
     */
    private boolean success;

    /**
     * 错误信息
     */
    private String msg;
    /**
     * 成功数据
     */
    private String desc;

    /**
     * 状态码
     */
    private String code;

    /**
     * 服务器响应时间
     */
    private long timestamp;

    public RestResponseBo() {
        this.timestamp = System.currentTimeMillis() / 1000;
    }

    public RestResponseBo(boolean success) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.success = success;
    }

    public RestResponseBo(boolean success, T payload) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.success = success;
        this.payload = payload;
    }

    public RestResponseBo(boolean success, T payload, String code) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.success = success;
        this.payload = payload;
        this.code = code;
    }

    public RestResponseBo(boolean success, String desc) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.success = success;
        this.desc = desc;
    }

    public RestResponseBo(boolean success, String msg, String code) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.success = success;
        this.msg = msg;
        this.code = code;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static RestResponseBo ok() {
        return new RestResponseBo(true);
    }

    public static <T> RestResponseBo ok(T payload) {
        return new RestResponseBo(true, payload);
    }

    public static <T> RestResponseBo ok(String code) {
        return new RestResponseBo(true, null, code);
    }

    public static <T> RestResponseBo ok(T payload, String code) {
        return new RestResponseBo(true, payload, code);
    }

    public static RestResponseBo fail() {
        return new RestResponseBo(false);
    }

    public static RestResponseBo failMsg(String msg) {
        return new RestResponseBo(false, msg);
    }

    public static RestResponseBo successMsg(String desc) {
        return new RestResponseBo(false, desc);
    }

    public static RestResponseBo failCode(String code) {
        return new RestResponseBo(false, null, code);
    }

    public static RestResponseBo fail(String code, String msg) {
        return new RestResponseBo(false, msg, code);
    }

}