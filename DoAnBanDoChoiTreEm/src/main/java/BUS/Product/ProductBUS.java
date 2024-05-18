/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus;

import java.util.ArrayList;
import Inventory.DAO.ProductDAO;
import Inventory.DTO.ProductDTO;
import Inventory.DTO.DoChoiLapGhep;
import Inventory.DTO.DoChoiPhuongTien;
import Inventory.DTO.DoChoiTheoPhim;
import Inventory.DTO.DoChoiThoiTrang;
import Inventory.DTO.RoBot;

/**
 *
 * @author Admin
 */
public class ProductBUS {

    private ProductDAO productDAO;

    public ProductBUS() {
        productDAO = new ProductDAO();
    }

    //Lay THong Tin Chung cua Tat San Pham
    public ArrayList<ProductDTO> getAllProducts() {
        return productDAO.getAllProducts();
    }

    //Lay Thong Tin Tung Loai San Pham
    public ArrayList<DoChoiPhuongTien> getAllVehicleToys() {
        return productDAO.getAllVehicleToys();
    }

    public ArrayList<DoChoiTheoPhim> getAllMovieToys() {
        return productDAO.getAllMovieToys();
    }

    public ArrayList<DoChoiThoiTrang> getAllFashionToys() {
        return productDAO.getAllFashionToys();
    }

    public ArrayList<DoChoiLapGhep> getAllAssemblyToys() {
        return productDAO.getAllAssemblyToys();
    }

    public ArrayList<RoBot> getAllRoBotToys() {
        return productDAO.getAllRoBotToys();
    }

    //Tim Kiem San Pham Theo id
    public ArrayList<ProductDTO> searchProductById(String id) {
        return productDAO.searchProductById(id);
    }

    // tim kiem san pham theo ten
    public ArrayList<ProductDTO> searchProductByName(String name) {
        return productDAO.searchProductByName(name);
    }

    //Tim Kiem Tung Loai San Pham Theo id
    public ArrayList<DoChoiPhuongTien> searchVehicleToysById(String id) {
        return productDAO.searchVehicleToysById(id);
    }

    public ArrayList<DoChoiTheoPhim> searchMovieToysById(String id) {
        return productDAO.searchMovieToysById(id);
    }

    public ArrayList<DoChoiThoiTrang> searchFashionToysById(String id) {
        return productDAO.searchFashionToysById(id);
    }

    public ArrayList<DoChoiLapGhep> searchAssemblyToysById(String id) {
        return productDAO.searchAssemblyToysById(id);
    }

    public ArrayList<RoBot> searchRoBotToysById(String id) {
        return productDAO.searchRoBotToysById(id);
    }

    //Them Mot San Pham Vao Bang San Pham
    public void addProduct(ProductDTO product) {
        productDAO.addProduct(product);
    }

    //Them Mot San Pham Vao Tung Loai Bang San Pham
    public void addAssemblyToy(DoChoiLapGhep product) {
        productDAO.addAssemblyToy(product);
    }

    public void addVehicleToy(DoChoiPhuongTien product) {
        productDAO.addVehicleToy(product);
    }

    public void addMovieToy(DoChoiTheoPhim product) {
        productDAO.addMovieToy(product);
    }

    public void addFashionToy(DoChoiThoiTrang product) {
        productDAO.addFashionToy(product);
    }

    public void addRoBotToy(RoBot product) {
        productDAO.addRoBotToy(product);
    }

    //Xoa Mot San Pham
    public void removeProduct(String id) {
        productDAO.removeProduct(id);
    }

    //Xoa Mot San Pham Cua Tung Loai
    public void removeVehicleToy(String id) {
        productDAO.removeVehicleToy(id);
    }

    public void removeMovieToy(String id) {
        productDAO.removeMovieToy(id);
    }

    public void removeFashionToy(String id) {
        productDAO.removeFashionToy(id);
    }

    public void removeAssemblyToy(String id) {
        productDAO.removeAssemblyToy(id);
    }

    public void removeRoBotToy(String id) {
        productDAO.removeRoBotToy(id);
    }

    //Cap Nhat Thong Tin San Pham Theo id San Pham
    public void updateProduct(ProductDTO product) {
        productDAO.updateProduct(product);
    }

    //Cap Nhat Thong Tin Tung Loai San Pham Theo Id
    public void updateVehicleToy(DoChoiPhuongTien product) {
        productDAO.updateVehicleToy(product);
    }

    public void updateMovieToy(DoChoiTheoPhim product) {
        productDAO.updateMovieToy(product);
    }

    public void updateFashionToy(DoChoiThoiTrang product) {
        productDAO.updateFashionToy(product);
    }

    public void updateAssemblyToy(DoChoiLapGhep product) {
        productDAO.updateAssemblyToy(product);
    }

    public void updateRoBotToy(RoBot product) {
        productDAO.updateRoBotToy(product);
    }
    
    public int[] getInfoProd(){
       return productDAO.getInfoProd();
    }
}
