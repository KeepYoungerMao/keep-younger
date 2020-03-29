package com.mao.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zongx at 2020/3/27 22:03
 */
@Getter
@AllArgsConstructor
public enum SecretEnum {

    AES("AES",128),
    DES("DES",56);

    private String type;
    private int strong;

}
