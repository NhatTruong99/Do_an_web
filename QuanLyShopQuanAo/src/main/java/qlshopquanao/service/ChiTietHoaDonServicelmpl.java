package qlshopquanao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlshopquanao.model.ChiTietHoaDon;
import qlshopquanao.repository.ChiTietHoaDonRepository;

@Service
public class ChiTietHoaDonServicelmpl implements ChiTietHoaDonService {
	@Autowired
	private ChiTietHoaDonRepository ChiTietHoaDonRepository;
	
	@Override
	public List<ChiTietHoaDon> getAllChiTietHoaDon() {
		return ChiTietHoaDonRepository.findAll();
	}

	@Override
	public void saveChiTietHoaDon(ChiTietHoaDon chitiethoadon) {
		this.ChiTietHoaDonRepository.save(chitiethoadon);
		
	}

	@Override
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

	@Override
	public void deleteChiTietHoaDonById(long maHD) {
		this.ChiTietHoaDonRepository.deleteById(maHD);
	}

	@Override
	public List<ChiTietHoaDon> getByKeyword(String keyword) {
		return ChiTietHoaDonRepository.findByKeyword(keyword);
	}
}
