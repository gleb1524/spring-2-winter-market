package ru.geekbrains.karaban.winter.market.api;


public class OrderItemDto {
    private Long id;

    private Long productId;

    private Long orderId;

    private int quantity;

    private int pricePerProduct;

    private int price;

    public OrderItemDto(Long id, Long productId, Long orderId, int quantity, int pricePerProduct, int price) {
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.pricePerProduct = pricePerProduct;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPricePerProduct() {
        return pricePerProduct;
    }

    public void setPricePerProduct(int pricePerProduct) {
        this.pricePerProduct = pricePerProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    public OrderItemDto(OrderItem orderItem) {
//        this.id = orderItem.getId();
//        this.productId = orderItem.getProduct().getId();
//        this.orderId = orderItem.getOrder().getId();
//        this.quantity = orderItem.getQuantity();
//        this.pricePerProduct = orderItem.getPricePerProduct();
//        this.price = orderItem.getPrice();
//    }
}
