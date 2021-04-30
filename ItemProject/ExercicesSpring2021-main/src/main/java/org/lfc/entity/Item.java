package org.lfc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
	
	protected @Id @GeneratedValue Long id;

	protected String name;

	public Item(String name)
	{
		this.name = name;

	}

	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.id = id ;
	}
	
	public String getName() {
		return name ;
	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name ;
	}
}
