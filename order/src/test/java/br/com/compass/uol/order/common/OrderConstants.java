package br.com.compass.uol.order.common;

import br.com.compass.uol.order.domain.dto.request.OrderDtoRequest;
import br.com.compass.uol.order.domain.dto.response.ItemsDtoResponse;
import br.com.compass.uol.order.domain.dto.response.OrderDtoResponse;
import br.com.compass.uol.order.domain.entity.Items;
import br.com.compass.uol.order.domain.entity.Order;
import br.com.compass.uol.order.domain.enums.OrderStatus;
import br.com.compass.uol.order.domain.enums.PaymentStatus;
import br.com.compass.uol.order.factory.ItemsDtoResponseFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderConstants {
    public static final Order ORDER = new Order() {{
        setId(1);
        setCpf("12345678910");
        setItems(
                Collections.singletonList(new Items(
                        4,
                        "item name",
                        "item description",
                        LocalDate.of(2023, 4, 6),
                        LocalDate.of(2025, 1, 1),
                        30.0
                ))
        );
        setAmount(44.8);
        setOrderStatus(OrderStatus.FINISHED);
        setPaymentStatus(PaymentStatus.APPROVED);
    }};
//    public static final OrderDtoRequest CREATE_ORDER = new OrderDtoRequest(){{
//        setCpf("12345678910");
//        setItems(
//                (Items) Collections.singletonList(new Items(2))
//        );
//        setAmount(44.8);
//        setOrderStatus(OrderStatus.FINISHED);
//        setPaymentStatus(PaymentStatus.APPROVED);
//    }};

}