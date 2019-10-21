/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hai Nam
 */
public class DBUtilities implements Serializable {

    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
        //1. Load driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2. Create connection String
        String url = "jdbc:sqlserver://localhost:1433;databaseName=DangNhap";
        //3. Open connection
        Connection con = DriverManager.getConnection(url, "sa", "123");

        return con;
    }
}
