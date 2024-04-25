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
            rs = st.executeQuery("SHOW TABLES LIKE 'dochoiphuongtien'");
            if (!rs.next()) {
                st.executeUpdate("create table dochoiphuongtien(id int AUTO_INCREMENT primary key, ten varchar(200), xuatxu varchar(200), gia decimal(10,2), soluong int, loaiPhuongTien varchar(200), status int DEFAULT 1)");
            }

            st.executeUpdate("insert into dochoiphuongtien (ten, xuatxu, gia, soluong, loaiPhuongTien) values('Đồ chơi xe công trình 3L 3LHGL888', 'Vietnam', 69.000, 10, 'xe công trình')");
            st.executeUpdate("insert into dochoiphuongtien (ten, xuatxu, gia, soluong, loaiPhuongTien) values('Đồ chơi xe công trình điều khiển 3L 3L3688-K72', 'Vietnam', 82.500, 10, 'xe công trình')");
            st.executeUpdate("insert into dochoiphuongtien (ten, xuatxu, gia, soluong, loaiPhuongTien) values('Đồ chơi xe công trình LATOYS LA10368-8', 'Vietnam', 18.000, 10, 'xe công trình')");
            st.executeUpdate("insert into dochoiphuongtien (ten, xuatxu, gia, soluong, loaiPhuongTien) values('Đồ chơi lắp ráp xe công trình 3L 3LHL8610', 'Vietnam', 39.500, 10, 'xe lắp ráp')");
            st.executeUpdate("insert into dochoiphuongtien (ten, xuatxu, gia, soluong, loaiPhuongTien) values('Đồ chơi xe điều khiển 3L 3L6918-100', 'Vietnam', 119.500, 10, 'xe điều khiển')");
            st.executeUpdate("insert into dochoiphuongtien (ten, xuatxu, gia, soluong, loaiPhuongTien) values('Đồ chơi xe tăng 3L 3LHY-169', 'Vietnam', 39.000, 10, 'xe tăng')");
            st.executeUpdate("insert into dochoiphuongtien (ten, xuatxu, gia, soluong, loaiPhuongTien) values('Đồ chơi xe công trình 3L 3LLY037F', 'Vietnam', 39.000, 10, 'xe công trình')");
            st.executeUpdate("insert into dochoiphuongtien (ten, xuatxu, gia, soluong, loaiPhuongTien) values('Đồ chơi xe hợp kim 3L 3L388-54C', 'Vietnam', 442.000, 10, 'xe hợp kim')");
            st.executeUpdate("insert into dochoiphuongtien (ten, xuatxu, gia, soluong, loaiPhuongTien) values('Đồ chơi xe bus 3L 3LBH668-3', 'Vietnam', 39.000, 10, 'xe bus')");
            st.executeUpdate("insert into dochoiphuongtien (ten, xuatxu, gia, soluong, loaiPhuongTien) values('Đồ chơi xe công trình 3L 3L706-33', 'Vietnam', 39.000, 10, 'xe công trình')");

            rs = st.executeQuery("SHOW TABLES LIKE 'dochoitheophim'");
            if (!rs.next()) {
                st.executeUpdate("create table dochoitheophim(id int AUTO_INCREMENT primary key, ten varchar(200), xuatxu varchar(200), gia decimal(10,0), soluong int, tenPhim varchar(200), status int DEFAULT 1)");
            }

            st.executeUpdate("insert into dochoitheophim (ten, xuatxu, gia, soluong, tenPhim) values('Đồ chơi điện thoại cầm tay Doraemon', 'Vietnam', 190000, 10, 'Doraemon')");
            st.executeUpdate("insert into dochoitheophim (ten, xuatxu, gia, soluong, tenPhim) values('Đồ chơi quạt Doremon 3 cánh quay tay', 'Vietnam', 190000, 10, 'Doraemon')");
            st.executeUpdate("insert into dochoitheophim (ten, xuatxu, gia, soluong, tenPhim) values('Đồ chơi công chúa Elsa đầm nhựa xòe xoay 360 độ có đèn nhạc HX132', 'Vietnam', 250000, 10, 'Frozen')");
            st.executeUpdate("insert into dochoitheophim (ten, xuatxu, gia, soluong, tenPhim) values('Đồ chơi búa Thor StormBreaker bằng nhựa có nhạc đèn WL5023', 'Vietnam', 490000, 10, 'Avengers')");
            st.executeUpdate("insert into dochoitheophim (ten, xuatxu, gia, soluong, tenPhim) values('Hộp đồ chơi robot Iron Man Người Sắt nhảy múa có nhạc đèn 696-55', 'Vietnam', 490000, 10, 'Iron Man')");
            st.executeUpdate("insert into dochoitheophim (ten, xuatxu, gia, soluong, tenPhim) values('Đồ chơi mô hình 4 siêu anh hùng Thor, Captain, Thanos, Iron có đèn B88614', 'Vietnam', 250000, 10, 'Avengers')");
            st.executeUpdate("insert into dochoitheophim (ten, xuatxu, gia, soluong, tenPhim) values('Hộp 20 bộ bài Pokemon 38 lá bộ bằng giấy cứng', 'Vietnam', 190000, 10, 'Pokemon')");
            st.executeUpdate("insert into dochoitheophim (ten, xuatxu, gia, soluong, tenPhim) values('Đồ chơi Pikachu đánh trống vạn cốt bằng nhựa 3583-22A', 'Vietnam', 490000, 10, 'Pokemon')");
            st.executeUpdate("insert into dochoitheophim (ten, xuatxu, gia, soluong, tenPhim) values('Đồ chơi điện thoại cầm tay Người Nhện dùng pin có nhạc 3701', 'Vietnam', 250000, 10, 'Spider-Man')");
            st.executeUpdate("insert into dochoitheophim (ten, xuatxu, gia, soluong, tenPhim) values('Đồ chơi Trư Bát Giới đánh trống vạn cốt bằng nhựa', 'Vietnam', 190000, 10, 'Journey to the West')");

            rs = st.executeQuery("SHOW TABLES LIKE 'dochoithoitrang'");
            if (!rs.next()) {
                st.executeUpdate("create table dochoithoitrang(id int AUTO_INCREMENT primary key, ten varchar(200), xuatxu varchar(200), gia decimal(10,0), soluong int, xuHuong varchar(200), status int DEFAULT 1)");
            }

            st.executeUpdate("insert into dochoithoitrang (ten, xuatxu, gia, soluong, xuHuong) values('Bộ Dụng Cụ Màu Trang Trí Glitzy Spray', 'Vietnam', 190000, 10, 'Công nghệ')");
            st.executeUpdate("insert into dochoithoitrang (ten, xuatxu, gia, soluong, xuHuong) values('Bộ Dụng Cụ Màu Trang Trí Glitzy Studio', 'Vietnam', 190000, 10, 'Mùa hè')");
            st.executeUpdate("insert into dochoithoitrang (ten, xuatxu, gia, soluong, xuHuong) values('Bộ Dụng Cụ Màu Trang Trí Glitzy Neon', 'Vietnam', 250000, 10, 'Cổ tích')");
            st.executeUpdate("insert into dochoithoitrang (ten, xuatxu, gia, soluong, xuHuong) values('Bộ Dụng Cụ Màu Trang Trí Cơ Bản Glitzy', 'Vietnam', 490000, 10, 'Siêu anh hùng')");
            st.executeUpdate("insert into dochoithoitrang (ten, xuatxu, gia, soluong, xuHuong) values('Ba Lô Easy Go - Biệt Đội Khủng Long Xanh', 'Vietnam', 490000, 10, 'Siêu anh hùng')");
            st.executeUpdate("insert into dochoithoitrang (ten, xuatxu, gia, soluong, xuHuong) values('Ba Lô Dây Rút - Joy', 'Vietnam', 250000, 10, 'Siêu anh hùng')");
            st.executeUpdate("insert into dochoithoitrang (ten, xuatxu, gia, soluong, xuHuong) values('Túi Clever Note - Bold', 'Vietnam', 190000, 10, 'Thể thao')");
            st.executeUpdate("insert into dochoithoitrang (ten, xuatxu, gia, soluong, xuHuong) values('Ba Lô Kỳ Lân Ngọt Ngào - Hồng', 'Vietnam', 490000, 10, 'Thể thao')");
            st.executeUpdate("insert into dochoithoitrang (ten, xuatxu, gia, soluong, xuHuong) values('Ba Lô Nàng Cá Nhỏ - Xanh', 'Vietnam', 250000, 10, 'Công nghệ')");
            st.executeUpdate("insert into dochoithoitrang (ten, xuatxu, gia, soluong, xuHuong) values('Túi Clever Note - Delight', 'Vietnam', 190000, 10, 'Văn hóa')");

            rs = st.executeQuery("SHOW TABLES LIKE 'dochoilapghep'");
            if (!rs.next()) {
                st.executeUpdate("create table dochoilapghep(id int AUTO_INCREMENT primary key, ten varchar(200), xuatxu varchar(200), gia decimal(10,0), soluong int, soManhGhep int, status int DEFAULT 1)");
            }

            st.executeUpdate("insert into dochoilapghep (ten, xuatxu, gia, soluong, soManhGhep) values('Đồ chơi lắp ráp đường ray và xe chạy pin - set cứu hỏa VT55710A', 'Vietnam', 509000, 10, 100)");
            st.executeUpdate("insert into dochoilapghep (ten, xuatxu, gia, soluong, soManhGhep) values('Bộ đồ chơi lắp ráp vecto diy 3 trong 1 - dòng xe vệ sinh VT2019', 'Vietnam', 279000, 10, 120)");
            st.executeUpdate("insert into dochoilapghep (ten, xuatxu, gia, soluong, soManhGhep) values('Bộ đồ chơi lắp ráp vecto diy - xe xúc và phụ kiện OK1041', 'Vietnam', 120000, 10, 150)");
            st.executeUpdate("insert into dochoilapghep (ten, xuatxu, gia, soluong, soManhGhep) values('Bộ đồ chơi lắp ráp vecto diy 3 trong 1 - xe cứu hỏa VT1072', 'Vietnam', 399000, 10, 200)");
            st.executeUpdate("insert into dochoilapghep (ten, xuatxu, gia, soluong, soManhGhep) values('Đồ chơi lắp ráp vecto diy - xe tăng VT1073', 'Vietnam', 139000, 10, 250)");
            st.executeUpdate("insert into dochoilapghep (ten, xuatxu, gia, soluong, soManhGhep) values('Hộp đồ chơi robot Iron Man Người Sắt nhảy múa có nhạc đèn 696-55', 'Vietnam', 490000, 10, 300)");
            st.executeUpdate("insert into dochoilapghep (ten, xuatxu, gia, soluong, soManhGhep) values('Đồ chơi lắp ráp vecto diy - xe chở gỗ OK1013', 'Vietnam', 199000, 10, 350)");
            st.executeUpdate("insert into dochoilapghep (ten, xuatxu, gia, soluong, soManhGhep) values('Combo mô hình 2023 new boy character action figure vol 2 CB-A2709559-4778', 'Vietnam', 519000, 10, 400)");
            st.executeUpdate("insert into dochoilapghep (ten, xuatxu, gia, soluong, soManhGhep) values('Mô hình nhân vật converge kamen rider 25 A2638056-4778', 'Vietnam', 519000, 10, 450)");
            st.executeUpdate("insert into dochoilapghep (ten, xuatxu, gia, soluong, soManhGhep) values('Đồ chơi lắp ráp gunpla HG machine rider 0230362', 'Vietnam', 519000, 10, 500)");

            rs = st.executeQuery("SHOW TABLES LIKE 'Robot'");
            if (!rs.next()) {
                st.executeUpdate("create table Robot(id int AUTO_INCREMENT primary key, ten varchar(200), xuatxu varchar(200), gia decimal(10,0), soluong int, loaiRobot varchar(200), status int DEFAULT 1)");
            }

            st.executeUpdate("insert into Robot (ten, xuatxu, gia, soluong, loaiRobot) values('Robot chú chó tinh nghịch', 'Vietnam', 509000, 10, 'Dog')");
            st.executeUpdate("insert into Robot (ten, xuatxu, gia, soluong, loaiRobot) values('Robot mèo con thông thái', 'Vietnam', 509000, 10, 'Cat')");
            st.executeUpdate("insert into Robot (ten, xuatxu, gia, soluong, loaiRobot) values('Robot tương lai xanh', 'Vietnam', 509000, 10, 'Futuristic')");
            st.executeUpdate("insert into Robot (ten, xuatxu, gia, soluong, loaiRobot) values('Robot lăn lôn đỏ', 'Vietnam', 509000, 10, 'Rolling')");
            st.executeUpdate("insert into Robot (ten, xuatxu, gia, soluong, loaiRobot) values('Robot tương lai đỏ', 'Vietnam', 509000, 10, 'Futuristic')");
            st.executeUpdate("insert into Robot (ten, xuatxu, gia, soluong, loaiRobot) values('Chú robot quản gia thông thái đỏ', 'Vietnam', 599000, 10, 'Butler')");
            st.executeUpdate("insert into Robot (ten, xuatxu, gia, soluong, loaiRobot) values('Robot lăn lôn trắng', 'Vietnam', 509000, 10, 'Rolling')");
            st.executeUpdate("insert into Robot (ten, xuatxu, gia, soluong, loaiRobot) values('Chú robot quản gia thông thái xanh dương', 'Vietnam', 599000, 10, 'Butler')");
            st.executeUpdate("insert into Robot (ten, xuatxu, gia, soluong, loaiRobot) values('Cú con Owleez học bay trắng', 'Vietnam', 509000, 10, 'Owl')");
            st.executeUpdate("insert into Robot (ten, xuatxu, gia, soluong, loaiRobot) values('Xe điều khiển biến hình Mercedes-Benz đỏ', 'Vietnam', 509000, 10, 'Transforming Car')");

            rs = st.executeQuery("SHOW TABLES LIKE 'nhanvien'");
            if (!rs.next()) {
                st.executeUpdate("CREATE TABLE nhanvien(id INT AUTO_INCREMENT PRIMARY KEY, ten VARCHAR(200), tuoi INT, email VARCHAR(200), diaChi VARCHAR(200), sdt VARCHAR(50),vaiTro VARCHAR(20) DEFAULT 'Thu Ngan', status INT DEFAULT 1)");
            }
            st.executeUpdate("insert into nhanvien (id,ten,tuoi,email,diaChi,sdt,vaiTro) values(1,'Quan Ly',20,'ad','Vietnam','12345','Quan Ly')");
            st.executeUpdate("insert into nhanvien (id,ten,tuoi,email,diaChi,sdt,vaiTro) values(2,'Tuấn',20,'tuan','Vietnam','12345','Thu Ngan')");
            st.executeUpdate("insert into nhanvien (id,ten,tuoi,email,diaChi,sdt,vaiTro) values(3,'Sang',20,'sang','Vietnam','12345','Thu Ngan')");
            st.executeUpdate("insert into nhanvien (id,ten,tuoi,email,diaChi,sdt,vaiTro) values(4,'Quốc',20,'quoc','Vietnam','12345','Thu Ngan')");
            st.executeUpdate("insert into nhanvien (id,ten,tuoi,email,diaChi,sdt,vaiTro) values(5,'Thịnh',20,'thinh','Vietnam','12345','Thu Ngan')");

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
