package com.invenstmentcalculator.investmentapp.controller;

import com.invenstmentcalculator.investmentapp.dto.InvestmentResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InvestmentController {

    @GetMapping("/calculateInvestment")
    public String calculateInvestment(@RequestParam double initialAmount,
                                      @RequestParam double interestRate,
                                      @RequestParam int numberOfYears,
                                      @RequestParam int capitalizationFrequency,
                                      Model model) {
        List<InvestmentResult> results = new ArrayList<>();

        for (int month = 1; month <= numberOfYears * 12; month++) {
            double result;
            if (capitalizationFrequency > 0 && month % capitalizationFrequency == 0) {
                result = calculateInvestmentValue(initialAmount, interestRate, month / 12.0);
            } else {
                result = calculateInvestmentValueWithoutCapitalization(initialAmount, interestRate, month / 12.0);
            }
            results.add(new InvestmentResult(month, result));
        }

        model.addAttribute("results", results);
        return "investmentChart";
    }

    private double calculateInvestmentValue(double initialAmount, double interestRate, double numberOfYears) {
        return initialAmount * Math.pow(1 + interestRate / 100, numberOfYears);
    }

    private double calculateInvestmentValueWithoutCapitalization(double initialAmount, double interestRate, double numberOfYears) {
        return initialAmount * Math.pow(1 + interestRate / 100 / 12, numberOfYears * 12);
    }
}

