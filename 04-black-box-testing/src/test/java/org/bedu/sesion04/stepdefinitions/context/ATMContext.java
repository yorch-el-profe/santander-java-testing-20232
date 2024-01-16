package org.bedu.sesion04.stepdefinitions.context;

import org.bedu.sesion04.ATM;
import org.bedu.sesion04.model.Card;

import lombok.Data;

@Data
public class ATMContext {
    private ATM atm;
    private Card card;
}
