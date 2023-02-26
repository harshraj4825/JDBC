package com.thezero.jdbc.queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCQueries {
    public static void main(String[] args) {
        new JDBCQueries().testQuery();
    }
    private void testQuery(){//thezeroschema
        Statement myStmt;
        ResultSet myRs;
        String dbURL="jdbc:mysql://localhost:3306/thezeroschema";
        String user="harsh";
        String pass="thezero@123";
        try (Connection myConnection = DriverManager.getConnection(dbURL, user, pass)) {
            myStmt = myConnection.createStatement();
            myRs = myStmt.executeQuery("select * from employees");
            while (myRs.next()) {
                System.out.println(myRs.getString("last_name") + " " + myRs.getString("first_name"));
            }
        } catch (Exception e) {
            System.out.println("Exception occurred " + e);
        }
    }
}
