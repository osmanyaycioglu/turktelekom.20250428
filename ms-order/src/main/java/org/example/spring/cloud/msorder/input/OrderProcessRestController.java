package org.example.spring.cloud.msorder.input;

import org.example.spring.cloud.msorder.input.models.OrderResto;
import org.example.spring.cloud.msorder.input.models.ServerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order/process")
public class OrderProcessRestController {

    @PostMapping("/place")
    public ServerResponse<String> placeOrder(@RequestBody final OrderResto orderRestoParam) {
        return null;
    }

}
