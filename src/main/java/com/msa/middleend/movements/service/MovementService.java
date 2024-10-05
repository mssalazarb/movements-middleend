package com.msa.middleend.movements.service;

import com.msa.middleend.movements.domain.AccountMovement;
import com.msa.middleend.movements.domain.Movement;

import java.util.List;
import java.util.Map;

public interface MovementService {
    AccountMovement createMovement(Map<String, String> headers, Movement movement);

    List<AccountMovement> findAllMovementsByAccountId(Map<String, String> headers, Long accountId);
}
