package com.example.macro_calculator;

import com.example.macro_calculator.dtos.MacroResultDto;
import com.example.macro_calculator.dtos.UserProfileDto;
import com.example.macro_calculator.enums.ActivityLevel;
import com.example.macro_calculator.enums.Goal;
import com.example.macro_calculator.enums.Sex;
import com.example.macro_calculator.services.MacroCalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MacroCalculatorServiceTests {

    private final MacroCalculatorService service = new MacroCalculatorService();

    @Test
    public void shouldCalculateBmrForMaleCorrectly(){
        UserProfileDto profile = new UserProfileDto();
        profile.setAge(24);
        profile.setSex(Sex.MALE);
        profile.setHeight(190);
        profile.setWeight(160);
        double bmr = service.calculateBmr(profile);

        Assertions.assertEquals(2672.5, bmr, 0.1);
    }

    @Test
    public void shouldApplyActivityMultiplierCorrectly(){
        double bmr = 2000;
        double tdee = service.calculateTdee(bmr, ActivityLevel.LIGHT);

        Assertions.assertEquals(2750, tdee, 0.1);
    }
    @Test
    public void shouldAdjustCaloriesForLoss(){
        double tdee = 3000;
        double adjustedCalculation = service.adjustForGoal(tdee, Goal.LOSE);

        Assertions.assertEquals(2500, adjustedCalculation, 0.1);
    }
    @Test
    public void shouldCalculateFullMacroResult(){
        UserProfileDto profile = new UserProfileDto();
        profile.setAge(24);
        profile.setSex(Sex.MALE);
        profile.setHeight(190);
        profile.setWeight(160);
        profile.setActivityLevel(ActivityLevel.LIGHT);
        profile.setGoal(Goal.LOSE);

        MacroResultDto result = service.calculate(profile);


        Assertions.assertEquals(2672.5, result.getBmr(), 0.1); //BMR
        Assertions.assertEquals(3674.687, result.getTdee(), 0.1); //TDEE
        Assertions.assertEquals( 3174.687,result.getCaloriesPerDay(),0.1);//CALORIES PER DAY

        Assertions.assertEquals(238.10, result.getProteinGramsPerDay(), 0.5);
        Assertions.assertEquals(88.18, result.getFatGramsPerDay(), 0.5);
        Assertions.assertEquals(357.152, result.getCarbsGramsPerDay(), 0.5);

    }
    @Test
    public void shouldCalculateFullMacroResultForFemale(){
        UserProfileDto profile = new UserProfileDto();
        profile.setAge(24);
        profile.setSex(Sex.FEMALE);
        profile.setHeight(190);
        profile.setWeight(160);
        profile.setActivityLevel(ActivityLevel.LIGHT);
        profile.setGoal(Goal.LOSE);

        MacroResultDto result = service.calculate(profile);


        Assertions.assertEquals(2506.5, result.getBmr(), 0.1); //BMR
        Assertions.assertEquals(3446.437, result.getTdee(), 0.1); //TDEE
        Assertions.assertEquals( 2946.437,result.getCaloriesPerDay(),0.1);//CALORIES PER DAY

        Assertions.assertEquals(220.98, result.getProteinGramsPerDay(), 0.5);
        Assertions.assertEquals(81.84, result.getFatGramsPerDay(), 0.5);
        Assertions.assertEquals(331.47, result.getCarbsGramsPerDay(), 0.5);
    }

}
