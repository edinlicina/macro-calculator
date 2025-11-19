package com.example.macro_calculator.dtos;

import com.example.macro_calculator.enums.ActivityLevel;
import com.example.macro_calculator.enums.Goal;
import com.example.macro_calculator.enums.Sex;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class UserProfileDto {
    @Min(1)
    private int age;
    @NotNull
    private Sex sex;
    @Positive
    private double height;
    @Positive
    private double weight;
    @NotNull
    private ActivityLevel activityLevel;
    @NotNull
    private Goal goal;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
