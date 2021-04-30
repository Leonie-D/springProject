package org.lfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.lfc.entity.Item;
import org.lfc.exception.APIException;
import org.lfc.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService itemService;
    
	@PostMapping(path = "/post/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> postItem(@PathVariable String name) throws APIException
	{
		return ResponseEntity.status(HttpStatus.OK).body(itemService.create(new Item(name)));
	}

	@GetMapping
	public ResponseEntity<List<Item>> getAllItems()
	{
		return ResponseEntity.status(HttpStatus.OK).body(itemService.getAll());
	}

    @GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItem(@PathVariable String id) throws APIException {
		return ResponseEntity.status(HttpStatus.OK).body(itemService.get(id));
    }

	@DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> deleteItem(@PathVariable String id) throws APIException {
		return ResponseEntity.status(HttpStatus.OK).body(itemService.delete(id));
    }

}