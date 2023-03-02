package ru.geekbrains.karaban.winter.market.api;


public class OrderData {
    private String address;
    private String phone;

    public OrderData() {
    }

    public OrderData(String address, String phone) {
        this.address = address;
        this.phone = phone;
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
