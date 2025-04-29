package org.example.spring.cloud.msorder.input.models;

import lombok.Data;

@Data
public class ServerResponse<T> {

    private boolean errorOccured;
    private String  errorStr;
    private int     errorCode;
    private T       value;

}
