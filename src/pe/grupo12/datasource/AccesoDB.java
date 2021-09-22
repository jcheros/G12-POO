/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author ID46499778
 */
public class AccesoDB {
    public static Connection getConnection() throws Exception {
        Connection con = null;
        String host = "localhost";
        String port = "51521";
        String instance = "xe";
        String user = "USER12";
        String password = "USER12";
        
        try {
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            String url = String.format("jdbc:oracle:thin:@%s:%s/%s", host, port, instance);
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw e;
        }
        
        return con;
    }
}
