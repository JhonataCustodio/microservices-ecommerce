package br.com.compass.uol.order.domain.service;

import br.com.compass.uol.order.domain.dto.request.ItemsDtoRequest;
import br.com.compass.uol.order.domain.dto.response.ItemsDtoResponse;
import br.com.compass.uol.order.domain.entity.Items;
import br.com.compass.uol.order.domain.repository.ItemsRepository;
import br.com.compass.uol.order.domain.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemsRepository itemsRepository;
    @Autowired
    private OrderRepository orderRepository;
    public ItemsDtoResponse save(ItemsDtoRequest request){
        Items items = modelMapper.map(request, Items.class);
        itemsRepository.save(items);
        ItemsDtoResponse itemsDtoResponse = modelMapper.map(items, ItemsDtoResponse.class);
        return  itemsDtoResponse;
    }
}
