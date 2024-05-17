/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Statistical;
import Inventory.DTO.StaffDTO;
import UI.Employee.EmployeePage;
import UI.Product.ProductPage;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class StatisticalPage extends javax.swing.JPanel {
    private DefaultTableModel model;
    private int staTotal, staLeft, staRemain, proTotal, proSold, proRemain, cusTotal, billTotal, profit, sell, buy;
    EmployeePage em = new EmployeePage();
    ProductPage prod = new ProductPage();
    public StatisticalPage() {
        initComponents();       
        showInfo();
    }
    int[] staInfo = em.getInfoStaff();
    int[] prodInfo = prod.getInfoProd();
    public void showInfo(){
        staTotal1.setText(String.valueOf(staInfo[0]));
        staLeft1.setText(String.valueOf(staInfo[1]));
        staRemain1.setText(String.valueOf(staInfo[0] - staInfo[1]));
        prodTotal1.setText(TOOL_TIP_TEXT_KEY);
    }
        //String [] rowData = {String.valueOf/*(this.staTotal)*/(staInfo[0]),/*String.valueOf(this.staLeft)*/String.valueOf(staInfo[1]),String.valueOf(staInfo[0] - staInfo[1])};

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StatisLabel = new javax.swing.JLabel();
        staToTalLabel = new javax.swing.JLabel();
        staLeftLabel = new javax.swing.JLabel();
        staRemainLabel = new javax.swing.JLabel();
        prodTotalLabel = new javax.swing.JLabel();
        prodSoldLabel = new javax.swing.JLabel();
        prodRemainLabel = new javax.swing.JLabel();
        custTotalLabel = new javax.swing.JLabel();
        billTotalLabel = new javax.swing.JLabel();
        profLabel = new javax.swing.JLabel();
        staTotal1 = new javax.swing.JLabel();
        staLeft1 = new javax.swing.JLabel();
        staRemain1 = new javax.swing.JLabel();
        prodTotal1 = new javax.swing.JLabel();
        prodSold1 = new javax.swing.JLabel();
        prodRemain1 = new javax.swing.JLabel();
        custTotal1 = new javax.swing.JLabel();
        billTotal1 = new javax.swing.JLabel();
        prof1 = new javax.swing.JLabel();

        StatisLabel.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        StatisLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StatisLabel.setText("THỐNG KÊ");

        staToTalLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        staToTalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        staToTalLabel.setText("Tổng nhân viên:");

        staLeftLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        staLeftLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        staLeftLabel.setText("Nhân viên nghỉ");

        staRemainLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        staRemainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        staRemainLabel.setText("Nhân viên hiện tại");

        prodTotalLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        prodTotalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prodTotalLabel.setText("Tổng sản phẩm");

        prodSoldLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        prodSoldLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prodSoldLabel.setText("Sản phẩm đã bán");

        prodRemainLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        prodRemainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prodRemainLabel.setText("Sản phẩm còn lại");

        custTotalLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        custTotalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custTotalLabel.setText("Tổng khách hàng");

        billTotalLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        billTotalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        billTotalLabel.setText("Tổng hoá đơn bán");

        profLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        profLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profLabel.setText("Doanh thu");

        staTotal1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        staTotal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        staLeft1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        staLeft1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        staRemain1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        staRemain1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        prodTotal1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        prodTotal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        prodRemain1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        prodRemain1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        custTotal1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        custTotal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        billTotal1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        billTotal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        prof1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        prof1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(152, 553, Short.MAX_VALUE)
                .addComponent(StatisLabel)
                .addGap(522, 522, 522))
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(prodSoldLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staToTalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staRemainLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addComponent(staLeftLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prodTotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prodRemainLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(custTotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(billTotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(staTotal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staLeft1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staRemain1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prodTotal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prodSold1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prodRemain1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(custTotal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(billTotal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prof1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                .addGap(204, 204, 204))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(StatisLabel)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staToTalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staLeftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staRemainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staRemain1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prodTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prodTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prodSoldLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prodSold1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prodRemainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prodRemain1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(custTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(custTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(billTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(billTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prof1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(203, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel StatisLabel;
    private javax.swing.JLabel billTotal1;
    private javax.swing.JLabel billTotalLabel;
    private javax.swing.JLabel custTotal1;
    private javax.swing.JLabel custTotalLabel;
    private javax.swing.JLabel prodRemain1;
    private javax.swing.JLabel prodRemainLabel;
    private javax.swing.JLabel prodSold1;
    private javax.swing.JLabel prodSoldLabel;
    private javax.swing.JLabel prodTotal1;
    private javax.swing.JLabel prodTotalLabel;
    private javax.swing.JLabel prof1;
    private javax.swing.JLabel profLabel;
    private javax.swing.JLabel staLeft1;
    private javax.swing.JLabel staLeftLabel;
    private javax.swing.JLabel staRemain1;
    private javax.swing.JLabel staRemainLabel;
    private javax.swing.JLabel staToTalLabel;
    private javax.swing.JLabel staTotal1;
    // End of variables declaration//GEN-END:variables
}