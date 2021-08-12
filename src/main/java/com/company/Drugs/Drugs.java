package com.company.Drugs;

import com.company.dbhelper.dbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Drugs {
    private static Scanner sc = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewDrug() {
        System.out.println("Enter the name of the drug: ");
        String name = sc.next();


        try {
            ps = dbConnection.getConnection().prepareStatement("INSERT INTO drugs (name) " + " VALUES('"
                    + name + "')");
            ps.execute();

            System.out.println("Successfully added drug. ");
            return true;
        }
        catch (SQLException e) {
            e.getMessage();
            return false;
        }
    }
    public static void editDrug() {

        System.out.print("Enter the drug id you want to change a name: ");
        int id = sc.nextInt();

        System.out.println("Enter the new name of the drug: ");
        String update = sc.next();
        try {
            ps = dbConnection.getConnection().prepareStatement("UPDATE drugs SET name " + " = '"  + update + "' WHERE drugs_id= "+ id);

            ps.execute();
            System.out.println("Successfully edited drug. ");
        } catch(SQLException e) {
            e.printStackTrace();

        }
    }
    public static void deleteDrug() {

        System.out.print("Enter the drugs id you want to delete: ");
        int id = sc.nextInt();

        try {
            ps = dbConnection.getConnection().prepareStatement("DELETE FROM drugs WHERE drugs_id="+ id);
            ps.execute();
            System.out.println("Successfully deleted patient. ");
        } catch(SQLException e) {
            e.getMessage();

        }

    }



}
