package br.com.compass.uol.order.controller;

import br.com.compass.uol.order.common.ItemsConstants;
import br.com.compass.uol.order.domain.dto.request.ItemsDtoRequest;
import br.com.compass.uol.order.domain.dto.response.ItemsDtoResponse;
import br.com.compass.uol.order.domain.service.ItemsService;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ItemsControllerTest {
    @Mock
    private ItemsService itemsService;

    @InjectMocks
    private ItemsController itemsController;

    @Test
    public void save_WithValidData_ReturnItemsDtoResponse(){
        ItemsDtoRequest request = ItemsConstants.ITEMS_DTO_REQUEST;

        ItemsDtoResponse itemsDtoResponse = ItemsConstants.ITEMS_DTO_RESPONSE;
        when(itemsService.save(any(ItemsDtoRequest.class))).thenReturn(itemsDtoResponse);

        ResponseEntity<ItemsDtoResponse> result = itemsController.save(request);

        verify(itemsService, times(1)).save(request);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(itemsDtoResponse, result.getBody());
    }
}
