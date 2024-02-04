package com.invenstmentcalculator.investmentapp.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InvestmentServiceTest {

    @Test
    void calculateInvestmentValue_WithValidInput_ReturnsCorrectValue() {

        InvestmentService investmentService = new InvestmentService();
        double initialAmount = 1000;
        double interestRate = 5;
        double numberOfYears = 2;

        double result = investmentService.calculateInvestmentValue(initialAmount, interestRate, numberOfYears);

        double expectedValue = initialAmount * Math.pow(1 + interestRate / 100 / 12, numberOfYears * 12);
        assertEquals(expectedValue, result);
    }
}
