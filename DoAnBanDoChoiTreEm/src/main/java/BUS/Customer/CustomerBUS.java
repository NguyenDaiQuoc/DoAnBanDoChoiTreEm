// CustomerBUS.java
package Bus;

import Inventory.DAO.CustomerDAO;
import Inventory.Entity.Customer;
import java.util.ArrayList;

public class CustomerBUS {
    private CustomerDAO dao = new CustomerDAO();

    public ArrayList<Customer> getAllCustomers() {
        return dao.getAllCustomers();
    }

    public ArrayList<Customer> getCustomersByKeyword(String keyword) {
        return dao.getCustomersByKeyword(keyword);
    }

    public void addCustomer(Customer customer) {
        dao.addCustomer(customer);
    }

    public void removeCustomer(int id) {
        dao.removeCustomer(id);
    }

    public void updateCustomer(Customer customer) {
        dao.updateCustomer(customer);
    }
}