/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus;
import Inventory.DAO.CthdDAO;
import Inventory.DTO.CthdDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CthdBUS {
    public static ArrayList<CthdDTO> dscthd;
    CthdDAO dao = new CthdDAO();
    public CthdBUS(){
        dscthd = new ArrayList<>();
    }
    
    public ArrayList<CthdDTO> getAllCTHD() {
        return dao.getAllCTHD();
    }
    
    public void removeCTHD(String idSP) {
        dao.removeCTHD(idSP);
    }
    public void updateCTHD(CthdDTO cthddto, String oldIdSP) {
        dao.updateCTHD(cthddto,oldIdSP);
    }
}
