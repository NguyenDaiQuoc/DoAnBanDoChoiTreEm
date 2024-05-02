/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;
import BUS.Employee.EmployeeBUS;
import UI.LoginPage;
import UI.Bill.BillPage;
import UI.Customer.CustomerPage;
import UI.Employee.EmployeePage;
import UI.Product.ProductPage;
import UI.Sales.SalesPage;
import Inventory.DTO.StaffDTO;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class HomePage extends javax.swing.JFrame {
    CardLayout layout;
    SalesPage salespage;
    private EmployeeBUS bus = new EmployeeBUS();
    private StaffDTO staff = new StaffDTO();
    
    public HomePage(String userType, String tk) {
        initComponents();
        // set layout
        layout = new CardLayout();
        salespage = new SalesPage(); 
        displayPanel.setLayout(layout);
        displayPanel.add("Menu", new MenuPage(this));
        displayPanel.add("Sales", salespage);
        displayPanel.add("Products", new ProductPage());
        displayPanel.add("Customers", new CustomerPage());
        displayPanel.add("Employees", new EmployeePage());
        displayPanel.add("Bills", new BillPage(this, salespage));
         //Them hoa don vao cardlayout
//        if("EMPLOYEE".equalsIgnoreCase(userType)) {
//            jPanel3.remove(NhanvienBt);
//            jPanel3.remove(ThongkeBtn);
//        }
        getCurrentUser(tk);
        setTitle("Quản lí bán đồ chơi trẻ em");
        setVisible(true);
    }
    public void addCustPage() {
        layout.show(displayPanel, "Customers");
    }
    public void addProdPage() {
        layout.show(displayPanel, "Products");
    }
    public void addEmployPage() {
        layout.show(displayPanel, "Employees");
    }
    public void addBillPage(){
        layout.show(displayPanel, "Bills");
    }
    public void addSalesPage() {
        layout.show(displayPanel, "Sales");
    }
    public void addMenuPage() {
        layout.show(displayPanel, "Menu");
    }
    ///////////////
    private void getCurrentUser(String tk) {
        staff = bus.getStaffByUserName(tk);
        userNameLabel.setText("Xin chào " + staff.getStaName() + " !");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        LogoutBt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        menuBtn = new javax.swing.JButton();
        displayPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(160, 25));
        setMinimumSize(new java.awt.Dimension(1125, 780));

        headerPanel.setBackground(new java.awt.Color(51, 51, 51));
        headerPanel.setForeground(new java.awt.Color(255, 255, 255));
        headerPanel.setMinimumSize(new java.awt.Dimension(1125, 50));
        headerPanel.setPreferredSize(new java.awt.Dimension(1125, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        LogoutBt.setBackground(new java.awt.Color(51, 255, 255));
        LogoutBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LogoutBt.setText("Đăng xuất");
        LogoutBt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LogoutBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutBt.setMaximumSize(new java.awt.Dimension(63, 26));
        LogoutBt.setMinimumSize(new java.awt.Dimension(63, 26));
        LogoutBt.setPreferredSize(new java.awt.Dimension(63, 26));
        LogoutBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cửa hàng đồ chơi trẻ em");

        userNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userNameLabel.setForeground(new java.awt.Color(255, 255, 255));

        menuBtn.setText("Menu");
        menuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(143, 143, 143)
                .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(LogoutBt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LogoutBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userNameLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        displayPanel.setBackground(new java.awt.Color(255, 255, 255));
        displayPanel.setMinimumSize(new java.awt.Dimension(1125, 720));
        displayPanel.setPreferredSize(new java.awt.Dimension(1125, 720));
        displayPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(displayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtActionPerformed
        // TODO add your handling code here:
        dispose();
        LoginPage loginPage = new LoginPage();
    }//GEN-LAST:event_LogoutBtActionPerformed

    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnActionPerformed
        // TODO add your handling code here:
        addMenuPage();
    }//GEN-LAST:event_menuBtnActionPerformed

 
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogoutBt;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton menuBtn;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
