package co.edu.uniquindio.poo.catalog;
// package com.quindiofresh.catalog;

import co.edu.uniquindio.poo.model.Product;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Patrón Singleton: Garantiza una única instancia del catálogo de productos.
 * Proporciona un punto de acceso global y controlado a los productos.
 */
public class ProductCatalog {
    // 1. Instancia única y estática de la clase.
    private static final ProductCatalog INSTANCE = new ProductCatalog();
    
    private final Map<String, Product> products = new HashMap<>();

    // 2. Constructor privado para evitar la creación de instancias desde fuera.
    private ProductCatalog() {}

    // 3. Método público y estático para obtener la única instancia.
    public static ProductCatalog getInstance() {
        return INSTANCE;
    }

    public void addProduct(Product product) {
        products.put(product.getSku(), product);
    }

    public Optional<Product> getProductBySku(String sku) {
        return Optional.ofNullable(products.get(sku));
    }


    public void listProducts() {
        System.out.println("--- Catálogo de Productos Disponibles ---");
        products.values().forEach(System.out::println);
        System.out.println("--------------------------------------");
    }
}
