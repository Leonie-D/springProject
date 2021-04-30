package org.lfc.service;

import java.util.ArrayList;
import java.util.List;

import org.lfc.dao.ItemRepository;
import org.lfc.entity.Item;
import org.lfc.exception.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.util.Strings;

@Service
public class ItemService {

		@Autowired
	    private ItemRepository itemDAO;


	    public List<Item> getAll() {

	        return itemDAO.findAll();
	    }

	    public Item get(String id) throws APIException {
	        return entityToDto(getItem(id));
	    }

	    public Item create(Item item) throws APIException {
	        if (!isItemValid(item)) throw new APIException("Item invalid", HttpStatus.BAD_REQUEST);

	        final Item item2 = dtoToEntityNoId(item);

	        itemDAO.save(item2);

	        return entityToDto(item2);
	    }

	    public Item update(Item item) throws APIException {

	        if (!isItemValid(item)) throw new APIException("Update item invalid", HttpStatus.BAD_REQUEST);

	        final long itemId = item.getId();

	        itemDAO.findById(itemId).orElseThrow(
	                () -> new APIException("Item not found", HttpStatus.NOT_FOUND)
	        );

	        Item item3 = itemDAO.save(dtoToEntity(item));

	        return entityToDto(item3);
	    }


	    public Long delete(String id) throws APIException {

	        final Item item = getItem(id);

	        itemDAO.delete(item);

	        return item.getId();
	    }

	    private Item entityToDto(Item item) {
	        return new Item(item.getId(), item.getName(), item.getRegionCode(), item.getRegionName());
	    }

	    private Item dtoToEntity(Item item) {
	        return new Item(item.getId(), item.getName(), item.getRegionCode(), item.getRegionName());
	    }

	    private Item dtoToEntityNoId(Item item) {
	        return new Item(item.getName(), item.getRegionCode(), item.getRegionName());
	    }

	    private boolean isItemValid(Item item) {
	        return item != null
	                && !Strings.isBlank(item.getName())
	                && !Strings.isBlank(item.getRegionCode());
	    }

	    private Item getItem(String id) throws APIException {
	        long itemId;

	        try {
	            itemId = Long.parseLong(id);

	        } catch (NumberFormatException e) {
	            throw new APIException("Item invalid", HttpStatus.BAD_REQUEST);
	        }

	        return itemDAO.findById(itemId).orElseThrow(() -> new APIException("Item not found", HttpStatus.NOT_FOUND));
	    }
}
