package com.example.macro_calculator.dtos;

import java.time.LocalDate;

public class DailySummaryDto {

    private LocalDate date;

    private MacroBreakdownDto target;
    private MacroBreakdownDto consumed;
    private MacroBreakdownDto remaining;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public MacroBreakdownDto getTarget() {
        return target;
    }

    public void setTarget(MacroBreakdownDto target) {
        this.target = target;
    }

    public MacroBreakdownDto getConsumed() {
        return consumed;
    }

    public void setConsumed(MacroBreakdownDto consumed) {
        this.consumed = consumed;
    }

    public MacroBreakdownDto getRemaining() {
        return remaining;
    }

    public void setRemaining(MacroBreakdownDto remaining) {
        this.remaining = remaining;
    }
}
