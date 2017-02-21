package com.kiranpariyar.jdbcexample;

import java.sql.*;

public class DataBaseConnector {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_example";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "leapfrog";

    public static void connect(){
        Connection connection = null;
        Statement statement =null;

        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            statement = connection.createStatement();
            String sql = "Select * from user";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                System.out.println("first name :" + rs.getString("first_name"));
                System.out.println("last name :" + rs.getString("last_name"));
                System.out.println("address :" + rs.getString("address"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
