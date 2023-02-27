package com.thezero.jdbc.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JDBCDBMetadata {
    public static void main(String[] args) {
        new JDBCDBMetadata().testDbMetadata();
    }

    private void testDbMetadata(){
        String catalog=null;
        String schemaPattern=null;
        String tableNamePattern=null;
        String columnNamePattern=null;
        String[] types=null;
        String dbURL="jdbc:mysql://localhost:3306/thezeroschema";
        String user="harsh";
        String pass="thezero@123";
        try (Connection myConnection = DriverManager.getConnection(dbURL, user, pass)) {
            DatabaseMetaData databaseMetaData = myConnection.getMetaData();
            ResultSet resultSet=databaseMetaData.getTables(catalog,schemaPattern,tableNamePattern,types);
            while (resultSet.next())
                System.out.println(resultSet.getString("TABLE_NAME"));
            resultSet=databaseMetaData.getColumns(catalog,schemaPattern,"employees",columnNamePattern);
            while (resultSet.next())
                System.out.println(resultSet.getString("COLUMN_NAME"));
        } catch (Exception e) {
            System.out.println("Exception occurred " + e);
        }
    }
}
