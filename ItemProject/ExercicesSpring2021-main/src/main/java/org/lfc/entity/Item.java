package org.lfc.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@Entity
@NoArgsConstructor
public class Item {

    @GeneratedValue
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String regionCode;

    @Column
    private String regionName;

	public Item(Long id, String name) {
		this.id = id ;
		this.name = name;
	}

	public Item(String name) {
		this.name = name;
	}

	public String getRegionCode() {
		// TODO Auto-generated method stub
		return regionCode;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getRegionName() {
		// TODO Auto-generated method stub
		return regionName;
	}

}
