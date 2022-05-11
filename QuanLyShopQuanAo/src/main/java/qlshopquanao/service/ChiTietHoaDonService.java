package qlshopquanao.service;

import java.util.List;

import qlshopquanao.model.ChiTietHoaDon;

public interface ChiTietHoaDonService {
	List<ChiTietHoaDon> getAllChiTietHoaDon();
	void saveChiTietHoaDon(ChiTietHoaDon ChiTietHoaDon);
	ChiTietHoaDon getChiTietHoaDonById(long maHD);
	void deleteChiTietHoaDonById(long maHD);
	List<ChiTietHoaDon> getByKeyword(String keyword);
}
