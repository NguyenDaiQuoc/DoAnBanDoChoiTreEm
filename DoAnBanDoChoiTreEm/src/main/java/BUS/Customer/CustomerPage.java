package Demo.Customer;

import Bus.CustomerBUS;
import Inventory.DTO.CustomerDTO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CustomerPage extends JPanel {
    private DefaultTableModel tableModel;
    private JTable customerTable;
    private JTextField nameField, emailField, addressField, sdtField, searchField;
    private JButton addButton, removeButton, searchButton, cancelButton, editButton, saveButton;
    private int editingCustomerId = -1; // ID của khách hàng đang được chỉnh sửa
    private CustomerBUS bus = new CustomerBUS();

    public CustomerPage() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Khách hàng");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLUE);
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
        inputPanel.setLayout(new GridLayout(5, 2, 10, 10)); // Use a grid layout
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("SDT:"));
        inputPanel.add(sdtField);

        // Create a panel for the buttons and use a flow layout
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);

        // Create a panel for the search field and button
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(cancelButton);

        addButton.addActionListener(e -> {
            CustomerDTO newCustomer = new CustomerDTO(0, nameField.getText(), emailField.getText(), addressField.getText(), sdtField.getText());
            bus.addCustomer(newCustomer);
            loadAllCustomers();
        });

        removeButton.addActionListener(e -> {
            int selectedRow = customerTable.getSelectedRow();
            if (selectedRow != -1) {
                String id = customerTable.getValueAt(selectedRow, 0).toString();
                bus.removeCustomer(Integer.parseInt(id));
                loadAllCustomers();
            }
        });

        editButton.addActionListener(e -> {
            int selectedRow = customerTable.getSelectedRow();
            if (selectedRow != -1) {
                editingCustomerId = Integer.parseInt(customerTable.getValueAt(selectedRow, 0).toString());
                nameField.setText(customerTable.getValueAt(selectedRow, 1).toString());
                emailField.setText(customerTable.getValueAt(selectedRow, 2).toString());
                addressField.setText(customerTable.getValueAt(selectedRow, 3).toString());
                sdtField.setText(customerTable.getValueAt(selectedRow, 4).toString());
            }
        });

        saveButton.addActionListener(e -> {
            if (editingCustomerId != -1) {
                CustomerDTO updatedCustomer = new CustomerDTO(editingCustomerId, nameField.getText(), emailField.getText(), addressField.getText(), sdtField.getText());
                bus.updateCustomer(updatedCustomer);
                loadAllCustomers();
                editingCustomerId = -1;
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
        add(buttonPanel);
        add(searchPanel);
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

    public JTable getCustomerTable() {
        return customerTable;
    }
}
