package com.southwind.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TType implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}
