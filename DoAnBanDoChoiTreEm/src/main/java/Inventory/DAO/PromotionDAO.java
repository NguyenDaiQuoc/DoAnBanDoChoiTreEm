// PromotionDAO.java
package Inventory.DAO;

import Database.ConnectionProvider;
import Inventory.DTO.PromotionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PromotionDAO {

    public ArrayList<PromotionDTO> getAllPromotions() {
        ArrayList<PromotionDTO> promotions = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM khuyenmai");
            while (rs.next()) {
                promotions.add(new PromotionDTO(rs.getString("id"), rs.getString("noiDung"), rs.getDouble("phanTramGiamGia"))); // Change rs.getInt("id") to rs.getString("id")
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return promotions;
    }

    public ArrayList<PromotionDTO> getPromotionsByKeyword(String keyword) {
        ArrayList<PromotionDTO> promotions = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM khuyenmai WHERE noiDung LIKE ? OR phanTramGiamGia LIKE ?");
            pst.setString(1, "%" + keyword + "%");
            pst.setString(2, "%" + keyword + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                promotions.add(new PromotionDTO(rs.getString("id"), rs.getString("noiDung"), rs.getDouble("phanTramGiamGia"))); // Change rs.getInt("id") to rs.getString("id")
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return promotions;
    }

    public void addPromotion(PromotionDTO promotion) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("INSERT INTO khuyenmai (id, noiDung, phanTramGiamGia) VALUES (?, ?, ?)");
            pst.setString(1, promotion.getId());
            pst.setString(2, promotion.getNoiDung());
            pst.setDouble(3, promotion.getPhanTramGiamGia());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removePromotion(String id) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("DELETE FROM khuyenmai WHERE id = ?");
            pst.setString(1, id); // Change pst.setInt to pst.setString
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Tìm Kiếm Khuyến Mãi Theo id
    public ArrayList<PromotionDTO> searchPromotionById(String id) {
        ArrayList<PromotionDTO> promotionList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "SELECT * FROM khuyenmai WHERE status = 1 AND id LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%"); // Change ps.setInt to ps.setString
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PromotionDTO promotion = new PromotionDTO(rs.getString("id"), rs.getString("noiDung"), rs.getDouble("phanTramGiamGia")); // Change rs.getInt("id") to rs.getString("id")
                promotion.setId(rs.getString("id")); // Change rs.getInt("id") to rs.getString("id")
                promotion.setNoiDung(rs.getString("noiDung"));
                promotion.setPhanTramGiamGia(rs.getDouble("phanTramGiamGia"));
                promotionList.add(promotion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return promotionList;
    }

    public void updatePromotion(PromotionDTO promotion) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("UPDATE khuyenmai SET noiDung = ?, phanTramGiamGia = ? WHERE id = ?");
            pst.setString(1, promotion.getNoiDung());
            pst.setDouble(2, promotion.getPhanTramGiamGia());
            pst.setString(3, promotion.getId()); // Change pst.setInt to pst.setString
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
