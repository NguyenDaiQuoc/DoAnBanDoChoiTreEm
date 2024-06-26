/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus;
import Inventory.DAO.CthdDAO;
import Inventory.DTO.CthdDTO;
import UI.Sales.SalesPage;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CthdBUS {
    public static ArrayList<CthdDTO> dscthd;
    CthdDAO dao = new CthdDAO();
    public CthdBUS(){}
    
    public ArrayList<CthdDTO> getAllCTHD() {
        return dao.getAllCTHD();
    }
    
    public void addCTHD(CthdDTO cthd) {
        dao.addCTHD(cthd);
    }
    public void removeCTHD(String idSP, int idHD) {
        dao.removeCTHD(idSP, idHD);
    }
    public void updateCTHD(CthdDTO cthddto, String oldIdSP) {
        dao.updateCTHD(cthddto,oldIdSP);
    }
}
