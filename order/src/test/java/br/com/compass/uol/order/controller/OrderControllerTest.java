package br.com.compass.uol.order.controller;

import br.com.compass.uol.order.common.OrderConstants;
import br.com.compass.uol.order.domain.dto.response.OrderDtoResponse;
import br.com.compass.uol.order.domain.entity.Order;
import br.com.compass.uol.order.domain.repository.OrderRepository;
import br.com.compass.uol.order.domain.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {
    @Mock
    private OrderService orderService;
    @InjectMocks
    private OrderController orderController;
    @Mock
    private OrderRepository orderRepository;

    @Test
    public void getAll_ReturnsListOfOrderDtoResponse(){
        List<Order> orders = Collections.singletonList(OrderConstants.ORDER);
        when(orderService.getAll()).thenReturn(OrderConstants.ORDER_LIST);
        ResponseEntity<List<OrderDtoResponse>> response = orderController.getAll();

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());

        OrderDtoResponse orderDtoResponse = response.getBody().get(0);
        assertEquals(OrderConstants.ORDER.getId(), orderDtoResponse.getId());
        assertThat(orders.get(0).getCpf()).isEqualTo(orderDtoResponse.getCpf());
        assertThat(orders.get(0).getItems().get(0).getId()).isEqualTo(orderDtoResponse.getItems().get(0).getId());
        assertThat(orders.get(0).getItems().get(0).getName()).isEqualTo(orderDtoResponse.getItems().get(0).getName());
        assertThat(orders.get(0).getItems().get(0).getDescription()).isEqualTo(orderDtoResponse.getItems().get(0).getDescription());
        assertThat(orders.get(0).getItems().get(0).getCreationDate()).isEqualTo(orderDtoResponse.getItems().get(0).getCreationDate());
        assertThat(orders.get(0).getItems().get(0).getExpirationDate()).isEqualTo(orderDtoResponse.getItems().get(0).getExpirationDate());
        assertThat(orders.get(0).getItems().get(0).getAmount()).isEqualTo(orderDtoResponse.getItems().get(0).getAmount());
        assertThat(orders.get(0).getAmount()).isEqualTo(orderDtoResponse.getAmount());
        assertThat(orders.get(0).getOrderStatus()).isEqualTo(orderDtoResponse.getOrderStatus());
        assertThat(orders.get(0).getPaymentStatus()).isEqualTo(orderDtoResponse.getPaymentStatus());
    }
}
