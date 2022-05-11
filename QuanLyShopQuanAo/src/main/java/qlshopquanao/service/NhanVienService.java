package qlshopquanao.service;

import java.util.List;

import qlshopquanao.model.NhanVien;


public interface NhanVienService {
	List<NhanVien> getAllNhanVien();
	void saveNhanVien(NhanVien nhanvien);
	NhanVien getNhanVienById(long maNV);
	void deleteNhanVienById(long maNV);
	List<NhanVien> getByKeyword(String keyword);
}
