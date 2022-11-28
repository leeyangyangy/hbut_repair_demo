package com.lyt.manager.framework.respone;


import java.io.Serializable;

/**
 * <p>Title : 请求返回应答</p>
 * <p>Description : </p>
 * <p>DevelopTools : IDEA</p>
 * <p>DevelopSystem : Windows10</p>
 *
 * @Author : NemoMeng
 * @Date 2022/9/1 15:28
 */

/**
 * 什么是序列化？
 * 序列化是将对象状态转换为可保持或传输的格式的过程。与序列化相对的是反序列化，它将流转换为对象。这两个过程结合起来，可以轻松地存储和传输数据。
 *
 * 为什么要序列化对象
 * 把对象转换为字节序列的过程称为对象的序列化
 * 把字节序列恢复为对象的过程称为对象的反序列化
 *
 * 什么情况下需要序列化？
 * 当我们需要把对象的状态信息通过网络进行传输，或者需要将对象的状态信息持久化，以便将来使用时都需要把对象进行序列化
 */
public class ResponseData implements Serializable {


    public static final String DEFAULT_SUCCESS_MESSAGE = "请求成功";

    public static final String DEFAULT_ERROR_MESSAGE = "网络异常";

    public static final Integer DEFAULT_SUCCESS_CODE = 200;

    public static final Integer DEFAULT_ERROR_CODE = 500;

    /**
     * 请求是否成功
     */
    private Boolean success;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应对象
     */
    private Object data;

    private Object orders;

    private Object worker;

    public ResponseData() {
    }

    public ResponseData(Boolean success, Integer code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    //成功的方法
    public static ResponseData success(){
        ResponseData responseData = new ResponseData();
        responseData.setSuccess(true);
        responseData.setCode(DEFAULT_SUCCESS_CODE);
        responseData.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return responseData;
    }
    public static ResponseData success(Object object){
        ResponseData responseData = new ResponseData();
        responseData.setSuccess(true);
        responseData.setCode(DEFAULT_SUCCESS_CODE);
        responseData.setMessage(DEFAULT_SUCCESS_MESSAGE);
        responseData.setData(object);
        return responseData;
    }
    public static ResponseData success(Integer code, String message, Object object){
        ResponseData responseData = new ResponseData();
        responseData.setSuccess(true);
        responseData.setCode(code);
        responseData.setMessage(message);
        responseData.setData(object);
        return responseData;
    }

    //失败的方法
    public static ResponseData error(){
        ResponseData responseData = new ResponseData();
        responseData.setSuccess(false);
        responseData.setCode(DEFAULT_ERROR_CODE);
        responseData.setMessage(DEFAULT_ERROR_MESSAGE);
        return responseData;
    }
    public static ResponseData error(Object object){
        ResponseData responseData = new ResponseData();
        responseData.setSuccess(false);
        responseData.setCode(DEFAULT_ERROR_CODE);
        responseData.setMessage(DEFAULT_ERROR_MESSAGE);
        responseData.setData(object);
        return responseData;
    }
    public static ResponseData error(Integer code, String message, Object object){
        ResponseData responseData = new ResponseData();
        responseData.setSuccess(false);
        responseData.setCode(code);
        responseData.setMessage(message);
        responseData.setData(object);
        return responseData;
    }
}
