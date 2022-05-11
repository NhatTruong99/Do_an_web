package qlshopquanao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlshopquanao.model.ChiTietPhieuNhap;
import qlshopquanao.repository.ChiTietPhieuNhapRepository;

@Service
public class ChiTietPhieuNhapServicelmpl implements ChiTietPhieuNhapService {
	@Autowired
	private ChiTietPhieuNhapRepository ChiTietPhieuNhapRepository;
	
	@Override
	public List<ChiTietPhieuNhap> getAllChiTietPhieuNhap() {
		return ChiTietPhieuNhapRepository.findAll();
	}

	@Override
	public void saveChiTietPhieuNhap(ChiTietPhieuNhap chitietphieunhap) {
		this.ChiTietPhieuNhapRepository.save(chitietphieunhap);
	}

	@Override
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

	@Override
	public void deleteChiTietPhieuNhapById(long maPN) {
		this.ChiTietPhieuNhapRepository.deleteById(maPN);
	}

	@Override
	public List<ChiTietPhieuNhap> getByKeyword(String keyword) {
		return ChiTietPhieuNhapRepository.findByKeyword(keyword);
	}
}
