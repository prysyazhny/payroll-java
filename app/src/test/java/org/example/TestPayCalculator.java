package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPayCalculator {
    Payroll payroll;

    @BeforeEach
    public void setUp() {
        payroll = new Payroll();
    }

    @Test
    void itCalculatesThePayForZeroHoursWorked() {
        assertEquals(payroll.calculateGrossPay(0), 0.0);
    }

    @Test
    void itCalculatesThePayForRegularHoursWorked() {
        assertEquals(payroll.calculateGrossPay(35), 587.30);
    }

    @Test
    void itCalculatesThePayForOvertimeHoursWorked() {
        assertEquals(payroll.calculateGrossPay(50), 922.90);
        assertEquals(payroll.calculateGrossPay(500), 12249.40);
    }

    @Test
    void itCalculatesHealthInsurance() {
        assertEquals(payroll.calculateHealthInsurance(0), 15.0);
        assertEquals(payroll.calculateHealthInsurance(2), 15.0);
        assertEquals(payroll.calculateHealthInsurance(3), 35.0);
        assertEquals(payroll.calculateHealthInsurance(5), 35.0);
        assertEquals(payroll.calculateHealthInsurance(54353445), 35.0);
    }

    @Test
    void itCalculatesNetPay() {
        assertEquals(payroll.calculateNetPay(0, 0), -25.0);
        assertEquals(payroll.calculateNetPay(35, 0), 415.47);
        assertEquals(payroll.calculateNetPay(35, 3), 395.47);
        assertEquals(payroll.calculateNetPay(50, 0), 667.18);
        assertEquals(payroll.calculateNetPay(50, 3), 647.17);
    }

}