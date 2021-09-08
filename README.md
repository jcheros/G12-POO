# G12-POO
*PA del curso Programación Orientada a Objetos*

## Enunciado

Un banco local pretende instalar una nueva máquina de cajero automático (ATM), para permitir a los usuarios (es decir, los clientes del banco) realizar transacciones financieras básicas. Cada usuario solo puede tener una cuenta en el banco. Los usuarios del ATM deben poder ver el saldo de su cuenta, retirar efectivo (es decir, sacar dinero de una cuenta) y depositar dinero en una cuenta.
**La interfaz de usuario de cajero automático** contiene los siguientes componentes: una pantalla que muestra mensajes al usuario, un teclado que recibe datos numéricos de entrada del usuario, un dispensador de efectivo que dispensa efectivo al usuario, y una ranura de depósito que recibe dinero del usuario.

![alt text](https://github.com/jcheros/G12-POO/blob/main/ATMLayout.png?raw=true)

Usted deberá desarrollar una **primera versión del software** para que se ejecute en una computadora personal. Esta versión debe utilizar el monitor de la computadora para simular la pantalla del ATM y el teclado de la computadora para simular el teclado numérico del ATM.
Esta primera versión deberá permitir:
Cuando el usuario ingresa correctamente su NIP (número de identificación), se muestra el siguiente menú:

![alt text](https://github.com/jcheros/G12-POO/blob/main/ATMPrincipalMenu.png?raw=true)

Si el usuario selecciona la opción 1, se mostrará el saldo de la cuenta.
Si el usuario selecciona la opción 2, se muestra la siguiente interfaz:

![alt text](https://github.com/jcheros/G12-POO/blob/main/ATMWithdrawalMenu.png?raw=true)

La opción 3 del menú principal se utilizará para hacer un depósito de dinero, para ello en la pantalla principal se visualizará un mensaje que pide al usuario que ingrese un monto de depósito o que escriba 0 (cero) para cancelar la transacción.
En esta primera versión de Software deberá utilizar los componentes Swing de java para construir las interfaces de usuario para simular la pantalla del ATM y el teclado de la computadora para simular el teclado numérico del ATM.   
No es necesario que implemente ninguna funcionalidad, solo debe construir las interfaces de usuario.
