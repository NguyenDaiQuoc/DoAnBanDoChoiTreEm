// CustomerBUS.java
package Bus;

import Inventory.DAO.CustomerDAO;
import Inventory.DTO.CustomerDTO;
import java.util.ArrayList;

public class CustomerBUS {
    private CustomerDAO dao = new CustomerDAO();

    public ArrayList<CustomerDTO> getAllCustomers() {
        return dao.getAllCustomers();
    }

    public ArrayList<CustomerDTO> getCustomersByKeyword(String keyword) {
        return dao.getCustomersByKeyword(keyword);
    }

    public void addCustomer(CustomerDTO customer) {
        dao.addCustomer(customer);
    }

    public void removeCustomer(int id) {
        dao.removeCustomer(id);
    }

    public void updateCustomer(CustomerDTO customer) {
        dao.updateCustomer(customer);
    }
}
