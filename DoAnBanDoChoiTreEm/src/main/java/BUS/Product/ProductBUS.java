    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn;

import java.util.ArrayList;
import DoAn.ProductDAO;
import DoAn.ProductDTO;
import DoAn.DoChoiLapGhep;
import DoAn.DoChoiPhuongTien;
import DoAn.DoChoiTheoPhim;
import DoAn.RoBot;
/**
 *
 * @author ADMIN
 */
class ProductBUS {
    private ProductDAO productDAO = new ProductDAO();

    public ProductBUS() {
        
    }
    
    
    //Lay THong Tin Chung cua Tat San Pham
    public ArrayList<ProductDTO> getAllProducts(){
        ArrayList<ProductDTO> products = productDAO.getAllProducts();
        return products;
    }
    //Lay Thong Tin Tung Loai San Pham
    public ArrayList<DoChoiPhuongTien> getAllVehicleToys(){
        ArrayList<DoChoiPhuongTien> products = productDAO.getAllVehicleToys();
        return products;
    }
    
    public ArrayList<DoChoiTheoPhim> getAllMovieToys(){
        ArrayList<DoChoiTheoPhim> products = productDAO.getAllMovieToys();
        return products;
    }
    
    public ArrayList<DoChoiThoiTrang> getAllFashionToys(){
        ArrayList<DoChoiThoiTrang> products = productDAO.getAllFashionToys();
        return products;
    }
    
    public ArrayList<DoChoiLapGhep> getAllAssemblyToys(){
        ArrayList<DoChoiLapGhep> products = productDAO.getAllAssemblyToys();
        return products;
    }
    
    public ArrayList<RoBot> getAllRoBotToys(){
        ArrayList<RoBot> products = productDAO.getAllRoBotToys();
        return products;
    }
    
    //Tim Kiem San Pham Theo id
    public ArrayList<ProductDTO> searchProductById(String id){
        ArrayList<ProductDTO> products = productDAO.searchProductById(id);
        return products;
    }
    //Tim Kiem Tung Loai San Pham Theo id
    public ArrayList<DoChoiPhuongTien> searchVehicleToysById(String id){
        ArrayList<DoChoiPhuongTien> products = productDAO.searchVehicleToysById(id);
        return products;
    }
    
    public ArrayList<DoChoiTheoPhim> searchMovieToysById(String id){
        ArrayList<DoChoiTheoPhim> products = productDAO.searchMovieToysById(id);
        return products;
    }
    
    public ArrayList<DoChoiThoiTrang> searchFashionToysById(String id){
        ArrayList<DoChoiThoiTrang> products = productDAO.searchFashionToysById(id);
        return products;
    }
    
    public ArrayList<DoChoiLapGhep> searchAssemblyToysById(String id){
        ArrayList<DoChoiLapGhep> products = productDAO.searchAssemblyToysById(id);
        return products;
    }
    
    public ArrayList<RoBot> searchRoBotToysById(String id){
        ArrayList<RoBot> products = productDAO.searchRoBotToysById(id);
        return products;
    }
    
    //Them Mot San Pham Vao Bang San Pham
    public void addProduct(ProductDTO product){
        productDAO.addProduct(product);
    }
    //Them Mot San Pham Vao Tung Loai Bang San Pham
    public void addAssemblyToy(DoChoiLapGhep product){
        productDAO.addAssemblyToy(product);
    }
    
    public void addVehicleToy(DoChoiPhuongTien product){
        productDAO.addVehicleToy(product);
    }
    
    public void addMovieToy(DoChoiTheoPhim product){
        productDAO.addMovieToy(product);
    }
    
    public void addFashionToy(DoChoiThoiTrang product){
        productDAO.addFashionToy(product);
    }
    
    public void addRoBotToy(RoBot product){
        productDAO.addRoBotToy(product);
    }
    
    //Xoa Mot San Pham
    public void removeProduct(String id){
        productDAO.removeProduct(id);
    }
    //Xoa Mot San Pham Cua Tung Loai
    public void removeVehicleToy(String id){
        productDAO.removeVehicleToy(id);
    }
    
    public void removeMovieToy(String id){
        productDAO.removeMovieToy(id);
    }
    
    public void removeFashionToy(String id){
        productDAO.removeFashionToy(id);
    }
    
    public void removeAssemblyToy(String id){
        productDAO.removeAssemblyToy(id);
    }
    
    public void removeRoBotToy(String id){
        productDAO.removeRoBotToy(id);
    }
    
    //Cap Nhat Thong Tin San Pham Theo id San Pham
    public void updateProduct(ProductDTO product){
        productDAO.updateProduct(product);
    }
    //Cap Nhat Thong Tin Tung Loai San Pham Theo Id
    public void updateVehicleToy(DoChoiPhuongTien product){
        productDAO.updateVehicleToy(product);
    }
    
    public void updateMovieToy(DoChoiTheoPhim product){
        productDAO.updateMovieToy(product);
    }
    
    public void updateFashionToy(DoChoiThoiTrang product){
        productDAO.updateFashionToy(product);
    }
    
    public void updateAssemblyToy(DoChoiLapGhep product){
        productDAO.updateAssemblyToy(product);
    }
    
    public void updateRoBotToy(RoBot product){
        productDAO.updateRoBotToy(product);
    }
    public ArrayList<ProductDTO> searchProductByName(String name) {
        return productDAO.searchProductByName(name);
    }
    public void decreaseProductQuantity(String ten, int soLuong) {
        productDAO.decreaseProductQuantity(ten, soLuong);
    }
}
