package com.southwind.vo;

import com.southwind.entity.TType;
import lombok.Data;

import java.io.Serializable;

@Data
public class TMenuVO implements Serializable {
    private Integer id;

    private String name;

    private Double price;

    private String flavor;

    private Integer tid;

    private TType tType;

    private static final long serialVersionUID = 1L;
}
