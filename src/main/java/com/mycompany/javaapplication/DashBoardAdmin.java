/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.javaapplication;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author loena
 */
public class DashBoardAdmin extends javax.swing.JFrame {
    
    
   
   
    /**
     * Creates new form DashBoard 
     */
    
    
   public String UserFirstName; 
   public String UserLastName;
    // Getter
  public String getName() {
    return UserFirstName;
  }

  // Setter
  public void setName(String newName) {
    this.UserFirstName = newName;
  }
  
  public String getLname() {
    return UserLastName;
  }

  // Setter
  public void setLastname(String newName) {
    this.UserLastName = newName;
  }

    public DashBoardAdmin(String fname, String lname) {
        initComponents();
        userName.setText(fname + " "+ lname);
        
        Date date = new Date();
        
        
        dateTxt.setMinSelectableDate(date);
       
       
        // to add data to table
       try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM reservation order by return_date";
            PreparedStatement pstmt = conn.prepareStatement(query);              
            ResultSet rs = pstmt.executeQuery();
              

            while (rs.next()) {
                // User exists with the provided username and password
                 String id = String.valueOf(rs.getInt("reservation_id"));
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                long contact = rs.getLong("contacts");
                String contacts = String.valueOf(contact);
                String dates = String.valueOf(rs.getDate("return_date"));
                String equipment = rs.getString("equipment");
                String quantity = String.valueOf(rs.getInt("quantity"));
                
                //String array for store data into jtable
                String tbData[] = {id,name,surname,contacts,dates,equipment,quantity};
                
                DefaultTableModel tblModel = (DefaultTableModel) reservationTable.getModel();
                
                //add Strinf array dara into table
                tblModel.addRow(tbData);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
       
        // clear the table before add
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        model.setRowCount(0);

        // for table
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM users1 order by user_id";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // User exists with the provided username and password
                String id = String.valueOf(rs.getInt("user_id"));
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String username = rs.getString("username");
                String password = rs.getString("password");
                 String role = rs.getString("role");
               

                //String array for store data into jtable
                String tbData[] = {id,firstname,lastname,username,password,role};

                DefaultTableModel tblModel = (DefaultTableModel) userTable.getModel();

                //add Strinf array dara into table
                tblModel.addRow(tbData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        
        
         // to add data to table
       try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "select * from reservation where return_date < now()";
            PreparedStatement pstmt = conn.prepareStatement(query);              
            ResultSet rs = pstmt.executeQuery();
              

            while (rs.next()) {
                // User exists with the provided username and password
                 String id = String.valueOf(rs.getInt("reservation_id"));
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                long contact = rs.getLong("contacts");
                String contacts = String.valueOf(contact);
                String dates = String.valueOf(rs.getDate("return_date"));
                String equipment = rs.getString("equipment");
                String quantity = String.valueOf(rs.getInt("quantity"));
                
                //String array for store data into jtable
                String tbData[] = {id,name,surname,contacts,dates,equipment,quantity};
                
                DefaultTableModel tblModel = (DefaultTableModel) expirationTable.getModel();
                
                //add Strinf array dara into table
                tblModel.addRow(tbData);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

        jPanel5 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        TabPanel = new javax.swing.JTabbedPane();
        personTxt = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        dateTxt = new com.toedter.calendar.JDateChooser();
        nameTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        personTxt1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        searchTxt = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        dateTxt1 = new com.toedter.calendar.JDateChooser();
        nameTxt2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbxEquipment = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        reservationTable = new javax.swing.JTable();
        deleteBtn = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        quantitySpinner = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        SurnameTxt = new javax.swing.JTextField();
        contactTxt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        SurnameTxt2 = new javax.swing.JTextField();
        contactTxt2 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        passwordField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Create = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        lastNameField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cbxRole = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        expirationTable = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        deleteBtn1 = new javax.swing.JButton();
        searchField1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        showReservationBtn = new javax.swing.JButton();
        reservatiobBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        userName = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        showReservationBtn1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 1000));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 153, 0));

        lblUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUsername.setIcon(new javax.swing.ImageIcon("C:\\Users\\loena\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication\\src\\icon\\Transparent-pup-logo.png")); // NOI18N

