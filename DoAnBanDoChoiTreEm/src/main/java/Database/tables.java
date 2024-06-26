package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Random;

public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("SHOW TABLES LIKE 'nguoidung'");
            if (!rs.next()) {
                st.executeUpdate("create table nguoidung(id int AUTO_INCREMENT primary key,vaiTro varchar(50),ten varchar(200),sdt varchar(50),email varchar(200),matKhau varchar(50), diaChi varchar(200),status int DEFAULT 1)");
                st.executeUpdate("insert into nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi) values('QuanLy','Quan Ly','12345','ad','admin','Vietnam')");
                st.executeUpdate("insert into nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi) values('Nhan Vien','Nguyễn Ngọc Tuấn','123456','tuan','090904','Vietnam')");
                st.executeUpdate("insert into nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi) values('Nhan Vien','Nguyễn Hoàng Sang','123456','sang','091204','Vietnam')");
                st.executeUpdate("insert into nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi) values('Nhan Vien','Nguyễn Đại Quốc','123457','quoc','230104','Vietnam')");
                st.executeUpdate("insert into nguoidung (vaiTro,ten,sdt,email,matKhau,diaChi) values('Nhan Vien','Đinh Phúc Thịnh','123458','thinh','123456','Vietnam')");
            }

            rs = st.executeQuery("SHOW TABLES LIKE 'khachhang'");
            if (!rs.next()) {
                st.executeUpdate("create table khachhang(id varchar(10) primary key, ten varchar(200), email varchar(200), diaChi varchar(200), sdt varchar(50), status int DEFAULT 1)");
            }

            for (int i = 1; i <= 10; i++) {
                String id = "KH" + String.format("%02d", i);
                String ten = "Nguyen Van " + (char) ('A' + i - 1);
                String email = "kh" + i + "@mail.com";
                String diaChi = "Đường số " + i + " Vietnam";
                String sdt = "09" + String.format("%08d", new Random().nextInt(100000000));
                st.executeUpdate("insert into khachhang (id, ten, email, diaChi, sdt) values('" + id + "', '" + ten + "', '" + email + "', '" + diaChi + "', '" + sdt + "')");
            }

            rs = st.executeQuery("SHOW TABLES LIKE 'dochoiphuongtien'");
            if (!rs.next()) {
                st.executeUpdate("create table dochoiphuongtien(id int primary key, ten varchar(200), gia decimal(10,2), xuatxu varchar(200), soluong int, soLuongConLai int, loaiPhuongTien varchar(200), status int DEFAULT 1)");
                st.executeUpdate("insert into dochoiphuongtien (id, ten, gia, xuatxu, soluong, soLuongConLai, loaiPhuongTien) values('1001', 'Đồ chơi xe công trình 3L 3LHGL888', 69000, 'Vietnam', 10, 10, 'xe công trình')");
                st.executeUpdate("insert into dochoiphuongtien (id, ten, gia, xuatxu, soluong, soLuongConLai, loaiPhuongTien) values('1002', 'Đồ chơi xe công trình điều khiển 3L 3L3688-K72', 82500, 'Vietnam', 10, 10,  'xe công trình')");
                st.executeUpdate("insert into dochoiphuongtien (id, ten, gia, xuatxu, soluong, soLuongConLai, loaiPhuongTien) values('1003', 'Đồ chơi xe công trình LATOYS LA10368-8', 18000, 'Vietnam', 10, 10,  'xe công trình')");
                st.executeUpdate("insert into dochoiphuongtien (id, ten, gia, xuatxu, soluong, soLuongConLai, loaiPhuongTien) values('1004', 'Đồ chơi lắp ráp xe công trình 3L 3LHL8610', 39500, 'Vietnam', 10, 10,  'xe lắp ráp')");
                st.executeUpdate("insert into dochoiphuongtien (id, ten, gia, xuatxu, soluong, soLuongConLai, loaiPhuongTien) values('1005', 'Đồ chơi xe điều khiển 3L 3L6918-100', 119500, 'Vietnam', 10, 10,  'xe điều khiển')");
                st.executeUpdate("insert into dochoiphuongtien (id, ten, gia, xuatxu, soluong, soLuongConLai, loaiPhuongTien) values('1006', 'Đồ chơi xe tăng 3L 3LHY-169', 39000, 'Vietnam', 10, 10,  'xe tăng')");
                st.executeUpdate("insert into dochoiphuongtien (id, ten, gia, xuatxu, soluong, soLuongConLai, loaiPhuongTien) values('1007', 'Đồ chơi xe công trình 3L 3LLY037F', 39000, 'Vietnam', 10, 10,  'xe công trình')");
                st.executeUpdate("insert into dochoiphuongtien (id, ten, gia, xuatxu, soluong, soLuongConLai, loaiPhuongTien) values('1008', 'Đồ chơi xe hợp kim 3L 3L388-54C', 442000, 'Vietnam', 10, 10,  'xe hợp kim')");
                st.executeUpdate("insert into dochoiphuongtien (id, ten, gia, xuatxu, soluong, soLuongConLai, loaiPhuongTien) values('1009', 'Đồ chơi xe bus 3L 3LBH668-3', 39000, 'Vietnam', 10, 10,  'xe bus')");
                st.executeUpdate("insert into dochoiphuongtien (id, ten, gia, xuatxu, soluong, soLuongConLai, loaiPhuongTien) values('1010', 'Đồ chơi xe công trình 3L 3L706-33', 39000, 'Vietnam', 10, 10,  'xe công trình')");
            }

            rs = st.executeQuery("SHOW TABLES LIKE 'dochoitheophim'");
            if (!rs.next()) {
                st.executeUpdate("create table dochoitheophim(id int primary key, ten varchar(200), gia decimal(10,0), xuatxu varchar(200), soluong int, soLuongConLai int,  tenPhim varchar(200), status int DEFAULT 1)");
                st.executeUpdate("insert into dochoitheophim (id, ten, gia, xuatxu, soluong, soLuongConLai,  tenPhim) values('1101', 'Đồ chơi điện thoại cầm tay Doraemon', 190000, 'Vietnam', 10, 10, 'Doraemon')");
                st.executeUpdate("insert into dochoitheophim (id, ten, gia, xuatxu, soluong, soLuongConLai,  tenPhim) values('1102', 'Đồ chơi quạt Doremon 3 cánh quay tay', 190000, 'Vietnam', 10, 10, 'Doraemon')");
                st.executeUpdate("insert into dochoitheophim (id, ten, gia, xuatxu, soluong, soLuongConLai,  tenPhim) values('1103', 'Đồ chơi công chúa Elsa đầm nhựa xòe xoay 360 độ có đèn nhạc HX132', 250000, 'Vietnam', 10, 10, 'Frozen')");
                st.executeUpdate("insert into dochoitheophim (id, ten, gia, xuatxu, soluong, soLuongConLai,  tenPhim) values('1104', 'Đồ chơi búa Thor StormBreaker bằng nhựa có nhạc đèn WL5023', 490000, 'Vietnam', 10, 10, 'Avengers')");
                st.executeUpdate("insert into dochoitheophim (id, ten, gia, xuatxu, soluong, soLuongConLai,  tenPhim) values('1105', 'Hộp đồ chơi robot Iron Man Người Sắt nhảy múa có nhạc đèn 696-55', 490000, 'Vietnam', 10, 10, 'Iron Man')");
                st.executeUpdate("insert into dochoitheophim (id, ten, gia, xuatxu, soluong, soLuongConLai,  tenPhim) values('1106', 'Đồ chơi mô hình 4 siêu anh hùng Thor, Captain, Thanos, Iron có đèn B88614', 250000, 'Vietnam', 10, 10, 'Avengers')");
                st.executeUpdate("insert into dochoitheophim (id, ten, gia, xuatxu, soluong, soLuongConLai,  tenPhim) values('1107', 'Hộp 20 bộ bài Pokemon 38 lá bộ bằng giấy cứng', 190000, 'Vietnam', 10, 10, 'Pokemon')");
                st.executeUpdate("insert into dochoitheophim (id, ten, gia, xuatxu, soluong, soLuongConLai,  tenPhim) values('1108', 'Đồ chơi Pikachu đánh trống vạn cốt bằng nhựa 3583-22A', 490000, 'Vietnam', 10, 10, 'Pokemon')");
                st.executeUpdate("insert into dochoitheophim (id, ten, gia, xuatxu, soluong, soLuongConLai,  tenPhim) values('1109', 'Đồ chơi điện thoại cầm tay Người Nhện dùng pin có nhạc 3701', 250000, 'Vietnam', 10, 10, 'Spider-Man')");
                st.executeUpdate("insert into dochoitheophim (id, ten, gia, xuatxu, soluong, soLuongConLai,  tenPhim) values('1110', 'Đồ chơi Trư Bát Giới đánh trống vạn cốt bằng nhựa', 190000, 'Vietnam', 10, 10, 'Journey to the West')");
            }

            rs = st.executeQuery("SHOW TABLES LIKE 'dochoithoitrang'");
            if (!rs.next()) {
                st.executeUpdate("create table dochoithoitrang(id int primary key, ten varchar(200), gia decimal(10,0), xuatxu varchar(200), soluong int, soLuongConLai int,  xuHuong varchar(200), status int DEFAULT 1)");
                st.executeUpdate("insert into dochoithoitrang (id, ten, gia, xuatxu, soluong, soLuongConLai,  xuHuong) values('1201', 'Bộ Dụng Cụ Màu Trang Trí Glitzy Spray', 190000, 'Vietnam', 10, 10, 'Công nghệ')");
                st.executeUpdate("insert into dochoithoitrang (id, ten, gia, xuatxu, soluong, soLuongConLai,  xuHuong) values('1202', 'Bộ Dụng Cụ Màu Trang Trí Glitzy Studio', 190000, 'Vietnam', 10, 10, 'Mùa hè')");
                st.executeUpdate("insert into dochoithoitrang (id, ten, gia, xuatxu, soluong, soLuongConLai,  xuHuong) values('1203', 'Bộ Dụng Cụ Màu Trang Trí Glitzy Neon', 250000, 'Vietnam', 10, 10, 'Cổ tích')");
                st.executeUpdate("insert into dochoithoitrang (id, ten, gia, xuatxu, soluong, soLuongConLai,  xuHuong) values('1204', 'Bộ Dụng Cụ Màu Trang Trí Cơ Bản Glitzy', 490000, 'Vietnam', 10, 10, 'Siêu anh hùng')");
                st.executeUpdate("insert into dochoithoitrang (id, ten, gia, xuatxu, soluong, soLuongConLai,  xuHuong) values('1205', 'Ba Lô Easy Go - Biệt Đội Khủng Long Xanh', 490000, 'Vietnam', 10, 10, 'Siêu anh hùng')");
                st.executeUpdate("insert into dochoithoitrang (id, ten, gia, xuatxu, soluong, soLuongConLai,  xuHuong) values('1206', 'Ba Lô Dây Rút - Joy', 250000, 'Vietnam', 10, 10, 'Siêu anh hùng')");
                st.executeUpdate("insert into dochoithoitrang (id, ten, gia, xuatxu, soluong, soLuongConLai,  xuHuong) values('1207', 'Túi Clever Note - Bold', 190000, 'Vietnam', 10, 10, 'Thể thao')");
                st.executeUpdate("insert into dochoithoitrang (id, ten, gia, xuatxu, soluong, soLuongConLai,  xuHuong) values('1208', 'Ba Lô Kỳ Lân Ngọt Ngào - Hồng', 490000, 'Vietnam', 10, 10, 'Thể thao')");
                st.executeUpdate("insert into dochoithoitrang (id, ten, gia, xuatxu, soluong, soLuongConLai,  xuHuong) values('1209', 'Ba Lô Nàng Cá Nhỏ - Xanh', 250000, 'Vietnam', 10, 10, 'Công nghệ')");
                st.executeUpdate("insert into dochoithoitrang (id, ten, gia, xuatxu, soluong, soLuongConLai,  xuHuong) values('1210', 'Túi Clever Note - Delight', 190000, 'Vietnam', 10, 10, 'Văn hóa')");
            }

            rs = st.executeQuery("SHOW TABLES LIKE 'dochoilapghep'");
            if (!rs.next()) {
                st.executeUpdate("create table dochoilapghep(id int primary key, ten varchar(200), gia decimal(10,0), xuatxu varchar(200), soluong int, soLuongConLai int, soManhGhep int, status int DEFAULT 1)");
                st.executeUpdate("insert into dochoilapghep (id, ten, gia, xuatxu, soluong, soLuongConLai,  soManhGhep) values('1301', 'Đồ chơi lắp ráp đường ray và xe chạy pin - set cứu hỏa VT55710A', 509000, 'Vietnam', 10, 10, 100)");
                st.executeUpdate("insert into dochoilapghep (id, ten, gia, xuatxu, soluong, soLuongConLai,  soManhGhep) values('1302', 'Bộ đồ chơi lắp ráp vecto diy 3 trong 1 - dòng xe vệ sinh VT2019', 279000, 'Vietnam', 10, 10, 120)");
                st.executeUpdate("insert into dochoilapghep (id, ten, gia, xuatxu, soluong, soLuongConLai,  soManhGhep) values('1303', 'Bộ đồ chơi lắp ráp vecto diy - xe xúc và phụ kiện OK1041', 120000, 'Vietnam', 10, 10, 150)");
                st.executeUpdate("insert into dochoilapghep (id, ten, gia, xuatxu, soluong, soLuongConLai,  soManhGhep) values('1304', 'Bộ đồ chơi lắp ráp vecto diy 3 trong 1 - xe cứu hỏa VT1072', 399000, 'Vietnam', 10, 10, 200)");
                st.executeUpdate("insert into dochoilapghep (id, ten, gia, xuatxu, soluong, soLuongConLai,  soManhGhep) values('1305', 'Đồ chơi lắp ráp vecto diy - xe tăng VT1073', 139000, 'Vietnam', 10, 10, 250)");
                st.executeUpdate("insert into dochoilapghep (id, ten, gia, xuatxu, soluong, soLuongConLai,  soManhGhep) values('1306', 'Hộp đồ chơi robot Iron Man Người Sắt nhảy múa có nhạc đèn 696-55', 490000, 'Vietnam', 10, 10, 300)");
                st.executeUpdate("insert into dochoilapghep (id, ten, gia, xuatxu, soluong, soLuongConLai,  soManhGhep) values('1307', 'Đồ chơi lắp ráp vecto diy - xe chở gỗ OK1013', 199000, 'Vietnam', 10, 10, 350)");
                st.executeUpdate("insert into dochoilapghep (id, ten, gia, xuatxu, soluong, soLuongConLai,  soManhGhep) values('1308', 'Combo mô hình 2023 new boy character action figure vol 2 CB-A2709559-4778', 519000, 'Vietnam', 10, 10, 400)");
                st.executeUpdate("insert into dochoilapghep (id, ten, gia, xuatxu, soluong, soLuongConLai,  soManhGhep) values('1309', 'Mô hình nhân vật converge kamen rider 25 A2638056-4778', 519000, 'Vietnam', 10, 10, 450)");
                st.executeUpdate("insert into dochoilapghep (id, ten, gia, xuatxu, soluong, soLuongConLai,  soManhGhep) values('1310', 'Đồ chơi lắp ráp gunpla HG machine rider 0230362', 519000, 'Vietnam', 10, 10, 500)");
            }

            rs = st.executeQuery("SHOW TABLES LIKE 'Robot'");
            if (!rs.next()) {
                st.executeUpdate("create table Robot(id int primary key, ten varchar(200), gia decimal(10,0), xuatxu varchar(200), soluong int, soLuongConLai int,  loaiRobot varchar(200), status int DEFAULT 1)");
                st.executeUpdate("insert into Robot (id, ten, gia, xuatxu, soluong, soLuongConLai,  loaiRobot) values('1401', 'Robot chú chó tinh nghịch', 509000, 'Vietnam', 10, 10, 'Dog')");
                st.executeUpdate("insert into Robot (id, ten, gia, xuatxu, soluong, soLuongConLai,  loaiRobot) values('1402', 'Robot mèo con thông thái', 509000, 'Vietnam', 10, 10, 'Cat')");
                st.executeUpdate("insert into Robot (id, ten, gia, xuatxu, soluong, soLuongConLai,  loaiRobot) values('1403', 'Robot tương lai xanh', 509000, 'Vietnam', 10, 10, 'Futuristic')");
                st.executeUpdate("insert into Robot (id, ten, gia, xuatxu, soluong, soLuongConLai,  loaiRobot) values('1404', 'Robot lăn lôn đỏ', 509000, 'Vietnam', 10, 10, 'Rolling')");
                st.executeUpdate("insert into Robot (id, ten, gia, xuatxu, soluong, soLuongConLai,  loaiRobot) values('1405', 'Robot tương lai đỏ', 509000, 'Vietnam', 10, 10, 'Futuristic')");
                st.executeUpdate("insert into Robot (id, ten, gia, xuatxu, soluong, soLuongConLai,  loaiRobot) values('1406', 'Chú robot quản gia thông thái đỏ', 599000, 'Vietnam', 10, 10, 'Butler')");
                st.executeUpdate("insert into Robot (id, ten, gia, xuatxu, soluong, soLuongConLai,  loaiRobot) values('1407', 'Robot lăn lôn trắng', 509000, 'Vietnam', 10, 10, 'Rolling')");
                st.executeUpdate("insert into Robot (id, ten, gia, xuatxu, soluong, soLuongConLai,  loaiRobot) values('1408', 'Chú robot quản gia thông thái xanh dương', 599000, 'Vietnam', 10, 10, 'Butler')");
                st.executeUpdate("insert into Robot (id, ten, gia, xuatxu, soluong, soLuongConLai,  loaiRobot) values('1409', 'Cú con Owleez học bay trắng', 509000, 'Vietnam', 10, 10, 'Owl')");
                st.executeUpdate("insert into Robot (id, ten, gia, xuatxu, soluong, soLuongConLai,  loaiRobot) values('1410', 'Xe điều khiển biến hình Mercedes-Benz đỏ', 509000, 'Vietnam', 10, 10, 'Transforming Car')");
            }

            rs = st.executeQuery("SHOW TABLES LIKE 'sanpham'");
            if (!rs.next()) {
                st.executeUpdate("create table sanpham(id int primary key, ten varchar(200), gia decimal(10,0), xuatxu varchar(200), soluong int, soLuongConLai int, status int DEFAULT 1)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1001', 'Đồ chơi xe công trình 3L 3LHGL888', 69000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1002', 'Đồ chơi xe công trình điều khiển 3L 3L3688-K72', 82500, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1003', 'Đồ chơi xe công trình LATOYS LA10368-8', 18000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1004', 'Đồ chơi lắp ráp xe công trình 3L 3LHL8610', 39500, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1005', 'Đồ chơi xe điều khiển 3L 3L6918-100', 119500, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1006', 'Đồ chơi xe tăng 3L 3LHY-169', 39000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1007', 'Đồ chơi xe công trình 3L 3LLY037F', 39000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1008', 'Đồ chơi xe hợp kim 3L 3L388-54C', 442000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1009', 'Đồ chơi xe bus 3L 3LBH668-3', 39000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1010', 'Đồ chơi xe công trình 3L 3L706-33', 39000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1101', 'Đồ chơi điện thoại cầm tay Doraemon', 190000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1102', 'Đồ chơi quạt Doremon 3 cánh quay tay', 190000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1103', 'Đồ chơi công chúa Elsa đầm nhựa xòe xoay 360 độ có đèn nhạc HX132', 250000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1104', 'Đồ chơi búa Thor StormBreaker bằng nhựa có nhạc đèn WL5023', 490000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1105', 'Hộp đồ chơi robot Iron Man Người Sắt nhảy múa có nhạc đèn 696-55', 490000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1106', 'Đồ chơi mô hình 4 siêu anh hùng Thor, Captain, Thanos, Iron có đèn B88614', 250000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1107', 'Hộp 20 bộ bài Pokemon 38 lá bộ bằng giấy cứng', 190000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1108', 'Đồ chơi Pikachu đánh trống vạn cốt bằng nhựa 3583-22A', 490000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1109', 'Đồ chơi điện thoại cầm tay Người Nhện dùng pin có nhạc 3701', 250000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1110', 'Đồ chơi Trư Bát Giới đánh trống vạn cốt bằng nhựa', 190000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1201', 'Bộ Dụng Cụ Màu Trang Trí Glitzy Spray', 190000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1202', 'Bộ Dụng Cụ Màu Trang Trí Glitzy Studio', 190000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1203', 'Bộ Dụng Cụ Màu Trang Trí Glitzy Neon', 250000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1204', 'Bộ Dụng Cụ Màu Trang Trí Cơ Bản Glitzy', 490000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1205', 'Ba Lô Easy Go - Biệt Đội Khủng Long Xanh', 490000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1206', 'Ba Lô Dây Rút - Joy', 250000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1207', 'Túi Clever Note - Bold', 190000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1208', 'Ba Lô Kỳ Lân Ngọt Ngào - Hồng', 490000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1209', 'Ba Lô Nàng Cá Nhỏ - Xanh', 250000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1210', 'Túi Clever Note - Delight', 190000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1301', 'Đồ chơi lắp ráp đường ray và xe chạy pin - set cứu hỏa VT55710A', 509000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1302', 'Bộ đồ chơi lắp ráp vecto diy 3 trong 1 - dòng xe vệ sinh VT2019', 279000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1303', 'Bộ đồ chơi lắp ráp vecto diy - xe xúc và phụ kiện OK1041', 120000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1304', 'Bộ đồ chơi lắp ráp vecto diy 3 trong 1 - xe cứu hỏa VT1072', 399000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1305', 'Đồ chơi lắp ráp vecto diy - xe tăng VT1073', 139000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1306', 'Hộp đồ chơi robot Iron Man Người Sắt nhảy múa có nhạc đèn 696-55', 490000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1307', 'Đồ chơi lắp ráp vecto diy - xe chở gỗ OK1013', 199000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1308', 'Combo mô hình 2023 new boy character action figure vol 2 CB-A2709559-4778', 519000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1309', 'Mô hình nhân vật converge kamen rider 25 A2638056-4778', 519000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1310', 'Đồ chơi lắp ráp gunpla HG machine rider 0230362', 519000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1401', 'Robot chú chó tinh nghịch', 509000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1402', 'Robot mèo con thông thái', 509000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1403', 'Robot tương lai xanh', 509000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1404', 'Robot lăn lôn đỏ', 509000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1405', 'Robot tương lai đỏ', 509000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1406', 'Chú robot quản gia thông thái đỏ', 599000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1407', 'Robot lăn lôn trắng', 509000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1408', 'Chú robot quản gia thông thái xanh dương', 599000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1409', 'Cú con Owleez học bay trắng', 509000, 'Vietnam', 10, 10)");
                st.executeUpdate("insert into sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai) values('1410', 'Xe điều khiển biến hình Mercedes-Benz đỏ', 509000, 'Vietnam', 10, 10)");
            }

            rs = st.executeQuery("SHOW TABLES LIKE 'nhanvien'");
            if (!rs.next()) {
                st.executeUpdate("CREATE TABLE nhanvien(id INT PRIMARY KEY, ten VARCHAR(200), tuoi INT, gioitinh VARCHAR(3), email VARCHAR(200), diaChi VARCHAR(200), sdt VARCHAR(10),vaiTro VARCHAR(20) DEFAULT 'Thu Ngan', status INT DEFAULT 1)");
                st.executeUpdate("insert into nhanvien (id,ten,tuoi,gioitinh,email,diaChi,sdt,vaiTro) values(1,'Quan Ly',20,'Nam','ad','Vietnam','12345','Quan Ly')");
                st.executeUpdate("insert into nhanvien (id,ten,tuoi,gioitinh,email,diaChi,sdt,vaiTro) values(2,'Nguyễn Ngọc Tuấn',20,'Nam', 'tuan','Vietnam','12345','Thu Ngan')");
                st.executeUpdate("insert into nhanvien (id,ten,tuoi,gioitinh,email,diaChi,sdt,vaiTro) values(3,'Nguyễn Hoàng Sang',20,'Nam', 'sang','Vietnam','12345','Thu Ngan')");
                st.executeUpdate("insert into nhanvien (id,ten,tuoi,gioitinh,email,diaChi,sdt,vaiTro) values(4,'Nguyễn Đại Quốc',20,'Nam', 'quoc','Vietnam','12345','Thu Ngan')");
                st.executeUpdate("insert into nhanvien (id,ten,tuoi,gioitinh,email,diaChi,sdt,vaiTro) values(5,'Đinh Phúc Thịnh',20,'Nam', 'thinh','Vietnam','12345','Thu Ngan')");
            }

            rs = st.executeQuery("SHOW TABLES LIKE 'khuyenmai'");
            if (!rs.next()) {
                st.executeUpdate("create table khuyenmai(id varchar(10) primary key, noiDung varchar(200), phanTramGiamGia decimal(5,2), status int DEFAULT 1)");
                st.executeUpdate("insert into khuyenmai (id, noiDung, phanTramGiamGia) values('KM01', 'Black Friday', 40.00)");
                st.executeUpdate("insert into khuyenmai (id, noiDung, phanTramGiamGia) values('KM02', 'Lễ Giáng Sinh', 20.00)");
                st.executeUpdate("insert into khuyenmai (id, noiDung, phanTramGiamGia) values('KM03', 'Tết Nguyên Đán', 25.00)");
            }

            rs = st.executeQuery("SHOW TABLES LIKE 'hoadon'");
            if (!rs.next()) {
                st.executeUpdate("create table hoadon(id int AUTO_INCREMENT primary key, idNhanVien varchar(20), idKhachHang varchar(20), soLuongCTHD int, idKhuyenMai int, tongTien double, ngayXuat Date, status int DEFAULT 1) AUTO_INCREMENT = 3000");
            }
            rs = st.executeQuery("SHOW TABLES LIKE 'cthd'");
            if (!rs.next()) {
                st.executeUpdate("create table cthd(idHoaDon int, idSanPham varchar(20), tenSanPham varchar(100), soLuong int, giaTien double, status int DEFAULT 1)");
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
