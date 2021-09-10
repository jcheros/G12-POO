/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.services.impl;

import pe.grupo12.services.ATMService;

/**
 *
 * @author ID46499778
 */
public class ATMServiceImpl implements ATMService {
    private Data data = new Data();

    @Override
    public boolean validarRetiroFondos(int retiro) {
        return retiro <= data.getSaldoActual();
    }
    
    @Override
    public int retirarFondos(int retiro) {
        data.setSaldoActual(data.getSaldoActual() - retiro);
        return data.getSaldoActual();
    }

    @Override
    public int depositarFondos(int deposito) {
        data.setSaldoActual(data.getSaldoActual() + deposito);
        return data.getSaldoActual();
    }
    
    @Override
    public int obtenerSaldoActual() {
        return data.getSaldoActual();
    }
}
