package br.com.compass.uol.order.factory;

import br.com.compass.uol.order.domain.dto.response.ItemsDtoResponse;
import br.com.compass.uol.order.domain.entity.Items;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ItemsDtoResponseFactory {
    public static List<ItemsDtoResponse> createFromItems(List<Items> items) {
        if (items == null) {
            return Collections.emptyList();
        }
        return items.stream()
                .map(item -> new ItemsDtoResponse(
                        item.getId(),
                        item.getName(),
                        item.getDescription(),
                        item.getCreationDate(),
                        item.getExpirationDate(),
                        item.getAmount()
                ))
                .collect(Collectors.toList());
    }
}
