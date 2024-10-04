package com.msa.middleend.movements.service;

import com.msa.middleend.movements.domain.AccountMovement;
import com.msa.middleend.movements.domain.Movement;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface MovementService {
    ResponseEntity<AccountMovement> createMovement(Map<String, String> headers, Movement movement);

    ResponseEntity<List<AccountMovement>> findAllMovementsByAccountId(Map<String, String> headers, Long accountId);
}
