-- Tạo bảng nguoidung
CREATE TABLE IF NOT EXISTS nguoidung (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vaiTro VARCHAR(50),
    ten VARCHAR(200),
    sdt VARCHAR(50),
    email VARCHAR(200),
    matKhau VARCHAR(50),
    diaChi VARCHAR(200),
    status INT DEFAULT 1
);

-- Thêm dữ liệu mẫu vào bảng nguoidung
INSERT INTO nguoidung (vaiTro, ten, sdt, email, matKhau, diaChi) VALUES
    ('QuanLy', 'Quan Ly', '12345', 'ad', 'admin', 'Vietnam'),
    ('Nhan Vien', 'Nguyễn Ngọc Tuấn', '123456', 'tuan', '090904', 'Vietnam'),
    ('Nhan Vien', 'Nguyễn Hoàng Sang', '123456', 'sang', '091204', 'Vietnam'),
    ('Nhan Vien', 'Nguyễn Đại Quốc', '123457', 'quoc', '230104', 'Vietnam'),
    ('Nhan Vien', 'Đinh Phúc Thịnh', '123458', 'thinh', '123456', 'Vietnam');

-- Tạo bảng khachhang
CREATE TABLE IF NOT EXISTS khachhang (
    id VARCHAR(10) PRIMARY KEY,
    ten VARCHAR(200),
    email VARCHAR(200),
    diaChi VARCHAR(200),
    sdt VARCHAR(50),
    status INT DEFAULT 1
);

-- Thêm dữ liệu mẫu vào bảng khachhang
INSERT INTO khachhang (id, ten, email, diaChi, sdt) VALUES
    ('KH01', 'Nguyen Van A', 'kh1@mail.com', 'Đường số 1 Vietnam', '0912345678'),
    ('KH02', 'Nguyen Van B', 'kh2@mail.com', 'Đường số 2 Vietnam', '0923456789'),
    ('KH03', 'Nguyen Van C', 'kh3@mail.com', 'Đường số 3 Vietnam', '0934567890'),
    ('KH04', 'Nguyen Van D', 'kh4@mail.com', 'Đường số 4 Vietnam', '0945678901'),
    ('KH05', 'Nguyen Van E', 'kh5@mail.com', 'Đường số 5 Vietnam', '0956789012'),
    ('KH06', 'Nguyen Van F', 'kh6@mail.com', 'Đường số 6 Vietnam', '0967890123'),
    ('KH07', 'Nguyen Van G', 'kh7@mail.com', 'Đường số 7 Vietnam', '0978901234'),
    ('KH08', 'Nguyen Van H', 'kh8@mail.com', 'Đường số 8 Vietnam', '0989012345'),
    ('KH09', 'Nguyen Van I', 'kh9@mail.com', 'Đường số 9 Vietnam', '0990123456'),
    ('KH10', 'Nguyen Van J', 'kh10@mail.com', 'Đường số 10 Vietnam', '0901234567');

-- Tạo bảng dochoiphuongtien
CREATE TABLE IF NOT EXISTS dochoiphuongtien (
    id INT PRIMARY KEY,
    ten VARCHAR(200),
    gia DECIMAL(10,2),
    xuatxu VARCHAR(200),
    soluong INT,
    soLuongConLai INT,
    loaiPhuongTien VARCHAR(200),
    status INT DEFAULT 1
);

-- Thêm dữ liệu mẫu vào bảng dochoiphuongtien
INSERT INTO dochoiphuongtien (id, ten, gia, xuatxu, soluong, soLuongConLai, loaiPhuongTien) VALUES
    ('1001', 'Đồ chơi xe công trình 3L 3LHGL888', 69000, 'Vietnam', 10, 10, 'xe công trình'),
    ('1002', 'Đồ chơi xe công trình điều khiển 3L 3L3688-K72', 82500, 'Vietnam', 10, 10, 'xe công trình'),
    ('1003', 'Đồ chơi xe công trình LATOYS LA10368-8', 18000, 'Vietnam', 10, 10, 'xe công trình'),
    ('1004', 'Đồ chơi lắp ráp xe công trình 3L 3LHL8610', 39500, 'Vietnam', 10, 10, 'xe lắp ráp'),
    ('1005', 'Đồ chơi xe điều khiển 3L 3L6918-100', 119500, 'Vietnam', 10, 10, 'xe điều khiển'),
    ('1006', 'Đồ chơi xe tăng 3L 3LHY-169', 39000, 'Vietnam', 10, 10, 'xe tăng'),
    ('1007', 'Đồ chơi xe công trình 3L 3LLY037F', 39000, 'Vietnam', 10, 10, 'xe công trình'),
    ('1008', 'Đồ chơi xe hợp kim 3L 3L388-54C', 442000, 'Vietnam', 10, 10, 'xe hợp kim'),
    ('1009', 'Đồ chơi xe bus 3L 3LBH668-3', 39000, 'Vietnam', 10, 10, 'xe bus'),
    ('1010', 'Đồ chơi xe công trình 3L 3L706-33', 39000, 'Vietnam', 10, 10, 'xe công trình');


