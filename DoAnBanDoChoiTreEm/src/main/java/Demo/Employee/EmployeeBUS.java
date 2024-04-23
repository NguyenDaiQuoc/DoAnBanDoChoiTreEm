package BUS.Employee;

import Inventory.DAO.StaffDAO;
import Inventory.DTO.StaffDTO;
import java.util.ArrayList;

public class EmployeeBUS {
    private StaffDAO dao = new StaffDAO();

    public ArrayList<StaffDTO> getAllStaffs() {
        return dao.getAllStaffs();
    }

    public ArrayList<StaffDTO> getStaffsByKeyword(String keyword) {
        return dao.getStaffByKeyword(keyword);
    }

    public void addStaff(StaffDTO staff) {
        dao.addStaff(staff);
    }

    public void removeStaff(int id) {
        dao.removeStaff(id);
    }

    public void updateStaff(StaffDTO staff) {
        dao.updateStaff(staff);
    }
}

