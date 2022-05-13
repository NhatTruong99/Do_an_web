package webclothes.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webclothes.spring.model.KhachHang;
import webclothes.spring.model.LoaiSanPham;
import webclothes.spring.repository.LoaiSanPhamRepository;

@Service
public class LoaiSanPhamService{

	
	@Autowired
	private LoaiSanPhamRepository LoaiSanPhamRepository;

	public List<LoaiSanPham> getAllLoaiSanPham() {
		return LoaiSanPhamRepository.findAll();
	}

	public void saveLoaiSanPham(LoaiSanPham loaisanpham) {
		this.LoaiSanPhamRepository.save(loaisanpham);
		
	}


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


	public void deleteLoaiSanPhamById(long maLoaiSP) {
		this.LoaiSanPhamRepository.deleteById(maLoaiSP);
	}

	public List<LoaiSanPham> getByKeyword(String keyword) {
		return LoaiSanPhamRepository.findByKeyword(keyword);
	}

}