-- Tạo bảng dochoitheophim
CREATE TABLE IF NOT EXISTS dochoitheophim (
    id INT PRIMARY KEY,
    ten VARCHAR(200),
    gia DECIMAL(10,0),
    xuatxu VARCHAR(200),
    soluong INT,
    soLuongConLai INT,
    tenPhim VARCHAR(200),
    status INT DEFAULT 1
);

-- Thêm dữ liệu mẫu vào bảng dochoitheophim
INSERT INTO dochoitheophim (id, ten, gia, xuatxu, soluong, soLuongConLai, tenPhim) VALUES
    ('1101', 'Đồ chơi điện thoại cầm tay Doraemon', 190000, 'Vietnam', 10, 10, 'Doraemon'),
    ('1102', 'Đồ chơi quạt Doremon 3 cánh quay tay', 190000, 'Vietnam', 10, 10, 'Doraemon'),
    ('1103', 'Đồ chơi công chúa Elsa đầm nhựa xòe xoay 360 độ có đèn nhạc HX132', 250000, 'Vietnam', 10, 10, 'Frozen'),
    ('1104', 'Đồ chơi búa Thor StormBreaker bằng nhựa có nhạc đèn WL5023', 490000, 'Vietnam', 10, 10, 'Avengers'),
    ('1105', 'Hộp đồ chơi robot Iron Man Người Sắt nhảy múa có nhạc đèn 696-55', 490000, 'Vietnam', 10, 10, 'Iron Man'),
     ('1106', 'Đồ chơi mô hình 4 siêu anh hùng Thor, Captain, Thanos, Iron có đèn B88614', 250000, 'Vietnam', 10, 10, 'Avengers'),
    ('1107', 'Hộp 20 bộ bài Pokemon 38 lá bộ bằng giấy cứng', 190000, 'Vietnam', 10, 10, 'Pokemon'),
    ('1108', 'Đồ chơi Pikachu đánh trống vạn cốt bằng nhựa 3583-22A', 490000, 'Vietnam', 10, 10, 'Pokemon'),
    ('1109', 'Đồ chơi điện thoại cầm tay Người Nhện dùng pin có nhạc 3701', 250000, 'Vietnam', 10, 10, 'Spider-Man'),
    ('1110', 'Đồ chơi Trư Bát Giới đánh trống vạn cốt bằng nhựa', 190000, 'Vietnam', 10, 10, 'Journey to the West');

-- Tạo bảng dochoithoitrang
CREATE TABLE IF NOT EXISTS dochoithoitrang (
    id INT PRIMARY KEY,
    ten VARCHAR(200),
    gia DECIMAL(10,0),
    xuatxu VARCHAR(200),
    soluong INT,
    soLuongConLai INT,
    xuHuong VARCHAR(200),
    status INT DEFAULT 1
);

-- Thêm dữ liệu mẫu vào bảng dochoithoitrang
INSERT INTO dochoithoitrang (id, ten, gia, xuatxu, soluong, soLuongConLai, xuHuong) VALUES
    ('1201', 'Bộ Dụng Cụ Màu Trang Trí Glitzy Spray', 190000, 'Vietnam', 10, 10, 'Công nghệ'),
    ('1202', 'Bộ Dụng Cụ Màu Trang Trí Glitzy Studio', 190000, 'Vietnam', 10, 10, 'Mùa hè'),
    ('1203', 'Bộ Dụng Cụ Màu Trang Trí Glitzy Neon', 250000, 'Vietnam', 10, 10, 'Cổ tích'),
    ('1204', 'Bộ Dụng Cụ Màu Trang Trí Cơ Bản Glitzy', 490000, 'Vietnam', 10, 10, 'Siêu anh hùng'),
    ('1205', 'Ba Lô Easy Go - Biệt Đội Khủng Long Xanh', 490000, 'Vietnam', 10, 10, 'Siêu anh hùng'),
    ('1206', 'Ba Lô Dây Rút - Joy', 250000, 'Vietnam', 10, 10, 'Siêu anh hùng'),
    ('1207', 'Túi Clever Note - Bold', 190000, 'Vietnam', 10, 10, 'Thể thao'),
    ('1208', 'Ba Lô Kỳ Lân Ngọt Ngào - Hồng', 490000, 'Vietnam', 10, 10, 'Thể thao'),
    ('1209', 'Ba Lô Nàng Cá Nhỏ - Xanh', 250000, 'Vietnam', 10, 10, 'Công nghệ'),
     ('1210', 'Túi Clever Note - Delight', 190000, 'Vietnam', 10, 10, 'Văn hóa');


