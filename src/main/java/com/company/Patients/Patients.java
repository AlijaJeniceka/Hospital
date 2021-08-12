package com.company.Patients;

import com.company.dbhelper.dbConnection;

import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patients {
    private static Scanner sc = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewPatient() {
        System.out.println("Enter the  first name of the patient: ");
        String firstName = sc.next();

        System.out.println("Enter the second name of the patient: ");
        String secondName = sc.next();

        System.out.println("Enter the age of the patient: ");
        int age = sc.nextInt();

       try {
           ps = dbConnection.getConnection().prepareStatement("INSERT INTO patients (first_name, second_name, age) " + " VALUES('" + firstName + "', '" + secondName + "' , " + age + ")");
           ps.execute();
           System.out.println("Successfully added patient. ");
           return true;

       }
       catch (SQLException e) {
           e.getMessage();
           return false;
       }
    }
    public static void editPatient() {

        //Prompt the user for data
        System.out.print("Enter the patient id: ");
        int id = sc.nextInt();
        System.out.println("first_name, second_name, age");

        System.out.print("Enter what you want to change ");
        String object= sc.next();
        System.out.println("Enter the updated value: ");
        String update = sc.next();

        try {
            // Inserts students to the table.
            ps = dbConnection.getConnection().prepareStatement("UPDATE patients SET " + object + " = " + update + " WHERE id= "+ id);

            ps.execute();
            System.out.println("Successfully edited patient. ");
        } catch(SQLException e) {
            e.printStackTrace();

        }

    }

    public static void deletePatient() {

        System.out.print("Enter the patients id you want to delete: ");
        int id = sc.nextInt();

        try {
            ps = dbConnection.getConnection().prepareStatement("DELETE FROM patients WHERE id="+ id);
            ps.execute();
            System.out.println("Successfully deleted patient. ");
        } catch(SQLException e) {
            e.getMessage();

        }

    }

}
