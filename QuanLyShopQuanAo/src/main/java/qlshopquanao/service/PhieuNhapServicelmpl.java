package qlshopquanao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlshopquanao.model.PhieuNhap;
import qlshopquanao.repository.PhieuNhapRepository;

@Service
public class PhieuNhapServicelmpl implements PhieuNhapService{
	
	@Autowired
	private PhieuNhapRepository PhieuNhapRepository;
	
	@Override
	public List<PhieuNhap> getAllPhieuNhap() {
		return PhieuNhapRepository.findAll();
	}

	@Override
	public void savePhieuNhap(PhieuNhap phieunhap) {
		this.PhieuNhapRepository.save(phieunhap);
		
	}

	@Override
	public PhieuNhap getPhieuNhapById(long maPN) {
		Optional<PhieuNhap> optional = PhieuNhapRepository.findById(maPN);
		PhieuNhap phieunhap = null;
		if (optional.isPresent()) {
			phieunhap = optional.get();
		}
		else 
		{
			throw new RuntimeException(" Không tìm thấy phiếu nhập với mã phiếu nhập: " + maPN);    
		}
		return phieunhap;
	}

	@Override
	public void deletePhieuNhapById(long maPN) {
		this.PhieuNhapRepository.deleteById(maPN);
	}

	@Override
	public List<PhieuNhap> getByKeyword(String keyword) {
		return PhieuNhapRepository.findByKeyword(keyword);
	}
}