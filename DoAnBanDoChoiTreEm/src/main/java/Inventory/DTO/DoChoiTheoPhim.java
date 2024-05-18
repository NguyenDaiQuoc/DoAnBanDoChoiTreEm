/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.DTO;

/**
 *
 * @author ADMIN
 */
public class DoChoiTheoPhim extends ProductDTO {
    private String tenPhim;

    public DoChoiTheoPhim() {
    }

    public DoChoiTheoPhim(String id, String ten, double gia, String xuatxu, int soLuong, int soLuongConLai, String tenPhim) {
        super(id, ten, gia, xuatxu, soLuong, soLuongConLai);
        this.tenPhim = tenPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }
    
    
}
