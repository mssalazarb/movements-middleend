package com.msa.middleend.movements.domain;

import com.msa.middleend.movements.enums.TypeMovementEnum;
import lombok.Data;

@Data
public class AccountMovement {
    private Long id;
    private TypeMovementEnum typeMovement;
    private Double amount;
}
