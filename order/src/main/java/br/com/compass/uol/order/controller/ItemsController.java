package br.com.compass.uol.order.controller;

import br.com.compass.uol.order.domain.dto.request.ItemsDtoRequest;
import br.com.compass.uol.order.domain.dto.response.ItemsDtoResponse;
import br.com.compass.uol.order.domain.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @PostMapping("/api/item")
    public ResponseEntity<ItemsDtoResponse> save(@RequestBody ItemsDtoRequest request){
        ItemsDtoResponse itemsDtoResponse = itemsService.save(request);
        return  ResponseEntity.ok(itemsDtoResponse);
    }
}
