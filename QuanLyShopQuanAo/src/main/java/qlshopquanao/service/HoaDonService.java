package qlshopquanao.service;

import java.util.List;

import qlshopquanao.model.HoaDon;

public interface HoaDonService {
	List<HoaDon> getAllHoaDon();
	void saveHoaDon(HoaDon HoaDon);
	HoaDon getHoaDonById(long maHD);
	void deleteHoaDonById(long maHD);
	List<HoaDon> getByKeyword(String keyword);
}
