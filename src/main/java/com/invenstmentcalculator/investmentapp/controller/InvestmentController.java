package com.invenstmentcalculator.investmentapp.controller;

import com.invenstmentcalculator.investmentapp.dto.InvestmentResult;
import com.invenstmentcalculator.investmentapp.service.InvestmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class InvestmentController {

    InvestmentService investmentService;
    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @GetMapping("/calculateInvestmentChart")
    public String calculateInvestmentChart(@RequestParam double initialAmount,
                                      @RequestParam double interestRate,
                                      @RequestParam int numberOfYears,
                                      @RequestParam int capitalizationFrequency,
                                      Model model) {


        model.addAttribute("results", investmentService.calculate(initialAmount, interestRate, numberOfYears, capitalizationFrequency));
        return "investmentChart";
    }

    @GetMapping("/calculateInvestment")
    public ResponseEntity<List<InvestmentResult>> calculateInvestment(@RequestParam double initialAmount,
                                                                     @RequestParam double interestRate,
                                                                     @RequestParam int numberOfYears,
                                                                     @RequestParam int capitalizationFrequency) {
        return new ResponseEntity<>(investmentService.calculate(initialAmount, interestRate, numberOfYears, capitalizationFrequency), HttpStatus.OK);
    }

}

