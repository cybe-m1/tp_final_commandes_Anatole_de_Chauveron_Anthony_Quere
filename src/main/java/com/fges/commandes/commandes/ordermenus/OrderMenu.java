package com.fges.commandes.commandes.ordermenus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_order_menu")
@IdClass(OrderMenuPrimaryKeys.class)
public class OrderMenu {

    @Id
    private Long orderId;
    @Id
    private Long menuId;

    int quantity;
}
