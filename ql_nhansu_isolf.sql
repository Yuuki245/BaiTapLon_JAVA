-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 16, 2025 lúc 04:58 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ql_nhansu_isolf`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `maNV` varchar(10) NOT NULL,
  `hoTen` varchar(100) DEFAULT NULL,
  `phongBan` varchar(50) DEFAULT NULL,
  `loaiNV` enum('HanhChanh','TiepThi','TruongPhong') DEFAULT NULL,
  `luongCoBan` double DEFAULT NULL,
  `doanhSo` double DEFAULT NULL,
  `hoaHong` double DEFAULT NULL,
  `luongTrachNhiem` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`maNV`, `hoTen`, `phongBan`, `loaiNV`, `luongCoBan`, `doanhSo`, `hoaHong`, `luongTrachNhiem`) VALUES
('NV001', 'Nguyen Van A', 'PB001', 'HanhChanh', 8000000, NULL, NULL, NULL),
('NV002', 'Pham Van D', 'PB004', 'HanhChanh', 8500000, NULL, NULL, NULL),
('NV003', 'Tran Thi G', 'PB004', 'HanhChanh', 9000000, NULL, NULL, NULL),
('NV008', 'Le Van H', 'PB001', 'HanhChanh', 8200000, NULL, NULL, NULL),
('NV009', 'Nguyen Thi I', 'PB002', 'TiepThi', 7800000, 45000000, 0.04, NULL),
('NV010', 'Tran Van K', 'PB003', 'TruongPhong', 11000000, NULL, NULL, 3500000),
('NV011', 'Pham Thi L', 'PB005', 'HanhChanh', 8700000, NULL, NULL, NULL),
('NV012', 'Hoang Van M', 'PB004', 'TiepThi', 8000000, 70000000, 0.05, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phongban`
--

CREATE TABLE `phongban` (
  `maPB` varchar(10) NOT NULL,
  `tenPB` varchar(100) DEFAULT NULL,
  `moTa` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phongban`
--

INSERT INTO `phongban` (`maPB`, `tenPB`, `moTa`) VALUES
('PB001', 'Phòng Nhân sự', 'Quản lý nhân sự công ty'),
('PB002', 'Phòng Marketing', 'Quản lý các chiến dịch quảng cáo'),
('PB003', 'Phòng Kỹ thuật', 'Phát triển sản phẩm'),
('PB004', 'Phòng Kế toán', 'Quản lý tài chính và lương thưởng'),
('PB005', 'Phòng Công nghệ', 'Phát triển phần mềm và hệ thống'),
('PB006', 'Phòng Hành chính', 'Hỗ trợ văn phòng và sự kiện');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sinhvien`
--

CREATE TABLE `sinhvien` (
  `maSV` varchar(10) NOT NULL,
  `hoTen` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `sdt` varchar(20) DEFAULT NULL,
  `cmnd` varchar(20) DEFAULT NULL,
  `phongThucTap` varchar(50) DEFAULT NULL,
  `diemDanhGia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sinhvien`
--

INSERT INTO `sinhvien` (`maSV`, `hoTen`, `email`, `sdt`, `cmnd`, `phongThucTap`, `diemDanhGia`) VALUES
('SV001', 'Pham Thi D', 'd@uneti.com', '0912345678', '123456789', 'PB001', 8.5),
('SV002', 'Hoang Van E', 'e@uneti.com', '0987654321', '987654321', 'PB002', 7.8),
('SV003', 'Le Thi H', 'h@uneti.com', '0931234567', '111222333', 'PB004', 9),
('SV004', 'Vu Van I', 'i@uneti.com', '0949876543', '444555666', 'PB005', 8),
('SV005', 'Do Thi K', 'k@uneti.com', '0923456789', '777888999', 'PB006', 7.5),
('SV006', 'Bui Van L', 'l@uneti.com', '0918765432', '123456000', 'PB004', 8.8);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` enum('Admin','HR','Intern') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`username`, `password`, `role`) VALUES
('admin', 'admin123', 'Admin'),
('admin2', 'admin456', 'Admin'),
('hr1', 'hr123', 'HR'),
('hr2', 'hr456', 'HR'),
('intern1', 'intern123', 'Intern'),
('intern2', 'intern456', 'Intern'),
('manager1', 'manager123', 'HR');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`maNV`);

--
-- Chỉ mục cho bảng `phongban`
--
ALTER TABLE `phongban`
  ADD PRIMARY KEY (`maPB`);

--
-- Chỉ mục cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`maSV`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
