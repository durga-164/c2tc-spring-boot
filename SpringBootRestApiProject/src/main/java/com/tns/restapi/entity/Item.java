package com.tns.restapi.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private LocalDate manufacturing;

    @Column
    private LocalDate expiry;

    @Column
    private float price;

    @Column
    private String category;

    // Default constructor (no-argument)
    public Item() {
        // Initialize default values if needed
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getManufacturing() {
		return manufacturing;
	}

	public void setManufacturing(LocalDate manufacturing) {
		this.manufacturing = manufacturing;
	}

	public LocalDate getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Item(String name, LocalDate manufacturing, LocalDate expiry, float price, String category) {
        this.name = name;
        this.manufacturing = manufacturing;
        this.expiry = expiry;
        this.price = price;
        this.category = category;
    }

    // Getter and setter methods...

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", manufacturing=" + manufacturing + ", expiry=" + expiry
                + ", price=" + price + ", category=" + category + "]";
    }
}
