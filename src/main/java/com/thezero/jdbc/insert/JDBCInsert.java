package com.thezero.jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCInsert {
    public static void main(String[] args) {
        new JDBCInsert().testInsert();
    }
    private void testInsert(){//thezeroschema
        Statement myStmt;
        ResultSet myRs;
        String dbURL="jdbc:mysql://localhost:3306/thezeroschema";
        String user="harsh";
        String pass="thezero@123";
        try (Connection myConnection = DriverManager.getConnection(dbURL, user, pass)) {
            myStmt = myConnection.createStatement();
            int rowAffected=myStmt.executeUpdate("insert into employees (last_name,first_name,email,department, salary) values ('Raj','Harsh','iitianharshraj@gmail.com','EOT','60000')");
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
