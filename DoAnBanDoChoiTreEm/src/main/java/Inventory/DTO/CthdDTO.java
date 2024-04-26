/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.DTO;

/**
 *
 * @author Admin
 */
public class CthdDTO {
    int idHoaDon;
    String tenSanPham, idSanPham;
    int soLuong;
    double giaTien;
    String status;
    
    public CthdDTO() {
        idHoaDon = 0;
        idSanPham = "";
        tenSanPham = "";
        soLuong = 0;
        giaTien = 0;
        status = "";
    }
    
    public CthdDTO(int idHoaDon, String idSanPham, String tenSanPham, int soLuong, double giaTien, String status) {
        this.idHoaDon = idHoaDon;
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.status = status;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }    
}
