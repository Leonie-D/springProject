package org.lfc.configuration;

import org.lfc.dao.ItemRepository;
import org.lfc.entity.Item;
import org.lfc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabase implements ApplicationRunner {
    private ItemRepository itemRepository;
    private ItemService itemService;

    @Autowired
    public LoadDatabase(ItemRepository itemRepository, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Item item1 = new Item();
        item1.setName("Foulard");
        itemRepository.save(item1);

        Item item2 = new Item();
        item2.setName("Echarpe");
        itemRepository.save(item2);

        Item item3 = new Item();
        item3.setName("Tapis");
        itemRepository.save(item3);
    }
}
