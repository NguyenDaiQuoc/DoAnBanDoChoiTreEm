/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn;

import java.util.ArrayList;
import DoAn.ProductDTO;
import DoAn.DoChoiLapGhep;
import DoAn.DoChoiPhuongTien;
import DoAn.DoChoiTheoPhim;
import DoAn.DoChoiThoiTrang;
import DoAn.RoBot;
import Database.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ProductDAO {
    
    public ArrayList<ProductDTO> getAllProducts() {
        ArrayList<ProductDTO> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM sanpham WHERE status = 1");
            while (rs.next()) {
                ProductDTO product = new ProductDTO();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
                product.setTongSanPham(rs.getInt("tongSanPham"));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
    
    public ArrayList<DoChoiPhuongTien> getAllVehicleToys(){
        ArrayList<DoChoiPhuongTien> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM sanham WHERE status = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiPhuongTien product = new DoChoiPhuongTien();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
                product.setTongSanPham(rs.getInt("tongSanPham"));
                product.setLoaiPhuongTien(rs.getString("loaiPhuongTien"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productList;
    }
    
    public ArrayList<DoChoiTheoPhim> getAllMovieToys(){
        ArrayList<DoChoiTheoPhim> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM sanham WHERE status = 2");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiTheoPhim product = new DoChoiTheoPhim();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
                product.setTongSanPham(rs.getInt("tongSanPham"));
                product.setTenPhim(rs.getString("tenPhim"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productList;
    }
    
    public ArrayList<DoChoiThoiTrang> getAllFashionToys(){
        ArrayList<DoChoiThoiTrang> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM sanham WHERE status = 3");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiThoiTrang product = new DoChoiThoiTrang();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
                product.setTongSanPham(rs.getInt("tongSanPham"));
                product.setXuHuong(rs.getString("xuHuong"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productList;
    }
    
    public ArrayList<DoChoiLapGhep> getAllAssemblyToys(){
        ArrayList<DoChoiLapGhep> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM sanham WHERE status = 4");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiLapGhep product = new DoChoiLapGhep();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
                product.setTongSanPham(rs.getInt("tongSanPham"));
                product.setSoManhGhep(rs.getInt("soManhGhep"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productList;
    }
    
    public ArrayList<RoBot> getAllRoBotToys(){
        ArrayList<RoBot> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM sanham WHERE status = 5");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                RoBot product = new RoBot();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
                product.setTongSanPham(rs.getInt("tongSanPham"));
                product.setLoaiRoBot(rs.getString("loaiRoBot"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productList;
    }

    
    public ArrayList<ProductDTO> searchProductById(String id){
        ArrayList<ProductDTO> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM sanpham WHERE status = 1 AND id = ?");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProductDTO product = new ProductDTO();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
                product.setTongSanPham(rs.getInt("tongSanPham"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return productList;
    }
    
    public void addProduct(ProductDTO product){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO sanpham (id, ten, xuatxu, gia, soLuongConLai, tongSanPham, status) VALUES (?, ?, ?, ?, ?, ?, 1)");
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setString(3, product.getXuatxu());
            ps.setDouble(4, product.getGia());
            ps.setInt(5, product.getSoLuongConLai());
            ps.setInt(6, product.getTongSanPham());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeProduct(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE sanpham SET status = 0 WHERE id = ?");
            ps.setString(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateProduct(ProductDTO product){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE sanpham SET ten = ?, xuatxu = ?, gia = ?, soLuongConLai = ?, tongSanPham = ? WHERE id = ?");
            ps.setString(1, product.getTen());
            ps.setString(2, product.getXuatxu());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuongConLai());
            ps.setInt(5, product.getTongSanPham());
            ps.setString(7, product.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
