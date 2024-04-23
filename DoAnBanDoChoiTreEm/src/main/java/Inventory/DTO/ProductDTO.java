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
    private int soLuongConLai;
    private int tongSanPham;

    public ProductDTO() {
    }

    public ProductDTO(String id, String ten, String xuatxu, double gia, int soLuongConLai, int tongSanPham) {
        this.id = id;
        this.ten = ten;
        this.xuatxu = xuatxu;
        this.gia = gia;
        this.soLuongConLai = soLuongConLai;
        this.tongSanPham = tongSanPham;
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

    public int getSoLuongConLai() {
        return soLuongConLai;
    }

    public int getTongSanPham() {
        return tongSanPham;
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

    public void setSoLuongConLai(int soLuongConLai) {
        this.soLuongConLai = soLuongConLai;
    }

    public void setTongSanPham(int tongSanPham) {
        this.tongSanPham = tongSanPham;
    }

    

    
    
    
}
