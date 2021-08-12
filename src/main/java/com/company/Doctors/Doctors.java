package com.company.Doctors;

import com.company.dbhelper.dbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctors {
    private static Scanner sc = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewDoctor() {
        System.out.println("Enter the  first name of the doctor: ");
        String firstName = sc.next();

        System.out.println("Enter the second name of the doctor: ");
        String secondName = sc.next();

        System.out.println("Enter the speciality of the doctor: ");
        String speciality = sc.next();

        try {
            ps = dbConnection.getConnection().prepareStatement("INSERT INTO doctors (first_name, second_name, speciality) " + " VALUES('"
                    + firstName + "', '" + secondName + "' , '" + speciality+ "')");
            ps.execute();
            System.out.println("Successfully added doctor. ");
            return true;

        }
        catch (SQLException e) {
            e.getMessage();
            return false;
        }
    }
    public static void editDoctor() {

        System.out.print("Enter the doctors id: ");
        int id = sc.nextInt();
        System.out.println("first_name, second_name, speciality");

        System.out.print("Enter what you want to change ");
        String object= sc.next();
        System.out.println("Enter the updated value: ");
        String update = sc.next();

        try {
            ps = dbConnection.getConnection().prepareStatement("UPDATE doctors SET " + object + " = '" + update + "' WHERE doctors_id= "+ id);
            ps.execute();
            System.out.println("Successfully edited information about doctor. ");
        } catch(SQLException e) {
            e.printStackTrace();

        }

    }
    public static void deleteDoctor() {

        System.out.print("Enter the doctors id you want to delete: ");
        int id = sc.nextInt();

        try {
            ps = dbConnection.getConnection().prepareStatement("DELETE FROM doctors WHERE doctors_id="+ id);
            ps.execute();
            System.out.println("Successfully deleted doctor. ");
        } catch(SQLException e) {
            e.getMessage();

        }

    }

}
