package com.thezero.jdbc.queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCQueries {
    public static void main(String[] args) {
        new JDBCQueries().testQuery("select * from employees");
    }
    private void testQuery(String query){//thezeroschema
        Connection myConnection;
        Statement myStmt;
        ResultSet myRs;

        String dbURL="jdbc:mysql://localhost:3306/thezeroschema";
        String user="harsh";
        String pass="thezero@123";
        try{
            myConnection=DriverManager.getConnection(dbURL,user,pass);
            myStmt=myConnection.createStatement();
            myRs=myStmt.executeQuery(query);
            while (myRs.next()){
                System.out.println(myRs.getString("last_name")+" "+myRs.getString("first_name"));
            }
        }
        catch (Exception e){
            System.out.println("Exception occurred "+e);
        }
    }
}
