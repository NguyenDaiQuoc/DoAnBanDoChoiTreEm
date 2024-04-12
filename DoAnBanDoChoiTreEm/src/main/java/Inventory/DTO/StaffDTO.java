package Inventory.DTO;


public class StaffDTO extends CustomerDTO{
    private int staStatus;
    private String staRole;
    
    public StaffDTO(){}

    public StaffDTO(int staStatus, String staRole) {
        this.staStatus = staStatus;
        this.staRole = staRole;
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
