/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mini_annuaire_desktop.Frames.Etudiants;


import com.mycompany.mini_annuaire_desktop.DAO.DepartementsDAO;
import com.mycompany.mini_annuaire_desktop.DAO.EtudiantDAO;
import com.mycompany.mini_annuaire_desktop.DAO.FiliereDAO;
import com.mycompany.mini_annuaire_desktop.Entity.Departement;
import com.mycompany.mini_annuaire_desktop.Entity.Etudiant;
import com.mycompany.mini_annuaire_desktop.Entity.Filiere;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KAOUTAR
 */
public class EtudiantList extends javax.swing.JFrame {
    
    private  EtudiantDAO etudiantDAO = new EtudiantDAO();
    private  FiliereDAO filiereDAO = new FiliereDAO();
    private  DepartementsDAO departementsDAO = new DepartementsDAO();

    /**
     * Creates new form DepartementList
     */
    public EtudiantList() {
        initComponents();
        fillDepartementsComboBox();
            String dep = "";
            String fil = "";
            try{
                fil = filComboBox.getSelectedItem().toString();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            
            try{
                dep = depComboBox.getSelectedItem().toString();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            initJTable();
            fillTableByHintResult(FilterInput.getText(),fil,dep);        

    }
    
    public void fillTable(){
        try {
              initJTable();
              ArrayList<Etudiant> etudiants = etudiantDAO.getAll();  
              DefaultTableModel model = (DefaultTableModel) DataTable.getModel();
              String[] rowData = new String[6];
              if(!etudiants.isEmpty()){
              for (int i=0 ; i<etudiants.size();i++){
                  rowData[0] = etudiants.get(i).getCNE().toString();
                  rowData[1] = etudiants.get(i).getNom();
                  rowData[2] = etudiants.get(i).getPrenom();
                  rowData[3] = etudiants.get(i).getTelephone();
                  rowData[4] = etudiants.get(i).getFiliere().getLabel();
                  rowData[5] = etudiants.get(i).getDepartement().getLabel();
                  model.addRow(rowData);

              }
              }
              
             } catch (SQLException ex) {
               System.out.println(ex.getStackTrace());
            }
             
    }
    
    public void initJTable(){
        DefaultTableModel model = (DefaultTableModel) DataTable.getModel();
        model.setRowCount(0);
    }
    
    public void fillTableByHintResult(String hint,String filiere,String departement){
        try {
              ArrayList<Etudiant> etudiants = etudiantDAO.getEtudiantsByHint(hint, filiere, departement);  
              DefaultTableModel model = (DefaultTableModel) DataTable.getModel();
              String[] rowData = new String[6];
              if(!etudiants.isEmpty()){
              for (int i=0 ; i<etudiants.size();i++){
                  rowData[0] = etudiants.get(i).getCNE().toString();
                  rowData[1] = etudiants.get(i).getNom();
                  rowData[2] = etudiants.get(i).getPrenom();
                  rowData[3] = etudiants.get(i).getTelephone();
                  rowData[4] = etudiants.get(i).getFiliere().getLabel();
                  rowData[5] = etudiants.get(i).getDepartement().getLabel();
                  model.addRow(rowData);

              }}
              
                            
             } catch (SQLException ex) {
               System.out.println(ex.getStackTrace());
            }
    }
    
    
    
    public void fillDepartementsComboBox(){
        try {
            // TODO add your handling code here:
            ArrayList<Departement> departements = departementsDAO.getAll();
            DefaultComboBoxModel model = (DefaultComboBoxModel) depComboBox.getModel();
            for (int i=0 ; i<departements.size();i++){
                model.addElement(departements.get(i).getLabel());
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     public void fillFilieresComboBox(String departement){
        try {
            // TODO add your handling code here:
            ArrayList<Filiere> filieres = filiereDAO.getFiliereByDepartement(departement);
            DefaultComboBoxModel model = (DefaultComboBoxModel) filComboBox.getModel();
            for (int i=0 ; i<filieres.size();i++){
                model.addElement(filieres.get(i).getLabel());
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        FilterInput = new javax.swing.JTextField();
        filComboBox = new javax.swing.JComboBox<>();
        depComboBox = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(200, 500));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(95, 206, 128));
        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(95, 206, 128));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(95, 206, 128));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel13, java.awt.BorderLayout.PAGE_START);

        jPanel14.setBackground(new java.awt.Color(95, 206, 128));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel14, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBackground(new java.awt.Color(95, 206, 128));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel3.setText("Utilisation");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("départements");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(95, 206, 128));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Filiéres");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("étudiants");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(42, 42, 42))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(200, 169));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel7.setText("Administration");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Inserer département");

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Inserer filiére");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Inserer étudiant");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(16, 16, 16))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(27, 27, 27))
        );

        jPanel3.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jPanel4.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        FilterInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FilterInput.setToolTipText("");
        FilterInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FilterInputFocusGained(evt);
            }
        });
        FilterInput.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                FilterInputInputMethodTextChanged(evt);
            }
        });
        FilterInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterInputActionPerformed(evt);
            }
        });
        FilterInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FilterInputKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FilterInputKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FilterInputKeyTyped(evt);
            }
        });

        filComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filComboBoxActionPerformed(evt);
            }
        });

        depComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(depComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(filComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FilterInput, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FilterInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Delete");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Inserer");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(129, 129, 129)
                .addComponent(jButton1)
                .addGap(177, 177, 177))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(38, 38, 38))
        );

        jPanel5.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel11, java.awt.BorderLayout.LINE_START);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel12, java.awt.BorderLayout.LINE_END);

        DataTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNE", "Nom", "Prenom", "Telephone", "Filiere", "Departement"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DataTable.setRowHeight(35);
        jScrollPane1.setViewportView(DataTable);

        jPanel10.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel10, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FilterInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FilterInputActionPerformed

    private void FilterInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FilterInputFocusGained
        // TODO add your handling code here:
       
    }//GEN-LAST:event_FilterInputFocusGained

    private void FilterInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilterInputKeyPressed
         if(FilterInput.getText().equals("Filtrer")){
            FilterInput.setText("");
        }
        
    }//GEN-LAST:event_FilterInputKeyPressed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
        int row = DataTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne pour la supprimer ! ","Oops",JOptionPane.CANCEL_OPTION);
        }
        else{
           int opt = JOptionPane.showConfirmDialog(null,"Vous voulez vraiment supprimer cette filiere ! ","Confirmation",JOptionPane.YES_NO_OPTION);
           if(opt == 0){
               try {
                   DefaultTableModel model = (DefaultTableModel) DataTable.getModel();
                   etudiantDAO.destroy(new Etudiant(Integer.parseInt(model.getValueAt(row, 0).toString()),model.getValueAt(row, 1).toString(),
                         model.getValueAt(row, 2).toString(),new Filiere(model.getValueAt(row, 4).toString(),new Departement(model.getValueAt(row, 5).toString())),
                           new Departement(model.getValueAt(row, 5).toString()),model.getValueAt(row, 3).toString()));
                   initJTable();
            String dep = "";
            String fil = "";
            try{
                fil = filComboBox.getSelectedItem().toString();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            
            try{
                dep = depComboBox.getSelectedItem().toString();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            fillTableByHintResult(FilterInput.getText(),fil,dep);                       } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Un erreur s'est produit !","Oops",JOptionPane.YES_NO_OPTION);
               }
           }
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void FilterInputInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_FilterInputInputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_FilterInputInputMethodTextChanged

    private void FilterInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilterInputKeyTyped
        // TODO add your handling code here:
            
    }//GEN-LAST:event_FilterInputKeyTyped

    private void FilterInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilterInputKeyReleased
        // TODO add your handling code here:
            String dep = "";
            String fil = "";
            try{
                fil = filComboBox.getSelectedItem().toString();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            
            try{
                dep = depComboBox.getSelectedItem().toString();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            initJTable();
            fillTableByHintResult(FilterInput.getText(),fil,dep);
    }//GEN-LAST:event_FilterInputKeyReleased

    private void filComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filComboBoxActionPerformed
        // TODO add your handling code here:
        String dep = "";
            String fil = "";
            try{
                fil = filComboBox.getSelectedItem().toString();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            
            try{
                dep = depComboBox.getSelectedItem().toString();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            initJTable();           
            fillTableByHintResult(FilterInput.getText(),fil,dep);
    }//GEN-LAST:event_filComboBoxActionPerformed

    private void depComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depComboBoxActionPerformed
        // TODO add your handling code here:
        filComboBox.removeAllItems();
        fillFilieresComboBox(depComboBox.getSelectedItem().toString());
        String dep = "";
            String fil = "";
            try{
                fil = filComboBox.getSelectedItem().toString();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            
            try{
                dep = depComboBox.getSelectedItem().toString();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            initJTable();           
            fillTableByHintResult(FilterInput.getText(),fil,dep);
    }//GEN-LAST:event_depComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(EtudiantList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EtudiantList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EtudiantList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EtudiantList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new EtudiantList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DataTable;
    private javax.swing.JTextField FilterInput;
    private javax.swing.JComboBox<String> depComboBox;
    private javax.swing.JComboBox<String> filComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
