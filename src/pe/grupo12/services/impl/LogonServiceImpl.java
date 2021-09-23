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
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.grupo12.datasource.AccesoDB;
import pe.grupo12.modelo.Cuenta;
import pe.grupo12.services.LogonService;

/**
 *
 * @author ID46499778
 */
public class LogonServiceImpl implements LogonService {

    @Override
    public Optional<Cuenta> validarCredenciales(String numeroCuenta, String nip) {
        Optional<Cuenta> cuentaOptional = Optional.empty();
        Connection con = null;
        
        if (Objects.nonNull(numeroCuenta) && Objects.nonNull(nip)) {
            try {
                con = AccesoDB.getConnection();
                con.setAutoCommit(false);
                String query = "select numero_cta, nip, moneda, saldo, dni_cliente from cuentas where numero_cta = ? and nip = ?";
                
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, numeroCuenta);
                statement.setString(2, nip);
                
                ResultSet rs = statement.executeQuery(); 
                
                if (!rs.next()) {
                    cuentaOptional = Optional.empty();
                } else {
                    Cuenta cuenta = new Cuenta(
                        rs.getString("numero_cta"),
                        rs.getString("nip"),
                        rs.getString("moneda"),
                        rs.getFloat("saldo"),
                        rs.getString("dni_cliente")
                    );

                    cuentaOptional = Optional.of(cuenta);
                }

                con.commit();
            } catch (Exception ex) {
                Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return cuentaOptional;
    }
    
}
