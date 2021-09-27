/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.grupo12.datasource.AccesoDB;
import pe.grupo12.modelo.Cuenta;
import pe.grupo12.services.ATMService;

/**
 *
 * @author ID46499778
 */
public class ATMServiceImpl implements ATMService {
    private final Cuenta cuenta;

    public ATMServiceImpl(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public boolean validarRetiroFondos(Float retiro) {
        Float saldoActual = obtenerSaldoActual();
        return retiro <= saldoActual;
    }
    
    @Override
    public boolean validarSaldoCajero(Float retiro) {
        Float saldoActual = obtenerSaldoActualCajero();
        return retiro <= saldoActual && saldoActual >= 20;
    }
    
    @Override
    public Float retirarFondos(Float retiro) {
        // Obtenemos el saldo actual
        Float saldoActual = obtenerSaldoActual();
        Float nuevoSaldo = saldoActual;
        
        // Registramos la transacción
        int validaOp = gestionMovimientos(2, retiro);
        
        if (validaOp > 0) {
            nuevoSaldo = saldoActual - retiro;
        
            // Actualizamos el saldo de la cuenta
            actualizarSaldoActual(nuevoSaldo);
        }
        
        return nuevoSaldo;
    }

    @Override
    public Float depositarFondos(Float deposito) {
        // Obtenemos el saldo actual
        Float saldoActual = obtenerSaldoActual();
        Float nuevoSaldo = saldoActual;
        
        // Registramos la transacción
        int validaOp = gestionMovimientos(1, deposito);
        
        if (validaOp > 0) {
            nuevoSaldo = saldoActual + deposito;
        
            // Actualizamos el saldo de la cuenta
            actualizarSaldoActual(nuevoSaldo);
        }
        
        return nuevoSaldo;
    }
    
    @Override
    public Float obtenerSaldoActual() {
        Connection con = null;
        Float saldoActual = 0f;
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "select saldo from cuentas where numero_cta = ? and nip = ?";

            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, cuenta.getNumeroCta());
            statement.setString(2, cuenta.getNip());

            ResultSet rs = statement.executeQuery(); 

            if (!rs.next()) {
                saldoActual = 0f;
            } else {
                saldoActual = rs.getFloat("saldo");
            }
            
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return saldoActual;
    }
    
    @Override
    public Float obtenerSaldoActualCajero() {
        Connection con = null;
        Float saldoActual = 0f;
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "select saldo from cajeros where codigo = ?";

            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, Data.CODIGO_CAJERO);

            ResultSet rs = statement.executeQuery(); 

            if (!rs.next()) {
                saldoActual = 0f;
            } else {
                saldoActual = rs.getFloat("saldo");
            }
            
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return saldoActual;
    }
    
    private void actualizarSaldoActual(Float saldo) {
        Connection con = null;
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "update cuentas set saldo = ? where numero_cta = ? and nip = ?";

            PreparedStatement statement = con.prepareStatement(query);
            statement.setFloat(1, saldo);
            statement.setString(2, cuenta.getNumeroCta());
            statement.setString(3, cuenta.getNip());

            int rows = statement.executeUpdate();
            System.out.println(rows + " Registros actualizados");
            statement.close();
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int gestionMovimientos(int tipoTransaccion, Float importe) {
        Connection con = null;
        int rows = 0;
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "insert into movimientos (numero_op, fecha_hora, tipo, importe, numero_cta, codigo_cajero) values (MOVIMIENTOS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(query);
            statement.setTimestamp(1, new Timestamp(new Date().getTime()));
            statement.setInt(2, tipoTransaccion);
            statement.setFloat(3, importe);
            statement.setString(4, cuenta.getNumeroCta());
            statement.setInt(5, Data.CODIGO_CAJERO);

            rows = statement.executeUpdate();
            System.out.println(rows + " Registros insertados");
            statement.close();
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rows;
    }
}
