/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn;

/**
 *
 * @author ADMIN
 */
public class ProductDTO {
    private String id;
    private String ten;
    private String xuatxu;
    private double gia;
    private int soLuong;

    public ProductDTO() {
    }

    public ProductDTO(String id, String ten, String xuatxu, double gia, int soLuong) {
        this.id = id;
        this.ten = ten;
        this.xuatxu = xuatxu;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public String getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public String getXuatxu() {
        return xuatxu;
    }

    public double getGia() {
        return gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setXuatxu(String xuatxu) {
        this.xuatxu = xuatxu;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    

    

    
    
    
}
