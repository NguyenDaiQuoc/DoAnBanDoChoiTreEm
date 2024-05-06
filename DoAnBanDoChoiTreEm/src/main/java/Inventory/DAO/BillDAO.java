/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.DAO;
import Database.ConnectionProvider;
import Inventory.DTO.BillDTO;
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
public class BillDAO {
    // lay ds hoa don
    public ArrayList<BillDTO> getAllBills() {
        ArrayList<BillDTO> dshoadon = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM HOADON");
            while (rs.next()) {
                if(rs.getString("status").equals("true")) {
                    try {
                       dshoadon.add(new BillDTO(rs.getInt("id"), rs.getString("idNhanVien"), rs.getString("idKhachHang"), rs.getInt("soLuongCTHD"), rs.getDouble("tongTien"), rs.getDate("ngayXuat"), rs.getString("status")));
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dshoadon;
    }
    
    public ArrayList<BillDTO> getAllBills1() {
        ArrayList<BillDTO> dshoadon = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM HOADON");
            while (rs.next()) {
                try {
                   dshoadon.add(new BillDTO(rs.getInt("id"), rs.getString("idNhanVien"), rs.getString("idKhachHang"), rs.getInt("soLuongCTHD"), rs.getDouble("tongTien"), rs.getDate("ngayXuat"), rs.getString("status")));
               } catch (Exception e) {
                   e.printStackTrace();
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dshoadon;
    }
    
    // tim kiem hoa don ( tim kiem theo khoang gia tien, ngay xuat ) !!!!!!!!!!!!
    public ArrayList<BillDTO> getBillsByKeyword(String id, String idNV, String idKH, String soCTHD, String tongTien, String ngayXuat, String tuGia, String denGia, String tuNgay, String denNgay) {
        ArrayList<BillDTO> dshoadon = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM hoadon WHERE status = 'true' AND (id LIKE ? OR idNhanVien LIKE ? OR idKhachHang LIKE ? OR soLuongCTHD LIKE ? OR tongTien LIKE ? OR ngayXuat LIKE ? OR tongTien BETWEEN ? AND ? OR ngayXuat BETWEEN CAST(? AS DATE) AND CAST(? AS DATE))");
            pst.setString(1,id);
            pst.setString(2,idNV);
            pst.setString(3,idKH);
            pst.setString(4,soCTHD);
            pst.setString(5,tongTien);
            pst.setString(6,ngayXuat);
            pst.setString(7,tuGia);
            pst.setString(8,denGia);
            pst.setString(9,tuNgay);
            pst.setString(10,denNgay);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dshoadon.add(new BillDTO(rs.getInt("id"), rs.getString("idNhanVien"), rs.getString("idKhachHang"), rs.getInt("soLuongCTHD"), rs.getDouble("tongTien"), rs.getDate("ngayXuat"), rs.getString("status")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dshoadon;
    }
    
   public void addBill (BillDTO bill) {
       try {
           Connection con = ConnectionProvider.getCon();
           PreparedStatement pst = con.prepareStatement("INSERT INTO HOADON (idNhanVien, idKhachHang, soLuongCTHD, tongTien, ngayXuat, status) VALUES (?,?,?,?,?,?) WHERE id LIKE ?");
           pst.setString(1, bill.getIdNhanVien());
           pst.setString(2, bill.getIdKhachHang());
           pst.setInt(3, bill.getSoCTHD());
           pst.setDouble(4, bill.getTongTien());
           pst.setDate(5, (Date) bill.getNgayXuat());
           pst.setString(6, bill.getStatus());
           pst.setInt(7, bill.getId());
           pst.executeUpdate();
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
   
   public void removeBill (int id) {
       try {
           Connection con = ConnectionProvider.getCon();
           PreparedStatement pst = con.prepareStatement("UPDATE HOADON SET STATUS = 'false' WHERE id = ?");
           pst.setInt(1, id);
           pst.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   
   public void updateBill (BillDTO bill) {
       // chuyen doi date cua java sang sql
       java.sql.Date sqlDate = new java.sql.Date(bill.getNgayXuat().getTime());
       try {
           Connection con = ConnectionProvider.getCon();
           PreparedStatement pst = con.prepareStatement("UPDATE HOADON SET idNhanVien = ?, idKhachHang = ?, soLuongCTHD = ?, tongTien = ?, ngayXuat = ?, status = ? WHERE id = ?");
           pst.setString(1, bill.getIdNhanVien());
           pst.setString(2, bill.getIdKhachHang());
           pst.setInt(3, bill.getSoCTHD());
           pst.setDouble(4,bill.getTongTien());
           pst.setDate(5, sqlDate);
           pst.setString(6, bill.getStatus());
           pst.setInt(7, bill.getId());
           pst.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}