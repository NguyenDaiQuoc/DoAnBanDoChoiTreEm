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
    private double gia;
    private String xuatxu;
    private int soLuong;
    private int soLuongConLai;

    public ProductDTO() {
    }

    public ProductDTO(String id, String ten, double gia, String xuatxu, int soLuong, int soLuongConLai) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.xuatxu = xuatxu;
        this.soLuong = soLuong;
        this.soLuongConLai = soLuongConLai;
    }

    public String getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public double getGia() {
        return gia;
    }

    public String getXuatxu() {
        return xuatxu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getSoLuongConLai() {
        return soLuongConLai;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setXuatxu(String xuatxu) {
        this.xuatxu = xuatxu;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setSoLuongConLai(int soLuongConLai) {
        this.soLuongConLai = soLuongConLai;
    }
    
    
    

    

    
    
    
}
