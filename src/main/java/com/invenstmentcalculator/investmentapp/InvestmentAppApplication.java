package com.invenstmentcalculator.investmentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class InvestmentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestmentAppApplication.class, args);
	}
}
