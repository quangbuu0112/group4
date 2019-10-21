/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bth.DBU;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author buith
 */
public class DBUtilities implements Serializable{

    /**
     *
     * @return
     * @throws NamingException
     * @throws SQLException
     */
    public static Connection makeConnection() throws NamingException, SQLException {
        //su dung context can bat NamingException
        //lay OS
        Context context = new InitialContext(); //lay context cua may tinh hien hanh
        Context tomcatCtx = (Context)context.lookup("java:comp/env"); //lay context cua server hien hanh
        DataSource da = (DataSource)tomcatCtx.lookupLink("DS007");
        
        Connection con = da.getConnection();
        return con;
//        try {
//            //1. Load Driver
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            //2. Create connection string
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=accountSV";
//            //3. Open connection
//            Connection con = DriverManager.getConnection(url, "sa", "16111999");
//            return con;
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }    
//        return null;
    }
}
