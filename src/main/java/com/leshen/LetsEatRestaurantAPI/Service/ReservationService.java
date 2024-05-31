package com.leshen.LetsEatRestaurantAPI.Service;

import com.leshen.LetsEatRestaurantAPI.Contract.ReservationDto;
import com.leshen.LetsEatRestaurantAPI.Contract.ReservedTableDto;
import com.leshen.LetsEatRestaurantAPI.Model.Reservation;
import com.leshen.LetsEatRestaurantAPI.Model.ReservedTables;
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
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final ReservedTablesService reservedTablesService;
    private final ReservedTablesRepository reservedTablesRepository;

    public Long addReservation(ReservationDto reservationDto) {
        Reservation reservation = reservationMapper.toEntity(reservationDto);

        if (reservation.getReservedTables() != null) {
            for (ReservedTables reservedTable : reservation.getReservedTables()) {
                reservedTable.setReservation(reservation);
            }
        }

        reservation = reservationRepository.saveAndFlush(reservation);
        return reservation.getReservationId();
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<ReservationDto> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(reservationMapper::toDto)
                .collect(Collectors.toList());
    }

    public ReservationDto getReservationById(Long id) {
        return reservationRepository.findById(id)
                .map(reservationMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

}

