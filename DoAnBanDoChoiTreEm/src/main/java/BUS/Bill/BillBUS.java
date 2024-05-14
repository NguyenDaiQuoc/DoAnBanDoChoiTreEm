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
    public BillBUS(){}
    
    public ArrayList<BillDTO> getAllBills() {
        return dao.getAllBills();
    }
    
    void getDs() {
        if(dshoadon == null) {
            dshoadon = new ArrayList<BillDTO>();
            dshoadon = dao.getAllBills1();
        }
    }
    
    public ArrayList<BillDTO> getCurrentBillId() {
        return dao.getAllBills1();
    }

//    public ArrayList<BillDTO> getBillsByKeyword(String id, String idNV, String idKH, String soCTHD, String tongTien, String ngayXuat, String tuGia, String denGia, String tuNgay, String denNgay,String km) {
//        return dao.getBillsByKeyword(id, idNV, idKH, soCTHD, tongTien, ngayXuat, tuGia, denGia, tuNgay, denNgay, km);
//    }

    public boolean checkAvaiable(int id) {
        getDs();
        for(BillDTO hd : dshoadon) {
            if(hd.getId() == id) {
                return true;
            }
        }
        return false;
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
