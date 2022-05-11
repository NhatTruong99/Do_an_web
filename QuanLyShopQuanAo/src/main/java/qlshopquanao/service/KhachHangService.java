package qlshopquanao.service;

import java.util.List;

import qlshopquanao.model.KhachHang;

public interface KhachHangService {
	List<KhachHang> getAllKhachHang();
	void saveKhachHang(KhachHang khachhang);
	KhachHang getKhachHangById(long maKH);
	void deleteKhachHangById(long maKH);
	List<KhachHang> getByKeyword(String keyword);
}
