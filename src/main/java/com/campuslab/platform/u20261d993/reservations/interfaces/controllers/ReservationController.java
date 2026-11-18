package com.campuslab.platform.u20261d993.reservations.interfaces.controllers;

import com.campuslab.platform.u20261d993.reservations.application.commandservices.ReservationCommandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/equipment-reservations", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Equipment Reservations", description = "Equipment reservation management endpoints")
public class ReservationController {
    private final ReservationCommandService reservationCommandService;

    public ReservationController(ReservationCommandService reservationCommandService) {
        this.reservationCommandService = reservationCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a new equipment reservation", description = "Creates a new equipment reservation based on the provided details.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Reservation created successfully and iD"),
            @ApiResponse(responseCode = "400", description = "Information submitted invalid"),
            @ApiResponse(responseCode = "409", description = "Reservation Code Duplicated"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
}
