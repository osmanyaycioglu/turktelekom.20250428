package org.example.spring.cloud.msorder.input;

import org.example.spring.cloud.msorder.input.models.OrderResto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/order/process")
public class OrderProcessRestController {

    @PostMapping("/place")
    public String placeOrder(@RequestBody @Valid final OrderResto orderRestoParam) {
        return "OK";
    }

}
