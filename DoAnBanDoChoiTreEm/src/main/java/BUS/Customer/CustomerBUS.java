// CustomerBUS.java
package Bus;

import Inventory.DAO.CustomerDAO;
import Inventory.DTO.CustomerDTO;
import java.util.ArrayList;

public class CustomerBUS {
    private CustomerDAO dao = new CustomerDAO();
    private ArrayList<CustomerDTO> customerCache;

    public ArrayList<CustomerDTO> getAllCustomers() {
        if (customerCache == null) {
            customerCache = dao.getAllCustomers();
        }
        return new ArrayList<>(customerCache);
    }

    public ArrayList<CustomerDTO> getCustomersByKeyword(String keyword) {
        if (customerCache == null) {
            customerCache = dao.getAllCustomers();
        }
        ArrayList<CustomerDTO> result = new ArrayList<>();
        for (CustomerDTO customer : customerCache) {
            if (customer.getName().contains(keyword) || customer.getEmail().contains(keyword) ||
                customer.getAddress().contains(keyword) || customer.getSdt().contains(keyword)) {
                result.add(customer);
            }
        }
        return result;
    }

    public void addCustomer(CustomerDTO customer) {
        dao.addCustomer(customer);
        customerCache = null; // Invalidate the cache
    }

    public void removeCustomer(String id) {
        dao.removeCustomer(id);
        customerCache = null; // Invalidate the cache
    }

    public void updateCustomer(CustomerDTO customer) {
        dao.updateCustomer(customer);
        customerCache = null; // Invalidate the cache
    }
}

