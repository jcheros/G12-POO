/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.views;

import javax.swing.Action;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import pe.grupo12.services.impl.ATMServiceImpl;
import pe.grupo12.services.impl.LogonServiceImpl;

/**
 *
 * @author ID46499778
 */
public class ATMView extends javax.swing.JFrame {
    private String numeroCuenta;
    private String nip;
    private int menuPrincipalOpcion;
    private int menuRetiroOpcion;
    private String valorIngresado = "";
    private int estadoPantalla = 1;
    
    private LogonServiceImpl logonService;
    private ATMServiceImpl aTMService;
    
    // Evento asociado al teclado número para los botones
    Action tecladoNumericoAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            actualizarPantallaDesdeTecladoNumerico(e.getActionCommand(), (JButton) e.getSource());
        }
    };

    /**
     * Creates new form ATM
     */
    public ATMView() {
        initComponents();
        
				this.setLocationRelativeTo(null);	//Centra la pantalla en ejecución
				
        logonService = new LogonServiceImpl();
        aTMService = new ATMServiceImpl();
        
        this.setResizable(false);
        pantalla.setText(UtilView.BIENVENIDA);
        
        asociarBotonATecladoNumerico(boton0);
        asociarBotonATecladoNumerico(boton1);
        asociarBotonATecladoNumerico(boton2);
        asociarBotonATecladoNumerico(boton3);
        asociarBotonATecladoNumerico(boton4);
        asociarBotonATecladoNumerico(boton5);
        asociarBotonATecladoNumerico(boton6);
        asociarBotonATecladoNumerico(boton7);
        asociarBotonATecladoNumerico(boton8);
        asociarBotonATecladoNumerico(boton9);
    }
    
    // Método para mostrar un mensaje determinado en la pantalla luego de cierto tiempo
    public void regresarPantalla(String mensaje) {
        TimerTask task = new TimerTask() {
            public void run() {
                pantalla.setText(mensaje);
            }
        };
        
        Timer timer = new Timer("Timer");

        long delay = 2500L;
        timer.schedule(task, delay);
    }
    
    // Método para mapear un botón con la tecla del teclado numerico que le corresponde
    public final void asociarBotonATecladoNumerico(JButton boton) {
        String numeroBoton = boton.getText();
        KeyStroke pressed = KeyStroke.getKeyStroke(numeroBoton);
        InputMap inputMap = boton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(pressed, numeroBoton);
        boton.getActionMap().put(numeroBoton, tecladoNumericoAction);
    }
    
    // Método para añadir el texto del botón a la pantalla. También le da el foto al botón (Util si se usa el teclado numérico en lugar del evento clic)
    public void actualizarPantallaDesdeTecladoNumerico(String numero, JButton boton) {
        pantalla.append(numero);
        valorIngresado += numero;
        boton.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    boton3 = new javax.swing.JButton();
    boton1 = new javax.swing.JButton();
    boton2 = new javax.swing.JButton();
    boton4 = new javax.swing.JButton();
    boton5 = new javax.swing.JButton();
    boton6 = new javax.swing.JButton();
    boton7 = new javax.swing.JButton();
    boton8 = new javax.swing.JButton();
    boton9 = new javax.swing.JButton();
    boton0 = new javax.swing.JButton();
    botonEnter = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    pantalla = new javax.swing.JTextArea();
    jPanel3 = new javax.swing.JPanel();
    botonDeposito = new javax.swing.JButton();
    botonRetiro = new javax.swing.JButton();
    txt_retito = new javax.swing.JLabel();
    txt_retito1 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    jPanel4 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("ATM GRUPO 12");
    setUndecorated(true);

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    boton3.setBackground(new java.awt.Color(153, 153, 153));
    boton3.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
    boton3.setText("3");
    boton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    boton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        boton3ActionPerformed(evt);
      }
    });

    boton1.setBackground(new java.awt.Color(153, 153, 153));
    boton1.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
    boton1.setText("1");
    boton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    boton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        boton1ActionPerformed(evt);
      }
    });

    boton2.setBackground(new java.awt.Color(153, 153, 153));
    boton2.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
    boton2.setText("2");
    boton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    boton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        boton2ActionPerformed(evt);
      }
    });

    boton4.setBackground(new java.awt.Color(153, 153, 153));
    boton4.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
    boton4.setText("4");
    boton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    boton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        boton4ActionPerformed(evt);
      }
    });

    boton5.setBackground(new java.awt.Color(153, 153, 153));
    boton5.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
    boton5.setText("5");
    boton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    boton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        boton5ActionPerformed(evt);
      }
    });

    boton6.setBackground(new java.awt.Color(153, 153, 153));
    boton6.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
    boton6.setText("6");
    boton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    boton6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        boton6ActionPerformed(evt);
      }
    });

    boton7.setBackground(new java.awt.Color(153, 153, 153));
    boton7.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
    boton7.setText("7");
    boton7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    boton7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        boton7ActionPerformed(evt);
      }
    });

    boton8.setBackground(new java.awt.Color(153, 153, 153));
    boton8.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
    boton8.setText("8");
    boton8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    boton8.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        boton8ActionPerformed(evt);
      }
    });

    boton9.setBackground(new java.awt.Color(153, 153, 153));
    boton9.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
    boton9.setText("9");
    boton9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    boton9.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        boton9ActionPerformed(evt);
      }
    });

    boton0.setBackground(new java.awt.Color(153, 153, 153));
    boton0.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
    boton0.setText("0");
    boton0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    boton0.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        boton0ActionPerformed(evt);
      }
    });

    botonEnter.setBackground(new java.awt.Color(153, 153, 153));
    botonEnter.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
    botonEnter.setText("Enter");
    botonEnter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    botonEnter.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        botonEnterActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(boton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(boton0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(20, 20, 20)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20, 20, 20)
            .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(boton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20, 20, 20)
            .addComponent(boton9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(boton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20, 20, 20)
            .addComponent(boton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(botonEnter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(15, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20, 20, 20)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(boton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(boton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20, 20, 20)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(boton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(boton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(boton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(20, 20, 20)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(boton0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(botonEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel2.setBackground(new java.awt.Color(102, 102, 102));
    jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    pantalla.setEditable(false);
    pantalla.setBackground(new java.awt.Color(153, 255, 204));
    pantalla.setColumns(20);
    pantalla.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
    pantalla.setRows(5);
    jScrollPane1.setViewportView(pantalla);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1)
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    botonDeposito.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
    botonDeposito.setText("Inserte aquí el sobre del depósito");

    botonRetiro.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
    botonRetiro.setText("Tome aquí el efectivo");

    txt_retito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    txt_retito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/grupo12/views/imagenes/atm_retiro.png"))); // NOI18N
    txt_retito.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    txt_retito1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    txt_retito1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/grupo12/views/imagenes/atm_deposito.png"))); // NOI18N
    txt_retito1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addComponent(botonDeposito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
            .addComponent(txt_retito1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
          .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addComponent(txt_retito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(botonRetiro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)))
        .addContainerGap(15, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addComponent(botonRetiro)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txt_retito, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(botonDeposito)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txt_retito1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(15, 15, 15))
    );

    jPanel4.setBackground(new java.awt.Color(0, 0, 0));
    jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

    jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("ATM G12");

    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/grupo12/views/imagenes/icono_dolar.png"))); // NOI18N

    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/grupo12/views/imagenes/icono_uc_0.png"))); // NOI18N

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
        .addGap(70, 70, 70)
        .addComponent(jLabel3)
        .addGap(37, 37, 37)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(33, 33, 33)
        .addComponent(jLabel2)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
        .addContainerGap(15, Short.MAX_VALUE)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel2)
          .addComponent(jLabel3)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(12, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(12, 12, 12))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(12, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        // TODO add your handling code here:
        actualizarPantallaDesdeTecladoNumerico("1", boton1);
    }//GEN-LAST:event_boton1ActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        // TODO add your handling code here:
        actualizarPantallaDesdeTecladoNumerico("2", boton2);
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        // TODO add your handling code here:
        actualizarPantallaDesdeTecladoNumerico("3", boton3);
    }//GEN-LAST:event_boton3ActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        // TODO add your handling code here:
        actualizarPantallaDesdeTecladoNumerico("4", boton4);
    }//GEN-LAST:event_boton4ActionPerformed

    private void boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton5ActionPerformed
        // TODO add your handling code here:
        actualizarPantallaDesdeTecladoNumerico("5", boton5);
    }//GEN-LAST:event_boton5ActionPerformed

    private void boton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton6ActionPerformed
        // TODO add your handling code here:
        actualizarPantallaDesdeTecladoNumerico("6", boton6);
    }//GEN-LAST:event_boton6ActionPerformed

    private void boton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton7ActionPerformed
        // TODO add your handling code here:
        actualizarPantallaDesdeTecladoNumerico("7", boton7);
    }//GEN-LAST:event_boton7ActionPerformed

    private void boton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton8ActionPerformed
        // TODO add your handling code here:
        actualizarPantallaDesdeTecladoNumerico("8", boton8);
    }//GEN-LAST:event_boton8ActionPerformed

    private void boton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton9ActionPerformed
        // TODO add your handling code here:
        actualizarPantallaDesdeTecladoNumerico("9", boton9);
    }//GEN-LAST:event_boton9ActionPerformed

    private void boton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton0ActionPerformed
        // TODO add your handling code here:
        actualizarPantallaDesdeTecladoNumerico("0", boton0);
    }//GEN-LAST:event_boton0ActionPerformed

    private void botonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnterActionPerformed
        // TODO add your handling code here:
        switch (estadoPantalla) {
            case 1: // Ingreso de número de cuenta
                System.out.println("valorIngresado: " + valorIngresado);
                numeroCuenta = valorIngresado;
                valorIngresado = "";
                estadoPantalla = 2;
                pantalla.append("\nEscriba su NIP: ");
                break;
            case 2: // Ingreso de código NIP
                System.out.println("valorIngresado: " + valorIngresado);
                nip = valorIngresado;
                valorIngresado = "";
                
                boolean validarCredenciales = logonService.validarCredenciales(numeroCuenta, nip);
                
                if (validarCredenciales) {
                    estadoPantalla = 3;
                    pantalla.setText(UtilView.MENU_PRINCIPAL);
                } else {
                    pantalla.setText(UtilView.MENSAJE_DATO_INCORRECTO);
                    regresarPantalla(UtilView.BIENVENIDA);
                }
                
                break;
            case 3: // Validación de credenciales y menú principal
                menuPrincipalOpcion = Integer.parseInt(valorIngresado);
                valorIngresado = "";
                System.out.println("menuPrincipalOpcion: " + menuPrincipalOpcion);
                
                if (menuPrincipalOpcion >= 1 && menuPrincipalOpcion <= 4) {
                    switch (menuPrincipalOpcion) {
                        case 1: // Ver saldo
                            pantalla.setText("Su saldo actual es: $" + aTMService.obtenerSaldoActual());
                            regresarPantalla(UtilView.MENU_PRINCIPAL);
                            break;
                        case 2: // Retirar fondos
                            estadoPantalla = 4;
                            pantalla.setText(UtilView.MENU_RETIRO);
                            break;
                        case 3: // Depositar fondos
                            estadoPantalla = 5;
                            pantalla.setText(UtilView.MENSAJE_DEPOSITO);
                            break;
                        case 4: // Salir
                            estadoPantalla = 1;
                            pantalla.setText("¡Gracias! Vuelva pronto.");
                            regresarPantalla(UtilView.BIENVENIDA);
                            break;
                    }
                } else {
                    pantalla.setText(UtilView.MENSAJE_DATO_INCORRECTO);
                    regresarPantalla(UtilView.MENU_PRINCIPAL);
                }
                break;
            case 4: // Retiro de fondos
                menuRetiroOpcion = Integer.parseInt(valorIngresado);
                valorIngresado = "";
                int valorARetirar = 0;
                System.out.println("menuRetiroOpcion: " + menuRetiroOpcion);
                
                if (menuRetiroOpcion >= 1 && menuRetiroOpcion <= 6) {
                    switch (menuRetiroOpcion) {
                        case 1:
                            valorARetirar = 20;
                            break;
                        case 2:
                            valorARetirar = 40;
                            break;
                        case 3:
                            valorARetirar = 60;
                            break;
                        case 4:
                            valorARetirar = 100;
                            break;
                        case 5:
                            valorARetirar = 200;
                            break;
                    }
                    
                    if (menuRetiroOpcion == 6) {
                        pantalla.setText(UtilView.MENU_PRINCIPAL);
                        estadoPantalla = 3;
                    } else {
                        if (aTMService.validarRetiroFondos(valorARetirar)) {
                            aTMService.retirarFondos(valorARetirar);
                            pantalla.setText(UtilView.MENSAJE_RETIRO_OK);
                            regresarPantalla(UtilView.MENU_RETIRO);
                        } else {
                            pantalla.setText(UtilView.MENSAJE_SALDO_INSUFICIENTE);
                            regresarPantalla(UtilView.MENU_RETIRO);
                        }
                    }
                } else {
                    pantalla.setText(UtilView.MENSAJE_DATO_INCORRECTO);
                    regresarPantalla(UtilView.MENU_RETIRO);
                }
                
                break;
            case 5: // Deposito
                int valorDeposito = Integer.parseInt(valorIngresado);
                valorIngresado = "";
                
                if (valorDeposito == 0) {
                    pantalla.setText(UtilView.MENSAJE_OPERACION_CANCELADA);
                } else {
                    aTMService.depositarFondos(valorDeposito);
                    pantalla.setText(UtilView.MENSAJE_DEPOSITO_OK);
                }
                
                estadoPantalla = 3;
                regresarPantalla(UtilView.MENU_PRINCIPAL);
                break;
        }
    }//GEN-LAST:event_botonEnterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ATMView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ATMView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ATMView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ATMView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ATMView().setVisible(true);
            }
        });
    }
    

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton boton0;
  private javax.swing.JButton boton1;
  private javax.swing.JButton boton2;
  private javax.swing.JButton boton3;
  private javax.swing.JButton boton4;
  private javax.swing.JButton boton5;
  private javax.swing.JButton boton6;
  private javax.swing.JButton boton7;
  private javax.swing.JButton boton8;
  private javax.swing.JButton boton9;
  private javax.swing.JButton botonDeposito;
  private javax.swing.JButton botonEnter;
  private javax.swing.JButton botonRetiro;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JTextArea pantalla;
  private javax.swing.JLabel txt_retito;
  private javax.swing.JLabel txt_retito1;
  // End of variables declaration//GEN-END:variables
    
    
}
