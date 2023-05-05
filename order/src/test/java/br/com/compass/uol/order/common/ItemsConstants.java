package br.com.compass.uol.order.common;

import br.com.compass.uol.order.domain.dto.request.ItemsDtoRequest;
import br.com.compass.uol.order.domain.entity.Items;

import java.time.LocalDate;

public class ItemsConstants {
    public static final Items ITEMS = new Items() {{
        setId(1);
        setName("Item name");
        setDescription("Item Description");
        setCreationDate( LocalDate.of(2023, 4, 6));
        setExpirationDate(LocalDate.of(2025, 1, 1));
        setAmount(30.0);
    }};
    public static final ItemsDtoRequest ITEMS_DTO_REQUEST = new ItemsDtoRequest(){
        {
            setName("Item name");
            setDescription("Item Description");
            setCreationDate( LocalDate.of(2023, 4, 6));
            setExpirationDate(LocalDate.of(2025, 1, 1));
            setAmount(30.0);
        }
    };
}
