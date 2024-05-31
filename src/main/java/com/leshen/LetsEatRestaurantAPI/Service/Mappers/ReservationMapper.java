package com.leshen.LetsEatRestaurantAPI.Service.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.leshen.LetsEatRestaurantAPI.Contract.ReservationDto;
import com.leshen.LetsEatRestaurantAPI.Model.Reservation;

@Mapper(componentModel = "spring", uses = {RestaurantMapper.class, ReservedTableMapper.class})
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(target = "reservationId", ignore = true)
    @Mapping(target = "restaurant.restaurantId", source = "restaurantId")
    @Mapping(target = "reservedTables", source = "reservedTables")
    Reservation toEntity(ReservationDto reservationDto);

    @Mapping(source = "restaurant.restaurantId", target = "restaurantId")
    @Mapping(source = "reservedTables", target = "reservedTables")
    ReservationDto toDto(Reservation reservation);

    List<ReservationDto> toDtoList(List<Reservation> reservation);

    @Mapping(target = "reservationId", ignore = true)
    @Mapping(target = "restaurant.restaurantId", source = "restaurantId")
    @Mapping(target = "reservedTables", source = "reservedTables")
    void updateReservationFromDto(ReservationDto reservationDto, @MappingTarget Reservation reservation);

    @Mapping(target = "reservationId", ignore = true)
    @Mapping(target = "restaurant.restaurantId", source = "restaurantId")
    @Mapping(target = "reservedTables", source = "reservedTables")
    void patchReservationFromDto(ReservationDto reservationDto, @MappingTarget Reservation reservation);
}
