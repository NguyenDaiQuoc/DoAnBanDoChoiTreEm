// PromotionDAO.java
package Inventory.DAO;

import Database.ConnectionProvider;
import Inventory.DTO.PromotionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                promotions.add(new PromotionDTO(rs.getInt("id"), rs.getString("noiDung"), rs.getDouble("phanTramGiamGia")));
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
                promotions.add(new PromotionDTO(rs.getInt("id"), rs.getString("noiDung"), rs.getDouble("phanTramGiamGia")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return promotions;
    }

    public void addPromotion(PromotionDTO promotion) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("INSERT INTO khuyenmai (noiDung, phanTramGiamGia) VALUES (?, ?)");
            pst.setString(1, promotion.getNoiDung());
            pst.setDouble(2, promotion.getPhanTramGiamGia());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removePromotion(int id) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("DELETE FROM khuyenmai WHERE id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePromotion(PromotionDTO promotion) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("UPDATE khuyenmai SET noiDung = ?, phanTramGiamGia = ? WHERE id = ?");
            pst.setString(1, promotion.getNoiDung());
            pst.setDouble(2, promotion.getPhanTramGiamGia());
            pst.setInt(3, promotion.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
