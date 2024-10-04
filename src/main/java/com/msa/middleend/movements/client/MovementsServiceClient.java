package com.msa.middleend.movements.client;

import com.msa.middleend.movements.domain.AccountMovement;
import com.msa.middleend.movements.domain.Movement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(url = "${microservices.url}/api/v1/movements-service/movements" , name = "movementsServiceClient")
public interface MovementsServiceClient {
    @PostMapping()
    ResponseEntity<AccountMovement> createMovement (@RequestHeader Map<String, String> headers,
                                                     @RequestBody Movement movement);

    @GetMapping()
    ResponseEntity<List<AccountMovement>> findAllMovementsByAccountId (@RequestHeader Map<String, String> headers,
                                                                       @RequestParam Long accountId);
}
