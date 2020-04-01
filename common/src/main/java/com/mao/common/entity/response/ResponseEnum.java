package com.mao.common.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zongx at 2020/3/31 22:34
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum {

    SUCCESS(200,"ok"),

    PERMISSION(401,"invalid authorization"),

    NULL(404,"resource not found"),

    ERROR(500,"request error");

    private int code;
    private String detail;

}
