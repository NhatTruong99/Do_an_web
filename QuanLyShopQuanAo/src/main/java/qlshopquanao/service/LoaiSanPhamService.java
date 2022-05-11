package qlshopquanao.service;

import java.util.List;

import qlshopquanao.model.LoaiSanPham;


public interface LoaiSanPhamService {
	List<LoaiSanPham> getAllLoaiSanPham();
	void saveLoaiSanPham(LoaiSanPham loaisanpham);
	LoaiSanPham getLoaiSanPhamById(long maLoaiSP);
	void deleteLoaiSanPhamById(long maLoaiSP);
	List<LoaiSanPham> getByKeyword(String keyword);
}
