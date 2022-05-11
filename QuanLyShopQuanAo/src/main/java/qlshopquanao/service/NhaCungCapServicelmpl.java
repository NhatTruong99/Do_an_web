package qlshopquanao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlshopquanao.model.NhaCungCap;
import qlshopquanao.repository.NhaCungCapRepository;

@Service
public class NhaCungCapServicelmpl implements NhaCungCapService {

	@Autowired
	private NhaCungCapRepository NhaCungCapRepository;
	
	@Override
	public List<NhaCungCap> getAllNhaCungCap() {
		return NhaCungCapRepository.findAll();
	}

	@Override
	public void saveNhaCungCap(NhaCungCap nhacungcap) {
		this.NhaCungCapRepository.save(nhacungcap);
	}

	@Override
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

	@Override
	public void deleteNhaCungCapById(long maNCC) {
		this.NhaCungCapRepository.deleteById(maNCC);
	}

	@Override
	public List<NhaCungCap> getByKeyword(String keyword) {
		return NhaCungCapRepository.findByKeyword(keyword);
	}

}
