package com.thezero.jdbc.prepare.statement;

import com.thezero.jdbc.update.JDBCUpdate;

import java.sql.*;

public class JDBCPrepareStatement {
    public static void main(String[] args) {
        new JDBCPrepareStatement().testPrepareStatement();
    }
    private void testPrepareStatement(){
        ResultSet myRs;
        String dbURL="jdbc:mysql://localhost:3306/thezeroschema";
        String user="harsh";
        String pass="thezero@123";
        try (Connection myConnection = DriverManager.getConnection(dbURL, user, pass);
                PreparedStatement myStmt=myConnection.prepareStatement("select * from employees where salary>? and department=?")) {
            myStmt.setDouble(1,40000);
            myStmt.setString(2,"Legal");
            myRs=myStmt.executeQuery();
            while (myRs.next()) {
                System.out.println(myRs.getString("last_name") + " " + myRs.getString("first_name"));
            }
        } catch (Exception e) {
            System.out.println("Exception occurred " + e);
        }
    }
}
