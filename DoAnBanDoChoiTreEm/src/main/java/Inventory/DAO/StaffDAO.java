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

    public void addUser(StaffDTO staff) {
        try {
            Connection con = ConnectionProvider.getCon();
            //StaffDTO newStaff = new StaffDTO(0, "", 0, "", "", "", "", "Thu Ngan");
            PreparedStatement ps = con.prepareStatement("INSERT INTO nguoidung (id,vaiTro,ten,sdt,email,matKhau,diaChi) VALUES (?, ?, ?, ?, ?, ?,?)");
            //PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, staff.getStaID());
            ps.setString(2, "Nhan Vien");
            ps.setString(3, staff.getStaName());
            ps.setString(4, staff.getStaPhone());
            ps.setString(5, staff.getStaEmail());
            ps.setString(6, "123");
            ps.setString(7, staff.getStaAddress());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không thể thêm!");
            return;
        }
        JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!");
        return;
    }
    
    public void editUser(StaffDTO staff) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("UPDATE nguoidung SET vaitro = ?, ten = ?, sdt = ?, email = ?, diaChi = ? WHERE id = ?");
            pst.setString(1, "Nhan vien");
            pst.setString(2, staff.getStaName());
            pst.setString(3, staff.getStaPhone());
            pst.setString(4, staff.getStaEmail());
            pst.setString(5, staff.getStaAddress());
            pst.setInt(6, staff.getStaID());
            int updatedRows = pst.executeUpdate();
            if (updatedRows > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin người dùng thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy người dùng để cập nhật hoặc có lỗi xảy ra!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không thể cập nhật thông tin người dùng!");
        }
}

    public ArrayList<StaffDTO> getAllStaffs() {
        ArrayList<StaffDTO> staff = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM nhanvien WHERE status = 1");
            while (rs.next()) {
                staff.add(new StaffDTO(rs.getInt("id"), rs.getString("ten"), rs.getInt("tuoi"), rs.getString("gioitinh"), rs.getString("email"), rs.getString("diaChi"), rs.getString("sdt"), rs.getString("vaiTro")));
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
            PreparedStatement pst = con.prepareStatement("SELECT * FROM nhanvien WHERE status = 1 AND (id LIKE? OR ten LIKE ? OR tuoi LIKE ? OR gioitinh LIKE? OR email LIKE ? OR diaChi LIKE ? OR sdt LIKE ?)");
            pst.setString(1, "%" + keyword + "%");
            pst.setString(2, "%" + keyword + "%");
            pst.setString(3, "%" + keyword + "%");
            pst.setString(4, "%" + keyword + "%");
            pst.setString(5, "%" + keyword + "%");
            pst.setString(6, "%" + keyword + "%");
            pst.setString(7, "%" + keyword + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                staff.add(new StaffDTO(rs.getInt("id"), rs.getString("ten"), rs.getInt("tuoi"), rs.getString("gioitinh"), rs.getString("email"), rs.getString("diaChi"), rs.getString("sdt"), rs.getString("vaiTro")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staff;
    }

    public void addStaff(StaffDTO staff) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("INSERT INTO nhanvien (id,ten,tuoi,gioitinh, email, diaChi, sdt,vaitro, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 1)");
            pst.setInt(1, staff.getStaID());            
            pst.setString(2, staff.getStaName());
            pst.setInt(3, staff.getStaAge());
            pst.setString(4, staff.getStaSex());
            pst.setString(5, staff.getStaEmail());
            pst.setString(6, staff.getStaAddress());
            pst.setString(7, staff.getStaPhone());
            pst.setString(8, "Thu Ngan");
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
            PreparedStatement pst = con.prepareStatement("UPDATE nhanvien SET ten = ?, tuoi = ?, gioitinh = ?, email = ?, diaChi = ?, sdt = ? WHERE id = ?");
            pst.setString(1, staff.getStaName());
            pst.setInt(2, staff.getStaAge());
            pst.setString(3, staff.getStaSex());
            pst.setString(4, staff.getStaEmail());
            pst.setString(5, staff.getStaAddress());
            pst.setString(6, staff.getStaPhone());
            pst.setInt(7, staff.getStaID());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StaffDTO getStaffByUserName(String username) {//search
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
                loggedInStaff = new StaffDTO(id, name, 0, "", username, "", "", "");
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
    
    public int[] getInfoStaff(){
        int[] staInfo = new int[2];
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = ConnectionProvider.getCon();
            pst = con.prepareStatement("SELECT SUM(CASE WHEN status = 1 THEN 1 ELSE 0 END) AS active_count, SUM(CASE WHEN status = 0 THEN 1 ELSE 0 END) AS inactive_count FROM nhanvien");
            rs = pst.executeQuery();
            if (rs.next()) {
                staInfo[0] = rs.getInt("active_count");
                staInfo[1] = rs.getInt("inactive_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không thể truy vấn dữ liệu!");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return staInfo;
    }
    
}
