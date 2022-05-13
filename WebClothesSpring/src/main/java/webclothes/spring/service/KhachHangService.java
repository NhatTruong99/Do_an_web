package webclothes.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webclothes.spring.model.KhachHang;
import webclothes.spring.repository.KhachHangRepository;

@Service
public class KhachHangService{

	@Autowired
	private KhachHangRepository KhachHangRepository;
	

	public List<KhachHang> getAllKhachHang() {
		return KhachHangRepository.findAll();
	}

	public void saveKhachHang(KhachHang khachhang) {
		this.KhachHangRepository.save(khachhang);
		
	}

	public KhachHang getKhachHangById(long maKH) {
		Optional<KhachHang> optional = KhachHangRepository.findById(maKH);
		KhachHang khachhang = null;
		if (optional.isPresent()) {
			khachhang = optional.get();
		}
		else 
		{
			throw new RuntimeException(" Không tìm thấy khách hàng với mã khách hàng: " + maKH);    
		}
		return khachhang;
	}

	public void deleteKhachHangById(long maKH) {
		this.KhachHangRepository.deleteById(maKH);
	}

	public List<KhachHang> getByKeyword(String keyword) {
		return KhachHangRepository.findByKeyword(keyword);
	}

}
