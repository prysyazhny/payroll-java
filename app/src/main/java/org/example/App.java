package org.example;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    double hoursWorked;
    int dependents;

    Scanner scanner = new Scanner(System.in);
    System.out.println("\nWelcome to the Payroll Program!\n");

    System.out.println("How many hours did you work this week?");
    hoursWorked = scanner.nextDouble();

    System.out.println("How many children do you have?");
    dependents = scanner.nextInt();
    scanner.close();

    Payroll payroll = new Payroll();
    payroll.calculatePayroll(hoursWorked, dependents);

    System.out.println("\nThank you for using the Payroll Program!\n");

  }
}
