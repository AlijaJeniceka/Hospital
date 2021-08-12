package com.company.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", User.USERNAME.getValue(),
                    User.PASSWORD.getValue());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
