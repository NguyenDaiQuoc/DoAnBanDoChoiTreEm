/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus;
import Inventory.DAO.BillDAO;
import Inventory.DTO.BillDTO;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class BillBUS {
    public static ArrayList<BillDTO> dshoadon;
    BillDAO dao = new BillDAO();
    public BillBUS(){
        dshoadon = new ArrayList<>();
    }
    
    public ArrayList<BillDTO> getAllBills() {
        return dao.getAllBills();
    }

    public ArrayList<BillDTO> getBillsByKeyword(String id, String idNV, String idKH, String soCTHD, String tongTien, String ngayXuat, String tuGia, String denGia, String tuNgay, String denNgay) {
        return dao.getBillsByKeyword(id, idNV, idKH, soCTHD, tongTien, ngayXuat, tuGia, denGia, tuNgay, denNgay);
    }

    public void addBill(BillDTO bill) {
        dao.addBill(bill);
    }

    public void removeBill(int id) {
        dao.removeBill(id);
    }

    public void updateBill(BillDTO bill) {
        dao.updateBill(bill);
    }
}
