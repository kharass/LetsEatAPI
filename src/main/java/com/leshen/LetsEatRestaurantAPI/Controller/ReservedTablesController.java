package com.leshen.LetsEatRestaurantAPI.Controller;

import com.leshen.LetsEatRestaurantAPI.Contract.ReservationDto;
import com.leshen.LetsEatRestaurantAPI.Contract.ReservedTableDto;
import com.leshen.LetsEatRestaurantAPI.Contract.TableDto;
import com.leshen.LetsEatRestaurantAPI.Model.ReservedTables;
import com.leshen.LetsEatRestaurantAPI.Service.ReservedTablesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/reservedTables")
public class ReservedTablesController {

    private final ReservedTablesService reservedTablesService;

    @Autowired
    public ReservedTablesController(ReservedTablesService reservedTablesService) {
        this.reservedTablesService = reservedTablesService;
    }

    @PostMapping
    public ResponseEntity<Long> addReservedTable(@RequestBody ReservedTableDto reservedTableDto) {
        Long id = reservedTablesService.createReservedTable(reservedTableDto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @DeleteMapping("/{tableId}")
    public void deleteReservedTable(@PathVariable Long tableId) {
        reservedTablesService.deleteReservedTable(tableId);
    }

    @GetMapping
    public ResponseEntity<List<ReservedTableDto>> getAllReservedTables() {
        List<ReservedTableDto> reservedTables = reservedTablesService.getAllReservedTables();
        return new ResponseEntity<>(reservedTables, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservedTableDto> getReservedTableById(@PathVariable Long id) {
        ReservedTableDto reservedTable = reservedTablesService.getReservedTableById(id);
        return new ResponseEntity<>(reservedTable, HttpStatus.OK);
    }

    @PostMapping("/addExistingToReservation/{reservationId}/{tableId}")
    public ResponseEntity<ReservedTableDto> addExistingReservedTableToReservation(@PathVariable Long reservationId, @PathVariable Long tableId) {
        ReservedTableDto reservedTableDto = reservedTablesService.addExistingReservedTableToReservation(reservationId, tableId);
        return new ResponseEntity<>(reservedTableDto, HttpStatus.CREATED);
}

}