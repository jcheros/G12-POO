/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.grupo12.datasource.AccesoDB;
import pe.grupo12.services.LogonService;

/**
 *
 * @author ID46499778
 */
public class LogonServiceImpl implements LogonService {

    @Override
    public boolean validarCredenciales(String numeroCuenta, String nip) {
        oracle.jdbc.driver.OracleLog.setTrace(true);
        boolean validar = false;
        Connection con = null;
        
        if (Objects.nonNull(numeroCuenta) && Objects.nonNull(nip)) {
            try {
                con = AccesoDB.getConnection();
                con.setAutoCommit(false);
                String query = "select count(*) as contador from cuentas where numero_cta = ? and nip = ?";
                
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, numeroCuenta);
                statement.setString(2, nip);
                
                ResultSet rs = statement.executeQuery(); 
                
                if (!rs.next()) {
                    return false;
                }
                
                int contador = rs.getInt("CONTADOR");
                validar = contador > 0;
                con.commit();
            } catch (Exception ex) {
                Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return validar;
    }
    
}
