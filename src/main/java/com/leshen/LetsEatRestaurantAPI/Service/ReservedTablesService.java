package com.leshen.LetsEatRestaurantAPI.Service;

import com.leshen.LetsEatRestaurantAPI.Contract.ReservationDto;
import com.leshen.LetsEatRestaurantAPI.Contract.ReservedTableDto;
import com.leshen.LetsEatRestaurantAPI.Contract.TableDto;
import com.leshen.LetsEatRestaurantAPI.Model.Reservation;
import com.leshen.LetsEatRestaurantAPI.Model.ReservedTables;
import com.leshen.LetsEatRestaurantAPI.Model.Tables;
import com.leshen.LetsEatRestaurantAPI.Repository.ReservationRepository;
import com.leshen.LetsEatRestaurantAPI.Repository.ReservedTablesRepository;
import com.leshen.LetsEatRestaurantAPI.Service.Mappers.ReservationMapper;
import com.leshen.LetsEatRestaurantAPI.Service.Mappers.ReservedTableMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservedTablesService {

    private final ReservedTablesRepository reservedTablesRepository;
    private final ReservationRepository reservationRepository;
    private final ReservedTableMapper reservedTableMapper;

    public Long createReservedTable(ReservedTableDto reservedTableDto) {
        ReservedTables newTable = reservedTableMapper.toEntity(reservedTableDto);
        return reservedTablesRepository.save(newTable).getTableId();
    }

    public void deleteReservedTable(Long tableId) {
        reservedTablesRepository.deleteById(tableId);
    }

    public List<ReservedTableDto> getAllReservedTables() {
        return reservedTablesRepository.findAll().stream()
                .map(reservedTableMapper::toDto) 
                .collect(Collectors.toList());
    }

    public ReservedTableDto getReservedTableById(Long id) {
        return reservedTablesRepository.findById(id)
                .map(reservedTableMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Reserved table not found"));
    }
    

    public ReservedTableDto addExistingReservedTableToReservation(Long reservationId, Long tableId) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            
            Optional<ReservedTables> optionalReservedTable = reservedTablesRepository.findById(tableId);
            if (optionalReservedTable.isPresent()) {
                ReservedTables existingReservedTable = optionalReservedTable.get();
                existingReservedTable.setReservation(reservation);
                existingReservedTable.setRestaurant(reservation.getRestaurant());
                reservedTablesRepository.save(existingReservedTable);
                
                reservation.getReservedTables().add(existingReservedTable);
                reservationRepository.save(reservation);
                
                return convertToDto(existingReservedTable);
            } else {
                throw new RuntimeException("Table not found");
            }
        } else {
            throw new RuntimeException("Reservation not found");
        }
    }
    
    private ReservedTableDto convertToDto(ReservedTables reservedTable) {
        return new ReservedTableDto(
            reservedTable.getTableId(),
            reservedTable.getRestaurant().getRestaurantId(),
            reservedTable.getToken(),
            reservedTable.getSize()
        );
    }
    
    
    
    
    
}
