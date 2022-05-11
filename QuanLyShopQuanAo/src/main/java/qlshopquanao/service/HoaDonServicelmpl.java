package qlshopquanao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlshopquanao.model.HoaDon;
import qlshopquanao.repository.HoaDonRepository;

@Service
public class HoaDonServicelmpl implements HoaDonService{
	@Autowired
	private HoaDonRepository HoaDonRepository;
	
	@Override
	public List<HoaDon> getAllHoaDon() {
		return HoaDonRepository.findAll();
	}

	@Override
	public void saveHoaDon(HoaDon hoadon) {
		this.HoaDonRepository.save(hoadon);
		
	}

	@Override
	public HoaDon getHoaDonById(long maHD) {
		Optional<HoaDon> optional = HoaDonRepository.findById(maHD);
		HoaDon hoadon = null;
		if (optional.isPresent()) {
			hoadon = optional.get();
		}
		else 
		{
			throw new RuntimeException(" Không tìm thấy hoá dơn với mã hoá đơn: " + maHD);    
		}
		return hoadon;
	}

	@Override
	public void deleteHoaDonById(long maHD) {
		this.HoaDonRepository.deleteById(maHD);
	}

	@Override
	public List<HoaDon> getByKeyword(String keyword) {
		return HoaDonRepository.findByKeyword(keyword);
	}
}
