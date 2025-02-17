package com.example.coffee.dtos;


public interface CakeDto {
String getName();
String getDescription();
String getImageUrl();
long getPrice();
void setName(String name);
void setImageUrl(String imageUrl);
void setPrice(long price);
void setDescription(String description);
}