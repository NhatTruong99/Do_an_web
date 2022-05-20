-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2022 at 09:42 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlyshopquanao`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHD` int(10) NOT NULL,
  `MaSP` int(10) NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `DonGia` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MaPN` int(10) NOT NULL,
  `MaSP` int(10) NOT NULL,
  `SoLuongNhap` int(10) NOT NULL,
  `DonGiaNhap` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` int(10) NOT NULL,
  `SHD` varchar(100) NOT NULL,
  `NgayDat` date NOT NULL,
  `NgayGiao` date NOT NULL,
  `DiaChiNhan` varchar(500) NOT NULL,
  `TinhTrang` tinyint(1) NOT NULL,
  `DaThanhToan` tinyint(1) NOT NULL,
  `MaKH` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `SHD`, `NgayDat`, `NgayGiao`, `DiaChiNhan`, `TinhTrang`, `DaThanhToan`, `MaKH`) VALUES
(1, 'abc123', '2022-05-05', '2022-05-10', 'Nha Trang', 0, 1, 1),
(2, '2', '2022-05-05', '2022-05-08', '123', 1, 1, 1),
(3, '123', '2022-05-03', '2022-05-03', '123', 1, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` int(10) NOT NULL,
  `HoTen` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `SDT` int(15) NOT NULL,
  `DiaChi` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `HoTen`, `Email`, `SDT`, `DiaChi`) VALUES
(1, 'Nguyễn Văn Thạch', 'thach2001@gmail.com', 768686861, 'Nope123'),
(2, 'Trần Minh Trọng', 'trong@gmail.com', 123456789, 'Nha Trang');

-- --------------------------------------------------------

--
-- Table structure for table `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `MaLoaiSP` int(10) NOT NULL,
  `TenLoaiSP` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loaisanpham`
--

INSERT INTO `loaisanpham` (`MaLoaiSP`, `TenLoaiSP`) VALUES
(1, 'Áo sơ mi'),
(2, 'Áo thun'),
(3, 'Áo khoác'),
(4, 'Quần short'),
(5, 'Quần dài');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` int(10) NOT NULL,
  `TenNCC` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`) VALUES
(1, 'ABC'),
(2, 'accc');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` int(10) NOT NULL,
  `HoTen` varchar(100) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `SDT` int(15) NOT NULL,
  `DiaChi` varchar(500) NOT NULL,
  `CMND` varchar(12) NOT NULL,
  `TaiKhoan` varchar(150) NOT NULL,
  `MatKhau` varchar(150) NOT NULL,
  `MaQuyen` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `HoTen`, `Email`, `SDT`, `DiaChi`, `CMND`, `TaiKhoan`, `MatKhau`, `MaQuyen`) VALUES
(1, 'Nguyễn Nhật Trường', 'truong.nt.61cnttclc@ntu.edu.vn', 123456789, '............', '123456789', 'truong', '123', 1),
(2, 'Nguyễn Thành Nhân', 'nhan.nt.61cnttclc@ntu.edu.vn', 896497728, '............', '734 đường 2/', 'nhan', '123', 2);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPN` int(10) NOT NULL,
  `NgayNhap` date NOT NULL,
  `MaNV` int(10) NOT NULL,
  `MaNCC` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`MaPN`, `NgayNhap`, `MaNV`, `MaNCC`) VALUES
(1, '2022-05-06', 1, 1),
(2, '2022-05-15', 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `quyen`
--

CREATE TABLE `quyen` (
  `MaQuyen` int(10) NOT NULL,
  `TenQuyen` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `quyen`
--

INSERT INTO `quyen` (`MaQuyen`, `TenQuyen`) VALUES
(1, 'Admin'),
(2, 'User');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSP` int(10) NOT NULL,
  `TenSP` varchar(150) NOT NULL,
  `DacDiem` varchar(500) NOT NULL,
  `Anh` varchar(500) NOT NULL,
  `DonGia` int(50) NOT NULL,
  `GhiChu` varchar(200) NOT NULL,
  `MaSize` int(10) NOT NULL,
  `MaLoaiSP` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `TenSP`, `DacDiem`, `Anh`, `DonGia`, `GhiChu`, `MaSize`, `MaLoaiSP`) VALUES
