package org.nfshopservicedev.app.shop.order.model;
import java.util.Map;

public record Order(String id, Map<String, Integer> productQuantities, double totalSum) {}
