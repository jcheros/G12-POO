/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.views;

/**
 *
 * @author ID46499778
 */
public class UtilView {
    public final static String BIENVENIDA = "¡Bienvenido!\n\nEscriba su número de cuenta: ";
    public final static String MENU_PRINCIPAL = ""
            + "Menú Principal\n"
            + "\t1. Ver mi saldo\n"
            + "\t2. Retirar efectivo\n"
            + "\t3. Depositar fondos\n"
            + "\t4. Salir\n"
            + "Escriba una opción: ";
    public final static String MENU_RETIRO = ""
            + "Menú retiro\n"
            + "\t1- $20 \t4- $100\n"
            + "\t2- $40 \t5- $200\n"
            + "\t3- $60 \t6- Cancelar transacción\n"
            + "Elija su monto de retiro: ";
    public final static String MENSAJE_DATO_INCORRECTO = "Datos incorrectos";
    public final static String MENSAJE_SALDO_INSUFICIENTE = "Saldo insuficiente. Intente con un valor menor.";
    public final static String MENSAJE_RETIRO_OK = "Retire su efectivo";
    public final static String MENSAJE_DEPOSITO = "Ingrese el monto a depositar (o cero para cancelar) $: ";
    public final static String MENSAJE_OPERACION_CANCELADA = "Operación cancelada.";
    public final static String MENSAJE_DEPOSITO_OK = "Se depositó el monto correctamente.";
}
