package feemanagement.core;

import feemanagement.gui.AdminLoginForm;
import feemanagement.gui.StudentLoginForm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Welcome to Fee Management System ===");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Student");
        System.out.print("Enter choice: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            new AdminLoginForm().setVisible(true);
        } else if (choice == 2) {
            new StudentLoginForm().setVisible(true);
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
