package com.company.Manipulations;

import com.company.Doctors.Doctors;
import com.company.Drugs.Drugs;
import com.company.Patients.Patients;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please select with what table you want to work: \n 1.Patients \n 2.Doctors \n 3.Drugs");
        System.out.println("Select an option: ");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                menu1();
                break;
            case 2:
                menu2();
                break;
            case 3:
                menu3();
                break;
            default:
                System.out.println("Invalid option. ");

        }
    }
        public static void menu1() {
            Scanner sc = new Scanner(System.in);
            System.out.println("What would you like to do now? ");
            System.out.println("1. Add a new patient. ");
            System.out.println("2. Edit information about patient. ");
            System.out.println("3. Delete patient.");

            System.out.println("Select an option: ");
            int option1 = sc.nextInt();

            switch (option1) {
                case 1:
                    Patients.addNewPatient();

                    Menu.menu4();
                    break;
                case 2:
                    Patients.editPatient();

                    Menu.menu4();
                    break;
                case 3:
                    Patients.deletePatient();

                    Menu.menu4();
                    break;
                default:
                    System.out.println("Invalid option. ");
            }
        }
            public static void menu2() {
                Scanner sc = new Scanner(System.in);
                System.out.println("What would you like to do now? ");
                System.out.println("1. Add a new doctor. ");
                System.out.println("2. Edit information about doctor. ");
                System.out.println("3. Delete doctor from the table. ");
                System.out.println("Select an option: ");
                int option2 = sc.nextInt();

                switch (option2) {
                    case 1:
                        Doctors.addNewDoctor();

                        Menu.menu4();
                        break;
                    case 2:
                        Doctors.editDoctor();

                        Menu.menu4();
                        break;
                    case 3:
                        Doctors.deleteDoctor();

                        Menu.menu4();
                        break;
                    default:
                        System.out.println("Invalid option. ");
                }
            }
    public static void menu3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do now? ");
        System.out.println("1. Add a new drug. ");
        System.out.println("2. Edit name for drug. ");
        System.out.println("3. Delete a drug from the table. ");
        System.out.println("Select an option: ");
        int option3 = sc.nextInt();

        switch (option3) {
            case 1:
                Drugs.addNewDrug();;

                Menu.menu4();
                break;
            case 2:
                Drugs.editDrug();

                Menu.menu4();
                break;
            case 3:
                Drugs.deleteDrug();

                Menu.menu4();
                break;
            default:
                System.out.println("Invalid option. ");
        }

    }
    public static void menu4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to continue work with database? \n 1. Yes \n 2. No");
        int option4 = sc.nextInt();
        switch (option4) {
            case 1:
                Menu.menu();
                break;
            case 2:
                System.out.println("Your work is ended.");
                break;
        }
    }

}

