package com.southwind.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wuyanshen
 * @date 2020-02-07 5:08 下午
 * @discription 通用返回信息类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private int code;
    private String msg;
    private int count;
    private T data;
}
