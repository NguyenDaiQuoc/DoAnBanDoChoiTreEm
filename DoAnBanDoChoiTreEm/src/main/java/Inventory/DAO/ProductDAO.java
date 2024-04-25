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
    //Lay THong Tin Chung cua Tat San Pham
    public ArrayList<ProductDTO> getAllProducts() {
        ArrayList<ProductDTO> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM AllProduct WHERE status = 1");
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
    //Lay Thong Tin Tung Loai San Pham
    public ArrayList<DoChoiPhuongTien> getAllVehicleToys(){
        ArrayList<DoChoiPhuongTien> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Product1 WHERE status = 1");
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Product2 WHERE status = 1");
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Product3 WHERE status = 1");
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Product4 WHERE status = 1");
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Product5 WHERE status = 1");
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

    //Tim Kiem San Pham Theo id
    public ArrayList<ProductDTO> searchProductById(String id){
        ArrayList<ProductDTO> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "SELECT * FORM AllProduct WHERE status = 1 AND id LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProductDTO product = new ProductDTO();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
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
    //Tim Kiem Tung Loai San Pham Theo id
    public ArrayList<DoChoiPhuongTien> searchVehicleToysById(String id){
        ArrayList<DoChoiPhuongTien> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "SELECT * FORM Product1 WHERE status = 1 AND id LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiPhuongTien product = new DoChoiPhuongTien();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setTen(rs.getString("xuatxu"));
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
    
    public ArrayList<DoChoiTheoPhim> searchMovieToysById(String id){
        ArrayList<DoChoiTheoPhim> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "SELECT * FORM Product2 WHERE status = 1 AND id LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiTheoPhim product = new DoChoiTheoPhim();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setTen(rs.getString("xuatxu"));
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
    
    public ArrayList<DoChoiThoiTrang> searchFashionToysById(String id){
        ArrayList<DoChoiThoiTrang> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "SELECT * FORM Product3 WHERE status = 1 AND id LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiThoiTrang product = new DoChoiThoiTrang();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setTen(rs.getString("xuatxu"));
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
    
    public ArrayList<DoChoiLapGhep> searchAssemblyToysById(String id){
        ArrayList<DoChoiLapGhep> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "SELECT * FORM Product4 WHERE status = 1 AND id LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiLapGhep product = new DoChoiLapGhep();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setTen(rs.getString("xuatxu"));
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
    
    public ArrayList<RoBot> searchRoBotToysById(String id){
        ArrayList<RoBot> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "SELECT * FORM Product5 WHERE status = 1 AND id LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                RoBot product = new RoBot();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setTen(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
                product.setTongSanPham(rs.getInt("tongSanPham"));
                product.setLoaiRoBot(rs.getString("laiRoBot"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return productList;
    }
    
    //Them Mot San Pham Vao Bang San Pham
    public void addProduct(ProductDTO product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO AllProduct (id, ten, xuatxu, gia, soLuongConLai, tongSanPham, status) VALUES (?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
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
    //Them Mot San Pham Vao Tung Loai Bang San Pham
    public void addAssemblyToy(DoChoiLapGhep product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO Product4 (id, ten, xuatxu, gia, soLuongConLai, tongSanPham, soManhGhep, status) VALUES (?, ?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setString(3, product.getXuatxu());
            ps.setDouble(4, product.getGia());
            ps.setInt(5, product.getSoLuongConLai());
            ps.setInt(6, product.getTongSanPham());
            ps.setInt(7, product.getSoManhGhep());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
    public void addVehicleToy(DoChoiPhuongTien product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO sanpham (id, ten, xuatxu, gia, soLuongConLai, tongSanPham, loaiPhuongTien, status) VALUES (?, ?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setString(3, product.getXuatxu());
            ps.setDouble(4, product.getGia());
            ps.setInt(5, product.getSoLuongConLai());
            ps.setInt(6, product.getTongSanPham());
            ps.setString(7, product.getLoaiPhuongTien());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
            
    public void addMovieToy(DoChoiTheoPhim product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO sanpham (id, ten, xuatxu, gia, soLuongSanPham, tongSanPham, tenPhim, status) VALUES (?, ?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setString(3, product.getXuatxu());
            ps.setDouble(4, product.getGia());
            ps.setInt(5, product.getSoLuongConLai());
            ps.setInt(6, product.getTongSanPham());
            ps.setString(7, product.getTenPhim());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addFashionToy(DoChoiThoiTrang product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO sanpham (id, ten, xuatxu, gia, soLuongSanPham, tongSanPham, xuHuong, status) VALUES (?, ?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setString(3, product.getXuatxu());
            ps.setDouble(4, product.getGia());
            ps.setInt(5, product.getSoLuongConLai());
            ps.setInt(6, product.getTongSanPham());
            ps.setString(7, product.getXuHuong());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addRoBotToy(RoBot product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO sanpham (id, ten, xuatxu, gia, soLuongConLai, tongSanPham, loaiRoBot, status) VALUES (?, ?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setString(3, product.getXuatxu());
            ps.setDouble(4, product.getGia());
            ps.setInt(5, product.getSoLuongConLai());
            ps.setInt(6, product.getTongSanPham());
            ps.setString(7, product.getLoaiRoBot());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Xoa Mot San Pham
    public void removeProduct(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE AllProduct SET status = 0 WHERE id = ?");
            ps.setString(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Xoa Mot San Pham Cua Tung Loai
    public void removeVehicleToy(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE Product1 SET status = 0 WHERE id = ?");
            ps.setString(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeMovieToy(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE Product2 SET status = 0 WHERE id = ?");
            ps.setString(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeFashionToy(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE Product3 SET status = 0 WHERE id = ?");
            ps.setString(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeAssemblyToy(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE Product4 SET status = -4 WHERE id = ?");
            ps.setString(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeRoBotToy(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE Product5 SET status = -5 WHERE id = ?");
            ps.setString(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Cap Nhat Thong Tin San Pham Theo id San Pham
    public void updateProduct(ProductDTO product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "UPDATE AllProduct SET ten = ?, xuatxu = ?, gia = ?, soLuongSanPham = ?, tongSanPham = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
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
    //Cap Nhat Thong Tin Tung Loai San Pham Theo Id
    public void updateVehicleToy(DoChoiPhuongTien product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "UPDATE Product1 SET ten = ?, xuatxu = ?, gia = ?, soLuongSanPham = ?, tongSanPham = ?, loaiPhuongTien = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setString(2, product.getXuatxu());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuongConLai());
            ps.setInt(5, product.getTongSanPham());
            ps.setString(6, product.getLoaiPhuongTien());
            ps.setString(7, product.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateMovieToy(DoChoiTheoPhim product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "UPDATE Product2 SET ten = ?, xuatxu = ?, gia = ?, soLuongSanPham = ?, tongSanPham = ?, tenPhim = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setString(2, product.getXuatxu());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuongConLai());
            ps.setInt(5, product.getTongSanPham());
            ps.setString(6, product.getTenPhim());
            ps.setString(7, product.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateFashionToy(DoChoiThoiTrang product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "UPDATE Product3 SET ten = ?, xuatxu = ?, gia = ?, soLuongSanPham = ?, tongSanPham = ?, xuHuong = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setString(2, product.getXuatxu());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuongConLai());
            ps.setInt(5, product.getTongSanPham());
            ps.setString(6, product.getXuHuong());
            ps.setString(7, product.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateAssemblyToy(DoChoiLapGhep product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "UPDATE Product4 SET ten = ?, xuatxu = ?, gia = ?, soLuongSanPham = ?, tongSanPham = ?, soManhGhep = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setString(2, product.getXuatxu());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuongConLai());
            ps.setInt(5, product.getTongSanPham());
            ps.setInt(6, product.getSoManhGhep());
            ps.setString(7, product.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
 
    public void updateRoBotToy(RoBot product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "UPDATE Product5 SET ten = ?, xuatxu = ?, gia = ?, soLuongSanPham = ?, tongSanPham = ?, loaiRoBot = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setString(2, product.getXuatxu());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuongConLai());
            ps.setInt(5, product.getTongSanPham());
            ps.setString(6, product.getLoaiRoBot());
            ps.setString(7, product.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
