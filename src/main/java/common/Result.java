package common;

import java.io.Serializable;

/**
 * 统一响应结果类（企业安全版）
 * @param <T> 返回数据类型
 */
public class Result<T> implements Serializable {

    private Integer code;   // 状态码：200 成功，500 失败
    private String message; // 提示信息
    private T data;         // 泛型数据

    // 构造函数私有化，统一使用静态工厂方法
    private Result() {}

    // ================= 静态工厂方法 =================

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {
        return success("成功", data);
    }

    public static <T> Result<T> success(String message, T data) {
        Result<T> result = new Result<>();
        result.code = 200;
        result.message = message;
        result.data = data;
        return result;
    }

    public static <T> Result<T> error(String message) {
        return error(500, message);
    }

    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<>();
        result.code = code;
        result.message = message;
        return result;
    }

    // ================= Getter / Setter =================

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // ================= 安全 toString =================
    @Override
    public String toString() {
        // 只打印 code 和 message，不打印 data
        return "Result{code=" + code + ", message='" + message + "'}";
    }
}