-- Tạo bảng dochoilapghep
CREATE TABLE IF NOT EXISTS dochoilapghep (
    id INT PRIMARY KEY,
    ten VARCHAR(200),
    gia DECIMAL(10,0),
    xuatxu VARCHAR(200),
    soluong INT,
    soLuongConLai INT,
    soManhGhep INT,
    status INT DEFAULT 1
);

-- Thêm dữ liệu mẫu vào bảng dochoilapghep
INSERT INTO dochoilapghep (id, ten, gia, xuatxu, soluong, soLuongConLai, soManhGhep) VALUES
    ('1301', 'Đồ chơi lắp ráp đường ray và xe chạy pin - set cứu hỏa VT55710A', 509000, 'Vietnam', 10, 10, 100),
    ('1302', 'Bộ đồ chơi lắp ráp vecto diy 3 trong 1 - dòng xe vệ sinh VT2019', 279000, 'Vietnam', 10, 10, 120),
    ('1303', 'Bộ đồ chơi lắp ráp vecto diy - xe xúc và phụ kiện OK1041', 120000, 'Vietnam', 10, 10, 150),
     ('1304', 'Bộ đồ chơi lắp ráp vecto diy 3 trong 1 - xe cứu hỏa VT1072', 399000, 'Vietnam', 10, 10, 200),
    ('1305', 'Đồ chơi lắp ráp vecto diy - xe tăng VT1073', 139000, 'Vietnam', 10, 10, 250),
    ('1306', 'Hộp đồ chơi robot Iron Man Người Sắt nhảy múa có nhạc đèn 696-55', 490000, 'Vietnam', 10, 10, 300),
    ('1307', 'Đồ chơi lắp ráp vecto diy - xe chở gỗ OK1013', 199000, 'Vietnam', 10, 10, 350),
    ('1308', 'Combo mô hình 2023 new boy character action figure vol 2 CB-A2709559-4778', 519000, 'Vietnam', 10, 10, 400),
    ('1309', 'Mô hình nhân vật converge kamen rider 25 A2638056-4778', 519000, 'Vietnam', 10, 10, 450),
    ('1310', 'Đồ chơi lắp ráp gunpla HG machine rider 0230362', 519000, 'Vietnam', 10, 10, 500);


-- Tạo bảng Robot
CREATE TABLE IF NOT EXISTS Robot (
    id INT PRIMARY KEY,
    ten VARCHAR(200),
    gia DECIMAL(10,0),
    xuatxu VARCHAR(200),
    soluong INT,
    soLuongConLai INT,
    loaiRobot VARCHAR(200),
     status INT DEFAULT 1
);

-- Thêm dữ liệu mẫu vào bảng Robot
INSERT INTO Robot (id, ten, gia, xuatxu, soluong, soLuongConLai, loaiRobot) VALUES
    ('1401', 'Robot chú chó tinh nghịch', 509000, 'Vietnam', 10, 10, 'Dog'),
    ('1402', 'Robot mèo con thông thái', 509000, 'Vietnam', 10, 10, 'Cat'),
    ('1403', 'Robot tương lai xanh', 509000, 'Vietnam', 10, 10, 'Futuristic'),
    ('1404', 'Robot lăn lôn đỏ', 509000, 'Vietnam', 10, 10, 'Rolling'),
    ('1405', 'Robot tương lai đỏ', 509000, 'Vietnam', 10, 10, 'Futuristic'),
    ('1406', 'Chú robot quản gia thông thái đỏ', 599000, 'Vietnam', 10, 10, 'Butler'),
    ('1407', 'Robot lăn lôn trắng', 509000, 'Vietnam', 10, 10, 'Rolling'),
    ('1408', 'Chú robot quản gia thông thái xanh dương', 599000, 'Vietnam', 10, 10, 'Butler'),
    ('1409', 'Cú con Owleez học bay trắng', 509000, 'Vietnam', 10, 10, 'Owl'),
    ('1410', 'Xe điều khiển biến hình Mercedes-Benz đỏ', 509000, 'Vietnam', 10, 10, 'Transforming Car');
