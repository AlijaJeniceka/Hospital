package com.company.Patients;

import com.company.dbhelper.dbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PatController {
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
            ps = dbConnection.getConnection().prepareStatement("DELETE FROM doctors_shifts WHERE patients_id=" + id);
            ps.execute();
            ps = dbConnection.getConnection().prepareStatement("DELETE FROM patients WHERE id="+ id);
            ps.execute();
            System.out.println("Successfully deleted patient. ");
        } catch(SQLException e) {
            e.getMessage();

        }

    }
    public static Patient getPatients() {

        try {
            ps = dbConnection.getConnection().prepareStatement("SELECT * FROM patients");
            rs = ps.executeQuery();
            int id, age;
            String first_name, second_name;
            System.out.println("id\t first_name\t\t second_name\t age\t");
            Patient patient = new Patient();
            while(rs.next()){
                id = rs.getInt("id");
                first_name = rs.getString("first_name");
                second_name= rs.getString("second_name");
                age = rs.getInt("age");
                patient.setAge(age);
                patient.setId(id);
                patient.setFirst_name(first_name);
                patient.setSecond_name(second_name);
                System.out.println(id+ "\t\t" + first_name + "\t\t\t" + second_name + "\t\t" + age +"\t" );

            }
            return patient;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }
        public static void getPatientByID() {
            System.out.println("Enter the patients id you want to see information about: ");
            int patientID = sc.nextInt();
            try {
                ps = dbConnection.getConnection().prepareStatement("SELECT patients.first_name, patients.second_name, doctors.first_name, doctors.second_name, doctors.speciality, doctors_shifts.shifts_date, doctors_shifts.shifts_time FROM ((doctors_shifts INNER JOIN doctors ON doctors_shifts.doctors_id = doctors.doctors_id) INNER JOIN patients ON doctors_shifts.patients_id = patients.id) WHERE patients_id = " + patientID);
                ps.execute();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
}
