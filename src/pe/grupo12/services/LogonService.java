/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.services;

/**
 *
 * @author ID46499778
 */
public interface LogonService {
    boolean validarCredenciales(String numeroCuenta, String nip);
}