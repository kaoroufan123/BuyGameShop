package com.GameShop.utils;

import lombok.Data;
import lombok.Getter;

/**
 * @ClassName Result
 * @Author KaoRouFan
 * @Date 2025/3/25 18:56
 * @Version 1.14.5.14
 */


@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public Result(int i, String success, Object data) {

    }

    // 省略构造方法和静态方法
    public static Result success(Object data) {
        return new Result(200, "success", data);
    }

    public static Result error(String msg) {
        return new Result(500, msg, null);
    }
}
