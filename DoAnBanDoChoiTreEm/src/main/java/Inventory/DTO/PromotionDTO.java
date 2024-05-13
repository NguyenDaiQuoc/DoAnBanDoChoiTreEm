// PromotionDTO.java
package Inventory.DTO;

public class PromotionDTO {
    private String id; // Change this from int to String
    private String noiDung;
    private double phanTramGiamGia;

    public PromotionDTO(String id, String noiDung, double phanTramGiamGia) { // Change this from int to String
        this.id = id;
        this.noiDung = noiDung;
        this.phanTramGiamGia = phanTramGiamGia;
    }

    // Getter and setter for id
    public String getId() { // Change this from int to String
        return id;
    }

    public void setId(String id) { // Change this from int to String
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
