package org.example.spring.cloud.msorder.input.models;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PaymentRequestResto {

    private String     orderId;
    private String     customerNumber;
    private BigDecimal amount;

}
