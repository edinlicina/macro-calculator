package com.example.macro_calculator.services;

import com.example.macro_calculator.dtos.DailyLogDto;
import com.example.macro_calculator.dtos.MealDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class DailyLogService {

    private final Map<LocalDate, List<MealDto>> mealsByDate = new HashMap<>(); //DB substitute

    public void addMeal(LocalDate date, MealDto meal){
        List<MealDto> meals = mealsByDate.computeIfAbsent(date, d -> new ArrayList<>());
        meals.add(meal);
    }

    public DailyLogDto getDailyLog(LocalDate date){
        List<MealDto> meals = mealsByDate.getOrDefault(date, Collections.emptyList());

        double totalCalories = 0;
        double totalProtein = 0;
        double totalFat = 0;
        double totalCarbs = 0;

        for (MealDto meal: meals){
            totalCalories += meal.getCalories();
            totalProtein += meal.getProteinGrams();
            totalFat += meal.getFatGrams();
            totalCarbs += meal.getCarbsGrams();
        }
        DailyLogDto dto = new DailyLogDto();
        dto.setDate(date);
        dto.setMeals(meals);
        dto.setTotalCalories(totalCalories);
        dto.setTotalProteinGrams(totalProtein);
        dto.setTotalFatsGrams(totalFat);
        dto.setTotalCarbsGrams(totalCarbs);

        return dto;
    }




}
