package qlshopquanao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlshopquanao.model.KhachHang;
import qlshopquanao.model.LoaiSanPham;
import qlshopquanao.repository.LoaiSanPhamRepository;

@Service
public class LoaiSanPhamServicelmpl implements LoaiSanPhamService {

	
	@Autowired
	private LoaiSanPhamRepository LoaiSanPhamRepository;
	
	@Override
	public List<LoaiSanPham> getAllLoaiSanPham() {
		return LoaiSanPhamRepository.findAll();
	}

	@Override
	public void saveLoaiSanPham(LoaiSanPham loaisanpham) {
		this.LoaiSanPhamRepository.save(loaisanpham);
		
	}

	@Override
	public LoaiSanPham getLoaiSanPhamById(long maLoaiSP) {
		Optional<LoaiSanPham> optional = LoaiSanPhamRepository.findById(maLoaiSP);
		LoaiSanPham loaisanpham = null;
		if (optional.isPresent()) {
			loaisanpham = optional.get();
		}
		else 
		{
			throw new RuntimeException(" Không tìm thấy loại sản phẩm với mã loại sản phẩm: " + maLoaiSP);    
		}
		return loaisanpham;
	}

	@Override
	public void deleteLoaiSanPhamById(long maLoaiSP) {
		this.LoaiSanPhamRepository.deleteById(maLoaiSP);
	}

	@Override
	public List<LoaiSanPham> getByKeyword(String keyword) {
		return LoaiSanPhamRepository.findByKeyword(keyword);
	}

}
