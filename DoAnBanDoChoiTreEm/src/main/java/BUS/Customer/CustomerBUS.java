// CustomerBUS.java
package Bus;

import Inventory.DAO.CustomerDAO;
import Inventory.DTO.CustomerDTO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
            if (customer.getName().contains(keyword) || customer.getEmail().contains(keyword)
                    || customer.getAddress().contains(keyword) || customer.getSdt().contains(keyword)) {
                result.add(customer);
            }
        }
        return result;
    }

    public void exportToExcel(ArrayList<CustomerDTO> customers, String filePath) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Customers");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Email");
        headerRow.createCell(3).setCellValue("Address");
        headerRow.createCell(4).setCellValue("SDT");

        // Create data rows
        for (int i = 0; i < customers.size(); i++) {
            CustomerDTO customer = customers.get(i);
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(customer.getId());
            row.createCell(1).setCellValue(customer.getName());
            row.createCell(2).setCellValue(customer.getEmail());
            row.createCell(3).setCellValue(customer.getAddress());
            row.createCell(4).setCellValue(customer.getSdt());
        }

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<CustomerDTO> importFromExcel(String filePath) {
        ArrayList<CustomerDTO> customers = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(filePath)) {
            XSSFWorkbook workbook = new XSSFWorkbook(fileIn);
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Skip the header row
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String id = getCellValueAsString(row.getCell(0));
                String name = getCellValueAsString(row.getCell(1));
                String email = getCellValueAsString(row.getCell(2));
                String address = getCellValueAsString(row.getCell(3));
                String sdt = getCellValueAsString(row.getCell(4));

                customers.add(new CustomerDTO(id, name, email, address, sdt));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }

    private String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                // Convert numeric value to string
                return Double.toString(cell.getNumericCellValue());
            default:
                return "";
        }
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
    public int getInfoCus(){
        return dao.getInfoCus();
    }
}
