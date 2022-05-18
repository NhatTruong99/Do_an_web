package webclothes.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webclothes.spring.model.SanPham;
import webclothes.spring.repository.SanPhamRepository;

@Service
public class SanPhamService {
	
	@Autowired
	private SanPhamRepository SanPhamRepository;

	public List<SanPham> getAllSanPham() {
		return SanPhamRepository.findAll();
	}

	public void saveSanPham(SanPham sanpham) {
		this.SanPhamRepository.save(sanpham);
		
	}

	public SanPham getSanPhamById(long maSP) {
		Optional<SanPham> optional = SanPhamRepository.findById(maSP);
		SanPham sanpham = null;
		if (optional.isPresent()) {
			sanpham = optional.get();
		}
		else 
		{
			throw new RuntimeException(" Không tìm thấy sản phẩm với mã sản phẩm: " + maSP);    
		}
		return sanpham;
	}

	public void deleteSanPhamById(long maSP) {
		this.SanPhamRepository.deleteById(maSP);
	}

	public List<SanPham> getByKeyword(String keyword) {
		return SanPhamRepository.findByKeyword(keyword);
	}
	
	public List<SanPham> getByCategoryID(long idCategory){
		return SanPhamRepository.findByCategoryID(idCategory);
	}
}
