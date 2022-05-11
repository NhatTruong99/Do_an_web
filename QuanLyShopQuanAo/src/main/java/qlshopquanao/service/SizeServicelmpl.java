package qlshopquanao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlshopquanao.model.Size;
import qlshopquanao.model.Size;
import qlshopquanao.repository.SizeRepository;

@Service
public class SizeServicelmpl implements SizeService{

	@Autowired
	private SizeRepository SizeRepository;
	
	@Override
	public List<Size> getAllSize() {
		return SizeRepository.findAll();
	}

	@Override
	public void saveSize(Size size) {
		this.SizeRepository.save(size);
	}

	@Override
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

	@Override
	public void deleteSizeById(long maSize) {
		this.SizeRepository.deleteById(maSize);
	}

	@Override
	public List<Size> getByKeyword(String keyword) {
		return SizeRepository.findByKeyword(keyword);
	}

}
