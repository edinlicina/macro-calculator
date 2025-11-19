package com.example.macro_calculator.controllers;

import com.example.macro_calculator.dtos.DailyLogDto;
import com.example.macro_calculator.dtos.MealDto;
import com.example.macro_calculator.services.DailyLogService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/days")
public class DailyLogController {

    private final DailyLogService dailyLogService;

    public DailyLogController(DailyLogService dailyLogService) {
        this.dailyLogService = dailyLogService;
    }

    @PostMapping("/{date}/meals")
    public void addMeal(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestBody @Valid MealDto meal) {
        dailyLogService.addMeal(date,meal);
    }

    @GetMapping("/{date}")
    public DailyLogDto getDailyLogDto(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return dailyLogService.getDailyLog(date);
    }
}
