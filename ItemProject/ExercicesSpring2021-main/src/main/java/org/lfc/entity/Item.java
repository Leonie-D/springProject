package org.lfc.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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


	public Item(Long id, String name, String regionCode, String regionName) {
		this.id = id ;
		this.name = name;
        this.regionCode = regionCode;
        this.regionName = regionName;
	}

	public Item(String name2, String regionCode2, String regionName2) {
		this.name = name2;
        this.regionCode = regionCode2;
        this.regionName = regionName2;
	}

	public Item(String name3) {
		this.name = name3;
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
