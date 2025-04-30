package org.example.spring.cloud.mspayment.input;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
public class PaymentResponseResto {

    private String     orderId;
    private BigDecimal amount;

    @Builder(setterPrefix = "with")
    public PaymentResponseResto(final String orderIdParam,
                                final BigDecimal amountParam) {
        super();
        this.orderId = orderIdParam;
        this.amount = amountParam;
    }

    public PaymentResponseResto() {
        super();
    }

}
