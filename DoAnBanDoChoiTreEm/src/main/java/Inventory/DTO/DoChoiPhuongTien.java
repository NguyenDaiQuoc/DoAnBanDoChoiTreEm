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
    
    public DoChoiPhuongTien(String id, String ten, double gia, String xuatxu, int soLuong, int soLuongConLai, String loaiPhuongTien) {
        super(id, ten, gia, xuatxu, soLuong, soLuongConLai);
        this.loaiPhuongTien = loaiPhuongTien;
    }

    public String getLoaiPhuongTien() {
        return loaiPhuongTien;
    }

    public void setLoaiPhuongTien(String loaiPhuongTien) {
        this.loaiPhuongTien = loaiPhuongTien;
    }

    
    
    
}
