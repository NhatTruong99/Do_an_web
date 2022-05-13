package webclothes.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webclothes.spring.model.NhanVien;
import webclothes.spring.repository.NhanVienRepository;

@Service
public class NhanVienService{
	
	@Autowired
	private NhanVienRepository NhanVienRepository;

	public List<NhanVien> getAllNhanVien() {
		return NhanVienRepository.findAll();
	}

	public void saveNhanVien(NhanVien nhanvien) {
		this.NhanVienRepository.save(nhanvien);
		
	}

	public NhanVien getNhanVienById(long maNV) {
		Optional<NhanVien> optional = NhanVienRepository.findById(maNV);
		NhanVien nhanvien = null;
		if (optional.isPresent()) {
			nhanvien = optional.get();
		}
		else 
		{
			throw new RuntimeException(" Không tìm thấy nhân viên với mã nhân viên: " + maNV);    
		}
		return nhanvien;
	}


	public void deleteNhanVienById(long maNV) {
		this.NhanVienRepository.deleteById(maNV);
	}

	public List<NhanVien> getByKeyword(String keyword) {
		return NhanVienRepository.findByKeyword(keyword);
	}
}
