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
import webclothes.spring.model.Size;
import webclothes.spring.model.Size;
import webclothes.spring.repository.SizeRepository;

@Service
public class SizeService{

	@Autowired
	private SizeRepository SizeRepository;

	public List<Size> getAllSize() {
		return SizeRepository.findAll();
	}


	public void saveSize(Size size) {
		this.SizeRepository.save(size);
	}


	public Size getSizeById(long maSize) {
		Optional<Size> optional = SizeRepository.findById(maSize);
		Size size = null;
		if (optional.isPresent()) {
			size = optional.get();
		}
		else 
		{
			throw new RuntimeException(" Không tìm size với mã size: " + maSize);    
		}
		return size;
	}

	public void deleteSizeById(long maSize) {
		this.SizeRepository.deleteById(maSize);
	}

	public List<Size> getByKeyword(String keyword) {
		return SizeRepository.findByKeyword(keyword);
	}
	
	// Phân trang
		public Page<Size> findPaginatedSize(int pageNo, int pageSize, String sortField, String sortDirection) {
			Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending(); 
			
			Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
			return this.SizeRepository.findAll(pageable);
		}

}
