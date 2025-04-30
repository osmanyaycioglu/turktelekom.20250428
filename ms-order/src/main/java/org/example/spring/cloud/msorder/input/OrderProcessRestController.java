package org.example.spring.cloud.msorder.input;

import java.math.BigDecimal;
import java.util.UUID;

import org.example.spring.cloud.msorder.feign.IPaymentProcessIntegration;
import org.example.spring.cloud.msorder.input.models.OrderResto;
import org.example.spring.cloud.msorder.input.models.PaymentRequestResto;
import org.example.spring.cloud.msorder.input.models.PaymentResponseResto;
import org.example.spring.cloud.msorder.service.PaymentProcessService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/order/process")
@RequiredArgsConstructor
public class OrderProcessRestController {

    private final PaymentProcessService      paymentProcessService;

    @PostMapping("/place")
    public String placeOrder(@RequestBody @Valid final OrderResto orderRestoParam) {
        return paymentProcessService.placeOrder(orderRestoParam);
    }

}
