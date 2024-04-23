/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn;

/**
 *
 * @author ADMIN
 */
public class DoChoiPhuongTien extends ProductDTO {
    private String loaiPhuongTien;

    public DoChoiPhuongTien() {
    }
    
    public DoChoiPhuongTien(String id, String ten, String xuatxu, double gia, int soLuongConLai, int tongSanPham, String loaiPhuongTien) {
        super(id, ten, xuatxu, gia, soLuongConLai, tongSanPham);
        this.loaiPhuongTien = loaiPhuongTien;
    }

    public String getLoaiPhuongTien() {
        return loaiPhuongTien;
    }

    public void setLoaiPhuongTien(String loaiPhuongTien) {
        this.loaiPhuongTien = loaiPhuongTien;
    }

    
    
    
}
