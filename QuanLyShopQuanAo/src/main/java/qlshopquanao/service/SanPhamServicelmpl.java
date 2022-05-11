package qlshopquanao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlshopquanao.model.SanPham;
import qlshopquanao.repository.SanPhamRepository;

@Service
public class SanPhamServicelmpl implements SanPhamService {
	
	@Autowired
	private SanPhamRepository SanPhamRepository;
	
	@Override
	public List<SanPham> getAllSanPham() {
		return SanPhamRepository.findAll();
	}

	@Override
	public void saveSanPham(SanPham sanpham) {
		this.SanPhamRepository.save(sanpham);
		
	}

	@Override
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

	@Override
	public void deleteSanPhamById(long maSP) {
		this.SanPhamRepository.deleteById(maSP);
	}

	@Override
	public List<SanPham> getByKeyword(String keyword) {
		return SanPhamRepository.findByKeyword(keyword);
	}
}
