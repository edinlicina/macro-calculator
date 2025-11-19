package com.example.macro_calculator.dtos;

public class MacroResultDto {
    private double bmr;
    private double tdee;
    private double caloriesPerDay;
    private double proteinGramsPerDay;
    private double fatGramsPerDay;
    private double carbsGramsPerDay;

    public double getBmr() {
        return bmr;
    }

    public void setBmr(double bmr) {
        this.bmr = bmr;
    }

    public double getTdee() {
        return tdee;
    }

    public void setTdee(double tdee) {
        this.tdee = tdee;
    }

    public double getCaloriesPerDay() {
        return caloriesPerDay;
    }

    public void setCaloriesPerDay(double caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }

    public double getProteinGramsPerDay() {
        return proteinGramsPerDay;
    }

    public void setProteinGramsPerDay(double proteinGramsPerDay) {
        this.proteinGramsPerDay = proteinGramsPerDay;
    }

    public double getFatGramsPerDay() {
        return fatGramsPerDay;
    }

    public void setFatGramsPerDay(double fatGramsPerDay) {
        this.fatGramsPerDay = fatGramsPerDay;
    }

    public double getCarbsGramsPerDay() {
        return carbsGramsPerDay;
    }

    public void setCarbsGramsPerDay(double carbsGramsPerDay) {
        this.carbsGramsPerDay = carbsGramsPerDay;
    }
}
