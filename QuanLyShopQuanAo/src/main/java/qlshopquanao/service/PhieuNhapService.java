package qlshopquanao.service;

import java.util.List;

import qlshopquanao.model.PhieuNhap;

public interface PhieuNhapService {
	List<PhieuNhap> getAllPhieuNhap();
	void savePhieuNhap(PhieuNhap phieunhap);
	PhieuNhap getPhieuNhapById(long maPN);
	void deletePhieuNhapById(long maPN);
	List<PhieuNhap> getByKeyword(String keyword);
}
