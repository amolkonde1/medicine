package com.example.entity;

/*
 * Copyright © 2015 Sky plc All Rights reserved.
 * Please do not make your solution publicly available in any way e.g. post in forums or commit to GitHub.
 */

import java.util.Objects;

public class Medicine {
    public int id;
    public String name;
    public double price;
    public String manufacturer;
    public boolean availability;

    

    public Medicine() {
    }
    public Medicine(int id, String name, double price, String manufacturer, boolean availability) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.availability = availability;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public boolean isAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    @Override
	public int hashCode() {
		return Objects.hash(availability, id, manufacturer, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicine other = (Medicine) obj;
		return availability == other.availability && id == other.id && Objects.equals(manufacturer, other.manufacturer)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
    

}
