package com.example.macro_calculator;

import com.example.macro_calculator.dtos.DailyLogDto;
import com.example.macro_calculator.dtos.MealDto;
import com.example.macro_calculator.services.DailyLogService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DailyLogServiceTests {

    private final DailyLogService dailyLogService = new DailyLogService();

    @Test
    public void shouldReturnEmptyDailyLogWhenNoMealIsAdded(){
        LocalDate date = LocalDate.of(2025, 11,19);
        DailyLogDto log = dailyLogService.getDailyLog(date);

        Assertions.assertEquals(date, log.getDate());
        Assertions.assertNotNull(log.getMeals());
        Assertions.assertTrue(log.getMeals().isEmpty());

        Assertions.assertEquals(0.0, log.getTotalCalories(), 0.001);
        Assertions.assertEquals(0.0, log.getTotalProteinGrams(), 0.001);
        Assertions.assertEquals(0.0, log.getTotalFatsGrams(), 0.001);
        Assertions.assertEquals(0.0, log.getTotalCarbsGrams(), 0.001);
    }

    @Test
    public void shouldCalculateTotalsForASingleMeal(){
        LocalDate date = LocalDate.of(2025,11,19);

        MealDto meal = new MealDto();
        meal.setName("Chicken and rice");
        meal.setCalories(800);
        meal.setCarbsGrams(90);
        meal.setProteinGrams(60);
        meal.setFatGrams(20);

        dailyLogService.addMeal(date,meal);

        DailyLogDto log = dailyLogService.getDailyLog(date);

        Assertions.assertEquals(1, log.getMeals().size());
        Assertions.assertEquals(800,log.getTotalCalories());
        Assertions.assertEquals(60,log.getTotalProteinGrams());
        Assertions.assertEquals(20,log.getTotalFatsGrams());
        Assertions.assertEquals(90,log.getTotalCarbsGrams());
    }

    @Test
    public void shouldCalculateTotalsForMultipleMealsOnSameDay(){
        LocalDate date = LocalDate.of(2025,11,19);

        MealDto breakfast = new MealDto();
        breakfast.setName("Breakfast");
        breakfast.setCalories(500);
        breakfast.setProteinGrams(15);
        breakfast.setFatGrams(50);
        breakfast.setCarbsGrams(30);

        MealDto lunch = new MealDto();
        lunch.setName("Lunch");
        lunch.setCalories(900);
        lunch.setProteinGrams(70);
        lunch.setFatGrams(25);
        lunch.setCarbsGrams(95);

        dailyLogService.addMeal(date,breakfast);
        dailyLogService.addMeal(date,lunch);
        DailyLogDto log = dailyLogService.getDailyLog(date);
        Assertions.assertEquals(2, log.getMeals().size());
        Assertions.assertEquals(1400, log.getTotalCalories());
        Assertions.assertEquals(85,log.getTotalProteinGrams());
        Assertions.assertEquals(75,log.getTotalFatsGrams());
        Assertions.assertEquals(125,log.getTotalCarbsGrams());

    }

    @Test
    public void shouldKeepLogsIndependentFromEachOther(){
        LocalDate date1 = LocalDate.of(2025,11,19);
        LocalDate date2 = LocalDate.of(2025,11,18);

        MealDto breakfast = new MealDto();
        breakfast.setName("Breakfast");
        breakfast.setCalories(500);
        breakfast.setProteinGrams(15);
        breakfast.setFatGrams(50);
        breakfast.setCarbsGrams(30);

        MealDto lunch = new MealDto();
        lunch.setName("Lunch");
        lunch.setCalories(900);
        lunch.setProteinGrams(70);
        lunch.setFatGrams(25);
        lunch.setCarbsGrams(95);

        dailyLogService.addMeal(date1,breakfast);
        dailyLogService.addMeal(date2,lunch);

        DailyLogDto log1 = dailyLogService.getDailyLog(date1);
        DailyLogDto log2 = dailyLogService.getDailyLog(date2);

        Assertions.assertEquals(1, log1.getMeals().size());
        Assertions.assertEquals(1, log2.getMeals().size());

        Assertions.assertEquals(500, log1.getTotalCalories());
        Assertions.assertEquals(900, log2.getTotalCalories());



    }
}
