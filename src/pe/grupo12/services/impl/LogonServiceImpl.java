/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.services.impl;

import java.util.Objects;
import pe.grupo12.services.LogonService;

/**
 *
 * @author ID46499778
 */
public class LogonServiceImpl implements LogonService {

    @Override
    public boolean validarCredenciales(String numeroCuenta, String nip) {
        if (Objects.nonNull(numeroCuenta) && Objects.nonNull(nip))
            return numeroCuenta.equals(Data.NUMERO_CUENTA) && nip.equals(Data.NIP);
        return false;
    }
    
}
