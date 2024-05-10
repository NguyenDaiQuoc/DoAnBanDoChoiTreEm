/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAn;

/**
 *
 * @author ADMIN
 */
public class RoBot extends ProductDTO {
    private String loaiRoBot;

    public RoBot() {
    }

    public RoBot(String id, String ten, double gia, String xuatxu, int soLuong, int soLuongConLai, String loaiRoBot) {
        super(id, ten, gia, xuatxu, soLuong, soLuongConLai);
        this.loaiRoBot = loaiRoBot;
    }

    public String getLoaiRoBot() {
        return loaiRoBot;
    }

    public void setLoaiRoBot(String loaiRoBot) {
        this.loaiRoBot = loaiRoBot;
    }
    
    
}
