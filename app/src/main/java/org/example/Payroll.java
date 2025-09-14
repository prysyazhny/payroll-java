package org.example;

public class Payroll {
    private double hourlyRate = 16.78;
    private double overtimeThreshold = 40.0;

    private double taxRateSocialSecurity = 0.06;
    private double taxRateFederal = 0.14;
    private double taxRateState = 0.05;

    private double unionDues = 10.0;    

    public double getHourlyRate() {
        return hourlyRate;
    }
    public double getOvertimeThreshold() {
        return overtimeThreshold;
    }
    public double getTaxRateSocialSecurity() {
        return taxRateSocialSecurity;
    }
    public double getTaxRateFederal() {
        return taxRateFederal;
    }
    public double getTaxRateState() {
        return taxRateState;
    }
    public double getUnionDues() {
        return unionDues;
    }
    public double calculateHealthInsurance(int dependents) {
        if (dependents >= 3) {
            return 35.00;
        } else {
            return 15.00;
        }
    }

    public double calculateGrossPay(double hoursWorked) {
        double grossPay;
        if (hoursWorked <= getOvertimeThreshold()) {
            grossPay = hoursWorked * getHourlyRate();
        } else {
            double regularPay = getOvertimeThreshold() * getHourlyRate();
            double overtimeHours = hoursWorked - getOvertimeThreshold();
            double overtimePay = overtimeHours * getHourlyRate() * 1.5;
            grossPay = regularPay + overtimePay;
        }
        return Math.round(grossPay * 100.0) / 100.0;
    }

    public double calculateNetPay(double hoursWorked, int dependents) {
        double grossPay = calculateGrossPay(hoursWorked);
        double deductions = calculateDeductions(grossPay, dependents);
        return Math.round((grossPay - deductions) * 100.0) / 100.0;
    }

    public double calculateDeductions(double grossPay, int dependents) {
        double socialSecurityTax = grossPay * getTaxRateSocialSecurity();
        double federalTax = grossPay * getTaxRateFederal();
        double stateTax = grossPay * getTaxRateState();
        double healthInsurance = calculateHealthInsurance(dependents);
        return socialSecurityTax + federalTax + stateTax + healthInsurance + getUnionDues();
    }

    public void calculatePayroll(double hoursWorked, int dependents) {

        System.out.println("\nPayroll Stub:");

        System.out.printf("\n  Hours:  %.2f\n", hoursWorked);
        System.out.printf("  Rate:  %.2f $/hr\n", getHourlyRate());
        System.out.printf("  Gross:  $ %.2f\n", calculateGrossPay(hoursWorked));

        System.out.printf("\n  SocSec:  $ %.2f\n", (calculateGrossPay(hoursWorked) * getTaxRateSocialSecurity()));
        System.out.printf("  FedTax:  $ %.2f\n", (calculateGrossPay(hoursWorked) * getTaxRateFederal()));
        System.out.printf("  StTax:  $ %.2f\n", (calculateGrossPay(hoursWorked) * getTaxRateState()));
        System.out.printf("  Union:  $ %.2f\n", getUnionDues());
        System.out.printf("  Ins:  $ %.2f\n", calculateHealthInsurance(dependents));

        System.out.printf("  Net:  $ %.2f\n", calculateNetPay(hoursWorked, dependents));
    }

}
