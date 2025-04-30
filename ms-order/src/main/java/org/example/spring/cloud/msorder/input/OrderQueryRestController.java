package org.example.spring.cloud.msorder.input;

import java.util.List;

import org.example.spring.cloud.msorder.input.models.OrderResto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order/query")
public class OrderQueryRestController {

    @GetMapping("/find/all")
    public List<OrderResto> findAllOrders() {
        return null;
    }

    @GetMapping("/find/one")
    public List<OrderResto> findOneOrder(@RequestParam final Long orderId) {
        return null;
    }

}
