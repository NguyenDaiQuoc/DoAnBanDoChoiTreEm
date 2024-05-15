// PromotionPage.java
package UI.Promotion;

import Bus.PromotionBUS;
import Inventory.DTO.PromotionDTO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class PromotionPage extends JPanel {

    private DefaultTableModel tableModel;
    private JTable promotionTable;
    private JTextField noiDungField, phanTramGiamGiaField, searchField;
    private JButton addButton, removeButton, searchButton, cancelButton, editButton, saveButton, exportButton;
    private PromotionBUS bus = new PromotionBUS();
    private JTextField idField = new JTextField(10); // New field for ID
    private String editingPromotionId = null; // Change this from int to String

    public PromotionPage() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Khuyến mãi");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(20));
        add(titleLabel);
        add(Box.createVerticalStrut(20));

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nội dung");
        tableModel.addColumn("Phần trăm giảm giá");

        promotionTable = new JTable(tableModel);

        noiDungField = new JTextField(20);
        phanTramGiamGiaField = new JTextField(20);
        searchField = new JTextField(20);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        searchButton = new JButton("Search");
        cancelButton = new JButton("Cancel");
        editButton = new JButton("Edit");
        saveButton = new JButton("Save");
        exportButton = new JButton("Export");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Nội dung:"));
        inputPanel.add(noiDungField);
        inputPanel.add(new JLabel("Phần trăm giảm giá:"));
        inputPanel.add(phanTramGiamGiaField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        inputPanel.add(editButton);
        inputPanel.add(new JLabel("Search:"));
        inputPanel.add(searchField);
        inputPanel.add(searchButton);
        inputPanel.add(cancelButton);
        inputPanel.add(saveButton);
        inputPanel.add(exportButton);

        addButton.addActionListener(e -> {
            // Get the id from the idField
            String id = idField.getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Xin hãy nhập ID.");
                return;
            }

            // Check if id starts with "KM"
            if (!id.startsWith("KM")) {
                JOptionPane.showMessageDialog(null, "ID phải bắt đầu bằng 'KM'.");
                return;
            }

            // Check if id already exists in the database
            ArrayList<PromotionDTO> existingPromotions = bus.getAllPromotions();
            for (PromotionDTO promotion : existingPromotions) {
                if (promotion.getId().equals(id)) {
                    JOptionPane.showMessageDialog(null, "ID đã tồn tại. Vui lòng nhập ID khác.");
                    return;
                }
            }

            PromotionDTO newPromotion = new PromotionDTO(id, noiDungField.getText(), Double.parseDouble(phanTramGiamGiaField.getText()));
            bus.addPromotion(newPromotion);
            loadAllPromotions();
        });

        removeButton.addActionListener(e -> {
            int selectedRow = promotionTable.getSelectedRow();
            if (selectedRow != -1) {
                String id = promotionTable.getValueAt(selectedRow, 0).toString();
                bus.removePromotion(id); // No need to parse id to int
                loadAllPromotions();
            }
        });

        editButton.addActionListener(e -> {
            int selectedRow = promotionTable.getSelectedRow();
            if (selectedRow != -1) {
                editingPromotionId = promotionTable.getValueAt(selectedRow, 0).toString(); // Change this from Integer.parseInt(...) to toString()
                noiDungField.setText(promotionTable.getValueAt(selectedRow, 1).toString());
                phanTramGiamGiaField.setText(promotionTable.getValueAt(selectedRow, 2).toString());
            }
        });

        saveButton.addActionListener(e -> {
            if (editingPromotionId != null) { // Change this from -1 to null
                PromotionDTO updatedPromotion = new PromotionDTO(editingPromotionId, noiDungField.getText(), Double.parseDouble(phanTramGiamGiaField.getText()));
                bus.updatePromotion(updatedPromotion);
                loadAllPromotions();
                editingPromotionId = null; // Change this from -1 to null
            }
        });

        searchButton.addActionListener(e -> {
            String keyword = searchField.getText();
            loadPromotionsByKeyword(keyword);
        });

        cancelButton.addActionListener(e -> {
            loadAllPromotions();
        });
        
        exportButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getPath();
                // Check if the file has the .xlsx extension; if not, add it
                if (!filePath.toLowerCase().endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }
                bus.exportToExcel(bus.getAllPromotions(), filePath);
            }
        });

        JScrollPane scrollPane = new JScrollPane(promotionTable);

        add(inputPanel);
        add(Box.createVerticalStrut(20));
        add(scrollPane);

        loadAllPromotions();
    }

    private void loadAllPromotions() {
        // Xóa tất cả các hàng hiện có
        tableModel.setRowCount(0);

        // Tải lại danh sách khuyến mãi từ cơ sở dữ liệu
        ArrayList<PromotionDTO> promotions = bus.getAllPromotions();
        for (PromotionDTO promotion : promotions) {
            String[] rowData = {String.valueOf(promotion.getId()), promotion.getNoiDung(), String.valueOf(promotion.getPhanTramGiamGia())};
            tableModel.addRow(rowData);
        }
    }

    private void loadPromotionsByKeyword(String keyword) {
        // Xóa tất cả các hàng hiện có
        tableModel.setRowCount(0);

        // Tải lại danh sách khuyến mãi từ cơ sở dữ liệu
        ArrayList<PromotionDTO> promotions = bus.getPromotionsByKeyword(keyword);
        for (PromotionDTO promotion : promotions) {
            String[] rowData = {String.valueOf(promotion.getId()), promotion.getNoiDung(), String.valueOf(promotion.getPhanTramGiamGia())};
            tableModel.addRow(rowData);
        }
    }

    public JTable getPromotionTable() {
        return promotionTable;
    }
}