-- Tạo bảng sanpham
CREATE TABLE IF NOT EXISTS sanpham (
    id INT PRIMARY KEY,
    ten VARCHAR(200),
    gia DECIMAL(10,0),
    xuatxu VARCHAR(200),
    soluong INT,
    soLuongConLai INT,
      status INT DEFAULT 1
);

-- Thêm dữ liệu mẫu vào bảng sanpham
INSERT INTO sanpham (id, ten, gia, xuatxu, soluong, soLuongConLai)
SELECT id, ten, gia, xuatxu, soluong, soLuongConLai FROM dochoiphuongtien
UNION ALL
SELECT id, ten, gia, xuatxu, soluong, soLuongConLai FROM dochoitheophim
UNION ALL
SELECT id, ten, gia, xuatxu, soluong, soLuongConLai FROM dochoithoitrang
UNION ALL
SELECT id, ten, gia, xuatxu, soluong, soLuongConLai FROM dochoilapghep
UNION ALL
SELECT id, ten, gia, xuatxu, soluong, soLuongConLai FROM Robot;


-- Tạo bảng nhanvien
CREATE TABLE IF NOT EXISTS nhanvien (
    id INT PRIMARY KEY,
    ten VARCHAR(200),
    tuoi INT,
    gioitinh VARCHAR(3),
    email VARCHAR(200),
    diaChi VARCHAR(200),
    sdt VARCHAR(10),
    vaiTro VARCHAR(20) DEFAULT 'Thu Ngan',
    status INT DEFAULT 1
);

-- Thêm dữ liệu mẫu vào bảng nhanvien
INSERT INTO nhanvien (id, ten, tuoi, gioitinh, email, diaChi, sdt, vaiTro) VALUES
    (1,'Quan Ly',20,'Nam','ad','Vietnam','12345','Quan Ly'),
    (2,'Nguyễn Ngọc Tuấn',20,'Nam', 'tuan','Vietnam','12345','Thu Ngan'),
    (3,'Nguyễn Hoàng Sang',20,'Nam', 'sang','Vietnam','12345','Thu Ngan'),
    (4,'Nguyễn Đại Quốc',20,'Nam', 'quoc','Vietnam','12345','Thu Ngan'),
    (5,'Đinh Phúc Thịnh',20,'Nam', 'thinh','Vietnam','12345','Thu Ngan');
    
-- Tạo bảng khuyenmai
CREATE TABLE IF NOT EXISTS khuyenmai (
    id VARCHAR(10) PRIMARY KEY,
    noiDung VARCHAR(200),
    phanTramGiamGia DECIMAL(5,2),
     status INT DEFAULT 1
);

-- Thêm dữ liệu mẫu vào bảng khuyenmai
INSERT INTO khuyenmai (id, noiDung, phanTramGiamGia) VALUES
    ('KM01', 'Black Friday', 40.00),
    ('KM02', 'Lễ Giáng Sinh', 20.00),
    ('KM03', 'Tết Nguyên Đán', 25.00);

-- Tạo bảng hoadon
CREATE TABLE IF NOT EXISTS hoadon (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idNhanVien VARCHAR(20),
    idKhachHang VARCHAR(20),
    soLuongCTHD INT,
    idKhuyenMai VARCHAR(10),
    tongTien DOUBLE,
    ngayXuat DATE,
    status INT DEFAULT 1,
    FOREIGN KEY (idKhachHang) REFERENCES khachhang(id),
    FOREIGN KEY (idKhuyenMai) REFERENCES khuyenmai(id),
     FOREIGN KEY (idNhanVien) REFERENCES nhanvien(id)
) AUTO_INCREMENT = 3000;

-- Tạo bảng cthd
CREATE TABLE IF NOT EXISTS cthd (
    idHoaDon INT,
    idSanPham INT,
    tenSanPham VARCHAR(100),
    soLuong INT,
    giaTien DOUBLE,
    status INT DEFAULT 1,
    FOREIGN KEY (idHoaDon) REFERENCES hoadon(id),
    FOREIGN KEY (idSanPham) REFERENCES sanpham(id)
);