// Customer.java
package Inventory.DTO;

public class CustomerDTO {

    private String id; // Change this from int to String
    private String name;
    private String email;
    private String address;
    private String sdt;

    public CustomerDTO(String id, String name, String email, String address, String sdt) { // Change this from int to String
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.sdt = sdt;
    }

    // getters and setters
    public String getId() { // Change this from int to String
        return id;
    }

    public void setId(String id) { // Change this from int to String
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
