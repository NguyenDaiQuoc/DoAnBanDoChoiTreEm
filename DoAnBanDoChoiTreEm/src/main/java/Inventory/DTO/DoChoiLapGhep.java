/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn;

/**
 *
 * @author ADMIN
 */
public class DoChoiLapGhep extends ProductDTO {
    private int soManhGhep;

    public DoChoiLapGhep() {
    }

    public DoChoiLapGhep(int soManhGhep, String id, String ten, String xuatxu, double gia, int soLuongConLai, int tongSanPham) {
        super(id, ten, xuatxu, gia, soLuongConLai, tongSanPham);
        this.soManhGhep = soManhGhep;
    }

    public int getSoManhGhep() {
        return soManhGhep;
    }

    public void setSoManhGhep(int soManhGhep) {
        this.soManhGhep = soManhGhep;
    }
    
    
}
