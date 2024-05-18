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

    public DoChoiThoiTrang(String id, String ten, double gia, String xuatxu, int soLuong, int soLuongConLai, String xuHuong) {
        super(id, ten, gia, xuatxu, soLuong, soLuongConLai);
        this.xuHuong = xuHuong;
    }

    public String getXuHuong() {
        return xuHuong;
    }

    public void setXuHuong(String xuHuong) {
        this.xuHuong = xuHuong;
    }
    
    
    
    
}
