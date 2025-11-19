package com.example.macro_calculator.dtos;

import java.time.LocalDate;
import java.util.List;

public class DailyLogDto {

    private LocalDate date;
    private List<MealDto> meals;

    private double totalCalories;
    private double totalProteinGrams;
    private double totalCarbsGrams;
    private double totalFatsGrams;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<MealDto> getMeals() {
        return meals;
    }

    public void setMeals(List<MealDto> meals) {
        this.meals = meals;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public double getTotalProteinGrams() {
        return totalProteinGrams;
    }

    public void setTotalProteinGrams(double totalProteinGrams) {
        this.totalProteinGrams = totalProteinGrams;
    }

    public double getTotalCarbsGrams() {
        return totalCarbsGrams;
    }

    public void setTotalCarbsGrams(double totalCarbsGrams) {
        this.totalCarbsGrams = totalCarbsGrams;
    }

    public double getTotalFatsGrams() {
        return totalFatsGrams;
    }

    public void setTotalFatsGrams(double totalFatsGrams) {
        this.totalFatsGrams = totalFatsGrams;
    }
}
