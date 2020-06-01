package payroll_sys;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UpdateSalaryPage extends javax.swing.JFrame {

   Connection con;
    Statement stmt;
    ResultSet rs;
    String dd, dd1, dd2;
    String fn, ln, mn, ll, pg, dp, yr, fc;
    String ns, mt, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, t1, t2, t3, t4, rm;
    
    
    int rowCount = -1;
    public UpdateSalaryPage() {
        initComponents();
        
          
        //this.setExtendedState(Frame.MAXIMIZED_BOTH);
        
        //this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        
   
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        std_panel = new javax.swing.JPanel();
        txtFirstname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFirstname1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFirstname3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtFirstname4 = new javax.swing.JTextField();
        txtFirstname12 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtFirstname23 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        btnAdd_Student2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtFirstname7 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtFirstname8 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnUpdate3 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtFirstname22 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        btnAdd_Student = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        std_panel.setBackground(new java.awt.Color(255, 255, 255));
        std_panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        std_panel.setMinimumSize(new java.awt.Dimension(932, 611));
        std_panel.setPreferredSize(new java.awt.Dimension(932, 611));
        std_panel.setRequestFocusEnabled(false);
        std_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFirstname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFirstname.setEnabled(false);
        txtFirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstnameActionPerformed(evt);
            }
        });
        std_panel.add(txtFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 250, 30));

        jLabel6.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel6.setText("First name : ");
        std_panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 110, 30));

        txtFirstname1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFirstname1.setEnabled(false);
        std_panel.add(txtFirstname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 250, 30));

        jLabel7.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel7.setText("Middle name : ");
        std_panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 110, 30));

        txtFirstname3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFirstname3.setEnabled(false);
        std_panel.add(txtFirstname3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 250, 30));

        jLabel11.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel11.setText("Department : ");
        std_panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 110, 30));

        txtFirstname4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFirstname4.setEnabled(false);
        txtFirstname4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstname4ActionPerformed(evt);
            }
        });
        std_panel.add(txtFirstname4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 250, 30));

        txtFirstname12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFirstname12.setEnabled(false);
        std_panel.add(txtFirstname12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 250, 30));

        jLabel20.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel20.setText("Basic Salary : ");
        std_panel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 100, 30));

        jLabel19.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel19.setText("Surname : ");
        std_panel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 110, 30));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMPLOYEE", "OVERTIME", "MEDICAL", "BONUS", "OTHER", "SALARY", "RATE", "TOTAL AMOUNT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(table);

        std_panel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 1060, 250));

        txtFirstname23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFirstname23.setEnabled(false);
        std_panel.add(txtFirstname23, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 250, 30));

        jLabel29.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel29.setText("Employee ID : ");
        std_panel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 110, 30));

        btnAdd_Student2.setBackground(new java.awt.Color(163, 192, 192));
        btnAdd_Student2.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        btnAdd_Student2.setForeground(new java.awt.Color(16, 107, 35));
        btnAdd_Student2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payroll_sys/upd.png"))); // NOI18N
        btnAdd_Student2.setText("Update");
        btnAdd_Student2.setEnabled(false);
        btnAdd_Student2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnAdd_Student2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd_Student2ActionPerformed(evt);
            }
        });
        std_panel.add(btnAdd_Student2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 240, 160, 40));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jRadioButton1.setText("Amount");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        std_panel.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, 100, 30));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jRadioButton2.setText("Percentage %");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        std_panel.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 130, 30));

        jLabel22.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel22.setText("Update Salary By : ");
        std_panel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 130, 30));

        jLabel27.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel27.setText("Percentage % : ");
        std_panel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 130, 30));

        txtFirstname7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFirstname7.setEnabled(false);
        txtFirstname7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstname7ActionPerformed(evt);
            }
        });
        std_panel.add(txtFirstname7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 200, 30));

        jLabel26.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel26.setText("Amount : ");
        std_panel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 130, 30));

        txtFirstname8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFirstname8.setEnabled(false);
        txtFirstname8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstname8ActionPerformed(evt);
            }
        });
        std_panel.add(txtFirstname8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 200, 30));

        jPanel3.add(std_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 1100, 600));

        jPanel4.setBackground(new java.awt.Color(245, 245, 246));

        btnUpdate3.setBackground(new java.awt.Color(0, 102, 102));
        btnUpdate3.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        btnUpdate3.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate3.setText("HOME");
        btnUpdate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnUpdate3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(btnUpdate3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 80, 30));

        jLabel34.setBackground(new java.awt.Color(0, 204, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payroll_sys/logo.png"))); // NOI18N
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1012, 0, 120, 70));

        jLabel17.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Update Employee Salary");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 230, 30));

        jPanel5.setBackground(new java.awt.Color(245, 245, 246));

        txtFirstname22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Perpetua", 2, 18)); // NOI18N
        jLabel28.setText("Search by ID or Surname : ");

        btnAdd_Student.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd_Student.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        btnAdd_Student.setForeground(new java.awt.Color(16, 107, 35));
        btnAdd_Student.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payroll_sys/sec.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFirstname22, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd_Student, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFirstname22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 460, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstname4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstname4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstname4ActionPerformed

    private void txtFirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstnameActionPerformed

    private void btnUpdate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate3ActionPerformed
        // TODO add your handling code here:
        MainForm rs = new MainForm();
        rs.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnUpdate3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void txtFirstname7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstname7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstname7ActionPerformed

    private void txtFirstname8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstname8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstname8ActionPerformed

    private void btnAdd_Student2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd_Student2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd_Student2ActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateSalaryPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAdd_Student;
    public static javax.swing.JButton btnAdd_Student2;
    public static javax.swing.JButton btnUpdate3;
    private javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JPanel std_panel;
    private javax.swing.JTable table;
    public static javax.swing.JTextField txtFirstname;
    public static javax.swing.JTextField txtFirstname1;
    public static javax.swing.JTextField txtFirstname12;
    public static javax.swing.JTextField txtFirstname22;
    public static javax.swing.JTextField txtFirstname23;
    public static javax.swing.JTextField txtFirstname3;
    public static javax.swing.JTextField txtFirstname4;
    public static javax.swing.JTextField txtFirstname7;
    public static javax.swing.JTextField txtFirstname8;
    // End of variables declaration//GEN-END:variables
}
