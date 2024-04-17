/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Demo.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Tạo lớp con kế thừa từ JPanel
public class EmployeePage extends JPanel {
    private DefaultTableModel tableModel;
    private JTable employeeTable;
    private JTextField nameField, ageField, positionField;
    private JButton addButton, removeButton;

    public EmployeePage() {
        // Gọi constructor của lớp cha (JPanel)
        super();

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
        tableModel.addColumn("Name");
        tableModel.addColumn("Age");
        tableModel.addColumn("Position");

        // Khởi tạo JTable với tableModel
        employeeTable = new JTable(tableModel);

        // Tạo các trường nhập liệu và nút thêm/xóa
        nameField = new JTextField(20);
        ageField = new JTextField(10);
        positionField = new JTextField(20);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");

        // Tạo JPanel để chứa các trường nhập liệu và nút thêm/xóa
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Position:"));
        inputPanel.add(positionField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        // Thêm sự kiện cho nút thêm
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] rowData = {nameField.getText(), ageField.getText(), positionField.getText()};
                tableModel.addRow(rowData);
                clearFields();
            }
        });

        // Thêm sự kiện cho nút xóa
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = employeeTable.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                }
            }
        });

        // Thêm JTable vào JScrollPane để có thể cuộn nếu cần
        JScrollPane scrollPane = new JScrollPane(employeeTable);

        // Thêm các thành phần vào JPanel này (lớp con)
        add(inputPanel);
        add(Box.createVerticalStrut(20)); // Khoảng cách giữa inputPanel và JTable
        add(scrollPane);
    }

    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
        positionField.setText("");
    }

    // Phương thức để lấy JTable để có thể sử dụng ở lớp khác
    public JTable getEmployeeTable() {
        return employeeTable;
    }
}
