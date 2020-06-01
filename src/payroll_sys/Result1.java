package payroll_sys;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Result1 extends javax.swing.JFrame {

   Connection con;
    Statement stmt;
    ResultSet rs;
    String dd, dd1, dd2;
    String fn, ln, mn, ll, pg, dp, yr, fc;
    String sn, ns, mt, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12,c13, t1, t2, t3, t4, rm;
    
    
    int rowCount = -1;
    public Result1() {
        initComponents();
        
          
        //this.setExtendedState(Frame.MAXIMIZED_BOTH);
        
        table1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table1.getTableHeader().setOpaque(false);
        table1.getTableHeader().setBackground(new Color(225, 225, 225));
        table1.getTableHeader().setForeground(new Color(3, 3, 3));
        table1.getTableHeader().setPreferredSize(new Dimension(30, 90));
        table1.setRowHeight(30);
            
        table2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table2.getTableHeader().setOpaque(false);
        table2.getTableHeader().setBackground(new Color(204, 0, 0));
        table2.getTableHeader().setForeground(new Color(3, 3, 3));
        table2.getTableHeader().setPreferredSize(new Dimension(30, 90));
        table2.setRowHeight(30);
        
        table3.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table3.getTableHeader().setOpaque(false);
        table3.getTableHeader().setBackground(new Color(204, 0, 0));
        table3.getTableHeader().setForeground(new Color(3, 3, 3));
        table3.getTableHeader().setPreferredSize(new Dimension(30, 90));
        table3.setRowHeight(30);
        
        table4.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table4.getTableHeader().setOpaque(false);
        table4.getTableHeader().setBackground(new Color(204, 0, 0));
        table4.getTableHeader().setForeground(new Color(3, 3, 3));
        table4.getTableHeader().setPreferredSize(new Dimension(30, 90));
        table4.setRowHeight(30);
        
        
        rst_panel.setVisible(true);
        //this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        
        
                  jScrollPane3.setVisible(true);
                  jScrollPane4.setVisible(false);
                  jScrollPane5.setVisible(false);
                  jScrollPane6.setVisible(false);
        
          try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; database=Result_DB; user=sa; password=Tunani14real;";
            Connection connect = DriverManager.getConnection(url);
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("select * from Faculty_Table");
            
           while(rs.next()){
               
               drpFaculty1.addItem(rs.getString("Faculty"));
               
           }
           connect.close();
           
        }catch(Exception Error){
            
               JOptionPane.showMessageDialog(null, Error);
        }
     
           
        TableCellRenderer headerRenderer = new VerticalTableHeaderCellRenderer();
        Enumeration column1 = table1.getColumnModel().getColumns();
        while (column1.hasMoreElements()) {
           ((TableColumn) column1.nextElement()).setHeaderRenderer(headerRenderer);
        }
        Enumeration column2 = table2.getColumnModel().getColumns();
        while (column2.hasMoreElements()) {
           ((TableColumn) column2.nextElement()).setHeaderRenderer(headerRenderer);
        }
        Enumeration column3 = table3.getColumnModel().getColumns();
        while (column3.hasMoreElements()) {
           ((TableColumn) column3.nextElement()).setHeaderRenderer(headerRenderer);
        }
        Enumeration column4 = table4.getColumnModel().getColumns();
        while (column4.hasMoreElements()) {
           ((TableColumn) column4.nextElement()).setHeaderRenderer(headerRenderer);
        }
        
                  //table1.disable();
               // table1.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());
       
              if(drpFaculty1.getSelectedItem().equals("SCIENCE")){
                  jScrollPane4.setVisible(false);
                  jScrollPane5.setVisible(false);
                  jScrollPane6.setVisible(false);
                            drpDepart1.setSelectedItem("COMPUTER & INFORMATION SCIENCES");
                            drpProg1.setSelectedItem("B.Sc Information Tech");
                try
                {
                    DefaultTableModel model=(DefaultTableModel)table1.getModel();
                    //String[] columns = {"Column 1","Column 2"};
                    //model.setColumnCount(0);
                    model.setRowCount(0);

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433; database=Result_DB; user=sa; password=Tunani14real;";
                    Connection connect = DriverManager.getConnection(url);
                    Statement st = connect.createStatement();
                    String sql = "select * from SRT_DP1_vw_Table where Faculty = ? and Programme = 'B.Sc Information Tech' order by Matric_No ASC";

                    
                        PreparedStatement pst = connect.prepareStatement(sql);
                        pst.setString(1, String.valueOf(drpFaculty1.getSelectedItem()));
                        
                        ResultSet rs = pst.executeQuery();
                        
                        while(rs.next())
                        {
                            
                        
                            txtSection.setText(rs.getString("Year"));
                            txtLevel.setText(rs.getString("Level"));
                            txtSem.setText(rs.getString("Semester"));
                            
                            sn=rs.getString("SRT_ID");
                            //ns=rs.getString("Names");
                            mt=rs.getString("Matric_No");
                            c1=rs.getString("MTH111");
                            c2=rs.getString("BIO117");
                            c3=rs.getString("CSC111");
                            c4=rs.getString("CHM111");
                            c5=rs.getString("PHY111");
                            c6=rs.getString("PHY119");
                            c7=rs.getString("EDS111");
                            c8=rs.getString("GST111");
                            c9=rs.getString("GST112");
                            c10=rs.getString("CHM119");
                            c11=rs.getString("CIT111");
                            c12=rs.getString("BIO111");
                            t1=rs.getString("TCP");
                            t2=rs.getString("TNUR");
                            t3=rs.getString("TNUP");
                            t4=rs.getString("GPA");
                            rm=rs.getString("Remarks");
                            Object[] row = {sn,mt, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, t1, t2, t3, t4, rm};
                            //model.addColumn(columns);
                            model.addRow(row);
                        }


                    }
                catch(SQLException e)

                    {


            System.out.println("Could not retrieve database metadata " + e.getMessage());

            }catch (ClassNotFoundException ex) {
                        //Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }

              }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rst_panel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        drpDepart1 = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtSem = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtSection = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        lblCord = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jLabel56 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtLevel = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        drpProg1 = new javax.swing.JComboBox<>();
        drpFaculty1 = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        table4 = new javax.swing.JTable();
        btnAdd_Student = new javax.swing.JButton();
        btnAdd_Student1 = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rst_panel.setBackground(new java.awt.Color(255, 255, 255));
        rst_panel.setMinimumSize(new java.awt.Dimension(932, 611));
        rst_panel.setPreferredSize(new java.awt.Dimension(932, 611));
        rst_panel.setRequestFocusEnabled(false);
        rst_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S/N", "MATRIC NO", "MTH 111 (3)", "BIO 117 (1)", "CSC 111 (3)", "CHM 111 (3)", "CHM 119 (1)", "PHY 111 (3)", "PHY 119 (1)", "BIO 111 (3)", "EDS 111 (1)", "GST 111 (2)", "GST 112 (2)", "CIT 111 (1)", "TCP", "TNUR", "TNUP", "GPA", "REMARKS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFocusable(false);
        table1.setGridColor(new java.awt.Color(0, 0, 0));
        table1.setIntercellSpacing(new java.awt.Dimension(2, 2));
        table1.setOpaque(false);
        table1.setRowHeight(30);
        table1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        table1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(1).setPreferredWidth(180);
            table1.getColumnModel().getColumn(18).setPreferredWidth(200);
        }

        rst_panel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 1350, 330));

        drpDepart1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        drpDepart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drpDepart1ActionPerformed(evt);
            }
        });
        rst_panel.add(drpDepart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 320, 20));

        jLabel30.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jLabel30.setText("DEPARTMENT :");
        rst_panel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 110, 20));

        jLabel31.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jLabel31.setText("PROGRAMME :");
        rst_panel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 110, 20));

        jLabel33.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("CITY CAMPUS, OFF ALARA STREET, YABA, LAGOS, NIGERIA");
        rst_panel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 510, 30));

        txtSem.setEditable(false);
        txtSem.setBackground(new java.awt.Color(255, 255, 255));
        txtSem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSem.setBorder(null);
        rst_panel.add(txtSem, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 170, 20));

        jLabel34.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jLabel34.setText("SEMESTER :");
        rst_panel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 90, 20));

        jLabel35.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jLabel35.setText("SESSION :");
        rst_panel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 80, 20));

        txtSection.setEditable(false);
        txtSection.setBackground(new java.awt.Color(255, 255, 255));
        txtSection.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSection.setBorder(null);
        rst_panel.add(txtSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 220, 20));

        jLabel36.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N
        jLabel36.setText("B.Sc  Examination");
        rst_panel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 190, 20));

        jLabel37.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("F - 0 -- 44");
        rst_panel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, 80, 10));

        jLabel38.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jLabel38.setText("TITLE OF EXAMINATION :");
        rst_panel.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 180, 20));

        jLabel39.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jLabel39.setText("FACULTY :");
        rst_panel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 80, 20));

        jLabel40.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("GRADE");
        rst_panel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 80, 10));

        jLabel41.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("A - 70 -- 100");
        rst_panel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 90, 10));

        jLabel42.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("B - 60 -- 69");
        rst_panel.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 80, 10));

        jLabel43.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("C - 50 -- 59");
        rst_panel.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 660, 80, 10));

        jLabel44.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("D - 45 -- 49");
        rst_panel.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 680, 80, 10));

        jLabel45.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("LEGEND");
        rst_panel.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 610, 70, 20));

        jLabel46.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("TCP -- Total Credits Points");
        rst_panel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 630, 140, 20));

        jLabel47.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("TNUR -- Total Number of Units Registered");
        rst_panel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 650, 220, 20));

        jLabel48.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("TNUP -- Total Number of Units Passed");
        rst_panel.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 670, 220, 20));

        jLabel49.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("GPA -- Grade Point Average");
        rst_panel.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 690, 190, 20));

        lblCord.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        rst_panel.add(lblCord, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 670, 270, 30));

        jLabel51.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel51.setText("Name & Signature:_______________");
        rst_panel.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 650, 280, 30));

        jLabel52.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel52.setText("Signature: ____________");
        rst_panel.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 640, 190, 30));

        jLabel53.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Dean of Faculty");
        rst_panel.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 670, 160, 30));

        jLabel54.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Prof C. K. Ayo");
        rst_panel.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 660, 130, 30));

        jLabel55.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel55.setText("Vice ");
        rst_panel.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 680, 40, 30));

        table2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S/N", "MATRIC NO", "MAC 111 (2)", "MAC 112 (2)", "MAC 113 (2)", "MAC 114 (2)", "MAC 115 (2)", "MAC 116 (2)", "ENG 111 (2)", "EDS 111 (1)", "GST 111 (2)", "GST 112 (2)", "CIT 111 (1)", "TCP", "TNUR", "TNUP", "GPA", "REMARKS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table2.setFocusable(false);
        table2.setGridColor(new java.awt.Color(255, 255, 255));
        table2.setIntercellSpacing(new java.awt.Dimension(2, 2));
        table2.setOpaque(false);
        table2.setRowHeight(30);
        table2.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        table2.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(0).setPreferredWidth(40);
            table2.getColumnModel().getColumn(1).setPreferredWidth(180);
            table2.getColumnModel().getColumn(17).setPreferredWidth(200);
        }

        rst_panel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 1350, 330));

        jLabel8.setBackground(new java.awt.Color(0, 204, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payroll_sys/b.png"))); // NOI18N
        rst_panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 200, 80));

        table3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S/N", "MATRIC NO", "MCB 111 (3)", "BIO 111 (3)", "BIO 117 (1)", "CHM 111 (3)", "CHM 119 (1)", "MAT 111 (3)", "PHY 111 (3)", "EDS 111 (1)", "GST 111 (2)", "GST 112 (2)", "PHY 119 (1)", "CIT 111 (1)", "TCP", "TNUR", "TNUP", "GPA", "REMARKS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table3.setFocusable(false);
        table3.setGridColor(new java.awt.Color(255, 255, 255));
        table3.setIntercellSpacing(new java.awt.Dimension(2, 2));
        table3.setOpaque(false);
        table3.setRowHeight(30);
        table3.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table3.setSelectionForeground(new java.awt.Color(0, 0, 0));
        table3.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(table3);
        if (table3.getColumnModel().getColumnCount() > 0) {
            table3.getColumnModel().getColumn(1).setPreferredWidth(180);
            table3.getColumnModel().getColumn(18).setPreferredWidth(200);
        }

        rst_panel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 1350, 330));

        jLabel56.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("COORDINATOR,");
        rst_panel.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 670, 110, 30));

        jLabel50.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jLabel50.setText("LEVEL :");
        rst_panel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 90, 20));

        txtLevel.setEditable(false);
        txtLevel.setBackground(new java.awt.Color(255, 255, 255));
        txtLevel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtLevel.setBorder(null);
        rst_panel.add(txtLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 150, 20));

        jLabel57.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel57.setText("Name & Signature: ______________");
        rst_panel.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 650, 260, 30));

        jLabel58.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel58.setText("Chancellor");
        rst_panel.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 680, 90, 30));

        drpProg1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        drpProg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drpProg1ActionPerformed(evt);
            }
        });
        rst_panel.add(drpProg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 320, 20));

        drpFaculty1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        drpFaculty1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drpFaculty1ActionPerformed(evt);
            }
        });
        rst_panel.add(drpFaculty1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 320, 20));

        table4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        table4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S/N", "MATRIC NO", "MTH 111 (3)", "MTH 113 (2)", "CSC 111 (3)", "CHM 111 (3)", "CHM 119 (1)", "PHY 111 (3)", "PHY 119 (1)", "BIO 111 (3)", "EDS 111 (1)", "GST 111 (2)", "GST 112 (2)", "CIT 111 (1)", "TCP", "TNUR", "TNUP", "GPA", "REMARKS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table4.setFocusable(false);
        table4.setGridColor(new java.awt.Color(0, 0, 0));
        table4.setIntercellSpacing(new java.awt.Dimension(2, 2));
        table4.setOpaque(false);
        table4.setRowHeight(30);
        table4.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table4.setSelectionForeground(new java.awt.Color(0, 0, 0));
        table4.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(table4);
        if (table4.getColumnModel().getColumnCount() > 0) {
            table4.getColumnModel().getColumn(1).setPreferredWidth(180);
            table4.getColumnModel().getColumn(18).setPreferredWidth(200);
        }

        rst_panel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 1350, 330));

        jPanel1.add(rst_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1370, 720));

        btnAdd_Student.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd_Student.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btnAdd_Student.setForeground(new java.awt.Color(204, 0, 51));
        btnAdd_Student.setText("PRINT");
        btnAdd_Student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd_StudentActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd_Student, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 5, 90, 20));

        btnAdd_Student1.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd_Student1.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btnAdd_Student1.setForeground(new java.awt.Color(204, 0, 51));
        btnAdd_Student1.setText("<< back");
        btnAdd_Student1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd_Student1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd_Student1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 90, 20));

        btnExport.setBackground(new java.awt.Color(255, 255, 255));
        btnExport.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExport.setForeground(new java.awt.Color(204, 0, 51));
        btnExport.setText("Export (Excel)");
        btnExport.setEnabled(false);
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        jPanel1.add(btnExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 7, 140, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void drpDepart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drpDepart1ActionPerformed
        // TODO add your handling code here:
           
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; database=Result_DB; user=sa; password=Tunani14real;";
            Connection connect = DriverManager.getConnection(url);
            String sql = "select * from Programme_vw_Table where Faculty = ? and Department = ?";
            PreparedStatement pst = connect.prepareStatement(sql);

            drpProg1.removeAllItems();
            pst.setString(1, String.valueOf(drpFaculty1.getSelectedItem()));
            pst.setString(2, String.valueOf(drpDepart1.getSelectedItem()));
            ResultSet rs = pst.executeQuery();

            while(rs.next()){

                drpProg1.addItem(rs.getString("Programme"));

            }
            connect.close();

        }catch(Exception Error){

            JOptionPane.showMessageDialog(null, Error);
        }
        
        /*
              if(drpDepart1.getSelectedItem().equals("COMPUTER & INFORMATION SCIENCES") & drpProg1.getSelectedItem().equals("B.Sc Computer Science")){
                  jScrollPane3.setVisible(true);
                  jScrollPane4.setVisible(false);
                  jScrollPane5.setVisible(false);
                try
                {
                    DefaultTableModel model=(DefaultTableModel)table1.getModel();
                    //String[] columns = {"Column 1","Column 2"};
                    //model.setColumnCount(0);
                    model.setRowCount(0);

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433; database=Result_DB; user=sa; password=Tunani14real;";
                    Connection connect = DriverManager.getConnection(url);
                    String sql = "select * from SRT_DP1_vw_Table where Department = ? and Programme = 'B.Sc Information Tech'  order by Matric_No ASC";

                    
                        PreparedStatement pst = connect.prepareStatement(sql);
                        pst.setString(1, String.valueOf(drpDepart1.getSelectedItem()));
                        lblCord.setText(drpDepart1.getSelectedItem().toString());
                        
                        ResultSet rs = pst.executeQuery();
                        while(rs.next())
                        {
                            
                            //lblCord.setText(rs.getString("Department"));
                            txtFaculty1.setText(rs.getString("Faculty"));
                            //drpProg1.addItem(rs.getString("Programme"));
                            txtSection.setText(rs.getString("Year"));
                            txtLevel.setText(rs.getString("Level"));
                            txtSem.setText(rs.getString("Semester"));
                            
                            sn=rs.getString("SRT_ID");
                            //ns=rs.getString("Names");
                            mt=rs.getString("Matric_No");
                            c1=rs.getString("MTH111");
                            c2=rs.getString("BIO117");
                            c3=rs.getString("CSC111");
                            c4=rs.getString("CHM111");
                            c5=rs.getString("PHY111");
                            c6=rs.getString("PHY119");
                            c7=rs.getString("EDS111");
                            c8=rs.getString("GST111");
                            c9=rs.getString("GST112");
                            c10=rs.getString("CHM119");
                            c11=rs.getString("CIT111");
                            c12=rs.getString("BIO111");
                            t1=rs.getString("TCP");
                            t2=rs.getString("TNUR");
                            t3=rs.getString("TNUP");
                            t4=rs.getString("GPA");
                            rm=rs.getString("Remarks");
                            Object[] row = {sn,mt, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, t1, t2, t3, t4, rm};
                            //model.addColumn(columns);
                            model.addRow(row);
                        }


                    }
                catch(SQLException e)

                    {


            System.out.println("Could not retrieve database metadata " + e.getMessage());

            }catch (ClassNotFoundException ex) {
                        //Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }

              }
              else if(drpDepart1.getSelectedItem().equals("MASS COMMUNICATION") & drpProg1.getSelectedItem().equals("B.Sc Mass Communication")){
                  jScrollPane3.setVisible(false);
                  jScrollPane5.setVisible(false);
                  jScrollPane4.setVisible(true);
                try
                {
                    DefaultTableModel model=(DefaultTableModel)table2.getModel();
                    //String[] columns = {"Column 1","Column 2"};
                    //model.setColumnCount(0);
                    model.setRowCount(0);

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433; database=Result_DB; user=sa; password=Tunani14real;";
                    Connection connect = DriverManager.getConnection(url);
                    //Statement st = connect.createStatement();
                    String sql = "select * from SRT_DP1_vw_Table where Department = ? and Semester = 'FIRST'  order by Matric_No ASC";

                    
                        PreparedStatement pst = connect.prepareStatement(sql);
                        pst.setString(1, String.valueOf(drpDepart1.getSelectedItem()));
                        lblCord.setText(drpDepart1.getSelectedItem().toString());
                        
                        ResultSet rs = pst.executeQuery();
                        while(rs.next())
                        {
                            
                            //lblCord.setText(rs.getString("Department"));
                            txtFaculty1.setText(rs.getString("Faculty"));
                            //drpProg1.addItem(rs.getString("Programme"));
                            txtSection.setText(rs.getString("Year"));
                            txtLevel.setText(rs.getString("Level"));
                            txtSem.setText(rs.getString("Semester"));
                            
                            sn=rs.getString("SRT_ID");
                            //ns=rs.getString("Names");
                            mt=rs.getString("Matric_No");
                            c1=rs.getString("MAC111");
                            c2=rs.getString("MAC112");
                            c3=rs.getString("MAC113");
                            c4=rs.getString("MAC114");
                            c5=rs.getString("MAC115");
                            c6=rs.getString("MAC116");
                            c7=rs.getString("ENG111");
                            c8=rs.getString("EDS111");
                            c9=rs.getString("GST111");
                            c10=rs.getString("GST112");
                           // c11=rs.getString("GST123");
                            c11=rs.getString("CIT111");
                            t1=rs.getString("TCP");
                            t2=rs.getString("TNUR");
                            t3=rs.getString("TNUP");
                            t4=rs.getString("GPA");
                            rm=rs.getString("Remarks");
                            Object[] row = {sn,mt, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10,c11, t1, t2, t3, t4, rm};
                            //model.addColumn(columns);
                            model.addRow(row);
                        }


                    }
                catch(SQLException e)

                    {


            System.out.println("Could not retrieve database metadata " + e.getMessage());

            }catch (ClassNotFoundException ex) {
                        //Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }

              }
              else if(drpDepart1.getSelectedItem().equals("BIOLOGICAL SCIENCES") & drpProg1.getSelectedItem().equals("B.Sc Biology")){
                  jScrollPane3.setVisible(false);
                  jScrollPane4.setVisible(false);
                  jScrollPane5.setVisible(true);
                try
                {
                    DefaultTableModel model=(DefaultTableModel)table3.getModel();
                    //String[] columns = {"Column 1","Column 2"};
                    //model.setColumnCount(0);
                    model.setRowCount(0);

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433; database=Result_DB; user=sa; password=Tunani14real;";
                    Connection connect = DriverManager.getConnection(url);
                    String sql = "select * from SRT_DP1_vw_Table where Department = ? and Semester = 'FIRST'  order by Matric_No ASC";

                    
                        PreparedStatement pst = connect.prepareStatement(sql);
                        pst.setString(1, String.valueOf(drpDepart1.getSelectedItem()));
                        lblCord.setText(drpDepart1.getSelectedItem().toString());
                        
                        ResultSet rs = pst.executeQuery();
                        while(rs.next())
                        {
                            
                            //lblCord.setText(rs.getString("Department"));
                            txtFaculty1.setText(rs.getString("Faculty"));
                            drpProg1.addItem(rs.getString("Programme"));
                            txtSection.setText(rs.getString("Year"));
                            txtLevel.setText(rs.getString("Level"));
                            txtSem.setText(rs.getString("Semester"));
                            
                            sn=rs.getString("SRT_ID");
                            //ns=rs.getString("Names");
                            mt=rs.getString("Matric_No");
                            c1=rs.getString("MCB111");
                            c2=rs.getString("BIO111");
                            c3=rs.getString("BIO117");
                            c4=rs.getString("CHM111");
                            c5=rs.getString("CHM119");
                            c6=rs.getString("MAT111");
                            c7=rs.getString("PHY111");
                            c9=rs.getString("EDS111");
                            c10=rs.getString("GST111");
                            c11=rs.getString("GST112");
                            c12=rs.getString("PHY119");
                            c13=rs.getString("CIT111");
                            t1=rs.getString("TCP");
                            t2=rs.getString("TNUR");
                            t3=rs.getString("TNUP");
                            t4=rs.getString("GPA");
                            rm=rs.getString("Remarks");
                            Object[] row = {sn,mt, c1, c2, c3, c4, c5, c6, c7, c9, c10, c11,c12,c13, t1, t2, t3, t4, rm};
                            //model.addColumn(columns);
                            model.addRow(row);
                        }


                    }
                catch(SQLException e)

                    {


            System.out.println("Could not retrieve database metadata " + e.getMessage());

            }catch (ClassNotFoundException ex) {
                        //Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }

              }
              else{
                  table1.disable();
              }*/
    }//GEN-LAST:event_drpDepart1ActionPerformed

    private void btnAdd_StudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd_StudentActionPerformed
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setJobName("Print Job");
                
                job.setPrintable(new Printable(){
                public int print(Graphics pg,PageFormat pf, int pageNum){
                        pf.setOrientation(PageFormat.LANDSCAPE);
                        if(pageNum>0){
                            return Printable.NO_SUCH_PAGE;
                        }
                        
                        java.awt.Graphics2D g2 = (java.awt.Graphics2D)pg;
                        g2.translate(pf.getImageableX(), pf.getImageableY());
                        g2.scale(0.61, 0.79);
                        
                        rst_panel.paint(g2);
                        
                        return Printable.PAGE_EXISTS;
                    }
                });
                
            boolean ok = job.printDialog();
            if(ok){
                try{
                    job.print();
                }catch (PrinterException er){}
            }
    }//GEN-LAST:event_btnAdd_StudentActionPerformed

    private void btnAdd_Student1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd_Student1ActionPerformed
        // TODO add your handling code here:
        MainForm rs = new MainForm();
        rs.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAdd_Student1ActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:

        JFileChooser save = new JFileChooser();
        save.setDialogTitle("Save as...");
        save.setFileFilter(new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm"));
        int choose = save.showSaveDialog(null);

        if(choose == JFileChooser.APPROVE_OPTION) {
            XSSFWorkbook export = new XSSFWorkbook();
            XSSFSheet sheet1 = export.createSheet("Result Sheet");
            XSSFFont sheetTitleFont = export.createFont();
            XSSFCellStyle cellStyle = export.createCellStyle();
            sheetTitleFont.setFontHeightInPoints((short) 14);
            sheetTitleFont.setBold(true);
            sheetTitleFont.setFontName("Arials");

            try{

                TableModel model = table1.getModel();
                //DefaultTableModel model=(DefaultTableModel)table.getModel();
                //model.setRowCount(0);

                TableColumnModel modelc = table1.getTableHeader().getColumnModel();

                /*
                XSSFRow JRow = sheet1.createRow((short) 0);
                for(int j = 0; j < 4; j++) {
                    XSSFCell cc = JRow.createCell(4);
                    cc.setCellValue("Ade");
                    cc.setCellStyle(cellStyle);
                }
                */

                //Get Header
                //TableColumnModel tcm = table.getColumnModel();
                XSSFRow hRow = sheet1.createRow((short) 0);
                for(int j = 0; j < modelc.getColumnCount(); j++) {
                    XSSFCell cell_h = hRow.createCell((short) j);
                    cell_h.setCellValue(modelc.getColumn(j).getHeaderValue().toString());
                    cell_h.setCellStyle(cellStyle);
                }

                //Get Other details
                for (int i = 0; i < model.getRowCount(); i++) {
                    XSSFRow fRow = sheet1.createRow((short) i+1);
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        XSSFCell cell_r = fRow.createCell((short) j);
                        cell_r.setCellValue(model.getValueAt(i, j).toString());
                        cell_r.setCellStyle(cellStyle);
                    }
                }
                FileOutputStream otp = new FileOutputStream(save.getSelectedFile()+".xlsx");
                try (BufferedOutputStream bos = new BufferedOutputStream(otp)) {
                    export.write(bos);
                }
                otp.close();

                JOptionPane.showMessageDialog(null, "Report generated successfully!");
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_btnExportActionPerformed

    private void drpProg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drpProg1ActionPerformed
        // TODO add your handling code here:
        if(drpProg1.getSelectedItem().equals("B.Sc Computer Science")){
                  jScrollPane6.setVisible(true);
                  jScrollPane4.setVisible(false);
                  jScrollPane5.setVisible(false);
                  jScrollPane3.setVisible(false);
                try
                {
                    DefaultTableModel model=(DefaultTableModel)table4.getModel();
                    //String[] columns = {"Column 1","Column 2"};
                    //model.setColumnCount(0);
                    model.setRowCount(0);

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433; database=Result_DB; user=sa; password=Tunani14real;";
                    Connection connect = DriverManager.getConnection(url);
                    String sql = "select * from SRT_DP1_vw_Table where Faculty = ? and Department = ? and Programme = 'B.Sc Computer Science' order by Matric_No ASC";

                    
                        PreparedStatement pst = connect.prepareStatement(sql);
                        pst.setString(1, String.valueOf(drpFaculty1.getSelectedItem()));
                        pst.setString(2, String.valueOf(drpDepart1.getSelectedItem()));
                        lblCord.setText(drpDepart1.getSelectedItem().toString());
                        
                        ResultSet rs = pst.executeQuery();
                        while(rs.next())
                        {
                            
                            //lblCord.setText(rs.getString("Department"));
                            //txtFaculty1.setText(rs.getString("Faculty"));
                            //drpProg1.addItem(rs.getString("Programme"));
                            txtSection.setText(rs.getString("Year"));
                            txtLevel.setText(rs.getString("Level"));
                            txtSem.setText(rs.getString("Semester"));
                            
                            sn=rs.getString("SRT_ID");
                            //ns=rs.getString("Names");
                            mt=rs.getString("Matric_No");
                            c1=rs.getString("MTH111");
                            c2=rs.getString("MTH113");
                            c3=rs.getString("CSC111");
                            c4=rs.getString("CHM111");
                            c5=rs.getString("PHY111");
                            c6=rs.getString("PHY119");
                            c7=rs.getString("EDS111");
                            c8=rs.getString("GST111");
                            c9=rs.getString("GST112");
                            c10=rs.getString("CHM119");
                            c11=rs.getString("CIT111");
                            c12=rs.getString("BIO111");
                            t1=rs.getString("TCP");
                            t2=rs.getString("TNUR");
                            t3=rs.getString("TNUP");
                            t4=rs.getString("GPA");
                            rm=rs.getString("Remarks");
                            Object[] row = {sn,mt, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, t1, t2, t3, t4, rm};
                            //model.addColumn(columns);
                            model.addRow(row);
                        }


                    }
                catch(SQLException e)

                    {


            System.out.println("Could not retrieve database metadata " + e.getMessage());

            }catch (ClassNotFoundException ex) {
                        //Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }

              }
              else if(drpProg1.getSelectedItem().equals("B.Sc Information Tech")){
                  jScrollPane3.setVisible(true);
                  jScrollPane4.setVisible(false);
                  jScrollPane5.setVisible(false);
                  jScrollPane6.setVisible(false);
                try
                {
                    DefaultTableModel model=(DefaultTableModel)table1.getModel();
                    //String[] columns = {"Column 1","Column 2"};
                    //model.setColumnCount(0);
                    model.setRowCount(0);

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433; database=Result_DB; user=sa; password=Tunani14real;";
                    Connection connect = DriverManager.getConnection(url);
                    String sql = "select * from SRT_DP1_vw_Table where Faculty = ? and Department = ? and Programme = 'B.Sc Information Tech' order by Matric_No ASC";

                    
                        PreparedStatement pst = connect.prepareStatement(sql);
                        pst.setString(1, String.valueOf(drpFaculty1.getSelectedItem()));
                        pst.setString(2, String.valueOf(drpDepart1.getSelectedItem()));
                        lblCord.setText(drpDepart1.getSelectedItem().toString());
                        
                        ResultSet rs = pst.executeQuery();
                        while(rs.next())
                        {
                            
                            //lblCord.setText(rs.getString("Department"));
                            //txtFaculty1.setText(rs.getString("Faculty"));
                            //drpProg1.addItem(rs.getString("Programme"));
                            txtSection.setText(rs.getString("Year"));
                            txtLevel.setText(rs.getString("Level"));
                            txtSem.setText(rs.getString("Semester"));
                            
                            sn=rs.getString("SRT_ID");
                            //ns=rs.getString("Names");
                            mt=rs.getString("Matric_No");
                            c1=rs.getString("MTH111");
                            c2=rs.getString("BIO117");
                            c3=rs.getString("CSC111");
                            c4=rs.getString("CHM111");
                            c5=rs.getString("PHY111");
                            c6=rs.getString("PHY119");
                            c7=rs.getString("EDS111");
                            c8=rs.getString("GST111");
                            c9=rs.getString("GST112");
                            c10=rs.getString("CHM119");
                            c11=rs.getString("CIT111");
                            c12=rs.getString("BIO111");
                            t1=rs.getString("TCP");
                            t2=rs.getString("TNUR");
                            t3=rs.getString("TNUP");
                            t4=rs.getString("GPA");
                            rm=rs.getString("Remarks");
                            Object[] row = {sn,mt, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, t1, t2, t3, t4, rm};
                            //model.addColumn(columns);
                            model.addRow(row);
                        }


                    }
                catch(SQLException e)

                    {


            System.out.println("Could not retrieve database metadata " + e.getMessage());

            }catch (ClassNotFoundException ex) {
                        //Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }

              }else if(drpProg1.getSelectedItem().equals("B.Sc Mass Communication")){
                  jScrollPane3.setVisible(false);
                  jScrollPane5.setVisible(false);
                  jScrollPane6.setVisible(false);
                  jScrollPane4.setVisible(true);
                try
                {
                    DefaultTableModel model=(DefaultTableModel)table2.getModel();
                    //String[] columns = {"Column 1","Column 2"};
                    //model.setColumnCount(0);
                    model.setRowCount(0);

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433; database=Result_DB; user=sa; password=Tunani14real;";
                    Connection connect = DriverManager.getConnection(url);
                    //Statement st = connect.createStatement();
                    String sql = "select * from SRT_DP1_vw_Table where Faculty = ? and Department = ? and Programme = 'B.Sc Mass Communication'  order by Matric_No ASC";

                    
                        PreparedStatement pst = connect.prepareStatement(sql);
                        pst.setString(1, String.valueOf(drpFaculty1.getSelectedItem()));
                        pst.setString(2, String.valueOf(drpDepart1.getSelectedItem()));
                        lblCord.setText(drpDepart1.getSelectedItem().toString());
                        
                        ResultSet rs = pst.executeQuery();
                        while(rs.next())
                        {
                            
                            //lblCord.setText(rs.getString("Department"));
                            //txtFaculty1.setText(rs.getString("Faculty"));
                            //drpProg1.addItem(rs.getString("Programme"));
                            txtSection.setText(rs.getString("Year"));
                            txtLevel.setText(rs.getString("Level"));
                            txtSem.setText(rs.getString("Semester"));
                            
                            sn=rs.getString("SRT_ID");
                            //ns=rs.getString("Names");
                            mt=rs.getString("Matric_No");
                            c1=rs.getString("MAC111");
                            c2=rs.getString("MAC112");
                            c3=rs.getString("MAC113");
                            c4=rs.getString("MAC114");
                            c5=rs.getString("MAC115");
                            c6=rs.getString("MAC116");
                            c7=rs.getString("ENG111");
                            c8=rs.getString("EDS111");
                            c9=rs.getString("GST111");
                            c10=rs.getString("GST112");
                           // c11=rs.getString("GST123");
                            c11=rs.getString("CIT111");
                            t1=rs.getString("TCP");
                            t2=rs.getString("TNUR");
                            t3=rs.getString("TNUP");
                            t4=rs.getString("GPA");
                            rm=rs.getString("Remarks");
                            Object[] row = {sn,mt, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10,c11, t1, t2, t3, t4, rm};
                            //model.addColumn(columns);
                            model.addRow(row);
                        }


                    }
                catch(SQLException e)

                    {


            System.out.println("Could not retrieve database metadata " + e.getMessage());

            }catch (ClassNotFoundException ex) {
                        //Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }

              }
              else if(drpProg1.getSelectedItem().equals("B.Sc Biology")){
                  jScrollPane3.setVisible(false);
                  jScrollPane4.setVisible(false);
                  jScrollPane6.setVisible(false);
                  jScrollPane5.setVisible(true);
                try
                {
                    DefaultTableModel model=(DefaultTableModel)table3.getModel();
                    //String[] columns = {"Column 1","Column 2"};
                    //model.setColumnCount(0);
                    model.setRowCount(0);

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433; database=Result_DB; user=sa; password=Tunani14real;";
                    Connection connect = DriverManager.getConnection(url);
                    String sql = "select * from SRT_DP1_vw_Table where Faculty = ? and Department = ? and Programme = 'B.Sc Biology'  order by Matric_No ASC";

                    
                        PreparedStatement pst = connect.prepareStatement(sql);
                        pst.setString(1, String.valueOf(drpFaculty1.getSelectedItem()));
                        pst.setString(2, String.valueOf(drpDepart1.getSelectedItem()));
                        lblCord.setText(drpDepart1.getSelectedItem().toString());
                        
                        ResultSet rs = pst.executeQuery();
                        while(rs.next())
                        {
                            
                            //lblCord.setText(rs.getString("Department"));
                            //drpFaculty1.setText(rs.getString("Faculty"));
                            //drpProg1.addItem(rs.getString("Programme"));
                            txtSection.setText(rs.getString("Year"));
                            txtLevel.setText(rs.getString("Level"));
                            txtSem.setText(rs.getString("Semester"));
                            
                            sn=rs.getString("SRT_ID");
                            //ns=rs.getString("Names");
                            mt=rs.getString("Matric_No");
                            c1=rs.getString("MCB111");
                            c2=rs.getString("BIO111");
                            c3=rs.getString("BIO117");
                            c4=rs.getString("CHM111");
                            c5=rs.getString("CHM119");
                            c6=rs.getString("MAT111");
                            c7=rs.getString("PHY111");
                            c9=rs.getString("EDS111");
                            c10=rs.getString("GST111");
                            c11=rs.getString("GST112");
                            c12=rs.getString("PHY119");
                            c13=rs.getString("CIT111");
                            t1=rs.getString("TCP");
                            t2=rs.getString("TNUR");
                            t3=rs.getString("TNUP");
                            t4=rs.getString("GPA");
                            rm=rs.getString("Remarks");
                            Object[] row = {sn,mt, c1, c2, c3, c4, c5, c6, c7, c9, c10, c11,c12,c13, t1, t2, t3, t4, rm};
                            //model.addColumn(columns);
                            model.addRow(row);
                        }


                    }
                catch(SQLException e)

                    {


            System.out.println("Could not retrieve database metadata " + e.getMessage());

            }catch (ClassNotFoundException ex) {
                        //Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }

              }
              else{
              }
    }//GEN-LAST:event_drpProg1ActionPerformed

    private void drpFaculty1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drpFaculty1ActionPerformed
        // TODO add your handling code here:
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; database=Result_DB; user=sa; password=Tunani14real;";
            Connection connect = DriverManager.getConnection(url);
            String sql = "select * from Department_vw_Table where Faculty = ?";
            PreparedStatement pst = connect.prepareStatement(sql);
            
            
            drpDepart1.removeAllItems();
            drpDepart1.addItem("-- select department --");
            
            pst.setString(1, String.valueOf(drpFaculty1.getSelectedItem()));
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){

                drpDepart1.addItem(rs.getString("Department"));

            }
            connect.close();

        }catch(Exception Error){

            JOptionPane.showMessageDialog(null, Error);
        }
    }//GEN-LAST:event_drpFaculty1ActionPerformed

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
                new Result1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAdd_Student;
    public static javax.swing.JButton btnAdd_Student1;
    public static javax.swing.JButton btnExport;
    public static javax.swing.JComboBox<String> drpDepart1;
    public static javax.swing.JComboBox<String> drpFaculty1;
    public static javax.swing.JComboBox<String> drpProg1;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblCord;
    public static javax.swing.JPanel rst_panel;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    private javax.swing.JTable table4;
    public static javax.swing.JTextField txtLevel;
    public static javax.swing.JTextField txtSection;
    public static javax.swing.JTextField txtSem;
    // End of variables declaration//GEN-END:variables
}
