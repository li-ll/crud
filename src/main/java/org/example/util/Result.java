package org.example.util;

/**
 * @author ruo
 * @version 1.0
 * @date 2023/1/29
 */
public class Result {

    private String code;

    private String message = "success";

    private Object data;

    public Result(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result() {
    }

    // 后面result生成器需要以下方法
    public Result setCode(String resultCode){
        this.code = resultCode;
        return this;
    }

    public Result setMessage(String message){
        this.message = message;
        return this;
    }

    public Result setData(Object data){
        this.data = data;
        return this;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}

