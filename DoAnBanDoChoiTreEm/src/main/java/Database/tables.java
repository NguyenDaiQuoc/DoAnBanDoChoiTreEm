package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SHOW TABLES LIKE 'nguoidung'");
            if (!rs.next()) {
                st.executeUpdate("create table nguoidung(id int AUTO_INCREMENT primary key,vaiTro varchar(50),ten varchar(200),sdt varchar(50),email varchar(200),matKhau varchar(50), diaChi varchar(200),status int DEFAULT 1)");
            }
            st.executeUpdate("insert into nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi) values('QuanLy','Quan Ly','12345','ad','admin','Vietnam')");
            st.executeUpdate("insert into nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi) values('Nhan Vien','Tuấn','123456','tuan','090904','Vietnam')");
            st.executeUpdate("insert into nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi) values('Nhan Vien','Sang','123456','sang','091204','Vietnam')");
            st.executeUpdate("insert into nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi) values('Nhan Vien','Quốc','123457','quoc','230104','Vietnam')");
            st.executeUpdate("insert into nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi) values('Nhan Vien','Thịnh','123458','thinh','123456','Vietnam')");

            rs = st.executeQuery("SHOW TABLES LIKE 'khachhang'");
            if (!rs.next()) {
                st.executeUpdate("create table khachhang(id int AUTO_INCREMENT primary key, ten varchar(200), email varchar(200), diaChi varchar(200), sdt varchar(50), status int DEFAULT 1)");
            }
            for (int i = 1; i <= 10; i++) {
                st.executeUpdate("insert into khachhang (ten, email, diaChi, sdt) values('Khach Hang " + i + "','kh" + i + "@mail.com','Dia Chi " + i + "','12345" + i + "')");
            }
            rs = st.executeQuery("SHOW TABLES LIKE 'sanpham'");
            if (!rs.next()) {
                st.executeUpdate("create table sanpham(id int AUTO_INCREMENT primary key, ten varchar(200), xuatxu varchar(200), gia decimal(10,2), soluong int, theloai varchar(200), status int DEFAULT 1)");
            }
            rs = st.executeQuery("SHOW TABLES LIKE 'nhanvien'");
            if (!rs.next()) {
                st.executeUpdate("CREATE TABLE nhanvien(id INT AUTO_INCREMENT PRIMARY KEY, ten VARCHAR(200), tuoi INT, email VARCHAR(200), diaChi VARCHAR(200), sdt VARCHAR(50),vaiTro VARCHAR(20) DEFAULT 'thungan', status INT DEFAULT 1)");
            }

            // Đồ chơi phương tiện
            for (int i = 1; i <= 10; i++) {
                st.executeUpdate("insert into sanpham (ten, xuatxu, gia, soluong, theloai) values('Do Choi Phuong Tien " + i + "', 'Vietnam', 100.00, 10, 'Do Choi Phuong Tien')");
            }

// Đồ chơi theo phim
            for (int i = 1; i <= 10; i++) {
                st.executeUpdate("insert into sanpham (ten, xuatxu, gia, soluong, theloai) values('Do Choi Theo Phim " + i + "', 'Vietnam', 100.00, 10, 'Do Choi Theo Phim')");
            }

// Đồ chơi thời trang
            for (int i = 1; i <= 10; i++) {
                st.executeUpdate("insert into sanpham (ten, xuatxu, gia, soluong, theloai) values('Do Choi Thoi Trang " + i + "', 'Vietnam', 100.00, 10, 'Do Choi Thoi Trang')");
            }

// Đồ chơi lắp ghép
            for (int i = 1; i <= 10; i++) {
                st.executeUpdate("insert into sanpham (ten, xuatxu, gia, soluong, theloai) values('Do Choi Lap Ghep " + i + "', 'Vietnam', 100.00, 10, 'Do Choi Lap Ghep')");
            }

// Robot
            for (int i = 1; i <= 10; i++) {
                st.executeUpdate("insert into sanpham (ten, xuatxu, gia, soluong, theloai) values('Robot " + i + "', 'Vietnam', 100.00, 10, 'Robot')");
            }

            JOptionPane.showMessageDialog(null, "Da tao bang thanh cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
