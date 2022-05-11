package qlshopquanao.service;

import java.util.List;

import qlshopquanao.model.Size;
public interface SizeService {
	List<Size> getAllSize();
	void saveSize(Size size);
	Size getSizeById(long maSize);
	void deleteSizeById(long maSize);
	List<Size> getByKeyword(String keyword);
}
