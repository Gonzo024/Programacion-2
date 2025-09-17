package co.edu.uniquindio.poo.model;
// package com.quindiofresh.model;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

public class Order {
    // Atributos obligatorios
    private final String id;
    private final LocalDate creationDate;
    private final Customer customer;
    private final Map<Product, Integer> products; // Producto y cantidad

    // Atributos opcionales
    private final String shippingAddress;
    private final String specialNotes;
    private final String discountCode;

    // Constructor privado que recibe el builder
    private Order(OrderBuilder builder) {
        this.id = UUID.randomUUID().toString();
        this.creationDate = LocalDate.now();
        this.customer = builder.customer;
        this.products = builder.products;
        this.shippingAddress = builder.shippingAddress;
        this.specialNotes = builder.specialNotes;
        this.discountCode = builder.discountCode;
    }
    
    public double getTotalAmount() {
        return products.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    @Override
    public String toString() {
        return "Order{" + "\n" +
                "  id='" + id + '\'' + ",\n" +
                "  creationDate=" + creationDate + ",\n" +
                "  customer=" + customer + ",\n" +
                "  products=" + products.size() + " items,\n" +
                "  shippingAddress='" + (shippingAddress != null ? shippingAddress : "N/A") + '\'' + ",\n" +
                "  specialNotes='" + (specialNotes != null ? specialNotes : "N/A") + '\'' + ",\n" +
                "  discountCode='" + (discountCode != null ? discountCode : "N/A") + '\'' + ",\n" +
                "  totalAmount=" + getTotalAmount() + "\n" +
                '}';
    }

    /**
     * Patrón Builder: Permite construir un objeto complejo paso a paso.
     * Separa la construcción de un objeto de su representación.
     */
    public static class OrderBuilder {
        // Atributos obligatorios
        private final Customer customer;
        private final Map<Product, Integer> products;

        // Atributos opcionales
        private String shippingAddress;
        private String specialNotes;
        private String discountCode;

        public OrderBuilder(Customer customer, Map<Product, Integer> products) {
            this.customer = customer;
            this.products = products;
        }

        public OrderBuilder withShippingAddress(String address) {
            this.shippingAddress = address;
            return this; // Permite encadenar métodos
        }

        public OrderBuilder withSpecialNotes(String notes) {
            this.specialNotes = notes;
            return this;
        }

        public OrderBuilder withDiscountCode(String code) {
            this.discountCode = code;
            return this;
        }

        public Order build() {
            // Aquí se podrían agregar validaciones antes de crear el objeto
            return new Order(this);
        }
    }
}
