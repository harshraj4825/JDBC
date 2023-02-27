package com.thezero.jdbc.delete;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDelete {
    public static void main(String[] args) {
        new JDBCDelete().testDelete();
    }

    private void testDelete(){
        Statement myStmt;
        ResultSet myRs;
        String dbURL="jdbc:mysql://localhost:3306/thezeroschema";
        String user="harsh";
        String pass="thezero@123";
        try (Connection myConnection = DriverManager.getConnection(dbURL, user, pass)) {
            myStmt = myConnection.createStatement();
            int rowAffected=myStmt.executeUpdate("delete from employees where last_name='Raj'");
            System.out.println("Affected row: "+rowAffected);
            myRs = myStmt.executeQuery("select * from employees");
            while (myRs.next()) {
                System.out.println(myRs.getString("last_name") + " " + myRs.getString("first_name"));
            }
        } catch (Exception e) {
            System.out.println("Exception occurred " + e);
        }
    }
}
