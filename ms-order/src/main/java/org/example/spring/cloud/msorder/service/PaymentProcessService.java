package org.example.spring.cloud.msorder.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.example.spring.cloud.msorder.feign.IPaymentProcessIntegration;
import org.example.spring.cloud.msorder.input.models.OrderResto;
import org.example.spring.cloud.msorder.input.models.PaymentRequestResto;
import org.example.spring.cloud.msorder.input.models.PaymentResponseResto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentProcessService {
    private final RestTemplate               restTemplate;
    private final RestClient.Builder         restBuilder;
    private final IPaymentProcessIntegration paymentProcessIntegration;


    @Retry(name = "payment1", fallbackMethod = "placeOrderFB")
    @CircuitBreaker(name = "cb-payment1")
    public String placeOrder(OrderResto orderRestoParam) {
        PaymentRequestResto restoLoc = new PaymentRequestResto();
        restoLoc.setCustomerNumber(orderRestoParam.getCustomerNumber());
        restoLoc.setOrderId(UUID.randomUUID()
                                .toString());
        restoLoc.setAmount(new BigDecimal(1000));

        //        PaymentResponseResto postForObjectLoc = this.restTemplate.postForObject("http://PAYMENT/api/v1/payment/process/pay",
        //                                                                                restoLoc,
        //                                                                                PaymentResponseResto.class);

        //        ResponseEntity<PaymentResponseResto> entityLoc = this.restBuilder.build()
        //                                                                         .post()
        //                                                                         .uri("http://PAYMENT/api/v1/payment/process/pay")
        //                                                                         .contentType(MediaType.APPLICATION_JSON)
        //                                                                         .body(restoLoc)
        //                                                                         .retrieve()
        //                                                                         .toEntity(PaymentResponseResto.class);
        PaymentResponseResto payLoc = this.paymentProcessIntegration.pay(restoLoc);
        return "" + payLoc;
    }

    public String placeOrderFB(OrderResto orderRestoParam,
                               Throwable throwableParam) {
        return "Fallback message";
    }

}
