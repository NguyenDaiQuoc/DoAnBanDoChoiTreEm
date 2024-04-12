package Inventory.DTO;

import java.util.Random;

public abstract class CustomerDTO {
    private String custName, custPhone, custAddress, custEmail;
    private int custID;

    public CustomerDTO(String cusName, String cusPhone, String cusAddress, String cusEmail, int cusID) {
        this.custName = cusName;
        this.custPhone = cusPhone;
        this.custAddress = cusAddress;
        this.custEmail = cusEmail;
        this.custID = cusID;
    }
    
        public CustomerDTO(){}

    public String getCusName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCusEmail() {
        return custEmail;
    }

    public void setCusEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public int getCustID() {
        return custID;
    }

    public void setCusID(int custID) {
        this.custID = custID;
    }
    
    public String GenerateUID() {
        Random rd = new Random();
        //String UID = "";
        StringBuilder UID = new StringBuilder();
        String characters = "abcdefghijklmnoqprstuvwxyzABCDEFGHIJKLMNOPQRSTUVwXYZ0123456789!@#$%&";
        int i = 8; //UID chu 8 ky tu
        while (i-- > 0) {
            //UID = UID.concat(String.valueOf(characters.charAt(rd.nextInt(characters.length()))));
            UID.append(characters.charAt(rd.nextInt(characters.length())));
        }
        //return UID;
        return UID.toString();
    }
    
}
