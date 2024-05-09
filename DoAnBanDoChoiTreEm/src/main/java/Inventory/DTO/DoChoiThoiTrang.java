/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.DTO;

/**
 *
 * @author ADMIN
 */
public class DoChoiThoiTrang extends ProductDTO {
    private String xuHuong;

    public DoChoiThoiTrang() {
    }

    public DoChoiThoiTrang(String id, String ten, String xuatxu, double gia, int soLuong, String xuHuong) {
        super(id, ten, xuatxu, gia, soLuong);
        this.xuHuong = xuHuong;
    }

    public String getXuHuong() {
        return xuHuong;
    }

    public void setXuHuong(String xuHuong) {
        this.xuHuong = xuHuong;
    }
    
    
    
    
}
