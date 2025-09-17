package co.edu.uniquindio.poo.main;
// package com.quindiofresh.main;

import co.edu.uniquindio.poo.catalog.ProductCatalog;
import co.edu.uniquindio.poo.model.Customer;
import co.edu.uniquindio.poo.model.Order;
import co.edu.uniquindio.poo.model.Product;
import co.edu.uniquindio.poo.payment.*;
import co.edu.uniquindio.poo.shipping.*;

import co.edu.uniquindio.poo.notification.NotificationService;
import co.edu.uniquindio.poo.payment.PaymentFactory;
import co.edu.uniquindio.poo.payment.PaymentMethod;

import co.edu.uniquindio.poo.notification.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(" Iniciando simulación de pedido en Quindío Fresh...");

        // 1. Singleton: Obtener la única instancia del catálogo y poblarla.
        ProductCatalog catalog = ProductCatalog.getInstance();
        catalog.addProduct(new Product("FRT-01", "Caja de Fresas", 8000));
        catalog.addProduct(new Product("VRD-02", "Bolsa de Tomates", 5000));
        catalog.addProduct(new Product("CFE-03", "Café Especial 500g", 25000));
        catalog.listProducts();
        
        // 2. Crear un cliente y un carrito de compras
        Customer customer = new Customer("Ana Pérez", "ana.perez@email.com", "3112223344");
        Map<Product, Integer> shoppingCart = new HashMap<>();
        shoppingCart.put(catalog.getProductBySku("FRT-01").get(), 2); // 2 cajas de fresas
        shoppingCart.put(catalog.getProductBySku("CFE-03").get(), 1); // 1 bolsa de café
        
        // 3. Builder: Construir un pedido con datos obligatorios y opcionales.
        System.out.println("\n  Construyendo el pedido con el patrón Builder...");
        Order order = new Order.OrderBuilder(customer, shoppingCart)
                .withShippingAddress("Calle Falsa 123, Armenia")
                .withSpecialNotes("Dejar en portería")
                .build();
        
        System.out.println(" Pedido creado exitosamente:");
        System.out.println(order);
        
        double orderTotal = order.getTotalAmount();
        System.out.println("Total de productos: $" + orderTotal);

        // 4. Factory Method: Procesar el pago.
        System.out.println("\n Procesando el pago con el patrón Factory Method...");
        PaymentFactory paymentFactory = new CreditCardPaymentFactory(); // Podría ser PsePaymentFactory
        PaymentMethod paymentMethod = paymentFactory.createPaymentMethod();
        paymentMethod.processPayment(orderTotal);
        
        // 5. Factory Method: Calcular el envío.
        System.out.println("\n Calculando el envío con el patrón Factory Method...");
        ShippingFactory shippingFactory = new co.edu.uniquindio.poo.shipping.StandardShippingFactory(); // Podría ser ExpressShippingFactory
        ShippingCalculator shippingCalculator = shippingFactory.createShippingCalculator();
        double shippingCost = shippingCalculator.calculateCost();
        
        System.out.println("Costo total final (productos + envío): $" + (orderTotal + shippingCost));
        
        // 6. Factory Method: Enviar notificación al cliente.
        System.out.println("\n Notificando al cliente con el patrón Factory Method...");
        NotificationFactory notificationFactory = new EmailNotificationFactory(); // Podría ser SmsNotificationFactory
        NotificationService notificationService = notificationFactory.createNotificationService();
        notificationService.sendNotification("¡Tu pedido ha sido confirmado y está en camino!");
        
        System.out.println("\n Simulación completada.");
    }
}