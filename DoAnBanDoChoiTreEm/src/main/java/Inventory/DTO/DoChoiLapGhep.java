/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.DTO;

/**
 *
 * @author ADMIN
 */
public class DoChoiLapGhep extends ProductDTO {
    private int soManhGhep;

    public DoChoiLapGhep() {
    }

    public DoChoiLapGhep(String id, String ten, String xuatxu, double gia, int soLuong, int soManhGhep) {
        super(id, ten, xuatxu, gia, soLuong);
        this.soManhGhep = soManhGhep;
    }

    public int getSoManhGhep() {
        return soManhGhep;
    }

    public void setSoManhGhep(int soManhGhep) {
        this.soManhGhep = soManhGhep;
    }
    
    
}
