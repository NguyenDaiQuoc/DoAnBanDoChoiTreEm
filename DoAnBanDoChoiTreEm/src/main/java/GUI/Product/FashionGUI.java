/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import DoAn.ProductBUS;
import DoAn.DoChoiPhuongTien;
import DoAn.ProductDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */

public class FashionGUI extends JPanel {
    private DefaultTableModel tableModel;
    private JTable productTable;
    private JTextField idField, tenField, giaField, xuatXuField, soLuongField, soLuongConLaiField, xuHuongField, searchField;
    private JButton addButton, removeButton, updateButton, searchButton, printButton, editButton;
    private ProductBUS bus = new ProductBUS();
    
    public FashionGUI() {
        // Gọi constructor của lớp cha (JPanel)
        super();

        // Sử dụng BoxLayout để căn giữa các thành phần
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Tạo JLabel với tiêu đề "Nhân viên"
        JLabel titleLabel = new JLabel("ĐỒ CHƠI THỜI TRANG");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Đặt font và kích thước chữ
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Căn giữa theo chiều ngang

        // Thêm JLabel vào JPanel
        add(Box.createVerticalStrut(20)); // Khoảng cách trên cùng
        add(titleLabel);
        add(Box.createVerticalStrut(20)); // Khoảng cách dưới cùng

        // Tạo tableModel với các cột: Name, Age, Position
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Id");
        tableModel.addColumn("Ten");
        tableModel.addColumn("Gia");
        tableModel.addColumn("XuatXu");
        tableModel.addColumn("SoLuong");
        tableModel.addColumn("SoLuongConLai");
        tableModel.addColumn("xuHuong");

        // Khởi tạo JTable với tableModel
        productTable = new JTable(tableModel);

        // Tạo các trường nhập liệu và nút thêm/xóa
        idField = new JTextField(20);
        tenField = new JTextField(10);
        giaField = new JTextField(20);
        xuatXuField = new JTextField(20);
        soLuongField = new JTextField(20);
        soLuongConLaiField = new JTextField(20);
        xuHuongField = new JTextField(20);
        searchField = new JTextField(20);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        updateButton = new JButton("Update");
        searchButton = new JButton("Search");
        printButton = new JButton("Print");
        editButton = new JButton("Edit");

        // Tạo JPanel để chứa các trường nhập liệu và nút thêm/xóa
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2, 10, 10)); // Use a grid layout
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        inputPanel.add(new JLabel("Id:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Ten:"));
        inputPanel.add(tenField);
        inputPanel.add(new JLabel("Gia:"));
        inputPanel.add(giaField);
        inputPanel.add(new JLabel("XuatXu:"));
        inputPanel.add(xuatXuField);
        inputPanel.add(new JLabel("SoLuong:"));
        inputPanel.add(soLuongField);
        inputPanel.add(new JLabel("SoLuongConLai:"));
        inputPanel.add(soLuongConLaiField);
        inputPanel.add(new JLabel("XuHuong:"));
        inputPanel.add(xuHuongField);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(printButton);
        buttonPanel.add(editButton);
        
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

//         Thêm sự kiện cho nút thêm
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoChoiThoiTrang newProduct = new DoChoiThoiTrang();
                newProduct.setId(idField.getText());
                newProduct.setTen(tenField.getText());
                newProduct.setGia(Double.parseDouble(giaField.getText()));
                newProduct.setXuatxu(xuatXuField.getText());
                newProduct.setSoLuong(Integer.parseInt(soLuongField.getText()));
                newProduct.setSoLuongConLai(Integer.parseInt(soLuongConLaiField.getText()));
                newProduct.setXuHuong(xuHuongField.getText());
                bus.addFashionToy(newProduct);
                loadAllFashionToys();
            }
        });
        
        printButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                loadAllFashionToys();
            }
        });

        // Thêm sự kiện cho nút xóa
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                String id = productTable.getValueAt(selectedRow, 0).toString();
                bus.removeFashionToy(id);
                loadAllFashionToys();
                JOptionPane.showMessageDialog(null,"Xoá sản phẩm thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không có sản phẩm được chọn để xoá");
            }
            }
        });
        //Them su kien cho nut sua
        updateButton.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if(selectedRow != -1){
                    DoChoiThoiTrang newProduct = new DoChoiThoiTrang();
                    newProduct.setId(idField.getText());
                    newProduct.setTen(tenField.getText());
                    newProduct.setGia(Double.parseDouble(giaField.getText()));
                    newProduct.setXuatxu(xuatXuField.getText());
                    newProduct.setSoLuong(Integer.parseInt(soLuongField.getText()));
                    newProduct.setSoLuongConLai(Integer.parseInt(soLuongConLaiField.getText()));
                    newProduct.setXuHuong(xuHuongField.getText());
                    bus.updateFashionToy(newProduct);
                    loadAllFashionToys();
                }
            }
        });
        //Them su kien cho nut chinh sua
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                idField.setText(productTable.getValueAt(selectedRow, 0).toString());
                tenField.setText(productTable.getValueAt(selectedRow, 1).toString());
                giaField.setText(productTable.getValueAt(selectedRow, 2).toString());
                xuatXuField.setText(productTable.getValueAt(selectedRow, 3).toString());
                soLuongField.setText(productTable.getValueAt(selectedRow, 4).toString());
                soLuongConLaiField.setText(productTable.getValueAt(selectedRow, 5).toString());
                xuHuongField.setText(productTable.getValueAt(selectedRow, 6).toString());
                }
            }
        });
        //Them sự kiện cho nút tìm kiếm
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = searchField.getText();
                tableModel.setRowCount(0);
                ArrayList<DoChoiThoiTrang> products = bus.searchFashionToysById(id);
                for(DoChoiThoiTrang product : products){
                    String[] rowData = {product.getId(), product.getTen(), String.valueOf(product.getGia()), product.getXuatxu(), String.valueOf(product.getSoLuong()), String.valueOf(product.getSoLuongConLai()), product.getXuHuong()};
                    tableModel.addRow(rowData);
                }  
            }
        });
        // Thêm JTable vào JScrollPane để có thể cuộn nếu cần
        JScrollPane scrollPane = new JScrollPane(productTable);

        // Thêm các thành phần vào JPanel này (lớp con)
        add(inputPanel);
        add(buttonPanel);
        add(searchPanel);
        add(Box.createVerticalStrut(20)); // Khoảng cách giữa inputPanel và JTable
        add(scrollPane);
    }
    
    public void loadAllFashionToys(){
        tableModel.setRowCount(0);
        ArrayList<DoChoiThoiTrang> products = bus.getAllFashionToys();
        for(DoChoiThoiTrang product : products){
            String[] rowData = {product.getId(), product.getTen(), String.valueOf(product.getGia()), product.getXuatxu(), String.valueOf(product.getSoLuong()), String.valueOf(product.getSoLuongConLai()), product.getXuHuong()};
            tableModel.addRow(rowData);
        }   
    }
    
}

