package qlshopquanao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlshopquanao.model.NhanVien;
import qlshopquanao.repository.NhanVienRepository;

@Service
public class NhanVienServicelmpl implements NhanVienService {
	
	@Autowired
	private NhanVienRepository NhanVienRepository;
	
	@Override
	public List<NhanVien> getAllNhanVien() {
		return NhanVienRepository.findAll();
	}

	@Override
	public void saveNhanVien(NhanVien nhanvien) {
		this.NhanVienRepository.save(nhanvien);
		
	}

	@Override
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

	@Override
	public void deleteNhanVienById(long maNV) {
		this.NhanVienRepository.deleteById(maNV);
	}

	@Override
	public List<NhanVien> getByKeyword(String keyword) {
		return NhanVienRepository.findByKeyword(keyword);
	}
}
