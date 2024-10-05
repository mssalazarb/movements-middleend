package com.msa.middleend.movements.service.impl;

import com.msa.middleend.movements.client.MovementsServiceClient;
import com.msa.middleend.movements.domain.AccountMovement;
import com.msa.middleend.movements.domain.Movement;
import com.msa.middleend.movements.service.MovementService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MovementServiceImpl implements MovementService {

    private final MovementsServiceClient movementsServiceClient;

    @Override
    @CircuitBreaker(name = "movementsService", fallbackMethod = "fallbackCreateMovement")
    public AccountMovement createMovement(Map<String, String> headers, Movement movement) {
        return this.movementsServiceClient.createMovement(headers, movement).getBody();
    }

    private ResponseEntity<String> fallbackCreateMovement() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error creating movement");
    }

    @Override
    @CircuitBreaker(name = "movementsService", fallbackMethod = "fallbackFindMovements")
    public List<AccountMovement> findAllMovementsByAccountId(Map<String, String> headers, Long accountId) {
        return this.movementsServiceClient.findAllMovementsByAccountId(headers, accountId).getBody();
    }
    private ResponseEntity<String> fallbackFindMovements() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error getting movements");
    }

}
