package team.vert.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.vert.order.dao.ItemRepository;
import team.vert.order.dao.OrderRepository;
import team.vert.order.entity.Item;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public void addItem(Item item) {
        if(!itemRepository.existsById(item.getId())) {
            itemRepository.save(item);
        }
    }
}
