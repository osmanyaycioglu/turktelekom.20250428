package org.example.spring.cloud.mspayment.input;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/payment/process")
public class PaymentProcessRestController {

    @Value("${server.port}")
    private Integer port;

    @PostMapping("/pay")
    @Operation(description = "uzun desc", summary = "kısa desc")
    public PaymentResponseResto pay(@RequestBody final PaymentRequestResto paymentRequestRestoParam) {
        return PaymentResponseResto.builder()
                                   .withOrderIdParam(paymentRequestRestoParam.getOrderId() + "-" + this.port)
                                   .withAmountParam(paymentRequestRestoParam.getAmount())
                                   .build();
    }

}
