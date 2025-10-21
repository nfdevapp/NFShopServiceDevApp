package org.nfshopservicedev.app.shop.order.model;
import java.util.List;

public record Order(int id, List<Integer> productIds) {}
