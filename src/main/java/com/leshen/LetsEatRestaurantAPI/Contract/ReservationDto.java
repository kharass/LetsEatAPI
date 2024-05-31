package com.leshen.LetsEatRestaurantAPI.Contract;

import java.util.List;

import com.leshen.LetsEatRestaurantAPI.Model.ReservedTables;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    
    @Schema(description = "Unique identifier for the reservation")
    private Long reservationId;

    @Schema(description = "Identifier for the restaurant to which the reservation belongs")
    private Long restaurantId;

    @Schema(description = "List of reserved tables")
    private List<ReservedTableDto> reservedTables;

}
