package webclothes.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webclothes.spring.model.HoaDon;
import webclothes.spring.repository.HoaDonRepository;

@Service
public class HoaDonService{
	@Autowired
	private HoaDonRepository HoaDonRepository;
	

	public List<HoaDon> getAllHoaDon() {
		return HoaDonRepository.findAll();
	}

	public void saveHoaDon(HoaDon hoadon) {
		this.HoaDonRepository.save(hoadon);
		
	}


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

	public void deleteHoaDonById(long maHD) {
		this.HoaDonRepository.deleteById(maHD);
	}


	public List<HoaDon> getByKeyword(String keyword) {
		return HoaDonRepository.findByKeyword(keyword);
	}
}
