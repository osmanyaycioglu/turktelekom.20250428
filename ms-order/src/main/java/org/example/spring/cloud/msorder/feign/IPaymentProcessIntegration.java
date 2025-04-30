package org.example.spring.cloud.msorder.feign;

import org.example.spring.cloud.msorder.input.models.PaymentRequestResto;
import org.example.spring.cloud.msorder.input.models.PaymentResponseResto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "PAYMENT", contextId = "1")
public interface IPaymentProcessIntegration {

    @PostMapping("/api/v1/payment/process/pay")
    public PaymentResponseResto pay(@RequestBody final PaymentRequestResto paymentRequestRestoParam);
}
