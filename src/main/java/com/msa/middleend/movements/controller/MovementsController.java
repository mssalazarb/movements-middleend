package com.msa.middleend.movements.controller;

import com.msa.middleend.movements.domain.AccountMovement;
import com.msa.middleend.movements.domain.Movement;
import com.msa.middleend.movements.service.MovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/movements")
@RequiredArgsConstructor
public class MovementsController {

    private final MovementService movementService;

    @PostMapping
    @CrossOrigin
    public ResponseEntity<AccountMovement> createCustomer(@RequestHeader Map<String, String> headers, @RequestBody Movement movement) {
        return new ResponseEntity<>(this.movementService.createMovement(headers, movement), HttpStatus.CREATED);
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<AccountMovement>> createCustomer(@RequestHeader Map<String, String> headers, @RequestParam Long accountId) {
        return new ResponseEntity<>(this.movementService.findAllMovementsByAccountId(headers, accountId), HttpStatus.OK);
    }
}
