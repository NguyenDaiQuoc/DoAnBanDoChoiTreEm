// PromotionPage.java
package UI.Promotion;

import Bus.PromotionBUS;
import Inventory.DTO.PromotionDTO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PromotionPage extends JPanel {
    private DefaultTableModel tableModel;
    private JTable promotionTable;
    private JTextField noiDungField, phanTramGiamGiaField, searchField;
    private JButton addButton, removeButton, searchButton, cancelButton, editButton, saveButton;
    private int editingPromotionId = -1; // ID của khuyến mãi đang được chỉnh sửa
    private PromotionBUS bus = new PromotionBUS();

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

        JPanel inputPanel = new JPanel();
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

        addButton.addActionListener(e -> {
            PromotionDTO newPromotion = new PromotionDTO(0, noiDungField.getText(), Double.parseDouble(phanTramGiamGiaField.getText()));
            bus.addPromotion(newPromotion);
            loadAllPromotions();
        });

        removeButton.addActionListener(e -> {
            int selectedRow = promotionTable.getSelectedRow();
            if (selectedRow != -1) {
                String id = promotionTable.getValueAt(selectedRow, 0).toString();
                bus.removePromotion(Integer.parseInt(id));
                loadAllPromotions();
            }
        });

        editButton.addActionListener(e -> {
            int selectedRow = promotionTable.getSelectedRow();
            if (selectedRow != -1) {
                editingPromotionId = Integer.parseInt(promotionTable.getValueAt(selectedRow, 0).toString());
                noiDungField.setText(promotionTable.getValueAt(selectedRow, 1).toString());
                phanTramGiamGiaField.setText(promotionTable.getValueAt(selectedRow, 2).toString());
            }
        });

        saveButton.addActionListener(e -> {
            if (editingPromotionId != -1) {
                PromotionDTO updatedPromotion = new PromotionDTO(editingPromotionId, noiDungField.getText(), Double.parseDouble(phanTramGiamGiaField.getText()));
                bus.updatePromotion(updatedPromotion);
                loadAllPromotions();
                editingPromotionId = -1;
            }
        });

        searchButton.addActionListener(e -> {
            String keyword = searchField.getText();
            loadPromotionsByKeyword(keyword);
        });

        cancelButton.addActionListener(e -> {
            loadAllPromotions();
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
