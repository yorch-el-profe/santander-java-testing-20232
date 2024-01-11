package org.bedu.sesion03.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private long id;
    private double amount;
}
