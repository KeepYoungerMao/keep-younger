package com.mao.common.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zongx at 2020/3/31 22:31
 */
@Getter
@Setter
@AllArgsConstructor
public class ResponseData<T> {

    private int code;       //状态码
    private String msg;     //描述信息
    private T data;         //返回数据体

    public static <T> ResponseData<T> ok(T data){
        return o(ResponseEnum.SUCCESS,data);
    }

    public static ResponseData<ErrorData> permission(String data){
        return o(ResponseEnum.PERMISSION,new ErrorData(data));
    }

    public static ResponseData<ErrorData> none(String data){
        return o(ResponseEnum.NULL,new ErrorData(data));
    }

    public static ResponseData<ErrorData> error(String data){
        return o(ResponseEnum.ERROR,new ErrorData(data));
    }

    private static <T> ResponseData<T> o(ResponseEnum type, T data){
        return new ResponseData<>(type.getCode(),type.getDetail(),data);
    }

}
