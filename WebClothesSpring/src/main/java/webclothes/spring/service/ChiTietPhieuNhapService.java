package webclothes.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webclothes.spring.model.ChiTietPhieuNhap;
import webclothes.spring.repository.ChiTietPhieuNhapRepository;

@Service
public class ChiTietPhieuNhapService {
	@Autowired
	private ChiTietPhieuNhapRepository ChiTietPhieuNhapRepository;
	

	public List<ChiTietPhieuNhap> getAllChiTietPhieuNhap() {
		return ChiTietPhieuNhapRepository.findAll();
	}


	public void saveChiTietPhieuNhap(ChiTietPhieuNhap chitietphieunhap) {
		this.ChiTietPhieuNhapRepository.save(chitietphieunhap);
	}


	public ChiTietPhieuNhap getChiTietPhieuNhapById(long maPN) {
		Optional<ChiTietPhieuNhap> optional = ChiTietPhieuNhapRepository.findById(maPN);
		ChiTietPhieuNhap chitietphieunhap = null;
		if (optional.isPresent()) {
			chitietphieunhap = optional.get();
		}
		else 
		{
			throw new RuntimeException(" Không tìm thấy chi tiết phiếu nhập với mã phiếu nhập: " + maPN);    
		}
		return chitietphieunhap;
	}


	public void deleteChiTietPhieuNhapById(long maPN) {
		this.ChiTietPhieuNhapRepository.deleteById(maPN);
	}


	public List<ChiTietPhieuNhap> getByKeyword(String keyword) {
		return ChiTietPhieuNhapRepository.findByKeyword(keyword);
	}
}