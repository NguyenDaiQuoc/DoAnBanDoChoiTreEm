// PromotionDTO.java
package Inventory.DTO;

public class PromotionDTO {
    private int id;
    private String noiDung;
    private double phanTramGiamGia;

    public PromotionDTO(int id, String noiDung, double phanTramGiamGia) {
        this.id = id;
        this.noiDung = noiDung;
        this.phanTramGiamGia = phanTramGiamGia;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public double getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(double phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }
}
