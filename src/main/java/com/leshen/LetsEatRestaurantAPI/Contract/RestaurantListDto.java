package com.leshen.LetsEatRestaurantAPI.Contract;

import com.leshen.LetsEatRestaurantAPI.Model.RestaurantCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
public class RestaurantListDto {

    @Schema(description = "Unique identifier for the restaurant")
    private Long restaurantId;

    @Schema(description = "Restaurant's name", defaultValue = "Example restaurant", example = "Example restaurant")
    private String restaurantName;

    @Schema(description = "Restaurant's category")
    private RestaurantCategory restaurantCategory;

    @Schema(description = "Restaurant's opening hours", defaultValue = "00:00 - 00:00", example = "10:00 - 19:00")
    private String openingHours;

    @Schema(description = "Restaurant's photo link", defaultValue = "https://purohotel.pl/media/22nfhnuw/ph_gdansk_magari001.jpg?width=562&height=351&format=webp&rnd=133123860716900000", example = "https://purohotel.pl/media/22nfhnuw/ph_gdansk_magari001.jpg?width=562&height=351&format=webp&rnd=133123860716900000")
    private String photoLink;

    @Schema(description = "Location longitude", defaultValue = "00.00", example = "103.817356")
    private Double longitude;

    @Schema(description = "Location latitude", defaultValue = "00.00", example = "25.60162")
    private Double latitude;

    @Schema(description = "Distance form user to restaurant", defaultValue = "0.0 km", example = "0.76 km")
    private String distance;

    @Schema(description = "List of available tables")
    private List<TableDto> tables;

    @Schema(description = "isFavorite", defaultValue = "false", example = "false")
    private Boolean isFavorite;


    @Setter
    @Getter
    @Schema(description = "Calculated rating of restaurant", minimum = "1", maximum = "5")
    private double stars;
}