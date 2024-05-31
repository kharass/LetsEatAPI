package com.leshen.LetsEatRestaurantAPI.Service.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.leshen.LetsEatRestaurantAPI.Contract.ReservedTableDto;
import com.leshen.LetsEatRestaurantAPI.Model.ReservedTables;

@Mapper(componentModel = "spring", uses = RestaurantMapper.class)
public interface ReservedTableMapper {
    ReservedTableMapper INSTANCE = Mappers.getMapper(ReservedTableMapper.class);

    @Mapping(target = "restaurant.restaurantId", source = "restaurantId")
    ReservedTables toEntity(ReservedTableDto reservedTableDto);

    @Mapping(source = "restaurant.restaurantId", target = "restaurantId")
    ReservedTableDto toDto(ReservedTables reservedTables);

    List<ReservedTableDto> toDtoList(List<ReservedTables> reservedTables);

    @Mapping(target = "restaurant.restaurantId", source = "restaurantId")
    @Mapping(target = "reservation", ignore = true) 
    void updateReservedTableFromDto(ReservedTableDto reservedTableDto, @MappingTarget ReservedTables reservedTable);

    @Mapping(target = "restaurant.restaurantId", source = "restaurantId")
    @Mapping(target = "reservation", ignore = true) 
    void patchReservedTableFromDto(ReservedTableDto reservedTableDto, @MappingTarget ReservedTables reservedTables);
}

