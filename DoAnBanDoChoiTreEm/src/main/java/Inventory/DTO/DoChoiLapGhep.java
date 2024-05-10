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

    public DoChoiLapGhep(String id, String ten, double gia, String xuatxu, int soLuong, int soLuongConLai, int soManhGhep) {
        super(id, ten, gia, xuatxu, soLuong, soLuongConLai);
        this.soManhGhep = soManhGhep;
    }

    public int getSoManhGhep() {
        return soManhGhep;
    }

    public void setSoManhGhep(int soManhGhep) {
        this.soManhGhep = soManhGhep;
    }
    
    
}
