  // CustomerDAO.java
package Inventory.DAO;

import Database.ConnectionProvider;
import Inventory.DTO.CustomerDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CustomerDAO {

    public ArrayList<CustomerDTO> getAllCustomers() {
        ArrayList<CustomerDTO> customers = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM khachhang");
            while (rs.next()) {
                customers.add(new CustomerDTO(rs.getString("id"), rs.getString("ten"), rs.getString("email"), rs.getString("diaChi"), rs.getString("sdt")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public ArrayList<CustomerDTO> getCustomersByKeyword(String keyword) {
        ArrayList<CustomerDTO> customers = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM khachhang WHERE ten LIKE ? OR email LIKE ? OR diaChi LIKE ? OR sdt LIKE ?");
            pst.setString(1, "%" + keyword + "%");
            pst.setString(2, "%" + keyword + "%");
            pst.setString(3, "%" + keyword + "%");
            pst.setString(4, "%" + keyword + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                customers.add(new CustomerDTO(rs.getString("id"), rs.getString("ten"), rs.getString("email"), rs.getString("diaChi"), rs.getString("sdt")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void addCustomer(CustomerDTO customer) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("INSERT INTO khachhang (id, ten, email, diaChi, sdt) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, customer.getId());
            pst.setString(2, customer.getName());
            pst.setString(3, customer.getEmail());
            pst.setString(4, customer.getAddress());
            pst.setString(5, customer.getSdt());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeCustomer(String id) { // Change this from int to String
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("DELETE FROM khachhang WHERE id = ?");
            pst.setString(1, id); // Change this from setInt to setString
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(CustomerDTO customer) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("UPDATE khachhang SET ten = ?, email = ?, diaChi = ?, sdt = ? WHERE id = ?");
            pst.setString(1, customer.getName());
            pst.setString(2, customer.getEmail());
            pst.setString(3, customer.getAddress());
            pst.setString(4, customer.getSdt());
            pst.setString(5, customer.getId()); // Change this from setInt to setString
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getInfoCus(){
        int cusInfo = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = ConnectionProvider.getCon();
            pst = con.prepareStatement("SELECT SUM(status = 1)  AS total FROM khachhang");
            rs = pst.executeQuery();
            if (rs.next()) {
                cusInfo = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không thể truy vấn dữ liệu nhanvien!");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cusInfo;
    }
}
