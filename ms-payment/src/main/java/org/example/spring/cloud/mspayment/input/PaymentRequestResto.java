package org.example.spring.cloud.mspayment.input;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PaymentRequestResto {

    private String     orderId;
    private String     customerNumber;
    private BigDecimal amount;

}
