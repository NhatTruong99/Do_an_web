-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2022 at 06:42 PM
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

--
-- Dumping data for table `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MaHD`, `MaSP`, `SoLuong`, `DonGia`) VALUES
(1, 8, 5, 250000),
(2, 2, 1, 149000),
(2, 3, 1, 129000);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` int(10) NOT NULL,
  `SHD` varchar(100) NOT NULL,
  `NgayDat` date NOT NULL,
  `NgayGiao` date DEFAULT NULL,
  `DiaChiNhan` varchar(500) NOT NULL,
  `TinhTrang` varchar(20) NOT NULL,
  `MaKH` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `SHD`, `NgayDat`, `NgayGiao`, `DiaChiNhan`, `TinhTrang`, `MaKH`) VALUES
(1, 'HD2022060501', '2022-06-05', NULL, 'Khánh Hòa', 'Chưa xác nhận', 2),
(2, 'HD2022060502', '2022-06-05', NULL, 'Nha Trang - Khánh Hòa', 'Chưa xác nhận', 3);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` int(10) NOT NULL,
  `HoTen` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `SDT` varchar(15) NOT NULL,
  `DiaChi` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `HoTen`, `Email`, `SDT`, `DiaChi`) VALUES
(1, 'Trường', 'truong992001@gmail.com', '0356049424', 'Diên Lạc - Diên Khánh - Khánh Hòa'),
(2, 'Nhật Trường', 'truong992001@gmail.com', '0356049424', 'Diên Lạc - Diên Khánh - Khánh Hòa'),
(3, 'Thành Nhân', 'nhan@gmail.com', '0356669874', 'Nha Trang - Khánh Hòa');

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
  `MaQuyen` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `HoTen`, `Email`, `SDT`, `DiaChi`, `CMND`, `TaiKhoan`, `MatKhau`, `MaQuyen`) VALUES
