package com.fges.commandes.commandes.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateOrderRequestDto {
    private Long customerId;
    private Long truckId;
}
