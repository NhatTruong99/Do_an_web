package qlshopquanao.service;

import java.util.List;

import qlshopquanao.model.SanPham;

public interface SanPhamService {
	List<SanPham> getAllSanPham();
	void saveSanPham(SanPham sanpham);
	SanPham getSanPhamById(long maSP);
	void deleteSanPhamById(long maSP);
	List<SanPham> getByKeyword(String keyword);
}
