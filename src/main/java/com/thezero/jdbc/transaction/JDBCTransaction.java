package com.thezero.jdbc.transaction;

import com.thezero.jdbc.queries.JDBCQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTransaction {
    public static void main(String[] args) {
        new JDBCTransaction().testTransaction();
    }
    private void testTransaction(){
        String dbURL="jdbc:mysql://localhost:3306/thezeroschema";
        String user="harsh";
        String pass="thezero@123";
        try (Connection myConnection = DriverManager.getConnection(dbURL, user, pass)) {
            myConnection.setAutoCommit(false);

            if(true)
                myConnection.commit();
            else {
                myConnection.rollback();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred " + e);
        }
    }
}
