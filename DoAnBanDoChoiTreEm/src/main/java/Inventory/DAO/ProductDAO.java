/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.DAO;

import java.util.ArrayList;
import Inventory.DTO.ProductDTO;
import Inventory.DTO.DoChoiLapGhep;
import Inventory.DTO.DoChoiPhuongTien;
import Inventory.DTO.DoChoiTheoPhim;
import Inventory.DTO.DoChoiThoiTrang;
import Inventory.DTO.RoBot;
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
            ResultSet rs = st.executeQuery("SELECT * FROM sanpham WHERE status = 1");
            while (rs.next()) {
                ProductDTO product = new ProductDTO();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuong(rs.getInt("soluong"));
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM dochoiphuongtien WHERE status = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiPhuongTien product = new DoChoiPhuongTien();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuong(rs.getInt("soluong"));
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM dochoitheophim WHERE status = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiTheoPhim product = new DoChoiTheoPhim();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuong(rs.getInt("soluong"));
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM dochoithoitrang WHERE status = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiThoiTrang product = new DoChoiThoiTrang();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuong(rs.getInt("soluong"));
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM dochoilapghep WHERE status = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiLapGhep product = new DoChoiLapGhep();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuong(rs.getInt("soluong"));
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
                product.setSoLuong(rs.getInt("soluong"));
                product.setLoaiRoBot(rs.getString("loaiRobot"));
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
            String sql = "SELECT * FROM sanpham WHERE status = 1 AND id LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProductDTO product = new ProductDTO();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuong(rs.getInt("soluong"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return productList;
    }
    //Tim kiem san pham theo ten
    public ArrayList<ProductDTO> searchProductByName(String name){
        ArrayList<ProductDTO> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "SELECT * FROM sanpham WHERE status = 1 AND ten LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProductDTO product = new ProductDTO();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuong(rs.getInt("soluong"));
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
            String sql = "SELECT * FORM dochoiphuongtien WHERE status = 1 AND id LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiPhuongTien product = new DoChoiPhuongTien();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setTen(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuong(rs.getInt("soluong"));
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
            String sql = "SELECT * FORM dochoitheophim WHERE status = 1 AND id LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiTheoPhim product = new DoChoiTheoPhim();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setTen(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuong(rs.getInt("soluong"));
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
            String sql = "SELECT * FORM  WHERE dochoithoitrang status = 1 AND id LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiThoiTrang product = new DoChoiThoiTrang();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setTen(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuong(rs.getInt("soluong"));
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
            String sql = "SELECT * FORM dochoilapghep WHERE status = 1 AND id LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiLapGhep product = new DoChoiLapGhep();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setTen(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuong(rs.getInt("soluong"));
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
            String sql = "SELECT * FORM Robot WHERE status = 1 AND id LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                RoBot product = new RoBot();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setTen(rs.getString("xuatxu"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuong(rs.getInt("soluong"));
                product.setLoaiRoBot(rs.getString("laiRobot"));
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
            String sql = "INSERT INTO sanpham (id, ten, xuatxu, gia, soluong, status) VALUES (?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setString(3, product.getXuatxu());
            ps.setDouble(4, product.getGia());
            ps.setInt(5, product.getSoLuong());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Them Mot San Pham Vao Tung Loai Bang San Pham
    public void addAssemblyToy(DoChoiLapGhep product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO dochoilapghep (id, ten, xuatxu, gia, soluong, soManhGhep, status) VALUES (?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setString(3, product.getXuatxu());
            ps.setDouble(4, product.getGia());
            ps.setInt(5, product.getSoLuong());
            ps.setInt(7, product.getSoManhGhep());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
    public void addVehicleToy(DoChoiPhuongTien product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO dochoiphuongtien (id, ten, xuatxu, gia, soluong, loaiPhuongTien, status) VALUES (?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setString(3, product.getXuatxu());
            ps.setDouble(4, product.getGia());
            ps.setInt(5, product.getSoLuong());
            ps.setString(7, product.getLoaiPhuongTien());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
            
    public void addMovieToy(DoChoiTheoPhim product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO dochoitheophim (id, ten, xuatxu, gia, soluong, tenPhim, status) VALUES (?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setString(3, product.getXuatxu());
            ps.setDouble(4, product.getGia());
            ps.setInt(5, product.getSoLuong());
            ps.setString(7, product.getTenPhim());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addFashionToy(DoChoiThoiTrang product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO dochoithoitrang (id, ten, xuatxu, gia, soluong, xuHuong, status) VALUES (?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setString(3, product.getXuatxu());
            ps.setDouble(4, product.getGia());
            ps.setInt(5, product.getSoLuong());
            ps.setString(7, product.getXuHuong());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addRoBotToy(RoBot product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO Robot (id, ten, xuatxu, gia, soluong, loaiRoBot, status) VALUES (?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setString(3, product.getXuatxu());
            ps.setDouble(4, product.getGia());
            ps.setInt(5, product.getSoLuong());
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
            PreparedStatement ps = con.prepareStatement("UPDATE sanpham SET status = 0 WHERE id = ?");
            ps.setString(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Xoa Mot San Pham Cua Tung Loai
    public void removeVehicleToy(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE dochoiphuongtien SET status = 0 WHERE id = ?");
            ps.setString(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeMovieToy(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE dochoitheophim SET status = 0 WHERE id = ?");
            ps.setString(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeFashionToy(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE dochoithoitrang SET status = 0 WHERE id = ?");
            ps.setString(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeAssemblyToy(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE dochoilapghep SET status = 0 WHERE id = ?");
            ps.setString(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeRoBotToy(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE Robot SET status = 0 WHERE id = ?");
            ps.setString(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Cap Nhat Thong Tin San Pham Theo id San Pham
    public void updateProduct(ProductDTO product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "UPDATE sanpham SET ten = ?, xuatxu = ?, gia = ?, soluong = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setString(2, product.getXuatxu());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuong());
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
            String sql = "UPDATE dochoiphuongtien SET ten = ?, xuatxu = ?, gia = ?, soluong = ?, loaiPhuongTien = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setString(2, product.getXuatxu());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuong());
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
            String sql = "UPDATE docboitheophim SET ten = ?, xuatxu = ?, gia = ?, soluong = ?, tenPhim = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setString(2, product.getXuatxu());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuong());
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
            String sql = "UPDATE dochoithoitrang SET ten = ?, xuatxu = ?, gia = ?, soluong = ?, xuHuong = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setString(2, product.getXuatxu());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuong());
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
            String sql = "UPDATE dochoilapghep SET ten = ?, xuatxu = ?, gia = ?, soluong = ?, soManhGhep = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setString(2, product.getXuatxu());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuong());
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
            String sql = "UPDATE Robot SET ten = ?, xuatxu = ?, gia = ?, soluong = ?, loaiRoBot = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setString(2, product.getXuatxu());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuong());
            ps.setString(6, product.getLoaiRoBot());
            ps.setString(7, product.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
