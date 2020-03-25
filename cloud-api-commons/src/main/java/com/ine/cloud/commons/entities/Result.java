package com.ine.cloud.commons.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    public Result(Integer code, String msg) {
        this(code,msg,null);
    }
}
