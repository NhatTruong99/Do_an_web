package qlshopquanao.service;

import java.util.List;

import qlshopquanao.model.Quyen;


public interface QuyenService {
	List<Quyen> getAllQuyen();
	void saveQuyen(Quyen quyen);
	Quyen getQuyenById(long maQuyen);
	void deleteQuyenById(long maQuyen);
	List<Quyen> getByKeyword(String keyword);
}
