package com.example.macro_calculator.services;

import com.example.macro_calculator.dtos.MacroResultDto;
import com.example.macro_calculator.dtos.UserProfileDto;
import org.springframework.stereotype.Service;

@Service
public class MacroCalculatorService {

    public MacroResultDto calculate(UserProfileDto profile) {

        double bmr = calculateBmr(profile);
        double tdee = calculateTdee(bmr, profile.getActivityLevel());
        double caloriesTarget = adjustForGoal(tdee, profile.getGoal());

        MacroResultDto result = new MacroResultDto();
        result.setBmr(bmr);
        result.setTdee(tdee);
        result.setCaloriesPerDay(caloriesTarget);

        double proteinCalories = caloriesTarget * 0.30;
        double fatCalories = caloriesTarget * 0.25;
        double carbsCalories = caloriesTarget * 0.45;

        result.setProteinGramsPerDay(proteinCalories /4);
        result.setFatGramsPerDay(fatCalories /9);
        result.setCarbsGramsPerDay(carbsCalories /4);

        return result;

    }

    public double calculateBmr(UserProfileDto profile) {
        double weight = profile.getWeight();
        double height = profile.getHeight();
        int age = profile.getAge();

        if ("MALE".equalsIgnoreCase(profile.getSex())) {
            return 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            return 10 * weight + 6.25 * height - 5 * age - 161;
        }
    }

    public double calculateTdee(double bmr, String activityLevel) {
        String level = activityLevel.toUpperCase();
        double factor = switch (level) {
            case "SEDENTARY" -> 1.2;
            case "LIGHT" -> 1.375;
            case "MODERATE" -> 1.55;
            case "ACTIVE" -> 1.725;
            case "VERY_ACTIVE" -> 1.9;
            default -> 1.2;
        };
        return bmr * factor;
    }

    public double adjustForGoal(double tdee, String goal) {
        String g = goal.toUpperCase();
        return switch (g) {
            case "LOSE" -> tdee - 500;
            case "GAIN" -> tdee + 300;
            default -> tdee;
        };
    }
}
