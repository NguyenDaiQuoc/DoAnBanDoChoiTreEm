/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.DAO;

import java.util.ArrayList;
import Inventory.DTO.ProductDTO;
import Inventory.DTO.ProductDTO;
import Inventory.DTO.DoChoiLapGhep;
import Inventory.DTO.DoChoiPhuongTien;
import Inventory.DTO.DoChoiTheoPhim;
import Inventory.DTO.RoBot;
import Database.ConnectionProvider;
import Inventory.DTO.DoChoiThoiTrang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class ProductDAO extends ProductDTO {
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
                product.setGia(rs.getDouble("gia"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setSoLuong(rs.getInt("soLuong"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
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
                product.setGia(rs.getDouble("gia"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setSoLuong(rs.getInt("soLuong"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
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
                product.setGia(rs.getDouble("gia"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setSoLuong(rs.getInt("soLuong"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
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
                product.setGia(rs.getDouble("gia"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setSoLuong(rs.getInt("soLuong"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
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
                product.setGia(rs.getDouble("gia"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setSoLuong(rs.getInt("soluong"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM robot WHERE status = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                RoBot product = new RoBot();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setGia(rs.getDouble("gia"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setSoLuong(rs.getInt("soluong"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
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
            String sql = "SELECT * FROM sanpham WHERE status = 1 AND ( id LIKE ? OR ten LIKE ? OR gia LIKE ? OR xuatxu LIKE ? OR soLuong LIKE ? OR soLuongConLai LIKE ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ps.setString(2, "%" + id + "%");
            ps.setString(3, "%" + id + "%");
            ps.setString(4, "%" + id + "%");
            ps.setString(5, "%" + id + "%");
            ps.setString(6, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProductDTO product = new ProductDTO();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setGia(rs.getDouble("gia"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setSoLuong(rs.getInt("soLuong"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
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
            String sql = "SELECT * FROM dochoiphuongtien WHERE ( id LIKE ? OR ten LIKE ? OR gia LIKE ? OR xuatxu LIKE ? OR soLuong LIKE ? OR soLuongConLai LIKE ? OR loaiPhuongTien LIKE ? ) AND status = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ps.setString(2, "%" + id + "%");
            ps.setString(3, "%" + id + "%");
            ps.setString(4, "%" + id + "%");
            ps.setString(5, "%" + id + "%");
            ps.setString(6, "%" + id + "%");
            ps.setString(7, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiPhuongTien product = new DoChoiPhuongTien();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setGia(rs.getDouble("gia"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setSoLuong(rs.getInt("soLuong"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
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
            String sql = "SELECT * FROM dochoitheophim WHERE status = 1 AND ( id LIKE ? OR ten LIKE ? OR gia LIKE ? OR xuatxu LIKE ? OR soLuong LIKE ? OR soLuongConLai LIKE ? OR tenPhim LIKE ? )";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ps.setString(2, "%" + id + "%");
            ps.setString(3, "%" + id + "%");
            ps.setString(4, "%" + id + "%");
            ps.setString(5, "%" + id + "%");
            ps.setString(6, "%" + id + "%");
            ps.setString(7, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiTheoPhim product = new DoChoiTheoPhim();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setGia(rs.getDouble("gia"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setSoLuong(rs.getInt("soLuong"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
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
            String sql = "SELECT * FROM dochoithoitrang WHERE status = 1 AND ( id LIKE ? OR ten LIKE ? OR gia LIKE ? OR xuatxu LIKE ? OR soLuong LIKE ? OR soLuongConLai LIKE ? OR xuHuong LIKE ? )";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ps.setString(2, "%" + id + "%");
            ps.setString(3, "%" + id + "%");
            ps.setString(4, "%" + id + "%");
            ps.setString(5, "%" + id + "%");
            ps.setString(6, "%" + id + "%");
            ps.setString(7, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiThoiTrang product = new DoChoiThoiTrang();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setGia(rs.getDouble("gia"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setSoLuong(rs.getInt("soLuong"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
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
            String sql = "SELECT * FROM dochoilapghep WHERE status = 1 AND ( id LIKE ? OR ten LIKE ? OR gia LIKE ? OR xuatxu LIKE ? OR soLuong LIKE ? OR soLuongConLai LIKE ? OR soManhGhep LIKE ? )";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ps.setString(2, "%" + id + "%");
            ps.setString(3, "%" + id + "%");
            ps.setString(4, "%" + id + "%");
            ps.setString(5, "%" + id + "%");
            ps.setString(6, "%" + id + "%");
            ps.setString(7, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DoChoiLapGhep product = new DoChoiLapGhep();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setGia(rs.getDouble("gia"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setSoLuong(rs.getInt("soLuong"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
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
            String sql = "SELECT * FROM robot WHERE status = 1 AND ( id LIKE ? OR ten LIKE ? OR gia LIKE ? OR xuatxu LIKE ? OR soLuong LIKE ? OR soLuongConLai LIKE ? OR loaiRobot LIKE ? )";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ps.setString(2, "%" + id + "%");
            ps.setString(3, "%" + id + "%");
            ps.setString(4, "%" + id + "%");
            ps.setString(5, "%" + id + "%");
            ps.setString(6, "%" + id + "%");
            ps.setString(7, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                RoBot product = new RoBot();
                product.setId(rs.getString("id"));
                product.setTen(rs.getString("ten"));
                product.setGia(rs.getDouble("gia"));
                product.setXuatxu(rs.getString("xuatxu"));
                product.setSoLuong(rs.getInt("soLuong"));
                product.setSoLuongConLai(rs.getInt("soLuongConLai"));
                product.setLoaiRoBot(rs.getString("loaiRobot"));
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
            String sql = "INSERT INTO sanpham (id, ten, gia, xuatxu, soLuong, soLuongConLai, status) VALUES (?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setDouble(3, product.getGia());
            ps.setString(4, product.getXuatxu());
            ps.setInt(5, product.getSoLuong());
            ps.setInt(6, product.getSoLuongConLai());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Them Mot San Pham Vao Tung Loai Bang San Pham
    public void addAssemblyToy(DoChoiLapGhep product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO dochoilapghep (id, ten, gia, xuatxu, soLuong, soLuongConLai, soManhGhep, status) VALUES (?, ?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setDouble(3, product.getGia());
            ps.setString(4, product.getXuatxu());
            ps.setInt(5, product.getSoLuong());
            ps.setInt(6, product.getSoLuongConLai());
            ps.setInt(7, product.getSoManhGhep());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ProductDTO tmp = new ProductDTO();
        tmp.setId(product.getId());
        tmp.setTen(product.getTen());
        tmp.setGia(product.getGia());
        tmp.setXuatxu(product.getXuatxu());
        tmp.setSoLuong(product.getSoLuong());
        tmp.setSoLuongConLai(product.getSoLuongConLai());
        addProduct(tmp);
    }
        
    public void addVehicleToy(DoChoiPhuongTien product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO dochoiphuongtien (id, ten, gia, xuatxu, soLuong, soLuongConLai, loaiPhuongTien, status) VALUES (?, ?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setDouble(3, product.getGia());
            ps.setString(4, product.getXuatxu());
            ps.setInt(5, product.getSoLuong());
            ps.setInt(6, product.getSoLuongConLai());
            ps.setString(7, product.getLoaiPhuongTien());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ProductDTO tmp = new ProductDTO();
        tmp.setId(product.getId());
        tmp.setTen(product.getTen());
        tmp.setGia(product.getGia());
        tmp.setXuatxu(product.getXuatxu());
        tmp.setSoLuong(product.getSoLuong());
        tmp.setSoLuongConLai(product.getSoLuongConLai());
        addProduct(tmp);
    }
            
    public void addMovieToy(DoChoiTheoPhim product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO dochoitheophim (id, ten, gia, xuatxu, soLuong, soLuongConLai, tenPhim, status) VALUES (?, ?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setDouble(3, product.getGia());
            ps.setString(4, product.getXuatxu());
            ps.setInt(5, product.getSoLuong());
            ps.setInt(6, product.getSoLuongConLai());
            ps.setString(7, product.getTenPhim());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ProductDTO tmp = new ProductDTO();
            tmp.setId(product.getId());
            tmp.setTen(product.getTen());
            tmp.setGia(product.getGia());
            tmp.setXuatxu(product.getXuatxu());
            tmp.setSoLuong(product.getSoLuong());
            tmp.setSoLuongConLai(product.getSoLuongConLai());
            addProduct(tmp);
    }
    
    public void addFashionToy(DoChoiThoiTrang product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO dochoithoitrang (id, ten, gia, xuatxu, soLuong, soLuongConLai, xuHuong, status) VALUES (?, ?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setDouble(3, product.getGia());
            ps.setString(4, product.getXuatxu());
            ps.setInt(5, product.getSoLuong());
            ps.setInt(6, product.getSoLuongConLai());
            ps.setString(7, product.getXuHuong());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ProductDTO tmp = new ProductDTO();
            tmp.setId(product.getId());
            tmp.setTen(product.getTen());
            tmp.setGia(product.getGia());
            tmp.setXuatxu(product.getXuatxu());
            tmp.setSoLuong(product.getSoLuong());
            tmp.setSoLuongConLai(product.getSoLuongConLai());
            addProduct(tmp);
    }
    
    public void addRoBotToy(RoBot product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "INSERT INTO robot (id, ten, gia, xuatxu, soluong, soLuongConLai, loaiRoBot, status) VALUES (?, ?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getTen());
            ps.setDouble(3, product.getGia());
            ps.setString(4, product.getXuatxu());
            ps.setInt(5, product.getSoLuong());
            ps.setInt(6, product.getSoLuongConLai());
            ps.setString(7, product.getLoaiRoBot());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ProductDTO tmp = new ProductDTO();
            tmp.setId(product.getId());
            tmp.setTen(product.getTen());
            tmp.setGia(product.getGia());
            tmp.setXuatxu(product.getXuatxu());
            tmp.setSoLuong(product.getSoLuong());
            tmp.setSoLuongConLai(product.getSoLuongConLai());
            addProduct(tmp);
    }
    //Xoa Mot San Pham
    public void removeProduct(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE sanpham SET status = 0 WHERE id = ?");
            ps.setString(1, id);
            ps.executeUpdate();
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
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        removeProduct(id);
    }
    
    public void removeMovieToy(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE dochoitheophim SET status = 0 WHERE id = ?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        removeProduct(id);
    }
    
    public void removeFashionToy(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE dochoithoitrang SET status = 0 WHERE id = ?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        removeProduct(id);
    }
    
    public void removeAssemblyToy(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE dochoilapghep SET status = 0 WHERE id = ?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        removeProduct(id);
    }
    
    public void removeRoBotToy(String id){
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE robot SET status = 0 WHERE id = ?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        removeProduct(id);
    }
    //Cap Nhat Thong Tin San Pham Theo id San Pham
    public void updateProduct(ProductDTO product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "UPDATE sanpham SET ten = ?, gia = ?, xuatxu = ?, soLuong = ?, soLuongConLai = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setDouble(2, product.getGia());
            ps.setString(3, product.getXuatxu());
            ps.setInt(4, product.getSoLuong());
            ps.setInt(5, product.getSoLuongConLai());
            ps.setString(6, product.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Cap Nhat Thong Tin Tung Loai San Pham Theo Id
    public void updateVehicleToy(DoChoiPhuongTien product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "UPDATE dochoiphuongtien SET ten = ?, gia = ?, xuatxu = ?, soLuong = ?, soLuongConLai = ?, loaiPhuongTien = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setDouble(2, product.getGia());
            ps.setString(3, product.getXuatxu());
            ps.setInt(4, product.getSoLuong());
            ps.setInt(5, product.getSoLuongConLai());
            ps.setString(6, product.getLoaiPhuongTien());
            ps.setString(7, product.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ProductDTO tmp = new ProductDTO();
        tmp.setId(product.getId());
        tmp.setTen(product.getTen());
        tmp.setGia(product.getGia());
        tmp.setXuatxu(product.getXuatxu());
        tmp.setSoLuong(product.getSoLuong());
        tmp.setSoLuongConLai(product.getSoLuongConLai());
        updateProduct(tmp);
    }
    
    public void updateMovieToy(DoChoiTheoPhim product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "UPDATE dochoitheophim SET ten = ?, gia = ?, xuatxu = ?, soLuong = ?, soLuongConLai = ?, tenPhim = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setDouble(2, product.getGia()); 
            ps.setString(3, product.getXuatxu());
            ps.setInt(4, product.getSoLuong());
            ps.setInt(5, product.getSoLuongConLai());
            ps.setString(6, product.getTenPhim());
            ps.setString(7, product.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ProductDTO tmp = new ProductDTO();
        tmp.setId(product.getId());
        tmp.setTen(product.getTen());
        tmp.setGia(product.getGia());
        tmp.setXuatxu(product.getXuatxu());
        tmp.setSoLuong(product.getSoLuong());
        tmp.setSoLuongConLai(product.getSoLuongConLai());
        updateProduct(tmp);
        
    }
    
    public void updateFashionToy(DoChoiThoiTrang product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "UPDATE dochoithoitrang SET ten = ?, gia = ?, xuatxu = ?, soLuong = ?, soLuongConLai = ?, xuHuong = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setDouble(2, product.getGia());
            ps.setString(3, product.getXuatxu());
            ps.setInt(4, product.getSoLuong());
            ps.setInt(5, product.getSoLuongConLai());
            ps.setString(6, product.getXuHuong());
            ps.setString(7, product.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ProductDTO tmp = new ProductDTO();
        tmp.setId(product.getId());
        tmp.setTen(product.getTen());
        tmp.setGia(product.getGia());
        tmp.setXuatxu(product.getXuatxu());
        tmp.setSoLuong(product.getSoLuong());
        tmp.setSoLuongConLai(product.getSoLuongConLai());
        updateProduct(tmp);
    }
    
    public void updateAssemblyToy(DoChoiLapGhep product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "UPDATE dochoilapghep SET ten = ?, gia = ?, xuatxu = ?, soLuong = ?, soLuongConLai = ?, soManhGhep = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setDouble(2, product.getGia());
            ps.setString(3, product.getXuatxu());
            ps.setInt(4, product.getSoLuong());
            ps.setInt(5, product.getSoLuongConLai());
            ps.setInt(6, product.getSoManhGhep());
            ps.setString(7, product.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ProductDTO tmp = new ProductDTO();
        tmp.setId(product.getId());
        tmp.setTen(product.getTen());
        tmp.setGia(product.getGia());
        tmp.setXuatxu(product.getXuatxu());
        tmp.setSoLuong(product.getSoLuong());
        tmp.setSoLuongConLai(product.getSoLuongConLai());
        updateProduct(tmp);
    }
 
    public void updateRoBotToy(RoBot product){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "UPDATE robot SET ten = ?, gia = ?, xuatxu = ?, soLuong = ?, soLuongConLai = ?, loaiRoBot = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getTen());
            ps.setDouble(2, product.getGia());
            ps.setString(3, product.getXuatxu());
            ps.setInt(4, product.getSoLuong());
            ps.setInt(5, product.getSoLuongConLai());
            ps.setString(6, product.getLoaiRoBot());
            ps.setString(7, product.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ProductDTO tmp = new ProductDTO();
        tmp.setId(product.getId());
        tmp.setTen(product.getTen());
        tmp.setGia(product.getGia());
        tmp.setXuatxu(product.getXuatxu());
        tmp.setSoLuong(product.getSoLuong());
        tmp.setSoLuongConLai(product.getSoLuongConLai());
        updateProduct(tmp);
    }
    //KIểm tra xem sản phẩm có tồn tại ?
    public boolean checkProductExits(String nameProduct){
        boolean exits = false;
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "SELECT * FROM sanpham WHERE ten LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nameProduct);
            ResultSet rs = ps.executeQuery();
            exits = rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return exits;
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
    //KHi bán sản phẩm soLuongConLai giảm
    public void decreaseProductQuantity(String ten, int soLuongBan){
        try {
            Connection con = ConnectionProvider.getCon();
            String sql = "UPDATE sanpham SET soLuongConLai = soLuongConLai - ? WHERE ten LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, soLuongBan);
            ps.setString(2, ten);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public int[] getInfoProd() {
    int[] prodInfo = new int[2];
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    try {
        con = ConnectionProvider.getCon();
        String query = "SELECT SUM(soluong) AS total, SUM(soLuongConLai) AS remain FROM sanpham";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        if (rs.next()) {
            prodInfo[0] = rs.getInt("total");
            prodInfo[1] = rs.getInt("remain");
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
    return prodInfo;
}
}
