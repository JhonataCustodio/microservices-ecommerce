package br.com.compass.uol.order.domain.service;

import br.com.compass.uol.order.common.ItemsConstants;
import br.com.compass.uol.order.domain.dto.request.ItemsDtoRequest;
import br.com.compass.uol.order.domain.dto.response.ItemsDtoResponse;
import br.com.compass.uol.order.domain.entity.Items;
import br.com.compass.uol.order.domain.repository.ItemsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemsServiceTest {
    @InjectMocks
    private ItemsService itemsService;
    @Mock
    private ItemsRepository itemsRepository;
    @Mock
    private ModelMapper modelMapper;
    @Test
    public void save_WithValidData_CreateItem(){
        ItemsDtoRequest itemsDtoRequest = ItemsConstants.ITEMS_DTO_REQUEST;
        Items items = ItemsConstants.ITEMS;

        when(itemsRepository.save(any(Items.class))).thenReturn(items);
        ItemsDtoResponse savedItem = itemsService.save(itemsDtoRequest);

        assertNotNull(savedItem);
        assertThat(savedItem.getName()).isEqualTo(items.getName());
        assertThat(savedItem.getDescription()).isEqualTo(items.getDescription());
        assertThat(savedItem.getCreationDate()).isEqualTo(items.getCreationDate());
        assertThat(savedItem.getExpirationDate()).isEqualTo(items.getExpirationDate());
        assertThat(savedItem.getAmount()).isEqualTo(items.getAmount());
    }
}