        jLabel7.setBackground(new java.awt.Color(204, 153, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("POLYTHECNIC UNIVERSITY OF THE PHILIPPINES");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("ADMIN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(487, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel19))
                .addGap(3, 3, 3))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1220, 30);

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));
        jPanel2.setLayout(null);
        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 614, 0, 0);

        personTxt.setBackground(new java.awt.Color(255, 255, 255));
        personTxt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("Contact number");
        personTxt.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 140, 25));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("Surname");
        personTxt.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 87, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("Date of Return");
        personTxt.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 110, 25));

        jPanel4.setBackground(new java.awt.Color(102, 0, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RESERVATION SYSTEM");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        personTxt.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 590, 60));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        personTxt.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        personTxt.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 0, 0));
        jLabel14.setText("Name");
        personTxt.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 87, 25));

        dateTxt.setBackground(new java.awt.Color(255, 255, 255));
        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dateTxt.setForeground(new java.awt.Color(0, 0, 0));
        dateTxt.setDateFormatString("y -MMM-d");
        personTxt.add(dateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 150, 20));

        nameTxt.setBackground(new java.awt.Color(255, 255, 255));
        nameTxt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        nameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameTxtKeyTyped(evt);
            }
        });
        personTxt.add(nameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 140, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Equipments");
        personTxt.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 100, 30));

        personTxt1.setBackground(new java.awt.Color(255, 255, 255));
        personTxt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personTxt1MouseClicked(evt);
            }
        });
        personTxt1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 0));
        jLabel10.setText("Contact number");
        personTxt1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 140, 25));

        idTxt.setBackground(new java.awt.Color(255, 255, 255));
        idTxt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        idTxt.setForeground(new java.awt.Color(0, 0, 0));
        idTxt.setEnabled(false);
        personTxt1.add(idTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 140, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 0));
        jLabel11.setText("Surname");
        personTxt1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 87, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 0, 0));
        jLabel15.setText("Date of Return");
        personTxt1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 110, 25));

        searchTxt.setBackground(new java.awt.Color(255, 255, 255));
        searchTxt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        searchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxtActionPerformed(evt);
            }
        });
        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });
        personTxt1.add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 150, -1));

        jPanel6.setBackground(new java.awt.Color(102, 0, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RESERVATION SYSTEM");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        personTxt1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 590, 60));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        personTxt1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        personTxt1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jButton2.setBackground(new java.awt.Color(102, 0, 0));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 153, 0));
        jButton2.setText("Clear");
        jButton2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton2FocusGained(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        personTxt1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 130, 40));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 0, 0));
        jLabel17.setText("Name");
        personTxt1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 87, 25));

        dateTxt1.setBackground(new java.awt.Color(255, 255, 255));
        dateTxt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dateTxt1.setForeground(new java.awt.Color(0, 0, 0));
        dateTxt1.setDateFormatString("y -MMM-d");
        personTxt1.add(dateTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 150, 20));

        nameTxt2.setBackground(new java.awt.Color(255, 255, 255));
        nameTxt2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        personTxt1.add(nameTxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 140, -1));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Equipments");
        personTxt1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 100, 30));

        cbxEquipment.setBackground(new java.awt.Color(255, 255, 255));
        cbxEquipment.setForeground(new java.awt.Color(0, 0, 0));
        cbxEquipment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select item", "tv", "extension", "speaker and mic", "Hdmi", "projector", "chair", "table", "" }));
        cbxEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEquipmentActionPerformed(evt);
            }
        });
        personTxt1.add(cbxEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 130, 30));

        jButton1.setBackground(new java.awt.Color(102, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 153, 0));
        jButton1.setText("Submit");
        jButton1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton1FocusGained(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        personTxt1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 120, 40));

        reservationTable.setBackground(new java.awt.Color(255, 255, 255));
        reservationTable.setForeground(new java.awt.Color(0, 0, 0));
        reservationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Surname", "Contacts", "Return Date", "Equipments", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reservationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservationTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(reservationTable);
        if (reservationTable.getColumnModel().getColumnCount() > 0) {
            reservationTable.getColumnModel().getColumn(0).setResizable(false);
            reservationTable.getColumnModel().getColumn(1).setResizable(false);
            reservationTable.getColumnModel().getColumn(2).setResizable(false);
            reservationTable.getColumnModel().getColumn(3).setResizable(false);
            reservationTable.getColumnModel().getColumn(4).setResizable(false);
            reservationTable.getColumnModel().getColumn(5).setResizable(false);
            reservationTable.getColumnModel().getColumn(6).setResizable(false);
        }

        personTxt1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 750, 310));

        deleteBtn.setBackground(new java.awt.Color(102, 0, 0));
        deleteBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(204, 153, 0));
        deleteBtn.setText("DELETE");
        deleteBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                deleteBtnFocusGained(evt);
            }
        });
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        personTxt1.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 120, 40));

        jButton6.setBackground(new java.awt.Color(102, 0, 0));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(204, 153, 0));
        jButton6.setText("UPDATE");
        jButton6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton6FocusGained(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        personTxt1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 120, 40));

        quantitySpinner.setValue(1);
        quantitySpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                quantitySpinnerStateChanged(evt);
            }
        });
        quantitySpinner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantitySpinnerKeyTyped(evt);
            }
        });
        personTxt1.add(quantitySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 100, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Quantity");
        personTxt1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 80, 30));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 0, 0));
        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\loena\\Downloads\\search1.png")); // NOI18N
        jLabel16.setText("Search");
        personTxt1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 80, 30));

        SurnameTxt.setBackground(new java.awt.Color(255, 255, 255));
        SurnameTxt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        SurnameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SurnameTxtKeyTyped(evt);
            }
        });
        personTxt1.add(SurnameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 140, -1));

        contactTxt.setBackground(new java.awt.Color(255, 255, 255));
        contactTxt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        contactTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactTxtKeyTyped(evt);
            }
        });
        personTxt1.add(contactTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 140, -1));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 0, 0));
        jLabel21.setText("ID");
        personTxt1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 20, 20));

        personTxt.add(personTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 700));

        SurnameTxt2.setBackground(new java.awt.Color(255, 255, 255));
        SurnameTxt2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        personTxt.add(SurnameTxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 140, -1));

        contactTxt2.setBackground(new java.awt.Color(255, 255, 255));
        contactTxt2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        contactTxt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactTxt2KeyTyped(evt);
            }
        });
        personTxt.add(contactTxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 140, -1));

        TabPanel.addTab("tab1", personTxt);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });
        jPanel8.setLayout(null);

        jPanel13.setBackground(new java.awt.Color(102, 0, 0));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 153, 0));
        jLabel9.setText("User LIst");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel9)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.add(jPanel13);
        jPanel13.setBounds(150, 30, 500, 60);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 0, 0));
        jLabel12.setText("User name");
        jPanel8.add(jLabel12);
        jLabel12.setBounds(610, 130, 100, 30);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 0, 0));
        jLabel13.setText("User ID");
        jPanel8.add(jLabel13);
        jLabel13.setBounds(90, 130, 60, 30);

        searchField.setBackground(new java.awt.Color(255, 255, 255));
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        jPanel8.add(searchField);
        searchField.setBounds(610, 230, 150, 30);

        idField.setBackground(new java.awt.Color(255, 255, 255));
        idField.setEnabled(false);
        idField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idFieldKeyTyped(evt);
            }
        });
        jPanel8.add(idField);
        idField.setBounds(90, 160, 80, 30);

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Id", "First name", "Last name", "Username", "password", "role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userTableMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);
        if (userTable.getColumnModel().getColumnCount() > 0) {
            userTable.getColumnModel().getColumn(0).setResizable(false);
            userTable.getColumnModel().getColumn(1).setResizable(false);
            userTable.getColumnModel().getColumn(2).setResizable(false);
            userTable.getColumnModel().getColumn(3).setResizable(false);
            userTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel8.add(jScrollPane1);
        jScrollPane1.setBounds(60, 370, 660, 320);

        passwordField.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.add(passwordField);
        passwordField.setBounds(210, 230, 150, 30);

        firstNameField.setBackground(new java.awt.Color(255, 255, 255));
        firstNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                firstNameFieldKeyTyped(evt);
            }
        });
        jPanel8.add(firstNameField);
        firstNameField.setBounds(210, 160, 150, 30);

        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 0, 0));
        jLabel22.setText("password");
        jPanel8.add(jLabel22);
        jLabel22.setBounds(210, 200, 100, 30);

        userNameField.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.add(userNameField);
        userNameField.setBounds(610, 160, 150, 30);

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 0, 0));
        jLabel23.setText("Last name");
        jPanel8.add(jLabel23);
        jLabel23.setBounds(420, 130, 90, 30);

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 0, 0));
        jLabel24.setText("search");
        jPanel8.add(jLabel24);
        jLabel24.setBounds(610, 200, 90, 30);

        jLabel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 0, 0));
        jLabel25.setText("role");
        jPanel8.add(jLabel25);
        jLabel25.setBounds(420, 200, 90, 30);

        jButton3.setBackground(new java.awt.Color(102, 0, 0));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 153, 0));
        jButton3.setText("Update");
        jButton3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton3FocusGained(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton3);
        jButton3.setBounds(420, 310, 120, 29);

        jButton4.setBackground(new java.awt.Color(102, 0, 0));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(204, 153, 0));
        jButton4.setText("Delete");
        jButton4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton4FocusGained(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton4);
        jButton4.setBounds(580, 310, 120, 29);

        Create.setBackground(new java.awt.Color(102, 0, 0));
        Create.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Create.setForeground(new java.awt.Color(204, 153, 0));
        Create.setText("Create");
        Create.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CreateFocusGained(evt);
            }
        });
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });
        jPanel8.add(Create);
        Create.setBounds(240, 310, 120, 29);

        jButton5.setBackground(new java.awt.Color(102, 0, 0));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(204, 153, 0));
        jButton5.setText("Clear");
        jButton5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton5FocusGained(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton5);
        jButton5.setBounds(60, 310, 120, 29);

        lastNameField.setBackground(new java.awt.Color(255, 255, 255));
        lastNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lastNameFieldKeyTyped(evt);
            }
        });
        jPanel8.add(lastNameField);
        lastNameField.setBounds(420, 160, 150, 30);

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 0, 0));
        jLabel26.setText("First name");
        jPanel8.add(jLabel26);
        jLabel26.setBounds(210, 130, 80, 20);

        cbxRole.setBackground(new java.awt.Color(255, 255, 255));
        cbxRole.setForeground(new java.awt.Color(51, 51, 51));
        cbxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "student" }));
        jPanel8.add(cbxRole);
        cbxRole.setBounds(410, 230, 160, 30);

        TabPanel.addTab("tab2", jPanel8);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(102, 0, 0));

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 153, 0));
        jLabel27.setText("Due Date");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel27)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        expirationTable.setBackground(new java.awt.Color(255, 255, 255));
        expirationTable.setForeground(new java.awt.Color(0, 0, 0));
        expirationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Surname", "Contacts", "Return Date", "Equipments", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        expirationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expirationTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(expirationTable);
        if (expirationTable.getColumnModel().getColumnCount() > 0) {
            expirationTable.getColumnModel().getColumn(0).setResizable(false);
            expirationTable.getColumnModel().getColumn(1).setResizable(false);
            expirationTable.getColumnModel().getColumn(2).setResizable(false);
            expirationTable.getColumnModel().getColumn(3).setResizable(false);
            expirationTable.getColumnModel().getColumn(4).setResizable(false);
            expirationTable.getColumnModel().getColumn(5).setResizable(false);
            expirationTable.getColumnModel().getColumn(6).setResizable(false);
        }

        jButton7.setBackground(new java.awt.Color(102, 0, 0));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(204, 153, 0));
        jButton7.setText("Show table");
        jButton7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton7FocusGained(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        deleteBtn1.setBackground(new java.awt.Color(102, 0, 0));
        deleteBtn1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        deleteBtn1.setForeground(new java.awt.Color(204, 153, 0));
        deleteBtn1.setText("DELETE");
        deleteBtn1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                deleteBtn1FocusGained(evt);
            }
        });
        deleteBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn1ActionPerformed(evt);
            }
        });

        searchField1.setBackground(new java.awt.Color(255, 255, 255));
        searchField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchField1KeyReleased(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 0, 0));
        jLabel28.setIcon(new javax.swing.ImageIcon("C:\\Users\\loena\\Downloads\\search1.png")); // NOI18N
        jLabel28.setText("Search");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177)
                        .addComponent(deleteBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(searchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(165, 205, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        TabPanel.addTab("tab3", jPanel12);

        getContentPane().add(TabPanel);
        TabPanel.setBounds(190, 40, 980, 820);

        jPanel3.setBackground(new java.awt.Color(102, 0, 0));
        jPanel3.setLayout(null);

        showReservationBtn.setBackground(new java.awt.Color(204, 153, 0));
        showReservationBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        showReservationBtn.setForeground(new java.awt.Color(102, 0, 0));
        showReservationBtn.setText("Users List");
        showReservationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showReservationBtnActionPerformed(evt);
            }
        });
        jPanel3.add(showReservationBtn);
        showReservationBtn.setBounds(20, 310, 150, 47);

        reservatiobBtn.setBackground(new java.awt.Color(204, 153, 0));
        reservatiobBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        reservatiobBtn.setForeground(new java.awt.Color(102, 0, 0));
        reservatiobBtn.setText("Reservation");
        reservatiobBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                reservatiobBtnFocusGained(evt);
            }
        });
        reservatiobBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservatiobBtnActionPerformed(evt);
            }
        });
        jPanel3.add(reservatiobBtn);
        reservatiobBtn.setBounds(20, 230, 144, 47);

        logOutBtn.setBackground(new java.awt.Color(204, 153, 0));
        logOutBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        logOutBtn.setForeground(new java.awt.Color(102, 0, 0));
        logOutBtn.setText("Log Out");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });
        jPanel3.add(logOutBtn);
        logOutBtn.setBounds(20, 630, 140, 40);

        userName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        userName.setForeground(new java.awt.Color(204, 153, 0));
        userName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(userName);
        userName.setBounds(0, 60, 190, 30);

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 153, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Welcome");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(0, 0, 190, 60);

        showReservationBtn1.setBackground(new java.awt.Color(204, 153, 0));
        showReservationBtn1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        showReservationBtn1.setForeground(new java.awt.Color(102, 0, 0));
        showReservationBtn1.setText("Expired date");
        showReservationBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showReservationBtn1ActionPerformed(evt);
            }
        });
        jPanel3.add(showReservationBtn1);
        showReservationBtn1.setBounds(20, 400, 150, 47);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 60, 190, 800);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reservatiobBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservatiobBtnActionPerformed
        // TODO add your handling code here:
        TabPanel.setSelectedIndex(0);
    }//GEN-LAST:event_reservatiobBtnActionPerformed

    private void showReservationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showReservationBtnActionPerformed
        // TODO add your handling code here:
        TabPanel.setSelectedIndex(1);
    }//GEN-LAST:event_showReservationBtnActionPerformed

    private void reservatiobBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_reservatiobBtnFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_reservatiobBtnFocusGained

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void contactTxt2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactTxt2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_contactTxt2KeyTyped

    private void contactTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactTxtKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_contactTxtKeyTyped

    private void quantitySpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_quantitySpinnerStateChanged
        // TODO add your handling code here:
        int var1 = Integer.parseInt(quantitySpinner.getValue().toString());
        if(var1 < 1){
            quantitySpinner.setValue(1);
        }
    }//GEN-LAST:event_quantitySpinnerStateChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try{
            String id1 = idTxt.getText().toLowerCase();
            int id = Integer.parseInt(id1);
            String name = nameTxt.getText().toLowerCase();
            String surname = SurnameTxt.getText().toLowerCase();
            String contacts = contactTxt.getText().toLowerCase();
            String equipments = (String) cbxEquipment.getSelectedItem();
            java.util.Date return_date = dateTxt.getDate();
            java.sql.Date sqlDate = new java.sql.Date(return_date.getTime());
            int quantity = (int) quantitySpinner.getValue();
            
            if(contactTxt.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Contacts cannot be empty.");
            }
             if(cbxEquipment.getSelectedItem().equals("Select item")){
                JOptionPane.showMessageDialog(null, "Please Select an item");
                return;
            }
            else{
                UserHandler.updateReservation(id,name,surname,contacts, sqlDate ,equipments,quantity);
            JOptionPane.showMessageDialog(null, "Reservation updated");
            }
            

            idTxt.setText("");
            nameTxt.setText("");
            SurnameTxt.setText("");
            contactTxt.setText("");
            dateTxt.setCalendar(null);
            cbxEquipment.setSelectedItem("tv");
            quantitySpinner.setValue(1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Complete the input");
        }

        // clear the table before add
        DefaultTableModel model = (DefaultTableModel) reservationTable.getModel();
        model.setRowCount(0);

        // to update the table
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM reservation order by return_date";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // User exists with the provided username and password
                String id = String.valueOf(rs.getInt("reservation_id"));
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                long contact = rs.getLong("contacts");
                String contacts = String.valueOf(contact);
                String date = String.valueOf(rs.getDate("return_date"));
                String equipment = rs.getString("equipment");
                String quantity = String.valueOf(rs.getInt("quantity"));

                //String array for store data into jtable
                String tbData[] = {id,name,surname,contacts,date,equipment,quantity};

                DefaultTableModel tblModel = (DefaultTableModel) reservationTable.getModel();

                //add Strinf array dara into table
                tblModel.addRow(tbData);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton6FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6FocusGained

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int row = reservationTable.getSelectedRow();
        String cell = reservationTable.getModel().getValueAt(row, 0).toString();
        String sql = "DELETE from reservation where reservation_id = " + cell;
        try(Connection conn = DatabaseConnector.getConnection()){
            PreparedStatement checkStmt = conn.prepareStatement(sql);
            checkStmt.execute();

            JOptionPane.showMessageDialog(null, "DELETED SUCCESSFULLY");
            idTxt.setText("");
            nameTxt.setText("");
            SurnameTxt.setText("");
            contactTxt.setText("");
            dateTxt.setCalendar(null);
            cbxEquipment.setSelectedItem("tv");
            quantitySpinner.setValue(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        // clear the table before add
        DefaultTableModel model = (DefaultTableModel) reservationTable.getModel();
        model.setRowCount(0);

        // for table
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM reservation order by return_date";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // User exists with the provided username and password
                String id = String.valueOf(rs.getInt("reservation_id"));
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                long contact = rs.getLong("contacts");
                String contacts = String.valueOf(contact);
                String date = String.valueOf(rs.getDate("return_date"));
                String equipment = rs.getString("equipment");
                String quantity = String.valueOf(rs.getInt("quantity"));

                //String array for store data into jtable
                String tbData[] = {id,name,surname,contacts,date,equipment,quantity};

                DefaultTableModel tblModel = (DefaultTableModel) reservationTable.getModel();

                //add Strinf array dara into table
                tblModel.addRow(tbData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_deleteBtnActionPerformed

    private void deleteBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_deleteBtnFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBtnFocusGained

    private void reservationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationTableMouseClicked
        // TODO add your handling code here:
        int i = reservationTable.getSelectedRow();
        TableModel model = reservationTable.getModel();

        idTxt.setText(model.getValueAt(i,0).toString());
        nameTxt.setText(model.getValueAt(i,1).toString());
        SurnameTxt.setText(model.getValueAt(i,2).toString());
        contactTxt.setText(model.getValueAt(i,3).toString());
        //dateTxt.setDate((Date) model.getValueAt(i,4));

        // to get the data from combo box field
        String equipment = model.getValueAt(i, 5).toString();
        for(int j = 0; j < cbxEquipment.getItemCount(); j++){
            if(cbxEquipment.getItemAt(j).toString().equalsIgnoreCase(equipment)){
                cbxEquipment.setSelectedIndex(j);
            }
        }

        // to get the data from date field
        try{
            DefaultTableModel model1 = (DefaultTableModel)reservationTable.getModel();
            int row = reservationTable.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-MM-dd" ).parse((String)model1.getValueAt(row,4));
            dateTxt.setDate(date);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

        // to get the data from the spinner
        String spinner = model.getValueAt(i,6).toString();
        int spinner1 = Integer.parseInt(spinner);
        quantitySpinner.setValue(spinner1);

    }//GEN-LAST:event_reservationTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            String name = nameTxt.getText().toLowerCase();
            String surname = SurnameTxt.getText().toLowerCase();
            String contacts = contactTxt.getText().toLowerCase();
            String equipments = (String) cbxEquipment.getSelectedItem();
            
            java.util.Date return_date = dateTxt.getDate();
            java.sql.Date sqlDate = new java.sql.Date(return_date.getTime());
            
           

            int quantity= (int) quantitySpinner.getValue();
            
             boolean isValid = UserHandler.reservationValid(name,surname, contacts, sqlDate,equipments,quantity);
            
            if(isValid){
                JOptionPane.showMessageDialog(null, "reservation already exists.");
                return;
            }
            if(contactTxt.getText().isEmpty()){
                 JOptionPane.showMessageDialog(null, "Contacts cannot be empty.");
                 return;
            }
             if(cbxEquipment.getSelectedItem().equals("Select item")){
                JOptionPane.showMessageDialog(null, "Please Select an item");
                return;
            }
            else{
            UserHandler.reservation(name,surname,contacts, sqlDate ,equipments,quantity);
            JOptionPane.showMessageDialog(null, "Reservation created");
            }
            

            nameTxt.setText("");
            SurnameTxt.setText("");
            contactTxt.setText("");
            dateTxt.setCalendar(null);
            quantitySpinner.setValue(1);

        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Complete your input");
        }

        // clear the table before add
        DefaultTableModel model = (DefaultTableModel) reservationTable.getModel();
        model.setRowCount(0);

        // to update the table
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM reservation order by return_date";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // User exists with the provided username and password
                String id = String.valueOf(rs.getInt("reservation_id"));
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                long contact = rs.getLong("contacts");
                String contacts = String.valueOf(contact);
                String date = String.valueOf(rs.getDate("return_date"));
                String equipment = rs.getString("equipment");
                String quantity = String.valueOf(rs.getInt("quantity"));

                //String array for store data into jtable
                String tbData[] = {id,name,surname,contacts,date,equipment,quantity};

                DefaultTableModel tblModel = (DefaultTableModel) reservationTable.getModel();

                //add Strinf array dara into table
                tblModel.addRow(tbData);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1FocusGained

    private void cbxEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEquipmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEquipmentActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            nameTxt.setText("");
            SurnameTxt.setText("");
            contactTxt.setText("");
            dateTxt.setCalendar(null);
            quantitySpinner.setValue(1);
            cbxEquipment.setSelectedItem("Select item");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2FocusGained

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)reservationTable.getModel();
        String search = searchTxt.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        reservationTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

    }//GEN-LAST:event_searchTxtKeyReleased

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTxtActionPerformed

    private void jButton3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3FocusGained

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try(Connection conn = DatabaseConnector.getConnection()){
            
            String id = idField.getText().toLowerCase();
            int user_id = Integer.parseInt(id);
            String firstname = firstNameField.getText().toLowerCase();
            String lastname = lastNameField.getText().toLowerCase();
            String username = userNameField.getText().toLowerCase();
            String password = passwordField.getText().toLowerCase();
            //String role = roleField.getText().toLowerCase();
           String role = (String) cbxRole.getSelectedItem();
           
           
           String updateQuery = "update users1 set firstname='"+firstname+"', lastname='"+lastname+"',username='"+username+"', password='"+password+"', role='"+role+"' where user_id = '"+user_id+"'";
           PreparedStatement insertStmt = conn.prepareStatement(updateQuery);
           insertStmt.executeUpdate();
           
         
           
            String updateName = "UPDATE reservation SET name=?, surname=? WHERE name=? AND surname=?";
             PreparedStatement insertStmt1 = conn.prepareStatement(updateName);
                insertStmt1.setString(1, firstname);
                insertStmt1.setString(2, lastname);
                insertStmt1.setString(3,  UserFirstName);
                insertStmt1.setString(4, UserLastName);
               
                insertStmt1.executeUpdate();
                
                
                
           
           
           
           JOptionPane.showMessageDialog(null, "user updated");
            idField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            userNameField.setText("");
            passwordField.setText("");
            //roleField.setText("");
            

            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        // clear the table before add
        DefaultTableModel model1 = (DefaultTableModel) reservationTable.getModel();
        model1.setRowCount(0);

        // to update the table
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM reservation order by return_date";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // User exists with the provided username and password
                String id = String.valueOf(rs.getInt("reservation_id"));
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                long contact = rs.getLong("contacts");
                String contacts = String.valueOf(contact);
                String date = String.valueOf(rs.getDate("return_date"));
                String equipment = rs.getString("equipment");
                String quantity = String.valueOf(rs.getInt("quantity"));

                //String array for store data into jtable
                String tbData[] = {id,name,surname,contacts,date,equipment,quantity};

                DefaultTableModel tblModel = (DefaultTableModel) reservationTable.getModel();

                //add Strinf array dara into table
                tblModel.addRow(tbData);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
     // clear the table before add
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        model.setRowCount(0);

        // for table
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM users1 order by user_id";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // User exists with the provided username and password
                String id = String.valueOf(rs.getInt("user_id"));
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String username = rs.getString("username");
                String password = rs.getString("password");
                 String role = rs.getString("role");
               

                //String array for store data into jtable
                String tbData[] = {id,firstname,lastname,username,password,role};

                DefaultTableModel tblModel = (DefaultTableModel) userTable.getModel();

                //add Strinf array dara into table
                tblModel.addRow(tbData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4FocusGained

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row = userTable.getSelectedRow();
        String cell = userTable.getModel().getValueAt(row, 0).toString();
        String fname = userTable.getModel().getValueAt(row, 1).toString();
        String lname = userTable.getModel().getValueAt(row, 2).toString();
       
         String checkRole = (String) cbxRole.getSelectedItem();
            if(checkRole.equals("admin")){
                JOptionPane.showMessageDialog(null, "Admin cannot be deleted");
            }
            else{
        try(Connection conn = DatabaseConnector.getConnection()){
            
           
             String sql = "DELETE from users1 where user_id = " + cell;
            String sql1 = "DELETE from reservation where name ='"+fname+"' and surname ='"+lname+"' ";
            PreparedStatement checkStmt = conn.prepareStatement(sql);
             PreparedStatement checkStmt1 = conn.prepareStatement(sql1);
            checkStmt.execute();
            checkStmt1.execute();

            JOptionPane.showMessageDialog(null, "DELETED SUCCESSFULLY");
            idField.setText("");
            firstNameField.setText("");
            userNameField.setText("");
            passwordField.setText("");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            }
         // clear the table before add
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        model.setRowCount(0);

        // for table
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM users1 order by user_id";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // User exists with the provided username and password
                String id = String.valueOf(rs.getInt("user_id"));
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String username = rs.getString("username");
                String password = rs.getString("password");
                 String role = rs.getString("role");
               

                //String array for store data into jtable
                String tbData[] = {id,firstname,lastname,username,password,role};

                DefaultTableModel tblModel = (DefaultTableModel) userTable.getModel();

                //add Strinf array dara into table
                tblModel.addRow(tbData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CreateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CreateFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateFocusGained

    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateActionPerformed
        // TODO add your handling code here:
        String fname = firstNameField.getText().toLowerCase();
            String lname = lastNameField.getText().toLowerCase();
            String username1 = userNameField.getText().toLowerCase();
            String password1 = passwordField.getText().toLowerCase();
            //String role1 = roleField.getText();
            String role1 = (String) cbxRole.getSelectedItem();
            
         
            // method that will check if the user is already exist in the data base
         boolean isExist = UserHandler.registerUser(fname,lname, username1, password1, role1);
         
         if(isExist){
             JOptionPane.showMessageDialog(null, "User already exists");
         }
         else{
         try{
            // method  to insert new user to users table database
            UserUpdate.CreateUser(fname,lname,username1,password1,role1);
           
            JOptionPane.showMessageDialog(null, "user created");

            idField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            userNameField.setText("");
            passwordField.setText("");
           
            idField.setText("");
            

        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
         // clear the table before add
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        model.setRowCount(0);

        // for table
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM users1 order by user_id";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // User exists with the provided username and password
                String id = String.valueOf(rs.getInt("user_id"));
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String username = rs.getString("username");
                String password = rs.getString("password");
                 String role = rs.getString("role");
               

                //String array for store data into jtable
                String tbData[] = {id,firstname,lastname,username,password,role};

                DefaultTableModel tblModel = (DefaultTableModel) userTable.getModel();

                //add Strinf array dara into table
                tblModel.addRow(tbData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_CreateActionPerformed

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        // TODO add your handling code here:
        int i = userTable.getSelectedRow();
        TableModel model = userTable.getModel();
        
        
        
        
        idField.setText(model.getValueAt(i,0).toString());
        firstNameField.setText(model.getValueAt(i,1).toString());
        lastNameField.setText(model.getValueAt(i,2).toString());
        userNameField.setText(model.getValueAt(i,3).toString());
        passwordField.setText(model.getValueAt(i,4).toString());
        // roleField.setText(model.getValueAt(i,5).toString());
         String role = model.getValueAt(i, 5).toString();
         
        String changeFname =  firstNameField.getText();
        String changeLname =   lastNameField.getText();
        setName(changeFname);
        setLastname(changeLname);
         
        
        
        for(int j = 0; j < cbxRole.getItemCount(); j++){
            if(cbxRole.getItemAt(j).equalsIgnoreCase(role)){
                cbxRole.setSelectedIndex(j);
            }
        }
        

        
        
        

    }//GEN-LAST:event_userTableMouseClicked

    private void idFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idFieldKeyTyped
        // TODO add your handling code here:
         if (!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_idFieldKeyTyped

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:
         DefaultTableModel table = (DefaultTableModel)userTable.getModel();
        String search = searchField.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        userTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchFieldKeyReleased

    private void jButton5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton5FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5FocusGained

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        idField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            userNameField.setText("");
            passwordField.setText("");
            
    }//GEN-LAST:event_jButton5ActionPerformed

    private void quantitySpinnerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantitySpinnerKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_quantitySpinnerKeyTyped

    private void showReservationBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showReservationBtn1ActionPerformed
        // TODO add your handling code here:
        TabPanel.setSelectedIndex(2);
    }//GEN-LAST:event_showReservationBtn1ActionPerformed

    private void expirationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expirationTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_expirationTableMouseClicked

    private void jButton7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton7FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7FocusGained

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
        // clear the table before add
        DefaultTableModel model = (DefaultTableModel) expirationTable.getModel();
        model.setRowCount(0);
        
        
        // to add data to table
       try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "select * from reservation where return_date < now()";
            PreparedStatement pstmt = conn.prepareStatement(query);              
            ResultSet rs = pstmt.executeQuery();
              

            while (rs.next()) {
                // User exists with the provided username and password
                 String id = String.valueOf(rs.getInt("reservation_id"));
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                long contact = rs.getLong("contacts");
                String contacts = String.valueOf(contact);
                String dates = String.valueOf(rs.getDate("return_date"));
                String equipment = rs.getString("equipment");
                String quantity = String.valueOf(rs.getInt("quantity"));
                
                //String array for store data into jtable
                String tbData[] = {id,name,surname,contacts,dates,equipment,quantity};
                
                DefaultTableModel tblModel = (DefaultTableModel) expirationTable.getModel();
                
                //add Strinf array dara into table
                tblModel.addRow(tbData);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void deleteBtn1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_deleteBtn1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBtn1FocusGained

    private void deleteBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn1ActionPerformed
        // TODO add your handling code here:
        int row = expirationTable.getSelectedRow();
        String cell = expirationTable.getModel().getValueAt(row, 0).toString();
        String sql = "DELETE from reservation where reservation_id = " + cell;
        try(Connection conn = DatabaseConnector.getConnection()){
            PreparedStatement checkStmt = conn.prepareStatement(sql);
            checkStmt.execute();

            JOptionPane.showMessageDialog(null, "DELETED SUCCESSFULLY");
            idTxt.setText("");
            nameTxt.setText("");
            SurnameTxt.setText("");
            contactTxt.setText("");
            dateTxt.setCalendar(null);
            cbxEquipment.setSelectedItem("tv");
            quantitySpinner.setValue(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        // clear the table before add
        DefaultTableModel model = (DefaultTableModel) expirationTable.getModel();
        model.setRowCount(0);
        
        
        // to add data to table
       try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "select * from reservation where return_date < now()";
            PreparedStatement pstmt = conn.prepareStatement(query);              
            ResultSet rs = pstmt.executeQuery();
              

            while (rs.next()) {
                // User exists with the provided username and password
                 String id = String.valueOf(rs.getInt("reservation_id"));
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                long contact = rs.getLong("contacts");
                String contacts = String.valueOf(contact);
                String dates = String.valueOf(rs.getDate("return_date"));
                String equipment = rs.getString("equipment");
                String quantity = String.valueOf(rs.getInt("quantity"));
                
                //String array for store data into jtable
                String tbData[] = {id,name,surname,contacts,dates,equipment,quantity};
                
                DefaultTableModel tblModel = (DefaultTableModel) expirationTable.getModel();
                
                //add Strinf array dara into table
                tblModel.addRow(tbData);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteBtn1ActionPerformed

    private void personTxt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personTxt1MouseClicked
        // TODO add your handling code here:
         nameTxt.setText("");
            SurnameTxt.setText("");
            contactTxt.setText("");
            dateTxt.setCalendar(null);
            quantitySpinner.setValue(1);
            idTxt.setText("");
    }//GEN-LAST:event_personTxt1MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here: 
    }//GEN-LAST:event_jPanel8MouseClicked

    private void userTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userTableMouseEntered

    private void searchField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchField1KeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)expirationTable.getModel();
        String search = searchField1.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        expirationTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchField1KeyReleased

    private void nameTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTxtKeyTyped
        // TODO add your handling code here:
        if (!Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_nameTxtKeyTyped

    private void SurnameTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SurnameTxtKeyTyped
        // TODO add your handling code here:
         if (!Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_SurnameTxtKeyTyped

    private void firstNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameFieldKeyTyped
        // TODO add your handling code here:
         if (!Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_firstNameFieldKeyTyped

    private void lastNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameFieldKeyTyped
        // TODO add your handling code here:
         if (!Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_lastNameFieldKeyTyped

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
            java.util.logging.Logger.getLogger(DashBoardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Create;
    private javax.swing.JTextField SurnameTxt;
    private javax.swing.JTextField SurnameTxt2;
    private javax.swing.JTabbedPane TabPanel;
    private javax.swing.JComboBox<String> cbxEquipment;
    private javax.swing.JComboBox<String> cbxRole;
    private javax.swing.JTextField contactTxt;
    private javax.swing.JTextField contactTxt2;
    private com.toedter.calendar.JDateChooser dateTxt;
    private com.toedter.calendar.JDateChooser dateTxt1;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton deleteBtn1;
    private javax.swing.JTable expirationTable;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField idField;
    private javax.swing.JTextField idTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField nameTxt2;
    private javax.swing.JTextField passwordField;
    private javax.swing.JPanel personTxt;
    private javax.swing.JPanel personTxt1;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JButton reservatiobBtn;
    private javax.swing.JTable reservationTable;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField searchField1;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton showReservationBtn;
    private javax.swing.JButton showReservationBtn1;
    private javax.swing.JLabel userName;
    private javax.swing.JTextField userNameField;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables

   
    
}
