package com.springboot.jpa.data.dto;

public class ProductResponseDto {

    private Long number;
    private String name;
    private int price;
    private int stock;
    
    public ProductResponseDto() {}

    public ProductResponseDto(Long number, String name, int price, int stock){
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //필요에 따라 빌더 메서드와 hashCode/equals 메서드도 추가할 수 있다. 빌더 메서드는 빌더(Builder) 패턴을 따르는 메서드이다.


}
