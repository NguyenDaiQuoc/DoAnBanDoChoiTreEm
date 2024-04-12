package Inventory.DTO;

public class ProductDTO{
    private String proID, proName, proOrigin;
    private float proPrice;
    private int proRemain, proQuantity;
    
    public ProductDTO(String proID, String proName, float proPrice, String proOrigin, int proRemain, int proQuantity) {
        this.proID = proID;
        this.proName = proName;
        this.proPrice = proPrice;
        this.proOrigin = proOrigin;
        this.proRemain = proRemain;
        this.proQuantity = proQuantity;
    }
    
    public ProductDTO(){}
    

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public float getProPrice() {
        return proPrice;
    }

    public void setProPrice(float proPrice) {
        this.proPrice = proPrice;
    }

    public String getProOrigin() {
        return proOrigin;
    }

    public void setProOrigin(String proOrigin) {
        this.proOrigin = proOrigin;
    }

    public int getProRemain() {
        return proRemain;
    }

    public void setProRemain(int proRemain) {
        this.proRemain = proRemain;
    }

    public int getProQuantity() {
        return proQuantity;
    }

    public void setProQuantity(int proQuantity) {
        this.proQuantity = proQuantity;
    }
    
    
}