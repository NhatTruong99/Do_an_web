package qlshopquanao.service;

import java.util.List;

import qlshopquanao.model.ChiTietPhieuNhap;

public interface ChiTietPhieuNhapService {
	List<ChiTietPhieuNhap> getAllChiTietPhieuNhap();
	void saveChiTietPhieuNhap(ChiTietPhieuNhap ChiTietPhieuNhap);
	ChiTietPhieuNhap getChiTietPhieuNhapById(long maPN);
	void deleteChiTietPhieuNhapById(long maPN);
	List<ChiTietPhieuNhap> getByKeyword(String keyword);
}
