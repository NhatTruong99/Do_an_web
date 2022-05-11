-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 11, 2022 at 11:05 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.31

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

--
-- Dumping data for table `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MaHD`, `MaSP`, `SoLuong`, `DonGia`) VALUES
(1, 1, 3000, 20000),
(2, 2, 9, 30000);

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

--
-- Dumping data for table `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MaPN`, `MaSP`, `SoLuongNhap`, `DonGiaNhap`) VALUES
(1, 1, 3000, 30000),
(2, 2, 5, 20000);

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
(1, 'abc123', '2022-05-05', '2022-05-08', 'Nha Trang', 1, 1, 1);

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
(1, 'Nguyễn Văn Thạch', 'thach2001@gmail.com', 768686861, 'Nope'),
(5, 'Trần Minh Trọng', 'trong@gmail.com', 123456789, 'Nha Trang');

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
(1, 'Áo len'),
(4, 'Áo dài tay');

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
(2, '2022-05-15', 2, 1);

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
(1, 'Áo dài tay', 'Rẻ', 'aodaitay.jpg', 30000, 'Nope', 6, 4),
(2, 'Áo len', 'Rẻ', 'aolen.jpg', 100000, 'Nope', 1, 1);

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
(1, 'Size XXS', '...', '...'),
(2, 'Size XS', '...', '...'),
(3, 'Size S', '...', '...'),
(4, 'Size M', '...', '...'),
(5, 'Size L', '...', '...'),
(6, 'Size XL', '...', '...'),
(7, 'Size XXL', '...', '...');

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
  ADD KEY `FK_SanPham_Size` (`MaSize`);

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
  MODIFY `MaHD` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MaKH` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `MaLoaiSP` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
  MODIFY `MaSP` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `size`
--
ALTER TABLE `size`
  MODIFY `MaSize` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

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
  ADD CONSTRAINT `FK_SanPham_LoaiSP` FOREIGN KEY (`MaLoaiSP`) REFERENCES `loaisanpham` (`MaLoaiSP`),
  ADD CONSTRAINT `FK_SanPham_Size` FOREIGN KEY (`MaSize`) REFERENCES `size` (`MaSize`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
