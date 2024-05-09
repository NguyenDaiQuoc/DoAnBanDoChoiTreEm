/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.DTO;

/**
 *
 * @author ADMIN
 */
public class RoBot extends ProductDTO {
    private String loaiRoBot;

    public RoBot() {
    }

    public RoBot(String id, String ten, String xuatxu, double gia, int soLuong, String loaiRoBot) {
        super(id, ten, xuatxu, gia, soLuong);
        this.loaiRoBot = loaiRoBot;
    }

    public String getLoaiRoBot() {
        return loaiRoBot;
    }

    public void setLoaiRoBot(String loaiRoBot) {
        this.loaiRoBot = loaiRoBot;
    }
    
    
}
