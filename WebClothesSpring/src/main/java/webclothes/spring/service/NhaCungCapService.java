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
import webclothes.spring.model.SanPham;
import webclothes.spring.repository.NhaCungCapRepository;

@Service
public class NhaCungCapService{

	@Autowired
	private NhaCungCapRepository NhaCungCapRepository;

	public List<NhaCungCap> getAllNhaCungCap() {
		return NhaCungCapRepository.findAll();
	}

	public void saveNhaCungCap(NhaCungCap nhacungcap) {
		this.NhaCungCapRepository.save(nhacungcap);
	}

	public NhaCungCap getNhaCungCapById(long maNCC) {
		Optional<NhaCungCap> optional = NhaCungCapRepository.findById(maNCC);
		NhaCungCap nhacungcap = null;
		if (optional.isPresent()) {
			nhacungcap = optional.get();
		}
		else 
		{
			throw new RuntimeException(" Không tìm thấy nhà cung cấp với mã nhà cung cấp: " + maNCC);    
		}
		return nhacungcap;
	}

	public void deleteNhaCungCapById(long maNCC) {
		this.NhaCungCapRepository.deleteById(maNCC);
	}

	public List<NhaCungCap> getByKeyword(String keyword) {
		return NhaCungCapRepository.findByKeyword(keyword);
	}

	// Phân trang
	public Page<NhaCungCap> findPaginatedNhaCungCap(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
		Sort.by(sortField).descending(); 
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.NhaCungCapRepository.findAll(pageable);
	}
}
