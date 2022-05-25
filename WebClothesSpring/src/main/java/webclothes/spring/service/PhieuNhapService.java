package webclothes.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import webclothes.spring.model.NhaCungCap;
import webclothes.spring.model.PhieuNhap;
import webclothes.spring.repository.PhieuNhapRepository;

@Service
public class PhieuNhapService{
	
	@Autowired
	private PhieuNhapRepository PhieuNhapRepository;

	public List<PhieuNhap> getAllPhieuNhap() {
		return PhieuNhapRepository.findAll();
	}

	public void savePhieuNhap(PhieuNhap phieunhap) {
		this.PhieuNhapRepository.save(phieunhap);
		
	}


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

	public void deletePhieuNhapById(long maPN) {
		this.PhieuNhapRepository.deleteById(maPN);
	}

	public List<PhieuNhap> getByKeyword(String keyword) {
		return PhieuNhapRepository.findByKeyword(keyword);
	}
	
	// Phân trang
	public Page<PhieuNhap> findPaginatedPhieuNhap(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
		Sort.by(sortField).descending(); 
			
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.PhieuNhapRepository.findAll(pageable);
		}
}