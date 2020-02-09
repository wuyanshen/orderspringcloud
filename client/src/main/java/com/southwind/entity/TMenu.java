package com.southwind.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TMenu implements Serializable {

    private Integer id;

    private String name;

    private Double price;

    private String flavor;

    private TType tType;

    private static final long serialVersionUID = 1L;
}
