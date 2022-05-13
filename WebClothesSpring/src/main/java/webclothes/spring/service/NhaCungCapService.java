package webclothes.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webclothes.spring.model.NhaCungCap;
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

}
