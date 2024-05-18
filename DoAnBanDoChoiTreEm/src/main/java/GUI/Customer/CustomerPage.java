// CustomerPage.java
package UI.Customer;

import Bus.CustomerBUS;
import Inventory.DTO.CustomerDTO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CustomerPage extends JPanel {

    JTextField idField = new JTextField(10);
    private DefaultTableModel tableModel;
    private JTable customerTable;
    private JTextField nameField, emailField, addressField, sdtField, searchField;
    private JButton addButton, removeButton, searchButton, cancelButton, editButton, saveButton;
    private String editingCustomerId = null;
    private CustomerBUS bus = new CustomerBUS();

    public CustomerPage() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Khách hàng");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(20));
        add(titleLabel);
        add(Box.createVerticalStrut(20));

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Email");
        tableModel.addColumn("Address");
        tableModel.addColumn("SDT");

        customerTable = new JTable(tableModel);

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        addressField = new JTextField(20);
        sdtField = new JTextField(10);
        searchField = new JTextField(20);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        searchButton = new JButton("Search");
        cancelButton = new JButton("Cancel");
        editButton = new JButton("Edit");
        saveButton = new JButton("Save");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("SDT:"));
        inputPanel.add(sdtField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        inputPanel.add(editButton);
        inputPanel.add(new JLabel("Search:"));
        inputPanel.add(searchField);
        inputPanel.add(searchButton);
        inputPanel.add(cancelButton);
        inputPanel.add(saveButton);

        addButton.addActionListener(e -> {
            // Kiểm tra dữ liệu đầu vào
            if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || addressField.getText().isEmpty() || sdtField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.");
                return;
            }

            // Kiểm tra tên khách hàng
            if (!nameField.getText().matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(null, "Tên khách hàng không được chứa số hoặc kí tự đặc biệt. Vui lòng nhập lại.");
                return;
            }

            // Kiểm tra email
            if (!emailField.getText().contains("@")) {
                JOptionPane.showMessageDialog(null, "Email phải chứa kí tự '@'. Vui lòng nhập lại.");
                return;
            }

            // Kiểm tra số điện thoại
            if (!sdtField.getText().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "Số điện thoại chỉ được chứa số. Vui lòng nhập lại.");
                return;
            }

            String sdt = sdtField.getText();
            if (sdt.length() != 10) {
                JOptionPane.showMessageDialog(null, "Số điện thoại phải có đúng 10 ký tự.");
                return;
            }
            
            // Kiểm tra ID
            String id = idField.getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Xin hãy nhập ID.");
                return;
            }

            if (!id.startsWith("KH")) {
                JOptionPane.showMessageDialog(null, "ID phải bắt đầu bằng 'KH'.");
                return;
            }

            ArrayList<CustomerDTO> existingCustomers = bus.getAllCustomers();
            for (CustomerDTO customer : existingCustomers) {
                if (customer.getId().equals(id)) {
                    JOptionPane.showMessageDialog(null, "ID đã tồn tại. Xin hãy nhập ID khác.");
                    return;
                }
            }

            CustomerDTO newCustomer = new CustomerDTO(id, nameField.getText(), emailField.getText(), addressField.getText(), sdtField.getText());
            bus.addCustomer(newCustomer);
            loadAllCustomers();
        });

        removeButton.addActionListener(e -> {
            int selectedRow = customerTable.getSelectedRow();
            if (selectedRow != -1) {
                String id = customerTable.getValueAt(selectedRow, 0).toString();
                bus.removeCustomer(id); // Change this from Integer.parseInt(id) to id
                loadAllCustomers();
            }
        });

        editButton.addActionListener(e -> {
            int selectedRow = customerTable.getSelectedRow();
            if (selectedRow != -1) {
                editingCustomerId = customerTable.getValueAt(selectedRow, 0).toString(); // Change this from Integer.parseInt(...) to toString()
                nameField.setText(customerTable.getValueAt(selectedRow, 1).toString());
                emailField.setText(customerTable.getValueAt(selectedRow, 2).toString());
                addressField.setText(customerTable.getValueAt(selectedRow, 3).toString());
                sdtField.setText(customerTable.getValueAt(selectedRow, 4).toString());
            }
        });

        saveButton.addActionListener(e -> {
            if (editingCustomerId != null) { // Change this from -1 to null
                CustomerDTO updatedCustomer = new CustomerDTO(editingCustomerId, nameField.getText(), emailField.getText(), addressField.getText(), sdtField.getText());
                bus.updateCustomer(updatedCustomer);
                loadAllCustomers();
                editingCustomerId = null; // Change this from -1 to null
            }
        });

        searchButton.addActionListener(e -> {
            String keyword = searchField.getText();
            loadCustomersByKeyword(keyword);
        });

        cancelButton.addActionListener(e -> {
            loadAllCustomers();
        });

        JScrollPane scrollPane = new JScrollPane(customerTable);

        add(inputPanel);
        add(Box.createVerticalStrut(20));
        add(scrollPane);

        loadAllCustomers();
    }

    private void loadAllCustomers() {
        // Xóa tất cả các hàng hiện có
        tableModel.setRowCount(0);

        // Tải lại danh sách khách hàng từ cơ sở dữ liệu
        ArrayList<CustomerDTO> customers = bus.getAllCustomers();
        for (CustomerDTO customer : customers) {
            String[] rowData = {String.valueOf(customer.getId()), customer.getName(), customer.getEmail(), customer.getAddress(), customer.getSdt()};
            tableModel.addRow(rowData);
        }
    }

    private void loadCustomersByKeyword(String keyword) {
        // Xóa tất cả các hàng hiện có
        tableModel.setRowCount(0);

        // Tải lại danh sách khách hàng từ cơ sở dữ liệu
        ArrayList<CustomerDTO> customers = bus.getCustomersByKeyword(keyword);
        for (CustomerDTO customer : customers) {
            String[] rowData = {String.valueOf(customer.getId()), customer.getName(), customer.getEmail(), customer.getAddress(), customer.getSdt()};
            tableModel.addRow(rowData);
        }
    }
    
    public int getInfoCus(){
        return bus.getInfoCus();
    }

    public JTable getCustomerTable() {
        return customerTable;
    }
}
