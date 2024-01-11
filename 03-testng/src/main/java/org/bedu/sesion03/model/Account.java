package org.bedu.sesion03.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private long id;
    private double amount;
}
