package qlshopquanao.service;

import java.util.List;

import qlshopquanao.model.NhaCungCap;


public interface NhaCungCapService {
	List<NhaCungCap> getAllNhaCungCap();
	void saveNhaCungCap(NhaCungCap nhacungcap);
	NhaCungCap getNhaCungCapById(long maNCC);
	void deleteNhaCungCapById(long maNCC);
	List<NhaCungCap> getByKeyword(String keyword);
}
