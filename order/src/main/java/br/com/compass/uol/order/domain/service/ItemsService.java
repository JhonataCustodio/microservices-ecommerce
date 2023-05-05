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
        Items items = new Items();
        items.setName(request.getName());
        items.setDescription(request.getDescription());
        items.setCreationDate(request.getCreationDate());
        items.setExpirationDate(request.getExpirationDate());
        items.setAmount(request.getAmount());
        itemsRepository.save(items);
        ItemsDtoResponse itemsDtoResponse = new ItemsDtoResponse();
        itemsDtoResponse.setId(items.getId());
        itemsDtoResponse.setName(items.getName());
        itemsDtoResponse.setDescription(items.getDescription());
        itemsDtoResponse.setCreationDate(items.getCreationDate());
        itemsDtoResponse.setExpirationDate(items.getExpirationDate());
        itemsDtoResponse.setAmount(items.getAmount());
        return  itemsDtoResponse;
    }
}
