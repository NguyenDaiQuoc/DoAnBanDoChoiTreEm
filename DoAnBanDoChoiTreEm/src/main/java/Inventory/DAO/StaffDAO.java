package Inventory.DAO;

import Database.ConnectionProvider;
import Inventory.DTO.CustomerDTO;
import Inventory.DTO.ProductDTO;
import Inventory.DTO.StaffDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StaffDAO {
    private String tk;
    public ArrayList <StaffDTO> getAllStaffs (){
        ArrayList <StaffDTO> staff = new ArrayList <>();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM nhanvien WHERE status = 1");
            while (rs.next()) {
                staff.add(new StaffDTO(rs.getInt("id"), rs.getString("ten"), rs.getInt("tuoi"), rs.getString("email"), rs.getString("diaChi"),rs.getString("sdt"),rs.getString("vaiTro")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staff;
    }
    
    public ArrayList<StaffDTO> getStaffByKeyword(String keyword) {
        ArrayList<StaffDTO> staff = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM nhanvien WHERE status = 1 AND (ten LIKE ? OR email LIKE ? OR diaChi LIKE ? OR sdt LIKE ?)");
            pst.setString(1, "%" + keyword + "%");
            pst.setString(2, "%" + keyword + "%");
            pst.setString(3, "%" + keyword + "%");
            pst.setString(4, "%" + keyword + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                staff.add(new StaffDTO(rs.getInt("id"), rs.getString("ten"), rs.getInt("tuoi"), rs.getString("email"), rs.getString("diaChi"),rs.getString("sdt"),rs.getString("vaiTro")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staff;
    }

    public void addStaff(StaffDTO staff) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("INSERT INTO nhanvien (ten,tuoi, email, diaChi, sdt, status) VALUES (?, ?, ?, ?, ?, 1)");
            pst.setString(1, staff.getStaName());
            pst.setInt(2, staff.getStaAge());
            pst.setString(3, staff.getStaEmail());
            pst.setString(4, staff.getStaAddress());
            pst.setString(5, staff.getStaPhone());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeStaff(int id) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("UPDATE nhanvien SET status = 0 WHERE id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStaff(StaffDTO staff) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("UPDATE nhanvien SET ten = ?, tuoi = ?, email = ?, diaChi = ?, sdt = ? WHERE id = ?");
            pst.setString(1, staff.getStaName());
            pst.setInt(2, staff.getStaAge());
            pst.setString(3, staff.getStaEmail());
            pst.setString(4, staff.getStaAddress());
            pst.setString(5, staff.getStaPhone());
            pst.setInt(6, staff.getStaID());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public StaffDTO getStaffByUserName(String username) {
        StaffDTO loggedInStaff = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = ConnectionProvider.getCon();
            // Chuẩn bị truy vấn SQL
            pst = con.prepareStatement("SELECT * FROM nhanvien WHERE status = 1 AND email = ?");
            pst.setString(1, username);
            // Thực thi truy vấn
            rs = pst.executeQuery();
            if (rs.next()) {
                // Nếu có kết quả, lấy thông tin của nhân viên
                int id = rs.getInt("id");
                String name = rs.getString("ten");
                // Tạo đối tượng StaffDTO từ thông tin nhân viên
                loggedInStaff = new StaffDTO(id, name, 0, username, "", "", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Đóng các đối tượng ResultSet, PreparedStatement và Connection
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return loggedInStaff;
    }
    
}
