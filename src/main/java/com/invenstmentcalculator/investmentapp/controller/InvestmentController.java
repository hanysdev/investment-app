package com.invenstmentcalculator.investmentapp.controller;

import com.invenstmentcalculator.investmentapp.service.InvestmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InvestmentController {

    InvestmentService investmentService;
    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @GetMapping("/calculateInvestment")
    public String calculateInvestment(@RequestParam double initialAmount,
                                      @RequestParam double interestRate,
                                      @RequestParam int numberOfYears,
                                      @RequestParam int capitalizationFrequency,
                                      Model model) {


        model.addAttribute("results", investmentService.calculate(initialAmount, interestRate, numberOfYears, capitalizationFrequency));
        return "investmentChart";
    }
}

