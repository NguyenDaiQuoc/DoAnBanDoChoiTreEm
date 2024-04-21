package Inventory.DTO;

public class StaffDTO {
    private int staStatus, staID;
    private String staRole, staName, staEmail, staPhone, staAddress;
    
    public StaffDTO(){}

    public StaffDTO(int staID, String staName, String staEmail, String staPhone, String staAddress) {
        this.staID = staID;
        this.staName = staName;
        this.staEmail = staEmail;
        this.staPhone = staPhone;
        this.staAddress = staAddress;
    }



    public String getStaAddress() {
        return staAddress;
    }

    public void setStaAddress(String staAddress) {
        this.staAddress = staAddress;
    }

   

    public int getStaID() {
        return staID;
    }

    public void setStaID(int staID) {
        this.staID = staID;
    }

    public String getStaName() {
        return staName;
    }

    public void setStaName(String staName) {
        this.staName = staName;
    }

    public String getStaEmail() {
        return staEmail;
    }

    public void setStaEmail(String staEmail) {
        this.staEmail = staEmail;
    }

    public String getStaPhone() {
        return staPhone;
    }

    public void setStaPhone(String staPhone) {
        this.staPhone = staPhone;
    }

    
  
    public int getStaStatus() {
        return staStatus;
    }

    public void setStaStatus(int staStatus) {
        this.staStatus = staStatus;
    }

    public String getStaRole() {
        return staRole;
    }

    public void setStaRole(String staRole) {
        this.staRole = staRole;
    }
    
    
}
