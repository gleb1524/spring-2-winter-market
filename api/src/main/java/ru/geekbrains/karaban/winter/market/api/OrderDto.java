package ru.geekbrains.karaban.winter.market.api;


import java.util.List;

public class OrderDto {
    public OrderDto(Long id, List<OrderItemDto> orderItemDtos, int totalPrice, String address, String phone) {
        this.id = id;
        this.orderItemDtos = orderItemDtos;
        this.totalPrice = totalPrice;
        this.address = address;
        this.phone = phone;
    }

    private Long id;

    public OrderDto() {
    }

    private List<OrderItemDto> orderItemDtos;

    private int totalPrice;

    private String address;

    private String phone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItemDto> getOrderItemDtos() {
        return orderItemDtos;
    }

    public void setOrderItemDtos(List<OrderItemDto> orderItemDtos) {
        this.orderItemDtos = orderItemDtos;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
