/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.DTO;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class BillDTO {
    int id;
    String idNhanVien, idKhachHang;
    int soCTHD;
    double tongTien;
    Date ngayXuat;
    String status;
    
    public BillDTO() {
//       this.id = 0;
//       this.tongTien = 0;
//       this.soCTHD = 0;
//       try {
//           SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//           this.ngayXuat = formatter.parse("1/1/2000");
//       } catch (Exception e) {
//           e.printStackTrace();
//       }
//       this.idNhanVien = "";
//       this.idKhachHang = "";
//       this.status = "";
    }
    
    public BillDTO(int id, String idNhanVien, String idKhachHang,int soCTHD, double tongTien, Date ngayXuat, String status) {
        this.id = id;
        this.tongTien = tongTien;
        this.ngayXuat = ngayXuat;
        this.soCTHD = soCTHD;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getSoCTHD() {
        return soCTHD;
    }

    public void setSoCTHD(int soCTHD) {
        this.soCTHD = soCTHD;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
