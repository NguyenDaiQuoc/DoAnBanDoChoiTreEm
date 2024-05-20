/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.Product;

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
import Bus.ProductBUS;
import Inventory.DTO.RoBot;
import Inventory.DAO.ProductDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */

public class RoBotGUI extends JPanel {
    private DefaultTableModel tableModel;
    private JTable productTable;
    private JTextField idField, tenField, giaField, xuatXuField, soLuongField, soLuongConLaiField, loaiRoBotField, searchField;
    private JButton addButton, removeButton, updateButton, searchButton, printButton, editButton;
    private ProductBUS bus = new ProductBUS();
    
    public RoBotGUI() {
        super();

        // Sử dụng BoxLayout để căn giữa các thành phần
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("ROBOT");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Đặt font và kích thước chữ
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Căn giữa theo chiều ngang

        add(Box.createVerticalStrut(20)); // Khoảng cách trên cùng
        add(titleLabel);
        add(Box.createVerticalStrut(20)); // Khoảng cách dưới cùng

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Id");
        tableModel.addColumn("Tên SP");
        tableModel.addColumn("Giá SP");
        tableModel.addColumn("Xuất Xứ");
        tableModel.addColumn("Số lượng");
        tableModel.addColumn("Số lượng còn lại");
        tableModel.addColumn("Loại Robot");

        // Khởi tạo JTable với tableModel
        productTable = new JTable(tableModel);

        idField = new JTextField(20);
        tenField = new JTextField(10);
        giaField = new JTextField(20);
        xuatXuField = new JTextField(20);
        soLuongField = new JTextField(20);
        soLuongConLaiField = new JTextField(20);
        loaiRoBotField = new JTextField(20);
        searchField = new JTextField(20);
        addButton = new JButton("Thêm");
        removeButton = new JButton("Xóa");
        updateButton = new JButton("Cập nhật");
        searchButton = new JButton("Tìm kiếm");
        printButton = new JButton("Print");
        editButton = new JButton("Chỉnh sửa");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Id"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Tên SP"));
        inputPanel.add(tenField);
        inputPanel.add(new JLabel("Giá SP"));
        inputPanel.add(giaField);
        inputPanel.add(new JLabel("Xuất Xứ"));
        inputPanel.add(xuatXuField);
        inputPanel.add(new JLabel("Số lượng"));
        inputPanel.add(soLuongField);
        inputPanel.add(new JLabel("Số lượng còn lại"));
        inputPanel.add(soLuongConLaiField);
        inputPanel.add(new JLabel("Loại Robot"));
        inputPanel.add(loaiRoBotField);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(printButton);
        buttonPanel.add(editButton);
        
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.add(new JLabel("Nhập từ khóa:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

//         Thêm sự kiện cho nút thêm
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Kiem tra du lieu nhap
                if(idField.getText().isEmpty() || tenField.getText().isEmpty() || giaField.getText().isEmpty() || xuatXuField.getText().isEmpty() || soLuongField.getText().isEmpty() || soLuongConLaiField.getText().isEmpty() || loaiRoBotField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
                    return;
                }
                //Kiem tra id
                if (!idField.getText().startsWith("14")) {
                    JOptionPane.showMessageDialog(null, "ID phải bắt đầu bằng 14!");
                    return;
                }
                if (!idField.getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "ID không được chứa kí tự đặt biệt và chữ!");
                    return;
                }
                //Kiem tra gia
                if (!giaField.getText().matches("^[\\d\\W]+$")) {
                    JOptionPane.showMessageDialog(null, "Giá không được chứa chữ!");
                    return;
                }
                //Kiem tra xuat xu
                if (!xuatXuField.getText().matches("^[a-zA-Z]+$")) {
                    JOptionPane.showMessageDialog(null, "Xuất xứ không được chứa kí tự đặt biệt và số!");
                    return;
                }
                //Kiem tra so luong
                if (!soLuongField.getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Số lượng không được chứa kí tự đặt biệt và chữ!");
                    return;
                }
                //Kiem tra so luong con lai
                if (!soLuongConLaiField.getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Số lượng còn lại không được chứa kí tự đặt biệt và chữ!");
                    return;
                }
                //Kiem tra so luong con lai khong duoc lon hon so luong
                int x = Integer.parseInt(soLuongField.getText());
                int y = Integer.parseInt(soLuongConLaiField.getText());
                if(y > x){
                    JOptionPane.showMessageDialog(null, "Số lượng còn lại không được lớn hơn số lượng!");
                    return;
                }
                
                ArrayList<RoBot> products = bus.getAllRoBotToys();
                for(RoBot product : products){
                    if(product.getId().equals(idField.getText())){
                        JOptionPane.showMessageDialog(null, "ID đã tồn tại. Xin hãy nhập lai ID!");
                        return;
                    }
                }
                
                RoBot newProduct = new RoBot();
                newProduct.setId(idField.getText());
                newProduct.setTen(tenField.getText());
                newProduct.setGia(Double.parseDouble(giaField.getText()));
                newProduct.setXuatxu(xuatXuField.getText());
                newProduct.setSoLuong(Integer.parseInt(soLuongField.getText()));
                newProduct.setSoLuongConLai(Integer.parseInt(soLuongConLaiField.getText()));
                newProduct.setLoaiRoBot(loaiRoBotField.getText());
                bus.addRoBotToy(newProduct);
                loadAllRoBotToys();
                JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
            }
        });
        
        printButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                loadAllRoBotToys();
                clearFields();
            }
        });

        // Thêm sự kiện cho nút xóa
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                String id = productTable.getValueAt(selectedRow, 0).toString();
                bus.removeRoBotToy(id);
                loadAllRoBotToys();
                JOptionPane.showMessageDialog(null,"Xoá sản phẩm thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không có sản phẩm được chọn để xoá!");
            }
            }
        });
        //Them su kien cho nut sua
        updateButton.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                //Kiem tra du lieu nhap
                if(idField.getText().isEmpty() || tenField.getText().isEmpty() || giaField.getText().isEmpty() || xuatXuField.getText().isEmpty() || soLuongField.getText().isEmpty() || soLuongConLaiField.getText().isEmpty() || loaiRoBotField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm, ấn nút 'Chỉnh sửa' và nhập dữ liệu mới. Cuối cùng ấn 'Cập nhật'!");
                    return;
                }
                //Kiem tra id
                if (!idField.getText().startsWith("14")) {
                    JOptionPane.showMessageDialog(null, "ID phải bắt đầu bằng 14!");
                    return;
                }
                if (!idField.getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "ID không được chứa kí tự đặt biệt và chữ!");
                    return;
                }
                //Kiem tra gia
                if (!giaField.getText().matches("^[\\d\\W]+$")) {
                    JOptionPane.showMessageDialog(null, "Giá không được chứa chữ!");
                    return;
                }
                //Kiem tra xuat xu
                if (!xuatXuField.getText().matches("^[a-zA-Z]+$")) {
                    JOptionPane.showMessageDialog(null, "Xuất xứ không được chứa kí tự đặt biệt và số!");
                    return;
                }
                //Kiem tra so luong
                if (!soLuongField.getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Số lượng không được chứa kí tự đặt biệt và chữ!");
                    return;
                }
                //Kiem tra so luong con lai
                if (!soLuongConLaiField.getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Số lượng còn lại không được chứa kí tự đặt biệt và chữ!");
                    return;
                }
                //Kiem tra so luong con lai khong duoc lon hon so luong
                int x = Integer.parseInt(soLuongField.getText());
                int y = Integer.parseInt(soLuongConLaiField.getText());
                if(y > x){
                    JOptionPane.showMessageDialog(null, "Số lượng còn lại không được lớn hơn số lượng!");
                    return;
                }
                
                int selectedRow = productTable.getSelectedRow();
                if(selectedRow != -1){
                    RoBot newProduct = new RoBot();
                    newProduct.setId(idField.getText());
                    newProduct.setTen(tenField.getText());
                    newProduct.setGia(Double.parseDouble(giaField.getText()));
                    newProduct.setXuatxu(xuatXuField.getText());
                    newProduct.setSoLuong(Integer.parseInt(soLuongField.getText()));
                    newProduct.setSoLuongConLai(Integer.parseInt(soLuongConLaiField.getText()));
                    newProduct.setLoaiRoBot(loaiRoBotField.getText());
                    bus.updateRoBotToy(newProduct);
                    loadAllRoBotToys();
                    JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Không có sản phẩm được chọn để cập nhật!");
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
                loaiRoBotField.setText(productTable.getValueAt(selectedRow, 6).toString());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Không có hàng được chọn để chỉnh sửa!");
                }
            }
        });
        //Them sự kiện cho nút tìm kiếm
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = searchField.getText();
                if(id.isEmpty()) JOptionPane.showMessageDialog(null, "Nhập từ khóa để tìm kiếm!");
                tableModel.setRowCount(0);
                ArrayList<RoBot> products = bus.searchRoBotToysById(id);
                for(RoBot product : products){
                    String[] rowData = {product.getId(), product.getTen(), String.valueOf(product.getGia()), product.getXuatxu(), String.valueOf(product.getSoLuong()), String.valueOf(product.getSoLuongConLai()), product.getLoaiRoBot()};
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
    
    public void loadAllRoBotToys(){
        tableModel.setRowCount(0);
        ArrayList<RoBot> products = bus.getAllRoBotToys();
        for(RoBot product : products){
            String[] rowData = {product.getId(), product.getTen(), String.valueOf(product.getGia()), product.getXuatxu(), String.valueOf(product.getSoLuong()), String.valueOf(product.getSoLuongConLai()), product.getLoaiRoBot()};
            tableModel.addRow(rowData);
        }   
    }
    
    private void clearFields() {
        idField.setText("");
        tenField.setText("");
        giaField.setText("");
        xuatXuField.setText("");
        soLuongField.setText("");
        soLuongConLaiField.setText("");
        loaiRoBotField.setText("");
        searchField.setText("");
    }
}
