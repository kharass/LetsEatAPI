package com.leshen.LetsEatRestaurantAPI.Contract;

import com.leshen.LetsEatRestaurantAPI.Model.RestaurantCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    @Schema(description = "Unique identifier for the restaurant")
    private Long restaurantId;

    @Schema(description = "Token for authorization purposes", defaultValue = "your_token", example = "your_token")
    private String token;

    @Schema(description = "Restaurant's name", defaultValue = "Example restaurant", example = "Example restaurant")
    private String restaurantName;

    @Schema(description = "Restaurant's location", defaultValue = "80-894 Gdansk, Targ Drzewny 9/11", example = "(ZipCode) (City), (Street) (Number)")
    private String location;

    @Schema(description = "Restaurant's category")
    private RestaurantCategory restaurantCategory;

    @Schema(description = "Restaurant's opening hours", defaultValue = "10AM - 7PM", example = "10AM - 7PM")
    private String openingHours;

    @Schema(description = "Restaurant's photo link", defaultValue = "https://purohotel.pl/media/22nfhnuw/ph_gdansk_magari001.jpg?width=562&height=351&format=webp&rnd=133123860716900000", example = "https://purohotel.pl/media/22nfhnuw/ph_gdansk_magari001.jpg?width=562&height=351&format=webp&rnd=133123860716900000")
    private String photoLink;

    @Schema(description = "Restaurant's website link", defaultValue = "http://31.179.139.182:690/", example = "http://31.179.139.182:690/")
    private String websiteLink;

    @Schema(description = "Location longitude", defaultValue = "103.817356", example = "103.817356")
    private Double longitude;

    @Schema(description = "Location latitude", defaultValue = "25.60162", example = "25.60162")
    private Double latitude;

    @Schema(description = "Phone number", defaultValue = "213791169", example = "213791169")
    private String phoneNumber;

    @Schema(description = "isFavorite", defaultValue = "false", example = "false")
    private Boolean isFavorite;
}
