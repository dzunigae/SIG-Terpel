/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontera;

import Control.Verificaciones;
import Entidad.Producto;

/**
 *
 * @author 192545681742
 */
public class consulta2 extends javax.swing.JPanel {

    /**
     * Creates new form consulta2
     */
    public consulta2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        consultarId1 = new javax.swing.JTextField();
        consultaP2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        resultado = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));

        consultaP2.setText("Consultar");
        consultaP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaP2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 0, 14)); // NOI18N
        jLabel1.setText("CONSULTAR PRODUCTO POR ID");

        jLabel2.setText("Identificación Producto");

        resultado.setFont(new java.awt.Font("Traditional Arabic", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(consultaP2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(resultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(consultarId1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultarId1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(consultaP2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void consultaP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaP2ActionPerformed
        try{
            Verificaciones ver= new Verificaciones();
            String text= consultarId1.getText();
            
             if(text.length()==0){
                resultado.setText("Es necesaria una ID válida para ésta operación");
            }else if(!ver.isNumeric(text)){
                resultado.setText("La ID debe ser un número");
            }else if(20<text.length()){
                resultado.setText("La ID no puede superar los 20 dígitos");
            }else if(!ver.VerificarExistenciaID(Integer.parseInt(text))){
                resultado.setText("No existe ningún producto registrado con ésta ID");
            }else{
                Producto p= new Producto();
                p.setId(Integer.parseInt(text));
                Producto producto=ver.dao.leerID(p);
                resultado.setText("Nombre: " + producto.getNombre() +" Cantidad: " + producto.getCantidad() +" Valor unitario: "+ producto.getValor() + " Categoría: " + producto.getCategoria());
                
            }
        }catch(javax.persistence.NoResultException e){
            
                    }
    }//GEN-LAST:event_consultaP2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consultaP2;
    private javax.swing.JTextField consultarId1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel resultado;
    // End of variables declaration//GEN-END:variables
}
