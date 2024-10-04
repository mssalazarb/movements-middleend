package com.msa.middleend.movements.service.impl;

import com.msa.middleend.movements.client.MovementsServiceClient;
import com.msa.middleend.movements.domain.AccountMovement;
import com.msa.middleend.movements.domain.Movement;
import com.msa.middleend.movements.service.MovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MovementServiceImpl implements MovementService {

    private final MovementsServiceClient movementsServiceClient;

    @Override
    public ResponseEntity<AccountMovement> createMovement(Map<String, String> headers, Movement movement) {
        return this.movementsServiceClient.createMovement(headers, movement);
    }

    @Override
    public ResponseEntity<List<AccountMovement>> findAllMovementsByAccountId(Map<String, String> headers, Long accountId) {
        return this.movementsServiceClient.findAllMovementsByAccountId(headers, accountId);
    }
}
