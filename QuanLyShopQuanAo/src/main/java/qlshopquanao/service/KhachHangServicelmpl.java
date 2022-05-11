package qlshopquanao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlshopquanao.model.KhachHang;
import qlshopquanao.repository.KhachHangRepository;

@Service
public class KhachHangServicelmpl implements KhachHangService {

	@Autowired
	private KhachHangRepository KhachHangRepository;
	
	@Override
	public List<KhachHang> getAllKhachHang() {
		return KhachHangRepository.findAll();
	}

	@Override
	public void saveKhachHang(KhachHang khachhang) {
		this.KhachHangRepository.save(khachhang);
		
	}

	@Override
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

	@Override
	public void deleteKhachHangById(long maKH) {
		this.KhachHangRepository.deleteById(maKH);
	}

	@Override
	public List<KhachHang> getByKeyword(String keyword) {
		return KhachHangRepository.findByKeyword(keyword);
	}

}
