package com.invenstmentcalculator.investmentapp.dto;

public class InvestmentResult {
    private int month;
    private double value;

    public InvestmentResult(int month, double value) {
        this.month = month;
        this.value = value;
    }

    public int getMonth() {
        return month;
    }

    public double getValue() {
        return value;
    }
}
