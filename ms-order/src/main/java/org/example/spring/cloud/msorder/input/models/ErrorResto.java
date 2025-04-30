package org.example.spring.cloud.msorder.input.models;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class ErrorResto {

    private List<ErrorResto> subErrors;
    private String           errorDesc;
    private Integer          errorCode;

    @Builder(setterPrefix = "with")
    public ErrorResto(final List<ErrorResto> subErrorsParam,
                      final String errorDescParam,
                      final Integer errorCodeParam) {
        super();
        this.subErrors = subErrorsParam;
        this.errorDesc = errorDescParam;
        this.errorCode = errorCodeParam;
    }

    public ErrorResto() {
        super();
    }

}
