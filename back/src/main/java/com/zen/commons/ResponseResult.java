package com.zen.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResponseResult<T> {

    private Integer resCode;

    private String message;

    private T data;

    public ResponseResult(Integer resCode, String message) {
        this.resCode = resCode;
        this.message = message;
    }

    public ResponseResult(Integer resCode, String message, T data) {
        this.resCode = resCode;
        this.message = message;
        this.data = data;
    }

}



