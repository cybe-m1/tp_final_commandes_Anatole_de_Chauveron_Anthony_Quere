package com.fges.commandes.commandes.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TotalAmountResponseDto {
    private float price;
    private float tva;
    private float total;
}
