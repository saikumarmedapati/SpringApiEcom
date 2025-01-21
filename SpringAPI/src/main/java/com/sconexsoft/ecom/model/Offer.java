package com.sconexsoft.ecom.model;

public class Offer {

    private Long id;                    // Offer ID (Primary Key)
    private String name;                // Offer Name
    private String description;         // Offer Description
    private double discount_percentage; // Discount Percentage

    // Constructor using fields
    public Offer(Long id, String name, String description, double discount_percentage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.discount_percentage = discount_percentage;
    }

    // Default Constructor
    public Offer() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscountPercentage() {
        return discount_percentage;
    }

    public void setDiscountPercentage(double discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    // toString method
    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", discount_percentage=" + discount_percentage +
                '}';
    }
}
