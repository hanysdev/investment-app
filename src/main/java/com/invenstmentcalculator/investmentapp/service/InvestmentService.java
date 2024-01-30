package com.invenstmentcalculator.investmentapp.service;

import com.invenstmentcalculator.investmentapp.dto.InvestmentResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvestmentService {

    public List<InvestmentResult> calculate(double initialAmount,
                            double interestRate,
                            int numberOfYears,
                            int capitalizationFrequency){
        List<InvestmentResult> results = new ArrayList<>();
        double currentAmount = initialAmount;

        for (int month = 1; month <= numberOfYears * 12; month++) {
            if (capitalizationFrequency > 0 && month % capitalizationFrequency == 0) {
                currentAmount = calculateInvestmentValue(currentAmount, interestRate, 1 / (12.0/capitalizationFrequency));
            }
            results.add(new InvestmentResult(month, currentAmount));
        }
        return results;
    }

    private double calculateInvestmentValue(double initialAmount, double interestRate, double numberOfYears) {
        return initialAmount * Math.pow(1 + interestRate / 100 / 12, numberOfYears * 12);
    }


}
