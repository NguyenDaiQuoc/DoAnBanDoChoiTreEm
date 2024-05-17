package UI.Employee;

import BUS.EmployeeBUS;
import Inventory.DTO.StaffDTO;
import Database.ConnectionProvider;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class EmployeePage extends javax.swing.JPanel {

    Connection con;
    private DefaultTableModel tableModel;
    private DefaultTableModel model;
    public static int staTotal = 5, staIDEdit = -1, staLeft = 0;
    private EmployeeBUS bus = new EmployeeBUS();
    String name, age, email, address, phone, sex, id;

    public EmployeePage() {
        con = ConnectionProvider.getCon();
        initComponents();
        loadAllStaffs();
    }
    

    private int ok() {
        name = nameField.getText().trim();
        age = ageField.getText().trim();
        email = emailField.getText().trim();
        address = addressField.getText().trim();
        phone = phoneField.getText().trim();
        id = idField.getText();
        if (name.isEmpty() || email.isEmpty() || age.isEmpty() || address.isEmpty() || phone.isEmpty()) {// check xem cac truong co bi bo trong khong
            return 0;
        }
        ArrayList<StaffDTO> sta = bus.getAllStaffs();
        for (StaffDTO staffs : sta) {
            if (phone.length() != 10 || (!phone.matches("\\d{10}") || !phone.startsWith("0"))) { // check xem co du 10 ki tu hoac khac ki tu so khong
                return 0;
            }
            if (!name.matches("[a-zA-Z\\s]+")) {
                return 0;
            }
            if (!age.matches("\\d{2}")) {
                return 0;
            }
            //truong hop da co du lieu trung voi db
            if (id.equals(staffs.getStaID()) || name.equals(staffs.getStaName()) || phone.equals(staffs.getStaPhone()) || address.equals(staffs.getStaAddress()) || email.equals(staffs.getStaEmail())) { // truong hop da co trong database
                return 2;
            }
        }

        return 1; //truong hop thoa man tat ca cac rang buoc du lieu
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        sexCb.setSelectedItem("Nam");
        emailField.setText("");
        addressField.setText("");
        phoneField.setText("");
        searchField.setText("");
    }

    private void loadAllStaffs() {
        Vector header = new Vector();
        header.add("ID");
        header.add("Tên");
        header.add("Tuổi");
        header.add("Giới tính");
        header.add("Email");
        header.add("Địa chỉ");
        header.add("Số điện thoại");
        model = new DefaultTableModel(header, 0);
        ArrayList<StaffDTO> sta = bus.getAllStaffs();
        for (StaffDTO staffs : sta) {
            String[] rowData = {String.valueOf(staffs.getStaID()), staffs.getStaName(), String.valueOf(staffs.getStaAge()), staffs.getStaSex(), staffs.getStaEmail(), staffs.getStaAddress(), staffs.getStaPhone()};
            model.addRow(rowData);
        }
        staTable.setModel(model);
        staTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        staTable.getColumnModel().getColumn(1).setPreferredWidth(45);
        staTable.getColumnModel().getColumn(2).setPreferredWidth(25);
        staTable.getColumnModel().getColumn(3).setPreferredWidth(35);
        staTable.getColumnModel().getColumn(5).setPreferredWidth(45);

        // Tải lại danh sách khách hàng từ cơ sở dữ liệu
//        ArrayList<StaffDTO> staffs = bus.getAllStaffs();
//        for (StaffDTO staff : staffs) {
//            String[] rowData = {String.valueOf(staff.getStaID()), staff.getStaName(), String.valueOf(staff.getStaAge()), staff.getStaSex(), staff.getStaEmail(), staff.getStaAddress(), staff.getStaPhone(), staff.getStaRole()};
//            tableModel.addRow(rowData);
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        sexCb = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        staTable = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(1125, 710));
        setMinimumSize(new java.awt.Dimension(1125, 710));
        setPreferredSize(new java.awt.Dimension(1125, 710));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tên");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tuổi");

        ageField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Email");

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Địa chỉ");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Số điện thoại");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("NHÂN VIÊN");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        addButton.setText("Thêm");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Xoá");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        editButton.setText("Chỉnh sửa");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Tìm kiếm");

        searchButton.setText("Tìm kiếm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Lưu");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Huỷ bỏ");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Giới tính");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ID");

        idField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        sexCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        staTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(staTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(20, 20, 20)
                        .addComponent(sexCb, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(editButton)
                                .addGap(90, 90, 90)
                                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80))
                            .addComponent(saveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(sexCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void ageFieldActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        if (ok() == 1) {
            int age = Integer.parseInt(ageField.getText());
            int id = Integer.parseInt(idField.getText());
            String email = emailField.getText().trim();
            if (!email.contains("@")) {
                email += "@gmail.com";
            }
            staTotal++;
            StaffDTO newStaff = new StaffDTO(id, nameField.getText(), age, (String) sexCb.getSelectedItem(), email, addressField.getText(), phoneField.getText(), "Thu Ngan");
//            try {
//                String query = "INSERT INTO nguoidung (id,vaiTro,ten,sdt,email,matKhau,diaChi) VALUES (?, ?, ?, ?, ?, ?)";
//                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//                ps.setInt(1, newStaff.getStaID());
//                ps.setString(2, "Nhan Vien");
//                ps.setString(3, newStaff.getStaName());
//                ps.setString(4, newStaff.getStaPhone());
//                ps.setString(5, newStaff.getStaEmail());
//                ps.setString(6, "123");
//                ps.setString(7, newStaff.getStaAddress());
//                ps.executeUpdate();
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Không thể thêm!");
//            }
            bus.addUser(newStaff);
            bus.addStaff(newStaff);
            loadAllStaffs();
            clearFields();
            //JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!");
        } else if (ok() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin hoặc đúng định dạng!");
            clearFields();
        } else if (ok() == 2) {//truong hop nhap trung du lieu
            JOptionPane.showMessageDialog(null, "Đã tồn tại thông tin, vui lòng nhập thông tin khác!");
            clearFields();
        }
    }                                         

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int selectedRow = staTable.getSelectedRow();
        if (selectedRow != -1) {
            staIDEdit = Integer.parseInt(staTable.getValueAt(selectedRow, 0).toString());
            nameField.setText(staTable.getValueAt(selectedRow, 1).toString());
            ageField.setText(staTable.getValueAt(selectedRow, 2).toString());
            sexCb.setSelectedItem(staTable.getValueAt(selectedRow, 3).toString());
            emailField.setText(staTable.getValueAt(selectedRow, 4).toString());
            addressField.setText(staTable.getValueAt(selectedRow, 5).toString());
            phoneField.setText(staTable.getValueAt(selectedRow, 6).toString());                       
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần sửa thông tin!");
        }
    }                                          

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        int selectedRow = staTable.getSelectedRow();
        if (selectedRow != -1) {
            String id = staTable.getValueAt(selectedRow, 0).toString();
            bus.removeStaff(Integer.parseInt(id));
            staTotal--;
            staLeft--;
            loadAllStaffs();
            JOptionPane.showMessageDialog(null, "Xoá nhân viên thành công!");
        } else {
            JOptionPane.showMessageDialog(null, "Không có nhân viên được chọn để xoá");
        }
    }                                            

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        String keyword = searchField.getText();
        ArrayList<StaffDTO> sta = bus.getAllStaffs();
        Vector header = new Vector();
        header.add("ID");
        header.add("Tên");
        header.add("Tuổi");
        header.add("Giới tính");
        header.add("Email");
        header.add("Địa chỉ");
        header.add("Số điện thoại");
        model = new DefaultTableModel(header, 0);
        for (StaffDTO staffs : sta) {
            if (staffs.getStaAddress().contains(keyword) || staffs.getStaEmail().contains(keyword) || staffs.getStaName().contains(keyword) || staffs.getStaPhone().contains(keyword) || staffs.getStaSex().contains(keyword) || staffs.getStaRole().contains(keyword) || String.valueOf(staffs.getStaAge()).contains(keyword) || String.valueOf(staffs.getStaID()).contains(keyword)) {
                String[] rowData = {String.valueOf(staffs.getStaID()), staffs.getStaName(), String.valueOf(staffs.getStaAge()), staffs.getStaSex(), staffs.getStaEmail(), staffs.getStaAddress(), staffs.getStaPhone()};
                model.addRow(rowData);
            }
        }
        staTable.setModel(model);
        staTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        staTable.getColumnModel().getColumn(1).setPreferredWidth(45);
        staTable.getColumnModel().getColumn(2).setPreferredWidth(25);
        staTable.getColumnModel().getColumn(3).setPreferredWidth(35);
        staTable.getColumnModel().getColumn(5).setPreferredWidth(45);
    }                                            

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int selectedRow = staTable.getSelectedRow();
        if (selectedRow != -1) {
            int id = Integer.parseInt(staTable.getValueAt(selectedRow, 0).toString());
            int age = Integer.parseInt(ageField.getText());
            String name = nameField.getText();
            String sex = (String) sexCb.getSelectedItem();
            String email = emailField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            StaffDTO updatedStaff = new StaffDTO(id, name, age, sex, email, address, phone, "");
            bus.updateStaff(updatedStaff);
            bus.editUser(updatedStaff);
            loadAllStaffs();
            JOptionPane.showMessageDialog(null, "Lưu thông tin nhân viên thành công!");
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần sửa thông tin!");
        }
    }                                          

    public int[] getInfoStaff(){
        return bus.getInfoStaff();
    }
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        loadAllStaffs();
        clearFields();
    }                                            


    // Variables declaration - do not modify                     
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField ageField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> sexCb;
    private javax.swing.JTable staTable;
    // End of variables declaration                   
}
