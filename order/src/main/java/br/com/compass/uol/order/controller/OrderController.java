package br.com.compass.uol.order.controller;

import br.com.compass.uol.order.domain.dto.request.OrderDtoRequest;
import br.com.compass.uol.order.domain.dto.response.OrderDtoResponse;
import br.com.compass.uol.order.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/order")
    public ResponseEntity<OrderDtoResponse> save(@RequestBody OrderDtoRequest request){
        OrderDtoResponse orderDtoResponse = orderService.save(request);
        return ResponseEntity.ok(orderDtoResponse);
    }
    @GetMapping("/api/order")
    public ResponseEntity<List<OrderDtoResponse>> getAll(){
        List<OrderDtoResponse> orderDtoResponses = orderService.getAll();
        return ResponseEntity.ok(orderDtoResponses);
    }
}
