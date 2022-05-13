package webclothes.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webclothes.spring.model.ChiTietHoaDon;
import webclothes.spring.repository.ChiTietHoaDonRepository;

@Service
public class ChiTietHoaDonService{
	@Autowired
	private ChiTietHoaDonRepository ChiTietHoaDonRepository;
	

	public List<ChiTietHoaDon> getAllChiTietHoaDon() {
		return ChiTietHoaDonRepository.findAll();
	}


	public void saveChiTietHoaDon(ChiTietHoaDon chitiethoadon) {
		this.ChiTietHoaDonRepository.save(chitiethoadon);
		
	}


	public ChiTietHoaDon getChiTietHoaDonById(long maHD) {
		Optional<ChiTietHoaDon> optional = ChiTietHoaDonRepository.findById(maHD);
		ChiTietHoaDon chitiethoadon = null;
		if (optional.isPresent()) {
			chitiethoadon = optional.get();
		}
		else 
		{
			throw new RuntimeException(" Không tìm thấy chi tiết hoá đơn với mã hoá đơn: " + maHD);    
		}
		return chitiethoadon;
	}


	public void deleteChiTietHoaDonById(long maHD) {
		this.ChiTietHoaDonRepository.deleteById(maHD);
	}


	public List<ChiTietHoaDon> getByKeyword(String keyword) {
		return ChiTietHoaDonRepository.findByKeyword(keyword);
	}
}
