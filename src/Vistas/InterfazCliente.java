/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelos.Usuario;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controladores.ControladorBoleto;
import Modelos.Boleto;
import Controladores.ControladorFuncion;
import Controladores.ControladorUsuario;
import Modelos.Funcion;
import java.util.Arrays;
/**
 *
 * @author Marcela Alzate
 */
public class InterfazCliente extends javax.swing.JFrame {
    ControladorBoleto miControladorBoleto;
    ControladorFuncion miConttroladorFuncion;
    ControladorUsuario miControladorUsusario;
    Funcion miFuncion;
    /**
     * Creates new form InterfazCliente
     */
    public InterfazCliente() {
        initComponents();
        String urlServidor="http://127.0.0.1:8080";
        this.miControladorBoleto=new ControladorBoleto(urlServidor, "/boletos");
        this.miConttroladorFuncion=new ControladorFuncion(urlServidor, "/funciones");
        this.miControladorUsusario=new ControladorUsuario(urlServidor, "/usuarios");
        actualizarTablaBoletos();
        actualizarTablaUsuarios();
        actualizarComboFuncion();
    }
    public void actualizarTablaBoletos(){
        String nombresColumnas[] = {"_Id","Nombre usuario", "Tipo", "Valor", "Función","Silla"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombresColumnas);
        this.tbBoletos.setModel(miModelo);
        LinkedList<Boleto> boletos=this.miControladorBoleto.listar();
        for (Boleto actual:boletos) {
            String fila[] = new String[nombresColumnas.length];
            fila[0]=actual.getId();
            fila[1]=actual.getUsuario().getNombre();
            fila[2] = actual.getTipo();
            fila[3] = ""+(actual.getValor());            
            miModelo.addRow(fila);
        }
    }
    public void actualizarTablaUsuarios(){
        String nombresColumnas[] = {"Cedula", "Nombre", "Email", "Año nacimiento"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombresColumnas);
        this.tbUsuarios.setModel(miModelo);
        LinkedList<Usuario> usuarios=this.miControladorUsusario.listar();
        for (Usuario actual:usuarios) {
            String fila[] = new String[nombresColumnas.length];
            fila[0] = actual.getCedula();
            fila[1] = actual.getNombre();
            fila[2] = actual.getEmail();     
            fila[3] = ""+actual.getAioNacimiento();
            miModelo.addRow(fila);
        }
    }
    public void actualizarComboFuncion(){
        this.ComboFuncion.addItem("Hola");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ComboTipo = new javax.swing.JComboBox<>();
        txtValorBoleto = new javax.swing.JTextField();
        txtIdBoleto = new javax.swing.JTextField();
        txtCedulaUsuario = new javax.swing.JTextField();
        ComboFuncion = new javax.swing.JComboBox<>();
        ComboSilla = new javax.swing.JComboBox<>();
        btnCrearBoleto = new javax.swing.JButton();
        btnBuscarBoleto = new javax.swing.JButton();
        btnEditarBoleto = new javax.swing.JButton();
        btnEliminarBoleto = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBoletos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel1.setText("Cine Latino");

        jLabel2.setText("Id");

        jLabel3.setText("Valor");

        jLabel4.setText("Función");

        jLabel5.setText("Tipo");

        jLabel6.setText("Cédula Usuario");

        jLabel7.setText("Silla");

        ComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Niño", "Adulto" }));

        ComboFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboFuncionActionPerformed(evt);
            }
        });

        btnCrearBoleto.setText("Crear");
        btnCrearBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearBoletoActionPerformed(evt);
            }
        });

        btnBuscarBoleto.setText("Buscar");
        btnBuscarBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarBoletoActionPerformed(evt);
            }
        });

        btnEditarBoleto.setText("Editar");
        btnEditarBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarBoletoActionPerformed(evt);
            }
        });

        btnEliminarBoleto.setText("Eliminar");
        btnEliminarBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarBoletoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel8.setText("Tabla usuarios");

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel9.setText("Tabla boletos");

        tbBoletos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbBoletos);

        jScrollPane3.setViewportView(jScrollPane1);

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbUsuarios);

        jScrollPane4.setViewportView(jScrollPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(80, 80, 80)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtValorBoleto)
                                            .addComponent(ComboFuncion, 0, 158, Short.MAX_VALUE))))
                                .addGap(148, 148, 148)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCedulaUsuario)
                                    .addComponent(ComboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboSilla, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnCrearBoleto)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscarBoleto)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEditarBoleto)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminarBoleto))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(txtIdBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(997, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(ComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtValorBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedulaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(ComboFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboSilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearBoleto)
                    .addComponent(btnBuscarBoleto)
                    .addComponent(btnEditarBoleto)
                    .addComponent(btnEliminarBoleto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(txtIdBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(620, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Boletos", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboFuncionActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ComboFuncionActionPerformed

    private void btnCrearBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearBoletoActionPerformed
        // TODO add your handling code here:
        double valor = Double.parseDouble(this.txtValorBoleto.getText());
        String tipo = this.ComboTipo.getSelectedItem().toString();
        Boleto nuevoBoleto=new Boleto(valor, tipo);
        nuevoBoleto = this.miControladorBoleto.crear(nuevoBoleto);
        
        if(nuevoBoleto==null){
            JOptionPane.showMessageDialog(null, "Problemas al crear el boleto");
        }else{
            JOptionPane.showMessageDialog(null, "Boleto creado exitosamente");
            this.txtIdBoleto.setText(nuevoBoleto.getId());
        }  
        actualizarTablaBoletos();
        limpiarCampos();
    }//GEN-LAST:event_btnCrearBoletoActionPerformed

    private void btnBuscarBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarBoletoActionPerformed
        // TODO add your handling code here:
        String id = this.txtIdBoleto.getText();
        Boleto encontrado = this.miControladorBoleto.buscarPorId(id);
        if(encontrado != null){
            this.txtValorBoleto.setText(""+encontrado.getValor());
            this.txtCedulaUsuario.setText(encontrado.getUsuario().getCedula());
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro");
        }
    }//GEN-LAST:event_btnBuscarBoletoActionPerformed

    private void btnEditarBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarBoletoActionPerformed
        // TODO add your handling code here:
        double valor = Double.parseDouble(this.txtValorBoleto.getText());
        String tipo = ""+ this.ComboTipo.getSelectedItem();
        Usuario usuario = this.miControladorUsusario.buscarPorCedula(this.txtCedulaUsuario.getText());
        Boleto boletoActualizar = new Boleto(valor, tipo);
        Boleto actualizado = this.miControladorBoleto.actualizar(boletoActualizar);
        this.txtValorBoleto.setText(""+actualizado.getValor());
        this.txtCedulaUsuario.setText(actualizado.getUsuario().getCedula());
        actualizarTablaBoletos();
    }//GEN-LAST:event_btnEditarBoletoActionPerformed

    private void btnEliminarBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarBoletoActionPerformed
        // TODO add your handling code here:
        String id = this.txtIdBoleto.getText();
        this.miControladorBoleto.eliminar(id);
        JOptionPane.showMessageDialog(null, "Eliminado");
        actualizarTablaBoletos();
    }//GEN-LAST:event_btnEliminarBoletoActionPerformed
    public void limpiarCampos(){
        this.txtValorBoleto.setText("");
        this.txtCedulaUsuario.setText("");
        this.txtIdBoleto.setText("");
    }
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
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboFuncion;
    private javax.swing.JComboBox<String> ComboSilla;
    private javax.swing.JComboBox<String> ComboTipo;
    private javax.swing.JButton btnBuscarBoleto;
    private javax.swing.JButton btnCrearBoleto;
    private javax.swing.JButton btnEditarBoleto;
    private javax.swing.JButton btnEliminarBoleto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbBoletos;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JTextField txtCedulaUsuario;
    private javax.swing.JTextField txtIdBoleto;
    private javax.swing.JTextField txtValorBoleto;
    // End of variables declaration//GEN-END:variables
}
