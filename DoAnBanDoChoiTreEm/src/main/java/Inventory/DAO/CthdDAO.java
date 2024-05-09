/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.DAO;
import Database.ConnectionProvider;
import Inventory.DTO.BillDTO;
import Inventory.DTO.CthdDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class CthdDAO {
    
    // lay ds cthd
    public ArrayList<CthdDTO> getAllCTHD() {
        ArrayList<CthdDTO> dscthd = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CTHD WHERE status = 1");
            while(rs.next()) {
                    dscthd.add(new CthdDTO(rs.getInt("idHoaDon"), rs.getString("idSanPham"), rs.getString("tenSanPham"), rs.getInt("soLuong"), rs.getDouble("giaTien"), rs.getInt("status")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dscthd;
    }
    
    public void addCTHD (CthdDTO cthd) {
       try {
           Connection con = ConnectionProvider.getCon();
           PreparedStatement pst = con.prepareStatement("INSERT INTO cthd (idHoaDon, idSanPham, tenSanPham, soLuong, giaTien, status) VALUES (?,?,?,?,?,?)");
           pst.setInt(1, cthd.getIdHoaDon());
           pst.setString(2, cthd.getIdSanPham());
           pst.setString(3, cthd.getTenSanPham());
           pst.setInt(4, cthd.getSoLuong());
           pst.setDouble(5, cthd.getGiaTien());
           pst.setInt(6, cthd.getStatus());
           pst.executeUpdate();
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
    
    public void removeCTHD (String idSP, int idHD) {
       try {
           Connection con = ConnectionProvider.getCon();
           PreparedStatement pst = con.prepareStatement("UPDATE cthd SET STATUS = 0 WHERE idSanPham LIKE ? AND idHoaDon LIKE ?");
           pst.setString(1, idSP);
           pst.setInt(2, idHD);
           pst.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   
   public void updateCTHD (CthdDTO cthd, String oldIdSP) {
       try {
           Connection con = ConnectionProvider.getCon();
           PreparedStatement pst = con.prepareStatement("UPDATE cthd SET idSanPham = ?, tenSanPham = ?, soLuong = ?, giaTien = ? WHERE idSanPham = ? AND idHoaDon = ?");
           pst.setString(1, cthd.getIdSanPham());
           pst.setString(2, cthd.getTenSanPham());
           pst.setInt(3, cthd.getSoLuong());
           pst.setDouble(4,cthd.getGiaTien());
           pst.setString(5, oldIdSP);
           pst.setString(6, String.valueOf(cthd.getIdHoaDon()));
           pst.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
