package com.example.macro_calculator.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class MealDto {

    @NotBlank
    private String name;

    @PositiveOrZero
    private double calories;

    @PositiveOrZero
    private double proteinGrams;

    @PositiveOrZero
    private double fatGrams;

    @PositiveOrZero
    private double carbsGrams;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProteinGrams() {
        return proteinGrams;
    }

    public void setProteinGrams(double proteinGrams) {
        this.proteinGrams = proteinGrams;
    }

    public double getFatGrams() {
        return fatGrams;
    }

    public void setFatGrams(double fatGrams) {
        this.fatGrams = fatGrams;
    }

    public double getCarbsGrams() {
        return carbsGrams;
    }

    public void setCarbsGrams(double carbsGrams) {
        this.carbsGrams = carbsGrams;
    }
}
