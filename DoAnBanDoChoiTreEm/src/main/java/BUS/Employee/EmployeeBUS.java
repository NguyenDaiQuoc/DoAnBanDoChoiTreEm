package BUS;

import Inventory.DAO.StaffDAO;
import Inventory.DTO.StaffDTO;
import java.util.ArrayList;

public class EmployeeBUS {

    private StaffDAO dao = new StaffDAO();
    public static ArrayList <StaffDTO> dsnv;
    public EmployeeBUS(){}

    public void addUser(StaffDTO staff) {
        dao.addUser(staff);
    }
    
    public void editUser(StaffDTO staff){
        dao.editUser(staff);
    }
    
    public void getList(){
        if(dsnv == null){
            dsnv = new ArrayList<StaffDTO>();
            dsnv = dao.getAllStaffs();
        } else {
            dsnv = dao.getAllStaffs();
        }
    }

    public ArrayList<StaffDTO> getAllStaffs() {
        getList();
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

    public StaffDTO getStaffByUserName(String tk) {
        return dao.getStaffByUserName(tk);
    }
    
    public int[] getInfoStaff(){
        return dao.getInfoStaff();
    }
}
