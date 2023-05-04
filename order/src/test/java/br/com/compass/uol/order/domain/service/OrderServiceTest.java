package br.com.compass.uol.order.domain.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import br.com.compass.uol.order.common.OrderConstants;
import br.com.compass.uol.order.domain.dto.response.OrderDtoResponse;

import br.com.compass.uol.order.domain.entity.Order;
import br.com.compass.uol.order.domain.repository.ItemsRepository;
import br.com.compass.uol.order.domain.repository.OrderRepository;

import br.com.compass.uol.order.factory.OrderFactory;
import br.com.compass.uol.order.factory.OrderValidationFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @InjectMocks
    private OrderService orderService;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private ItemsRepository itemsRepository;
    @Mock
    private OrderFactory orderFactory;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private OrderValidationFactory orderValidationFactory;
    @Mock
    private RabbitTemplate template;

    @Test
    public void getAll_WithValidData_ReturnsListOfOrders() {
        Order order = OrderConstants.ORDER;
        when(orderRepository.findAll()).thenReturn(Collections.singletonList(order));
        List<OrderDtoResponse> result = orderService.getAll();

        assertThat(result).isNotNull().isNotEmpty();
        assertThat(result.get(0).getCpf()).isEqualTo(order.getCpf());
        assertThat(result.get(0).getItems().get(0).getId()).isEqualTo(order.getItems().get(0).getId());
        assertThat(result.get(0).getItems().get(0).getName()).isEqualTo(order.getItems().get(0).getName());
        assertThat(result.get(0).getItems().get(0).getDescription()).isEqualTo(order.getItems().get(0).getDescription());
        assertThat(result.get(0).getItems().get(0).getCreationDate()).isEqualTo(order.getItems().get(0).getCreationDate());
        assertThat(result.get(0).getItems().get(0).getExpirationDate()).isEqualTo(order.getItems().get(0).getExpirationDate());
        assertThat(result.get(0).getItems().get(0).getAmount()).isEqualTo(order.getItems().get(0).getAmount());
        assertThat(result.get(0).getAmount()).isEqualTo(order.getAmount());
        assertThat(result.get(0).getOrderStatus()).isEqualTo(order.getOrderStatus());
        assertThat(result.get(0).getPaymentStatus()).isEqualTo(order.getPaymentStatus());
    }
    @Test
    public void getByCpf_WithValidData_ReturnsListOfOrders() {
        Order order = OrderConstants.ORDER;
        String cpf = order.getCpf();
        when(orderRepository.searchByCpf(cpf)).thenReturn(Collections.singletonList(order));

        List<OrderDtoResponse> result = orderService.getByCpf(cpf);

        assertThat(result).isNotNull().isNotEmpty();
        assertThat(result.get(0).getCpf()).isEqualTo(order.getCpf());
        assertThat(result.get(0).getItems().get(0).getId()).isEqualTo(order.getItems().get(0).getId());
        assertThat(result.get(0).getItems().get(0).getName()).isEqualTo(order.getItems().get(0).getName());
        assertThat(result.get(0).getItems().get(0).getDescription()).isEqualTo(order.getItems().get(0).getDescription());
        assertThat(result.get(0).getItems().get(0).getCreationDate()).isEqualTo(order.getItems().get(0).getCreationDate());
        assertThat(result.get(0).getItems().get(0).getExpirationDate()).isEqualTo(order.getItems().get(0).getExpirationDate());
        assertThat(result.get(0).getItems().get(0).getAmount()).isEqualTo(order.getItems().get(0).getAmount());
        assertThat(result.get(0).getAmount()).isEqualTo(order.getAmount());
        assertThat(result.get(0).getOrderStatus()).isEqualTo(order.getOrderStatus());
        assertThat(result.get(0).getPaymentStatus()).isEqualTo(order.getPaymentStatus());
    }
    @Test
    public void getByAmount_WithValidData_ReturnsListOfOrders() {
        Order order = OrderConstants.ORDER;
        when(orderRepository.findAllByOrderByAmountAsc()).thenReturn(Collections.singletonList(order));

        List<OrderDtoResponse> result = orderService.getByAmount();

        assertThat(result).isNotNull().isNotEmpty();
        assertThat(result.get(0).getCpf()).isEqualTo(order.getCpf());
        assertThat(result.get(0).getItems().get(0).getId()).isEqualTo(order.getItems().get(0).getId());
        assertThat(result.get(0).getItems().get(0).getName()).isEqualTo(order.getItems().get(0).getName());
        assertThat(result.get(0).getItems().get(0).getDescription()).isEqualTo(order.getItems().get(0).getDescription());
        assertThat(result.get(0).getItems().get(0).getCreationDate()).isEqualTo(order.getItems().get(0).getCreationDate());
        assertThat(result.get(0).getItems().get(0).getExpirationDate()).isEqualTo(order.getItems().get(0).getExpirationDate());
        assertThat(result.get(0).getItems().get(0).getAmount()).isEqualTo(order.getItems().get(0).getAmount());
        assertThat(result.get(0).getAmount()).isEqualTo(order.getAmount());
        assertThat(result.get(0).getOrderStatus()).isEqualTo(order.getOrderStatus());
        assertThat(result.get(0).getPaymentStatus()).isEqualTo(order.getPaymentStatus());
    }
    @Test
    public void getById_WithValidData_ReturnsListOfOrders() {
        Order order = OrderConstants.ORDER;
        Integer id = order.getId();
        when(orderRepository.findById(id)).thenReturn(Optional.of(order));

        OrderDtoResponse result = orderService.getById(id);

        assertThat(result).isNotNull();
        assertThat(result.getCpf()).isEqualTo(order.getCpf());
        assertThat(result.getItems().get(0).getId()).isEqualTo(order.getItems().get(0).getId());
        assertThat(result.getItems().get(0).getName()).isEqualTo(order.getItems().get(0).getName());
        assertThat(result.getItems().get(0).getDescription()).isEqualTo(order.getItems().get(0).getDescription());
        assertThat(result.getItems().get(0).getCreationDate()).isEqualTo(order.getItems().get(0).getCreationDate());
        assertThat(result.getItems().get(0).getExpirationDate()).isEqualTo(order.getItems().get(0).getExpirationDate());
        assertThat(result.getItems().get(0).getAmount()).isEqualTo(order.getItems().get(0).getAmount());
        assertThat(result.getAmount()).isEqualTo(order.getAmount());
        assertThat(result.getOrderStatus()).isEqualTo(order.getOrderStatus());
        assertThat(result.getPaymentStatus()).isEqualTo(order.getPaymentStatus());
    }
    @Test
    public void delete_WithValidData_ReturnsMessageOrderRemoved() {
        Order order = OrderConstants.ORDER;
        Integer id = order.getId();
        when(orderRepository.findById(id)).thenReturn(Optional.of(order));
        String result = orderService.delete(id);

        verify(orderRepository).delete(order);
        assertEquals("Order removed", result);
    }
}
