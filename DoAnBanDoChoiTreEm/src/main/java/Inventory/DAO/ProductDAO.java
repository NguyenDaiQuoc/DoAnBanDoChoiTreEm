package Inventory.DAO;

import Inventory.DTO.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProductDAO{
    
   /* private void themBtnActionPerformed(java.awt.event.ActionEvent evt, ProductDTO product) {                              
        // TODO add your handling code here:
        String ten = product.getProName();
        float gia = product.getProPrice(); 
        String xuatxu = product.getProOrigin();
        int soluong = product.getProQuantity();
        String Status = "true";
        if(ten == null || gia == 0 || xuatxu == null || soluong == 0 ) {
            JOptionPane.showMessageDialog(null, "Hãy điền đủ thông tin !");
            tenSP.setText(" ");
            giaSP.setText(" ");
            xuatxuSP.setText(" ");
            soluongSP.setText(" ");
        } else {
            try {
                Connection con = Database.ConnectionProvider.getCon();
                String query = "INSERT INTO SanPham (Ten,Xuatxu,Giatien,Soluongconlai,Status) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, ten);
                ps.setString(2, xuatxu);
                ps.setFloat(3, gia);
                ps.setInt(4, soluong);
                ps.setString(5, Status);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Dữ liệu đã được chèn thành công.");
                } else {
                    System.out.println("Không thể chèn dữ liệu.");
                }

                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/
    
    
}