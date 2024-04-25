package Inventory.DTO;

public class StaffDTO {
    private int staID, staAge;
    private String staRole, staName, staEmail, staPhone, staAddress;
    
    public StaffDTO(){}

    public StaffDTO(int staID, String staName,int staAge, String staEmail, String staAddress, String staPhone, String staRole) {
        this.staID = staID;
        this.staName = staName;
        this.staAge = staAge;
        this.staEmail = staEmail;
        this.staAddress = staAddress;
        this.staPhone = staPhone;
        this.staRole = staRole;
    }

    
    
    public int getStaAge() {
        return staAge;
    }

    public void setStaAge(int staAge) {
        this.staAge = staAge;
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

    public String getStaRole() {
        return staRole;
    }

    public void setStaRole(String staRole) {
        this.staRole = staRole;
    }
    
    
}
