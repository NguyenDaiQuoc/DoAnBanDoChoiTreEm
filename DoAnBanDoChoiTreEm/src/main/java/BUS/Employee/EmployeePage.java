package BUS.Employee;

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

// Tạo lớp con kế thừa từ JPanel
public class EmployeePage extends JPanel {
    Connection con;
    private DefaultTableModel tableModel;
    private JTable employeeTable;
    private JTextField nameField, ageField, emailField, addressField, phoneField, positionField, searchField;
    private JButton refreshButton, addButton, removeButton, editButton, saveButton, searchButton, cancelButton;
    private int staTotal = 0, staIDEdit = -1;
    private EmployeeBUS bus = new EmployeeBUS();

    public EmployeePage() {
        // Gọi constructor của lớp cha (JPanel)
        super();
        
        con = ConnectionProvider.getCon();
        // Sử dụng BoxLayout để căn giữa các thành phần
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Tạo JLabel với tiêu đề "Nhân viên"
        JLabel titleLabel = new JLabel("Nhân viên");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Đặt font và kích thước chữ
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Căn giữa theo chiều ngang

        // Thêm JLabel vào JPanel
        add(Box.createVerticalStrut(20)); // Khoảng cách trên cùng
        add(titleLabel);
        add(Box.createVerticalStrut(20)); // Khoảng cách dưới cùng

        // Tạo tableModel với các cột: Name, Age, Position
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Age");
        tableModel.addColumn("Email");
        tableModel.addColumn("Address");
        tableModel.addColumn("Phone");
        tableModel.addColumn("Position");

        // Khởi tạo JTable với tableModel
        employeeTable = new JTable(tableModel);

        // Tạo các trường nhập liệu và nút 
        nameField = new JTextField(15);
        ageField = new JTextField(5);
        searchField = new JTextField(10);
        emailField = new JTextField(10);
        addressField = new JTextField(15);
        phoneField = new JTextField(10);
        positionField = new JTextField(10);
        refreshButton = new JButton("Refresh");
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        editButton = new JButton("Edit");
        searchButton = new JButton("Search");
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        // Tạo JPanel để chứa các trường nhập liệu và nút 
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Address"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Phone"));
        inputPanel.add(phoneField);
        inputPanel.add(new JLabel("Position"));
        inputPanel.add(positionField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(new JPanel());
        buttonPanel.add(refreshButton);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);

        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.add(new JLabel("Search"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(saveButton);
        searchPanel.add(cancelButton);

        // Thêm sự kiện cho nút thêm
        addButton.addActionListener(e -> {            
            int age = Integer.parseInt(ageField.getText());            
            staTotal++;
            StaffDTO newStaff = new StaffDTO(staTotal, nameField.getText(), age, emailField.getText(), addressField.getText(), phoneField.getText(), "Thu Ngan");
            try {
                String query = "INSERT INTO nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, "Nhan Vien");
                ps.setString(2, newStaff.getStaName());
                ps.setString(3, newStaff.getStaPhone());
                ps.setString(4, newStaff.getStaEmail());
                ps.setString(5,"123");
                ps.setString(6, newStaff.getStaAddress());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Lỗi SQL: " + ex.getMessage());
            }
            bus.addStaff(newStaff);
            loadAllStaffs();
            clearFields();

        });

        // Thêm sự kiện cho nút xóa
        removeButton.addActionListener(e -> {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow != -1) {
                String id = employeeTable.getValueAt(selectedRow, 0).toString();
                bus.removeStaff(Integer.parseInt(id));
                loadAllStaffs();
            }
        });

        // Thêm sự kiện cho nút sửa
        editButton.addActionListener(e -> {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow != -1) {
                staIDEdit = Integer.parseInt(employeeTable.getValueAt(selectedRow, 0).toString());
                nameField.setText(employeeTable.getValueAt(selectedRow, 1).toString());
                ageField.setText(employeeTable.getValueAt(selectedRow, 2).toString());
                emailField.setText(employeeTable.getValueAt(selectedRow, 3).toString());
                addressField.setText(employeeTable.getValueAt(selectedRow, 4).toString());
                phoneField.setText(employeeTable.getValueAt(selectedRow, 5).toString());
            }
        });

        // Thêm sự kiện cho nút tìm kiếm
        searchButton.addActionListener(e -> {
            String keyword = searchField.getText();
            getStaffsByKeyword(keyword);
        });

        // Thêm sự kiện cho nút lưu
        saveButton.addActionListener(e -> {
            int age = Integer.parseInt(ageField.getText());
            if (staIDEdit != -1) {
                StaffDTO updatedStaff = new StaffDTO(staIDEdit, nameField.getText(), age, emailField.getText(), addressField.getText(), phoneField.getText(), positionField.getText());
                bus.updateStaff(updatedStaff);
                loadAllStaffs();
                staIDEdit = -1;
            }
        });
        // Thêm sự kiện cho nút hủy bỏ
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadAllStaffs();
                clearFields();
            }
        });

        // Thêm sự kiện cho nút làm mới
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= /*staIDEdit*/ tableModel.getRowCount() ; i++) {
                    String idString = (String) tableModel.getValueAt(i, 0);
                    int currentID = Integer.parseInt(idString);
                    if (currentID != i + 1) {
                        tableModel.setValueAt(i + 1, i, 0);
                        // Viết code cập nhật lại ID trong cơ sở dữ liệu nếu cần
                         //bus.updateStaffID(currentID, i + 1);
                    }
                }
                loadAllStaffs();
            }
        });

        // Thêm JTable vào JScrollPane để có thể cuộn nếu cần
        JScrollPane scrollPane = new JScrollPane(employeeTable);

        // Thêm các thành phần vào JPanel này (lớp con)
        add(inputPanel);
        add(Box.createVerticalStrut(20)); // Khoảng cách giữa inputPanel và JTable
        add(buttonPanel);
        add(searchPanel);
        add(scrollPane);
        loadAllStaffs();
    }

    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
        emailField.setText("");
        addressField.setText("");
        phoneField.setText("");
        searchField.setText("");
    }

    private void loadAllStaffs() {
        // Xóa tất cả các hàng hiện có
        tableModel.setRowCount(0);

        // Tải lại danh sách khách hàng từ cơ sở dữ liệu
        ArrayList<StaffDTO> staffs = bus.getAllStaffs();
        for (StaffDTO staff : staffs) {
            String[] rowData = {String.valueOf(staff.getStaID()), staff.getStaName(), String.valueOf(staff.getStaAge()), staff.getStaEmail(), staff.getStaAddress(), staff.getStaPhone(), staff.getStaRole()};
            tableModel.addRow(rowData);
        }
    }

    private void getStaffsByKeyword(String keyword) {
        // Xóa tất cả các hàng hiện có
        tableModel.setRowCount(0);

        // Tải lại danh sách khách hàng từ cơ sở dữ liệu
        ArrayList<StaffDTO> staffs = bus.getStaffsByKeyword(keyword);
        for (StaffDTO staff : staffs) {
            String[] rowData = {String.valueOf(staff.getStaID()), staff.getStaName(), String.valueOf(staff.getStaAge()), staff.getStaEmail(), staff.getStaAddress(), staff.getStaPhone()};
            tableModel.addRow(rowData);
        }
    }

    // Phương thức để lấy JTable để có thể sử dụng ở lớp khác
    public JTable getEmployeeTable() {
        return employeeTable;
    }
}
