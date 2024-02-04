package com.invenstmentcalculator.investmentapp.dto;

import lombok.Getter;

@Getter
public class InvestmentResult {
    private final int month;
    private final double value;

    public InvestmentResult(int month, double value) {
        this.month = month;
        this.value = value;
    }

}
