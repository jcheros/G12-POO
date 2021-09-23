/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.modelo;

/**
 *
 * @author ID46499778
 */
public class Cuenta {
    private String numeroCta;
    private String nip;
    private String moneda;
    private Float saldo;
    private String dniCliente;

    public Cuenta() {
    }

    public Cuenta(String numeroCta, String nip, String moneda, Float saldo, String dniCliente) {
        this.numeroCta = numeroCta;
        this.nip = nip;
        this.moneda = moneda;
        this.saldo = saldo;
        this.dniCliente = dniCliente;
    }

    public String getNumeroCta() {
        return numeroCta;
    }

    public void setNumeroCta(String numeroCta) {
        this.numeroCta = numeroCta;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }
}
