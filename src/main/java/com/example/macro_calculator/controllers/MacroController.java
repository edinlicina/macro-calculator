package com.example.macro_calculator.controllers;

import com.example.macro_calculator.dtos.MacroResultDto;
import com.example.macro_calculator.dtos.UserProfileDto;
import com.example.macro_calculator.services.MacroCalculatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/macros")
public class MacroController {

    private final MacroCalculatorService macroCalculatorService;

    public MacroController(MacroCalculatorService macroCalculatorService){
        this.macroCalculatorService = macroCalculatorService;
    }

    @PostMapping("/calculate")
    public MacroResultDto calculate(@RequestBody UserProfileDto profile){
        return macroCalculatorService.calculate(profile);
    }

}
