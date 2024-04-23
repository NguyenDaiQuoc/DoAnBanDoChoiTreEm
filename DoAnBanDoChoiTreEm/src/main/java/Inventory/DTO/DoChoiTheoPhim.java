/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn;

/**
 *
 * @author ADMIN
 */
public class DoChoiTheoPhim extends ProductDTO {
    private String tenPhim;

    public DoChoiTheoPhim() {
    }

    public DoChoiTheoPhim(String id, String ten, String xuatxu, double gia, int soLuongConLai, int tongSanPham, String tenPhim) {
        super(id, ten, xuatxu, gia, soLuongConLai, tongSanPham);
        this.tenPhim = tenPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }
    
    
}