(1, 'Nguyễn Nhật Trường', 'truong.nt.61cnttclc@ntu.edu.vn', 123456789, '............', '123456789', 'truong', '$2a$10$qw5AFYTuKFTw3ufQhTxb5.Z14AjtcOQSJwz6crvsKT1fe35wrt2TK', NULL),
(2, 'Nguyễn Thành Nhân', 'nhan1269180000@gmail.com', 896497728, 'Nha Trang', '123456789', 'nhan', '$2a$10$hG3W7pKVVabFpX1/5IuI7O5o/t4HneewrFDYI3rolxuJB/TdIsqri', NULL),
(3, 'Nguyễn Văn Thạch', 'thach.nv.61cnttclc@ntu.edu.vn', 123456789, 'Nha Trang', '123456', 'thach', '$2a$10$NxdQDoHSs6Dla8gE/Cx/zOuzP5EHTXMER/VOA.aFphguCDVIoPEBO', NULL),
(4, 'Nguyễn Hưng', 'hung.61cnttclc@ntu.edu.vn', 123456789, 'Nha Trang', '123456', 'hung', '$2a$10$NxdQDoHSs6Dla8gE/Cx/zOuzP5EHTXMER/VOA.aFphguCDVIoPEBO', NULL),
(5, 'Võ Tuấn Anh', 'tuananh2001@gmail.com', 123456, 'Nha Trang', '123', 'tuananh', '$2a$10$pyp0.xI0xz1MY3AARxaT6OO3PNOIwTvD6giamhu/KJ0We2E0dsxUa', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien_quyen`
--

CREATE TABLE `nhanvien_quyen` (
  `nhanvien_id` int(11) NOT NULL,
  `quyen_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien_quyen`
--

INSERT INTO `nhanvien_quyen` (`nhanvien_id`, `quyen_id`) VALUES
(1, 1),
(2, 2),
(3, 3);

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
(2, 'Editor'),
(3, 'User');

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
  `MaLoaiSP` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `TenSP`, `DacDiem`, `Anh`, `DonGia`, `GhiChu`, `MaLoaiSP`) VALUES
(1, 'Áo thun LocalBrand Cemmery \" SIGNATURE TEE 2.0 \"', 'Chất liệu vải : 100% PREMIUM COTTON co giãn 4 chiều thoáng mát. Công nghệ : In nổi cao cấp, bảo quản tốt khi giặt máy, không bong tróc phai màu.', 'spNo1.jpg', 159000, '', 2),
(2, 'Áo thun LocalBrand Cemmery ', 'Chất liệu vải : 100% PREMIUM COTTON co giãn 4 chiều thoáng mát. Công nghệ : In nổi cao cấp, bảo quản tốt khi giặt máy, không bong tróc phai màu.', 'spNo2.jpg', 149000, '', 2),
(3, 'Áo thun tay ngắn Local Brand \"TIDY SHIRT\"', 'Chất liệu : Lụa mềm mịn, siêu mát, thấm hút mồ hôi nhanh chống nhăn, đường may sắc sảo, chi tiết Công nghệ : Thêu bằng đường nét chắc chắn, bảo quản tốt khi giặt máy.', 'spNo3.jpg', 129000, '', 2),
(4, 'Áo sơ mi nam FEAER chất lụa họa tiết lá đen Boo Boo', 'Chất liệu: Lụa Twill chéo mềm mịn, thoáng mát - Hàng còn nguyên tem mác, cực sang chảnh (xem video trên ảnh sản phẩm). - Họa tiết sọc trắng đen Khách hàng phối Jeans, Kaki, Short đều đẹp. Mặc dạo phố, du lịch hay đến các buổi tiệc đều mang đến sự tự tin đẳng cấp dành cho khách hàng.', 'spNo4.jpg', 300000, '', 1),
(5, 'Áo sơ mi tay ngắn nam nữ form rộng sơ mi cổ ', 'Kiểu dáng : Thời trang unisex dành cho Nam và Nữ,( lớn hơn form thường ). Chất liệu : Lụa CNK 100%', 'spNo5.jpg', 200000, '', 1),
(6, 'Áo sơ mi nữ form rộng dài tay kiểu công sở', 'Chất liệu : Lụa Chéo Ý (Không nhăn, Dày Dặn, Thời trang )', 'spNo6.jpg', 230000, '', 1),
(7, 'Áo Khoác Bomber A - phong cách nam nữ chất nỉ bông cotton', 'Áo khoác BOMBER vải nỉ bông cotton, đẹp, không co rút, Hình in không bong tróc, đặc biệt không những giúp bạn giữ ấm trong mùa lạnh mà còn có thể chống nắng, chống gió, chống bụi, chống rét, chống tia UV cực tốt, rất tiện lợi.', 'spNo7.jpg', 350000, '', 3),
(8, 'Quần baggy kaki nam nữ Nasa - Kiểu quần ống rộng basic', '- Chất liệu: Kaki cao cấp - Mực in cao cấp không bong tróc, hình in sắc nét, không phai màu, không gây hại cho da. - Đường may chuẩn chỉnh, tỉ mỉ, chắc chắn.', 'spNo8.jpg', 250000, '', 5),
(9, 'Quần Short Đùi Trơn thể thao basic nam nữ oversize ', 'Hàng chuẩn N7 sản xuất, tem mác chuẩn chính hãng. - Chất liệu: Nỉ cotton - Đường may chuẩn chỉnh, tỉ mỉ, chắc chắn.', 'spNo9.jpg', 200000, '', 4),
(10, 'Quần short nam ROWAY Fullbox, vải Umi co giãn nhẹ ', 'Chất liệu:Umi co giãn nhẹ không nhăn form regular suông mặc thoải mái\r\n- Hàng còn nguyên tem mác, cực sang chảnh \r\n-Basic phối Sơ mi hay áo phông đều đẹp. Mặc dạo phố, du lịch hay đến các buổi tiệc đều mang đến sự tự tin đẳng cấp dành cho khách hàng.\r\n', 'spNo10.jpg', 170000, '', 4),
(11, 'Áo sơ mi nữ trắng form rộng đi học Basic Unisex ', 'Áo sơ mi nữ dáng rộng, chất sơ mi kate rất dày dặn, mềm tay, nói không với hàng niloong mỏng quẹt hoặc cứng đơ , dường may tỷ mỉ chắc chắn, cổ áo được dựng mếch cứng cáp , hàng về rất đẹp. ', 'spNo11.jpg', 80000, '', 1),
(12, 'Áo sơ mi basic chất kaki cao cấp Hàn Quốc', 'Chất liệu: Lụa Twill chéo mềm mịn, thoáng mát - Hàng còn nguyên tem mác, cực sang chảnh', 'spNo12.jpg', 150000, '', 1),
(13, 'Áo sơ mi cổ bèo tiểu thư tay phồng', 'Mẫu áo sơ mi đi học nữ màu trắng và may đường chỉ chắc chắn theo kiểu dáng trẻ trung, năng động cho các bạn học sinh cấp 3, 2, sinh viên mặc đi học, làm thực tập, mặc thoải vận động không lo bục chỉ.', 'spNo13.jpg', 99000, '', 1),
(14, 'Áo sơ mi cộc tay Pocket Local Brand ODIN CLUB', 'Chất liệu: Thun 100% Cotton cao cấp, thấm hút mồ hôi rất tốt, thoáng mát, bề mặt vải mịn, ko xù - Hình in Decal công nghệ Nhật Bản siêu bền, thân thiện với da người - Đường may tỉ mỉ, chắc chắn. ', 'spNo14.jpg', 250000, '', 1),
(15, 'Áo phông form rộng nam nữ unisex freesize', 'Chất liệu: 35% cotton, 65% spandex. Độ dày tiêu chuẩn, không xù lông, mềm mại cho làn da, cầm mát tay + From : Áo thun Free size nữ nam 70kg đổ lại ( cao < m72) + Kĩ thuật may: Sản xuất trên dây chuyền hiện đại số lượng lớn để tối ưu giá thành. + Áo dáng Unisex nam nữ đều mặc được ', 'spNo15.jpg', 99000, '', 2),
(16, 'Áo phông cotton tay lỡ dáng rộng unisex - AndMan freesize dành cho nam và nữ ', 'Chất liệu vải : 100% PREMIUM COTTON co giãn 4 chiều thoáng mát. Công nghệ : In nổi cao cấp, bảo quản tốt khi giặt máy, không bong tróc phai màu. ', 'spNo16.jpg', 89000, '', 2),
(17, 'Áo phông nam nữ unisex tay lỡ MRTD Morishopx ', '- Áo thun tay lỡ UNISEX_ Dành cho cả nam và nữ - Xuất xứ: Việt Nam - Chất liệu: thun Cotton MỀM- MỊN- MÁT, không mỏng, không xù lông, hình in chắc chắn - Free size dưới 70kg, dưới 1m7', 'spNo17.jpg', 180000, '', 2),
(18, 'Áo polo unisex có phối logo NKI trước ngực - Áo cổ bẻ chất cotton cá sấu mềm và mát', 'Chất liệu vải : 100% PREMIUM COTTON co giãn 4 chiều thoáng mát. Công nghệ : In nổi cao cấp, bảo quản tốt khi giặt máy, không bong tróc phai màu.  ', 'spNo18.jpg', 129000, '', 2),
(19, 'Áo khoác chất nỉ form rộng thoải mái dành cho nam nữ', 'ÁO KHOÁC NỈ được sản xuất từ vải nỉ ngoại cao cấp, không xù, không phai màu, không gây rát da - Chuẩn form, thoải mái, màu sắc trung, tôn dáng, phù hợp với mọi lứa tuổi - Sản phẩm thiết kế đa dạng, nhiều màu sắc, tạo sự khoẻ khoắn, cá tính cho người mặc', 'spNo19.jpg', 190000, '', 3),
(20, 'Áo Khoác Bomber Teelab Basic ', 'Chất liệu: Vải gió dù - Form: Cơ bản - Thiết kế: Hình Typhography In cán lụa cao cấp ', 'spNo20.jpg', 250000, '', 3),
(21, 'Áo khoác dù NEEDS OF WISDOM Aero Jacket ', 'Chuẩn form, thoải mái, màu sắc trung, tôn dáng, phù hợp với mọi lứa tuổi - Sản phẩm thiết kế đa dạng, nhiều màu sắc, tạo sự khoẻ khoắn, cá tính cho người mặc ', 'spNo21.jpg', 250000, '', 3),
(22, 'Áo khoác dù nam mẫu Hades Thêu Phản Quang unisex form rộng', 'Vải dù 2 lớp dày dặn hình thêu tỉ mỉ sắc nét phía trước, hình in chắc chắn phía sau không bong tróc, đi mưa nhẹ được - Phù hợp đi học, đi làm, đi chơi, xem phim, cf, hẹn hò thay đổi outfit hàng ngày của bạn - Đối tượng nam và nữ', 'spNo22.jpg', 190000, '', 3),
(23, 'Áo khoác Varsity Local brand ONTOP nam vải kaki - Mono Varsity Jacket màu đen ', 'Chuẩn form, thoải mái, màu sắc trung, tôn dáng, phù hợp với mọi lứa tuổi - Sản phẩm thiết kế đa dạng, nhiều màu sắc, tạo sự khoẻ khoắn, cá tính cho người mặc', 'spNo23.jpg', 360000, '', 3),
(24, 'Áo khoác bomber varsity jacket gió City Cycle', 'Kiểu dáng: Áo khoác varsity jacket kiểu dáng suông, form rộng oversize, thiết kế chun phối sọc ở cổ tay, cổ áo và gấu áo, được thêu 2 bên tay và dòng chữ trước ngực đánh dấu thương hiệu City Cycle. Chất liệu: Vải dù cao cấp Hàn Quốc mịn, chống nhăn', 'spNo24.jpg', 550000, '', 3),
(25, 'Quần shorts The Bad God Wash Plain', 'Chất liệu: Nỉ da cá hàng xuất xịn , thoáng mát, phù hợp khi đi chơi, hoạt động ngoài trời - Đường may tỉ mỉ chắc chắc - Thiết kế: hiện đại, trẻ trung, dễ phối, thích hợp cả cho hoạt động thể thao', 'spNo25.jpg', 180000, '', 4),
(26, 'Quần Short Nike Swoosh Logo', 'Chất liệu: Nỉ da cá hàng xuất xịn , thoáng mát, phù hợp khi đi chơi, hoạt động ngoài trời - Đường may tỉ mỉ chắc chắc - Thiết kế: hiện đại, trẻ trung, dễ phối, thích hợp cả cho hoạt động thể thao', 'spNo26.jpg', 95000, '', 4),
(27, 'Quần Short Nam Thể Thao Cạp Chun Sau MANDO  ', 'Chất liệu: Nỉ da cá hàng xuất xịn , thoáng mát, phù hợp khi đi chơi, hoạt động ngoài trời - Đường may tỉ mỉ chắc chắc - Thiết kế: hiện đại, trẻ trung, dễ phối, thích hợp cả cho hoạt động thể thao', 'spNo27.jpg', 279000, '', 4),
(28, 'Quần short nỉ cotton Essentials quần đùi nam nữ Unisex City Cycle', 'Kiểu dáng: Quần short nỉ cotton nam nữ Essentials là kiểu quần đùi ống rộng unisex,form rộng, dáng suông. Quần được in chữ City Cycle Essentials năng động trẻ trung.', 'spNo28.jpg', 149000, '', 4),
(29, 'Quần short nam vải tăm Hàn thoáng mát, quần sooc ngố trơn thương hiệu JBAGY ', 'Kiểu dáng: Quần short nỉ cotton nam nữ Essentials là kiểu quần đùi ống rộng unisex,form rộng, dáng suông. Quần được in chữ City Cycle Essentials năng động trẻ trung, cạp chun phối dây thắt có thể điều chỉnh độ rộng tạo cảm giác thoải mái', 'spNo29.jpg', 149000, '', 4),
(30, 'Quần thể thao nam ulzzang chất nỉ in phản quang, bo chân, mẫu quần nỉ thu đông ', 'Chất liệu: nỉ mềm - Thiết kế: form rộng, bo chân, dây rút, phối 3 sọc làm nổi bật chiếc quần - Đường may chuẩn xuất xứ việt nam - Dễ mặc với mọi đối tượng thích hợp đi chơi, du lịch, thể thao, hoạt động ngoài trời', 'spNo30.jpg', 399000, '', 5),
(31, 'Quần dài Polyester Trơn The Bad God', 'Chất liệu: Polyester cao cấp dày dặn, trơn bóng thoáng mát, bề mặt vải mịn, ko xù, ko gião - Đường may tỉ mỉ, chắc chắn - Công dụng: mặc ở nhà, mặc đi chơi hoặc khi vận động thể thao', 'spNo31.jpg', 199000, '', 5),
(32, 'Quần kaki unisex nam nữ form rộng chất nhung, ống rộng ', 'Chất liệu: nỉ mềm - Thiết kế: form rộng, bo chân, dây rút, phối 3 sọc làm nổi bật chiếc quần - Đường may chuẩn xuất xứ việt nam - Dễ mặc với mọi đối tượng thích hợp đi chơi, du lịch, thể thao, hoạt động ngoài trời.', 'spNo32.jpg', 300000, '', 5),
(33, 'Quần thun dài thể thao nam Hàn Quốc phối dây kéo cao cấp ', 'Chất liệu: Polyester cao cấp dày dặn, trơn bóng thoáng mát, bề mặt vải mịn, ko xù, ko gião - Đường may tỉ mỉ, chắc chắn - Công dụng: mặc ở nhà, mặc đi chơi hoặc khi vận động thể thao', 'spNo33.jpg', 179000, '', 5),
(34, 'Quần Thể Thao Ống Rộng Màu Sắc Đơn Giản Cho Nữ ', 'Chất liệu: Polyester cao cấp dày dặn, trơn bóng thoáng mát, bề mặt vải mịn, ko xù, ko gião - Đường may tỉ mỉ, chắc chắn - Công dụng: mặc ở nhà, mặc đi chơi hoặc khi vận động thể thao', 'spNo34.jpg', 165000, '', 5),
(35, 'Quần Ống Rộng Nam Nữ Unisex kiểu dáng thể thao Ulzzang', 'Chất liệu: Vải umi thể thao dày dặn, chất co dãn thoải mái, mát mẻ - Form quần rộng vô cùng thoải mái - Gấu quần kiểu lai tưa, có thể cắt gấu lên tùy ý thích mặc dài hay ngắn để phù hợp với chiều cao từng người', 'spNo35.jpg', 520000, '', 5);

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
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Indexes for table `nhanvien_quyen`
--
ALTER TABLE `nhanvien_quyen`
  ADD PRIMARY KEY (`nhanvien_id`,`quyen_id`),
  ADD KEY `FK_Quyen_NhanVien-Quyen` (`quyen_id`);

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
  ADD KEY `MaLoaiSP` (`MaLoaiSP`);

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
  MODIFY `MaKH` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `MaLoaiSP` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MaNV` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `quyen`
--
ALTER TABLE `quyen`
  MODIFY `MaQuyen` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MaSP` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `FK_ChiTietHoaDon_HoaDon` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_ChiTietHoaDon_SanPham` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FK_HoaDon_KhachHang` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `nhanvien_quyen`
--
ALTER TABLE `nhanvien_quyen`
  ADD CONSTRAINT `FK_NhanVien_NhanVien-Quyen` FOREIGN KEY (`nhanvien_id`) REFERENCES `nhanvien` (`MaNV`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Quyen_NhanVien-Quyen` FOREIGN KEY (`quyen_id`) REFERENCES `quyen` (`MaQuyen`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaLoaiSP`) REFERENCES `loaisanpham` (`MaLoaiSP`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