(1, 'Áo thun LocalBrand Cemmery \" SIGNATURE TEE 2.0 \"', 'Chất liệu vải : 100% PREMIUM COTTON co giãn 4 chiều thoáng mát. Công nghệ : In nổi cao cấp, bảo quản tốt khi giặt máy, không bong tróc phai màu.', 'spNo1.jpg', 159000, '', 2, 2),
(2, 'Áo thun LocalBrand Cemmery ', 'Chất liệu vải : 100% PREMIUM COTTON co giãn 4 chiều thoáng mát. Công nghệ : In nổi cao cấp, bảo quản tốt khi giặt máy, không bong tróc phai màu.', 'spNo2.jpg', 149000, '', 2, 2),
(3, 'Áo thun tay ngắn Local Brand \"TIDY SHIRT\"', 'Chất liệu : Lụa mềm mịn, siêu mát, thấm hút mồ hôi nhanh chống nhăn, đường may sắc sảo, chi tiết Công nghệ : Thêu bằng đường nét chắc chắn, bảo quản tốt khi giặt máy.', 'spNo3.jpg', 129000, '', 3, 2),
(4, 'Áo sơ mi nam FEAER chất lụa họa tiết lá đen Boo Boo', 'Chất liệu: Lụa Twill chéo mềm mịn, thoáng mát - Hàng còn nguyên tem mác, cực sang chảnh (xem video trên ảnh sản phẩm). - Họa tiết sọc trắng đen Khách hàng phối Jeans, Kaki, Short đều đẹp. Mặc dạo phố, du lịch hay đến các buổi tiệc đều mang đến sự tự tin đẳng cấp dành cho khách hàng.', 'spNo4.jpg', 300000, '', 3, 1),
(5, 'Áo sơ mi tay ngắn nam nữ form rộng sơ mi cổ ', 'Kiểu dáng : Thời trang unisex dành cho Nam và Nữ,( lớn hơn form thường ). Chất liệu : Lụa CNK 100%', 'spNo5.jpg', 200000, '', 2, 1),
(6, 'Áo sơ mi nữ form rộng dài tay kiểu công sở', 'Chất liệu : Lụa Chéo Ý (Không nhăn, Dày Dặn, Thời trang )', 'spNo6.jpg', 230000, '', 2, 1),
(7, 'Áo Khoác Bomber A - phong cách nam nữ chất nỉ bông cotton', 'Áo khoác BOMBER vải nỉ bông cotton, đẹp, không co rút, Hình in không bong tróc, đặc biệt không những giúp bạn giữ ấm trong mùa lạnh mà còn có thể chống nắng, chống gió, chống bụi, chống rét, chống tia UV cực tốt, rất tiện lợi.', 'spNo7.jpg', 350000, '', 3, 3),
(8, 'Quần baggy kaki nam nữ Nasa - Kiểu quần ống rộng basic', '- Chất liệu: Kaki cao cấp - Mực in cao cấp không bong tróc, hình in sắc nét, không phai màu, không gây hại cho da. - Đường may chuẩn chỉnh, tỉ mỉ, chắc chắn.', 'spNo8.jpg', 250000, '', 1, 5),
(9, 'Quần Short Đùi Trơn thể thao basic nam nữ oversize ', 'Hàng chuẩn N7 sản xuất, tem mác chuẩn chính hãng. - Chất liệu: Nỉ cotton - Đường may chuẩn chỉnh, tỉ mỉ, chắc chắn.', 'spNo9.jpg', 200000, '', 2, 4),
(10, 'Quần short nam ROWAY Fullbox, vải Umi co giãn nhẹ ', 'Chất liệu:Umi co giãn nhẹ không nhăn form regular suông mặc thoải mái\r\n- Hàng còn nguyên tem mác, cực sang chảnh \r\n-Basic phối Sơ mi hay áo phông đều đẹp. Mặc dạo phố, du lịch hay đến các buổi tiệc đều mang đến sự tự tin đẳng cấp dành cho khách hàng.\r\n', 'spNo10.jpg', 170000, '', 4, 4);

-- --------------------------------------------------------

--
-- Table structure for table `size`
--

CREATE TABLE `size` (
  `MaSize` int(10) NOT NULL,
  `TenSize` varchar(20) NOT NULL,
  `ChieuCao` varchar(100) NOT NULL,
  `CanNang` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `size`
--

INSERT INTO `size` (`MaSize`, `TenSize`, `ChieuCao`, `CanNang`) VALUES
(1, 'Size S', '1M40 - 1M45', '38 - 41'),
(2, 'Size M', '1M45 - 1M50', '41 - 45'),
(3, 'Size L', '1M50 - 1M60', '46 - 53'),
(4, 'Size XL', '1M60 - 1M70', '53 - 62');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MaHD`,`MaSP`),
  ADD KEY `FK_ChiTietHoaDon_SanPham` (`MaSP`);

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`MaPN`,`MaSP`),
  ADD KEY `FK_ChiTietPhieuNhap_SanPham` (`MaSP`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `FK_HoaDon_KhachHang` (`MaKH`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Indexes for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`MaLoaiSP`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`),
  ADD KEY `FK_NhanVien_Quyen` (`MaQuyen`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPN`),
  ADD KEY `FK_PhieuNhap_NhanVien` (`MaNV`),
  ADD KEY `FK_PhieuNhap_NhaCungCap` (`MaNCC`);

--
-- Indexes for table `quyen`
--
ALTER TABLE `quyen`
  ADD PRIMARY KEY (`MaQuyen`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `FK_SanPham_LoaiSP` (`MaLoaiSP`),
  ADD KEY `FK_SanPham_Size` (`MaSize`),
  ADD KEY `MaLoaiSP` (`MaLoaiSP`),
  ADD KEY `MaSize` (`MaSize`),
  ADD KEY `MaSize_2` (`MaSize`);

--
-- Indexes for table `size`
--
ALTER TABLE `size`
  ADD PRIMARY KEY (`MaSize`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MaHD` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MaKH` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `MaLoaiSP` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `MaNCC` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MaNV` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `MaPN` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `quyen`
--
ALTER TABLE `quyen`
  MODIFY `MaQuyen` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MaSP` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `size`
--
ALTER TABLE `size`
  MODIFY `MaSize` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `FK_ChiTietHoaDon_SanPham` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `FK_ChiTietPhieuNhap_SanPham` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FK_HoaDon_KhachHang` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `FK_NhanVien_Quyen` FOREIGN KEY (`MaQuyen`) REFERENCES `quyen` (`MaQuyen`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `FK_PhieuNhap_NhaCungCap` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_PhieuNhap_NhanVien` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaLoaiSP`) REFERENCES `loaisanpham` (`MaLoaiSP`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sanpham_ibfk_2` FOREIGN KEY (`MaSize`) REFERENCES `size` (`MaSize`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
